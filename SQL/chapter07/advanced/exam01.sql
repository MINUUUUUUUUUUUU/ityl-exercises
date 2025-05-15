use sqldb;

# 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해서 학생을 기준으로 학생 이름/지역/가입한 동아리/동아리방을 출력하세요
select a.stdName, a.addr, b.clubName, b.roomNo from stdtbl as b
join stdclubtbl as b on a.stdName = b.studName
join clubtbl as c on b.clubName = c.clubName;

# 동아리를 기준으로 가입한 학생의 목록을 출력하세요.
#  출력정보: clubName, roomNo, stdName, addr
select clubName, roomNo, stdName, addr from clubtbl as a
join stdclubtbl as b on a.clubName = b.clubName
join stdtbl as c on b.stdName = c.stdName;

# 앞에서 추가한 테이블에서 '우대리'의 상관 연락처 정보를 확인하세요.
# ○ 출력할 정보
#  부하직원, 직속상관, 직속상관연락처
select a.emp, a.manager, b.empTel from empTbl as a
join empTbl as b on a.emp = b.manager;



# 모든 문제는 employees 데이터베이스에서 수행한다
use employees;

# 현재 재직 중인 직원의 정보를 출력하세요
# ○ 출력 항목: emp_no, first_name, last_name, title
select a.emp_no, a.first_name, a.last_name, b.title from employees as a
join titles as b on a.emp_no = b.emp_no
join dept_emp as c on a.emp_no = c.emp_no
where c.to_date > current_time;

# 현재 재직 중인 직원 정보를 출력하세요
# ○ 출력항목: 직원의 기본 정보 모두, title, salary
select a.*, b.title, d.salary from employees as a
join titles as b on a.emp_no = b.emp_no
join dept_emp as c on a.emp_no = c.emp_no
join salaries as d on a.emp_no = d.emp_no
where c.to_date > current_time;

# 현재 재직중인 직원의 정보를 출력하세요.
# ○ 출력항목: emp_no, first_name, last_name, department
# ○ 정렬: emp_no 오름 차순
select a.emp_no, a.first_name, a.last_name, d.dept_name from employees as a
join titles as b on a.emp_no = b.emp_no
join dept_emp as c on a.emp_no = c.emp_no
join departments as d on c.dept_no = d.dept_no
where c.to_date > current_time
order by emp_no;

# 부서별 재직중인 직원의 수를 출력하세요.
# ○ 출력 항목: 부서 번호, 부서명, 인원수
# ○ 정렬: 부서 번호 오름차순
select c.dept_no, d.dept_name, count(a.emp_no) from employees as a
join titles as b on a.emp_no = b.emp_no
join dept_emp as c on a.emp_no = c.emp_no
join departments as d on c.dept_no = d.dept_no
where c.to_date > current_time
group by c.dept_no
order by c.dept_no;

# 직원 번호가 10209인 직원의 부서 이동 히스토리를 출력하세요.
# ○ 출력항목: emp_no, first_name, last_name, dept_name, from_date, to_date
select distinct a.emp_no, a.first_name, a.last_name, d.dept_name, c.from_date, c.to_date from employees as a
join titles as b on a.emp_no = b.emp_no
join dept_emp as c on a.emp_no = c.emp_no
join departments as d on c.dept_no = d.dept_no
where a.emp_no = 10209;