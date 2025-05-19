USE tabledb;

-- 테이블이 존재하면 삭제
DROP TABLE IF EXISTS usertbl;

CREATE TABLE usertbl(
                        userID      CHAR(8) NOT NULL PRIMARY KEY,
                        name        VARCHAR(10) NOT NULL,
                        birthYear   INT NOT NULL,
                        addr        CHAR(2) NOT NULL,
                        mobile1     CHAR(3) NULL,
                        mobile2     CHAR(8) NULL,
                        height      SMALLINT NULL,
                        mDate       DATE NULL
);


-- 회원 테이블 샘플 데이터
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

USE tabledb;

-- 테이블이 존재하면 삭제
DROP TABLE IF EXISTS buytbl;

CREATE TABLE buytbl(
                       num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                       userid      CHAR(8) NOT NULL,
                       prodName    CHAR(6) NOT NULL,
                       groupName   CHAR(4) NULL,
                       price       INT NOT NULL,
                       amount      SMALLINT NOT NULL,
                       FOREIGN KEY(userid) REFERENCES usertbl(userID)
);

-- 구매 테이블 샘플 데이터
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);

-- 오류 발생 : userid 컬럼이 참조하는 usertbl테이블의 userID 컬럼에 'JYP'가 없음
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);



USE tabledb;

DROP TABLE IF EXISTS buytbl, usertbl;

CREATE TABLE usertbl (
                         userID CHAR(8) NOT NULL PRIMARY KEY,
                         name VARCHAR(10) NOT NULL,
                         email CHAR(30) NULL UNIQUE
);

-- 1. 정상 데이터 삽입 (기본 데이터)
INSERT INTO usertbl (userID, name, email) VALUES ('user001', '김철수', 'kim@example.com');
INSERT INTO usertbl (userID, name, email) VALUES ('user002', '이영희', 'lee@example.com');
INSERT INTO usertbl (userID, name, email) VALUES ('user003', '박지성', 'park@example.com');
INSERT INTO usertbl (userID, name, email) VALUES ('user004', '최민수', 'choi@example.com');
INSERT INTO usertbl (userID, name, email) VALUES ('user005', '정소미', 'jung@example.com');

-- 2. UNIQUE 제약조건 위반 테스트 (이메일 중복)
-- 이미 존재하는 이메일로 새 사용자 추가 시도 (오류 발생)
INSERT INTO usertbl (userID, name, email) VALUES ('user006', '홍길동', 'kim@example.com');

-- 3. NULL 값 테스트 (email은 NULL 허용)
INSERT INTO usertbl (userID, name, email) VALUES ('user007', '강민준', NULL);
INSERT INTO usertbl (userID, name, email) VALUES ('user008', '손흥민', NULL);

-- 4. 대소문자 테스트 (MySQL 기본 설정에서는 대소문자 구분 없음)
INSERT INTO usertbl (userID, name, email) VALUES ('user010', '이지원', 'LEE@EXAMPLE.COM');

-- 5. 업데이트 테스트 (이메일 중복으로 변경)
-- 기존 사용자의 이메일을 이미 존재하는 값으로 변경 (오류 발생)
UPDATE usertbl SET email = 'park@example.com' WHERE userID = 'user002';

-- 6. 업데이트 테스트 (중복 없는 이메일로 변경)
UPDATE usertbl SET email = 'lee_new@example.com' WHERE userID = 'user002';

-- 7. 일괄 삽입 테스트 (부분 실패할 경우 SQL 전체 실패)
INSERT INTO usertbl (userID, name, email) VALUES
                                              ('user011', '조아라', 'jo@example.com'),
                                              ('user012', '한지민', 'han@example.com'),
                                              ('user013', '류현진', 'kim@example.com'); -- 중복 이메일로 실패

SELECT * FROM usertbl;



USE tabledb;

-- v_usertbl 뷰가 있다면 삭제
DROP VIEW IF EXISTS v_usertbl;

-- v_usertbl 뷰 생성
CREATE VIEW v_usertbl
AS
SELECT
    userid,
    name,
    addr
FROM
    usertbl;

SELECT * FROM v_usertbl;-- 뷰를 테이블이라고 생각해도 무방




-- usertbl 샘플 데이터
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');



-- buytbl 생성
CREATE TABLE buyTBL(
                       num INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
                       userID  CHAR(8) NOT NULL,
                       prodName CHAR(6) NOT NULL,
                       FOREIGN KEY(userID) REFERENCES userTBL(userID)
                           ON DELETE CASCADE
                           ON UPDATE CASCADE
);

-- buytbl 샘플 데이터
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화');
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북');


-- v_userbuytbl 뷰가 있다면 삭제
DROP VIEW IF EXISTS v_userbuytbl;

-- v_userbuytbl 뷰 생성
CREATE VIEW v_userbuytbl
AS
SELECT
    U.userid,
    U.name,
    B.prodName,
    U.addr,
    CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM
    usertbl U
        INNER JOIN
    buytbl B ON U.userid = B.userid;

SELECT *
FROM
    v_userbuytbl
WHERE
    name = '김범수';