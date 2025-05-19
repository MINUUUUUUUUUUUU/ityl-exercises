DROP DATABASE tabledb;
CREATE DATABASE tabledb;

USE tabledb;

# 다음 컬럼을 가지는 userTBL과 buyTBL을 정의하세요.
# 기존에 테이블이 존재하면 삭제함
DROP TABLE IF EXISTS userTBL;
CREATE TABLE userTBL (
                         userID CHAR(8) NOT NULL,
                         name VARCHAR(10) NOT NULL,
                         birthYear INT NOT NULL,
                         CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID)
);

DROP TABLE IF EXISTS buyTBL;
CREATE TABLE buyTBL(
                       num INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
                       userID  CHAR(8) NOT NULL,
                       prodName CHAR(6) NOT NULL,
                       FOREIGN KEY(userID) REFERENCES userTBL(userID)
);

# 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
# 기존 buyTBL, userTBL 테이블을 삭제하세요.
DROP TABLE buyTBL, userTBL;
CREATE TABLE userTBL(
                        userID    CHAR(8) NOT NULL PRIMARY KEY,
                        name      VARCHAR(10) NOT NULL,
                        birthYear  INT NOT NULL,
                        email CHAR(30) NULL UNIQUE
);

# 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
# 기존 userTBL 테이블을 삭제하세요.
DROP TABLE userTBL;
CREATE TABLE userTBL (
                         userID    CHAR(8) PRIMARY KEY,
                         name      VARCHAR(10) ,
                         birthYear  INT CHECK  (birthYear >= 1900 AND birthYear <= 2023),
                         mobile    char(3) NOT NULL
);

# 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
# 기존 userTBL 테이블을 삭제하세요.

DROP TABLE userTBL;
CREATE TABLE userTBL(
                        userID      CHAR(8) NOT NULL PRIMARY KEY,
                        name        VARCHAR(10) NOT NULL,
                        birthYear   INT NOT NULL DEFAULT -1,
                        addr        CHAR(2) NOT NULL DEFAULT '서울',
                        mobile1     CHAR(3) NULL,
                        mobile2     CHAR(8) NULL,
                        height      SMALLINT NULL DEFAULT 170,
                        mDate       DATE NULL
);

# 앞에서 만든 userTBL에 대해서 다음 조건을 처리하도록 수정하세요.
# - mobile1 컬럼을 삭제함
# - name 컬럼명을 uName으로 변경함
# - 기본키를 제거함

ALTER TABLE userTBL DROP COLUMN mobile1;
ALTER TABLE userTBL CHANGE COLUMN name uName VARCHAR(10) NOT NULL;
ALTER TABLE userTBL DROP COLUMN userID;
# select * from userTBL;











# 다음 정보를 가지는 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성하세요
use employees;

DROP VIEW IF EXISTS EMPLOYEES_INFO;
CREATE VIEW EMPLOYEES_INFO
AS
    SELECT A.emp_no, birth_date, first_name, last_name,
           gender, hire_date, title, B.from_date as t_from, B.to_date as t_to
           , salary,C.from_date as s_from,C.to_date as s_to
    FROM employees AS A JOIN titles AS B ON A.emp_no = B.emp_no
    JOIN salaries AS C ON A.emp_no = C.emp_no


# EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력하세요.
SELECT * FROM EMPLOYEES_INFO
WHERE t_to > current_time;


# 다음 정보를 가지는 부서 정보를 출력하는 EMP_DEPT_INFO 뷰를 작성하세요
DROP VIEW IF EXISTS EMP_DEPT_INFO;
CREATE VIEW EMP_DEPT_INFO
    AS
        SELECT A.emp_no, B.dept_no, dept_name, from_date, to_date
        FROM employees AS A JOIN dept_emp AS B ON A.emp_no = B.emp_no
        JOIN departments AS C ON B.dept_no = C.dept_no;

# EMP_DEPT_INFO로 현재 재직자의 부서 정보를 출력하세요.
SELECT * FROM EMP_DEPT_INFO
WHERE to_date > current_time;