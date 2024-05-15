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
--Members Table


CREATE TABLE BOARD(
	NUM INT NOT NULL, --게시글 번호 
    ID VARCHAR2(100),  -- 회원 아이디를 참조하기 위한 컬럼 추가
	SUBJECT VARCHAR2(50) NOT NULL, --게시글 제목
	CONTENT VARCHAR2(4000) NOT NULL, -- 게시글 내용 
	HITCOUNT NUMBER(9), --조회수
	CREATED DATE, --작성 시간(작성일)
	GRADE INT CHECK (GRADE IN (0,1)),
CONSTRAINT PK_BOARD_NUM PRIMARY KEY(NUM), -- NUM 기본키 지정 
CONSTRAINT FK_BOARD_ID FOREIGN KEY (ID) REFERENCES MEMBERS(ID)
);

CREATE SEQUENCE seq_board_num
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_seq_board_num_SEQ	--시퀀스 사용 트리거 생성
BEFORE INSERT ON BOARD
FOR EACH ROW
BEGIN
    SELECT seq_board_num.NEXTVAL INTO :NEW.NUM FROM DUAL;
END;
--Board Table


CREATE TABLE Recipe (
    RecipeID INT PRIMARY KEY,
    RCategory VARCHAR(255), -- 카테고리
    Title VARCHAR2(255), -- 레시피 제목
    Description CLOB, -- 대량의 문자 데이터를 저장하기 위한 데이터 형식
    ImagePath VARCHAR(255), -- 이미지 파일 경로를 저장하기 위한 데이터 형식
    ID VARCHAR2(100),
    CONSTRAINT FK_Recipe_ID FOREIGN KEY (ID) REFERENCES MEMBERS(ID),
	LikeCount INT DEFAULT 0, -- 좋아요 수
    CommentCount INT DEFAULT 0 -- 댓글 수
);

CREATE SEQUENCE RECIPE_SEQ -- Recipe ID 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_RECIPE_SEQ -- 시퀀스 사용 트리거 생성
BEFORE INSERT ON Recipe
FOR EACH ROW
BEGIN
    SELECT RECIPE_SEQ.NEXTVAL INTO :NEW.RecipeID FROM DUAL;
END;
--Recipe Table


CREATE TABLE Comm (
    CommentID INT PRIMARY KEY,
    RecipeID INT, -- 댓글이 속한 레시피 ID
    ID VARCHAR2(100), 
    Content CLOB, -- 댓글에 문자 제한을 없애기 위해서
    FOREIGN KEY (RecipeID) REFERENCES Recipe(RecipeID), -- 레시피 ID 에 대한 외래 키 제약 조건 생성. COMMENT 테이블의 RecipeID 컬럼이
    -- Recipe 테이블의 RecipeID 컬럼을 참조한다는 것
    FOREIGN KEY (ID) REFERENCES MEMBERS(ID) -- USERID 에 대한 외래 키 제약 조건 생성. COMMENT 테이블의 USERID 컬럼이 USER 테이블의
    -- USERID 컬럼을 참조한다는 것
);

CREATE SEQUENCE COMMENT_SEQ -- CommentID 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_COMMENT_SEQ -- 시퀀스 사용 트리거 생성
BEFORE INSERT ON Comm
FOR EACH ROW
BEGIN
    SELECT COMMENT_SEQ.NEXTVAL INTO :NEW.CommentID FROM DUAL;
END;
--Comm Table


CREATE TABLE Heart (
    HeartID INT PRIMARY KEY,
    RecipeID INT, -- 좋아요를 누른 레시피의 ID 저장
    ID VARCHAR2(100), -- 좋아요를 누른 사용자의 ID 저장
    FOREIGN KEY (RecipeID) REFERENCES Recipe(RecipeID), -- RecipeID 에 대한 외래 키 제약 조건을 생성. Like 테이블의
    -- RecipeID 컬럼이 Recipe 테이블의 RecipeID 컬럼을 참조
    FOREIGN KEY (ID) REFERENCES MEMBERS(ID) -- UserID 에 대한 외래 키 제약 조건을 생성. Like 테이블의 UserID 컬럼이
    -- User 테이블의 UserID 컬럼을 참조
);

CREATE SEQUENCE Heart_SEQ -- LikeID 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_Heart_SEQ -- 시퀀스 사용 트리거 생성
BEFORE INSERT ON Heart
FOR EACH ROW
BEGIN
    SELECT Heart_SEQ.NEXTVAL INTO :NEW.HeartID FROM DUAL;
END;
--Heart Table


SELECT * FROM MEMBERS ;
SELECT * FROM BOARD;
SELECT * FROM RECIPE ;
SELECT * FROM Comm;
SELECT * FROM HEART ;
--Select