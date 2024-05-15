-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost 4.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 14.
-- Time: 오후 4:14:58

CREATE TABLE Recipe (
    RecipeID INT PRIMARY KEY,
    Title VARCHAR2(255), -- 레시피 제목
    Description CLOB, -- 대량의 문자 데이터를 저장하기 위한 데이터 형식
    ImagePath VARCHAR(255) -- 이미지 파일 경로를 저장하기 위한 데이터 형식
    -- LikeCount INT DEFAULT 0, -- 좋아요 수
    -- CommentCount INT DEFAULT 0 -- 댓글 수
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

SELECT * FROM RECIPE;
DROP TABLE RECIPE;
DROP SEQUENCE RECIPE_SEQ;

CREATE TABLE Comment (
    CommentID INT PRIMARY KEY,
    RecipeID INT, -- 댓글이 속한 레시피 ID
    UserID INT, 
    Content CLOB, -- 댓글에 문자 제한을 없애기 위해서
    FOREIGN KEY (RecipeID) REFERENCES Recipe(RecipeID), -- 레시피 ID 에 대한 외래 키 제약 조건 생성. COMMENT 테이블의 RecipeID 컬럼이
    -- Recipe 테이블의 RecipeID 컬럼을 참조한다는 것
    FOREIGN KEY (UserID) REFERENCES User(UserID) -- USERID 에 대한 외래 키 제약 조건 생성. COMMENT 테이블의 USERID 컬럼이 USER 테이블의
    -- USERID 컬럼을 참조한다는 것
);

SELECT * FROM Comment;


CREATE SEQUENCE COMMENT_SEQ -- CommentID 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_COMMENT_SEQ -- 시퀀스 사용 트리거 생성
BEFORE INSERT ON Comment
FOR EACH ROW
BEGIN
    SELECT COMMENT_SEQ.NEXTVAL INTO :NEW.CommentID FROM DUAL;
END;

CREATE TABLE Like (
    LikeID INT PRIMARY KEY,
    RecipeID INT, -- 좋아요를 누른 레시피의 ID 저장
    UserID INT, -- 좋아요를 누른 사용자의 ID 저장
    FOREIGN KEY (RecipeID) REFERENCES Recipe(RecipeID), -- RecipeID 에 대한 외래 키 제약 조건을 생성. Like 테이블의
    -- RecipeID 컬럼이 Recipe 테이블의 RecipeID 컬럼을 참조
    FOREIGN KEY (UserID) REFERENCES User(UserID) -- UserID 에 대한 외래 키 제약 조건을 생성. Like 테이블의 UserID 컬럼이
    -- User 테이블의 UserID 컬럼을 참조
);

CREATE SEQUENCE LIKE_SEQ -- LikeID 증가 시퀀스 생성
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE OR REPLACE TRIGGER TRG_LIKE_SEQ -- 시퀀스 사용 트리거 생성
BEFORE INSERT ON Like
FOR EACH ROW
BEGIN
    SELECT LIKE_SEQ.NEXTVAL INTO :NEW.LikeID FROM DUAL;
END;