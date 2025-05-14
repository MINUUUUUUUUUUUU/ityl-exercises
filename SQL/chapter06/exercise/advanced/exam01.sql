
use sqldb;
show tables;

#  다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요
select userID as '사용자 아이디', sum(amount) as '총 구매 개수' from buytbl
group by userID;

select userID as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl
group by userID ;

select avg(amount) as '평균 구매 개수' from buytbl;

select userID, avg(amount) from buytbl group by userID ;

# 다음 결과가 나오도록 usertbl에 대한 SQL 문을 작성하세요.
select name, height from usertbl
where height = (select min(height) from usertbl)
or height = (select max(height) from usertbl)

select count(*) as '휴대폰이 있는 사용자' from usertbl
where mobile1 is not null;

# buytbl 테이블로 다음을 처리하세요.

select userID as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl
group by userID ;

select * from
(select userID as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl
group by userID) result
where `총 구매액` >= 1000;


# --------------------------------------------------
# world 데이터베이스에서 다음 질문을 처리하세요.
use world;
show tables;

# ○ city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 총합을 구하시오.
select sum(population) from city
where CountryCode = 'KOR';

# ○ city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최소값을 구하시오. 단 결과를 나타내는 테이블의 필드는 "최소값"으로 표시하시오.
select min(population) as '최소값' from city
where CountryCode = 'KOR';

# ○ city 테이블에서 국가코드가 'KOR'인 도시들의 평균을 구하시오.
select avg(population) from city
where CountryCode = 'KOR';

# ○ city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최대값을 구하시오. 단 결과를 나타내는 테이블의 필드는 "최대값"으로 표시하시오.
select max(population) as '최대값' from city
where CountryCode = 'KOR';

# ○ country 테이블 각 레코드의 Name 칼럼의 글자수를 표시하시오.
select length(name) from country;

# ○ country 테이블의 나라명(Name 칼럼)을 앞 세글자만 대문자로 표시하시오.
select concat(upper(left(Name,3)), substr(Name, 4)) from country;

# ○ country 테이블의 기대수명(LifeExpectancy)을 소수점 첫째자리에서 반올림해서 표시하시오.
select name ,round(LifeExpectancy, 0) from country;

# --------------------------------------------------
# 모든 문제는 employees 데이터베이스에서 수행한다.
use employees;
show tables ;

# employees db에서 각 부서별 관리자를 출력하세요.
select * from dept_manager
where current_time between from_date and to_date;

# 부서번호 d005 부서의 현재 관리자 정보를 출력하세요.
select * from dept_manager
where current_time between from_date and to_date
and dept_no = 'd005';

# employees 테이블에서 페이지네이션으로 페이지를 추출하려고 한다. 다음 조건하에서 8번 페이지의 데이터를 출력하세요.
# ○ 입사일을 내림차순으로 정렬한다.
# ○ 한 페이지당 20명의 정보를 출력한다.

select * from employees order by hire_date desc limit 160, 20;

# employees db에서 재직자의 총 수를 구하시오
# ○ 재직자의 to_date값은 '9999-01-01'로 저장되어 있음

select count(*) from salaries where current_time between from_date and to_date;

# employees db에서 재직자의 평균 급여를 출력하시오
select avg(salary) from salaries where current_time between from_date and to_date;

# 재직자 전체 평균 급여 보다 급여를 더 많이 받는 재직자를 출력하세요.
select * from employees
natural join salaries
where (salary > (select avg(salary) from salaries where current_time between from_date and to_date))
and current_time between from_date and to_date;

# employees db에서 각 부서별 재직자의 수를 구하시오
# ○ 부서 번호로 구분하고, 부서 번호로 오름 차순 정렬하여 출력한다.
select dept_no, count(*) from employees natural join dept_emp
where current_time between from_date and to_date
group by dept_no
order by dept_no;