-- CONNECTION: url=jdbc:oracle:thin:@//localhost:1521/XE
-- New script in localhost.
-- Connection Type: dev 
-- Url: jdbc:oracle:thin:@//localhost:1521/XE
-- workspace : C:\WORKSPACE\MULTI\03_db
-- Date: 2024. 5. 11.
-- Time: 오전 2:48:31
-- num 게시판 번호 
-- id 표시 
DROP TABLE BOARD;
COMMIT;


CREATE TABLE BOARD(
	NUM INT NOT NULL, --게시글 번호 
    ID VARCHAR2(100),  -- 회원 아이디를 참조하기 위한 컬럼 추가
	SUBJECT VARCHAR2(50) NOT NULL, --게시글 제목
	CONTENT VARCHAR2(4000) NOT NULL, -- 게시글 내용 
	HITCOUNT NUMBER(9), --조회수
	CREATED DATE, --작성 시간(작성일)
	GRADE INT CHECK (GRADE IN (0,1)),
CONSTRAINT PK_BOARD_NUM PRIMARY KEY(NUM), -- NUM 기본키 지정 
CONSTRAINT FK_BOARD_ID FOREIGN KEY (ID) REFERENCES MEMBER(ID)

);

CREATE SEQUENCE seq_board_num
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100
NOCYCLE
CACHE 20;


INSERT INTO BOARD (NUM, ID, SUBJECT, CONTENT, HITCOUNT, CREATED, GRADE)
VALUES (seq_board_num.NEXTVAL, '사용자ID', '게시글 제목', '게시글 내용', 0, SYSDATE, 0);


--조회
SELECT NUM, ID, SUBJECT, CONTENT, HITCOUNT, CREATED, GRADE
FROM BOARD
ORDER BY NUM DESC;

--수정
UPDATE BOARD
SET SUBJECT = '새로운 제목', CONTENT = '새로운 내용'
WHERE NUM = 특정번호;


--삭제
DELETE FROM BOARD
WHERE NUM = 특정번호;
