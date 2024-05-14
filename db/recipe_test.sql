-- New script in localhost RECIPE.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 9.
-- Time: 오후 10:14:15


CREATE TABLE MEMBERS(
	NO INT PRIMARY KEY,		--회원 번호 (PK)
	ID VARCHAR2(100) UNIQUE,	--아이디 (유니크)
	PW VARCHAR2(100),	--비밀번호
	NAME VARCHAR2(20),		--이름
	GENDER VARCHAR2(3) CHECK (GENDER IN ('M','F')),		--성별(남M,여F)
	TEL VARCHAR2(15),	--연락처
	SIGNUP_DATE DATE DEFAULT sysdate,	--회원 가입일
	DELETE_ACCOUNT_DATE DATE DEFAULT NULL,	--회원 탈퇴일 (기본값 NULL)
	GRADE INT DEFAULT 1 CHECK (GRADE IN (0,1)),	--회원 등급(관리자0, 일반등급1)
	DELETE_ACCOUNT VARCHAR2(3) DEFAULT 'N' CHECK (DELETE_ACCOUNT IN ('Y','N'))		--퇴원 탈퇴 여부(탈퇴Y,기본N)
);

CREATE SEQUENCE MEMBERS_SEQ		--회원 번호 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;


CREATE OR REPLACE TRIGGER TRG_MEMBERS_SEQ	--시퀀스 사용 트리거 생성
BEFORE INSERT ON MEMBERS
FOR EACH ROW
BEGIN
    SELECT MEMBERS_SEQ.NEXTVAL INTO :NEW.NO FROM DUAL;
END;


-- 제거 순서  트리거 제거 > 시퀀스 제거 > 테이블 제거
DROP TRIGGER TRG_MEMBERS_SEQ;	-- 트리거 제거
	
DROP SEQUENCE MEMBERS_SEQ;	--시퀀스 제거

DROP TABLE MEMBERS ;  --테이블 제거

COMMIT;

SELECT * FROM MEMBERS;

SELECT * FROM MEMBERS WHERE ID = 'admin' AND PW = 'admin';



-- 멤버 추가시 ID는 고유하게 설정해서 ID만 다르게 설정해주세요.
insert into MEMBERS (ID, PW, NAME, GENDER, TEL)
values ('admin', 'admin' ,'admin' ,'M' , 010);

insert into MEMBERS (ID, PW, NAME, GENDER, TEL)
values ('test', 'test' ,'test' ,'M' , '010');

SELECT * FROM MEMBERS WHERE NAME = 'admin' AND TEL = 010;

INSERT INTO MEMBERS (ID, PW, NAME, GENDER, TEL, SIGNUP_DATE, GRADE, DELETE_ACCOUNT)
VALUES ('ID4', 'PW' ,'TEST1' ,'M' , '010', sysdate, '0', 'N' );

SELECT * FROM MEMBERS WHERE ID = 'admin' AND PW = 'admin';