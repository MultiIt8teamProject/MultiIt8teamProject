package com.multi.jdbc.member.model.dao;


import com.multi.jdbc.member.model.dto.Dto;
import com.recipe.member.dto.MemberDto;

import java.sql.*;
import java.util.Date;

public class NoticeDao {

    public void insert(Dto dto) {


        Connection con = null;
        PreparedStatement ps = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토커밋 설정 비활성화.");


            int result = 0;

            String sql = "INSERT INTO BOARD (num, id, subject, content, hitcount, created, grade) " +
                    "VALUES (seq_board_num.NEXTVAL, ?, ?, ?, ?, ?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, dto.getId());
            ps.setString(2, dto.getSubject());
            ps.setString(3, dto.getContent());
            ps.setInt(4, dto.getHitcount());
            ps.setDate(5, new java.sql.Date(dto.getCreated().getTime()));
            ps.setInt(6, dto.getGrade());

            result = ps.executeUpdate();

            if (result > 0) {
                con.commit();

            } else {
                con.rollback();
            }
            System.out.println("성공");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("에러");
            throw new RuntimeException(e);
        } finally {
            try {

                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {

                e.printStackTrace();
                e.printStackTrace();
            }
        }

    }


//    public void select(int num, String id, String subject, String conten, int hitcount, Date created){
//        Connection con = null;
//        PreparedStatement ps = null;
//
//        try {
//
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("1. 드라이버 설정 성공..");
//
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            String user = "scott";
//            String password = "tiger";
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("2. db연결 성공." + con);
//
//            // 오토커밋을 false로 설정
//            con.setAutoCommit(false);
//            System.out.println("3. 오토커밋 설정 비활성화.");
//
//
//            int result = 0;
//
//            String sql = "SELECT * FROM MEMBER";
//            ps = con.prepareStatement(sql);
//
//            ps.setInt(1, dto.get());
//            ps.setString(2, dto.getSubject());
//            ps.setString(3, dto.getContent());
//            ps.setInt(4, dto.getHitcount());
//            ps.setDate(5, new java.sql.Date(dto.getCreated().getTime()));
//            ps.setInt(6, dto.getGrade());
//
//            result = ps.executeUpdate();
//
//            if (result > 0) {
//                con.commit();
//
//            } else {
//                con.rollback();
//            }
//            System.out.println("성공");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("에러");
//            throw new RuntimeException(e);
//        } finally {
//            try {
//
//                ps.close(); // 먼저닫기
//                con.close();
//            } catch (SQLException e) {
//
//                e.printStackTrace();
//                e.printStackTrace();
//            }
//        }
//    }

    public Dto select(int num) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dto dto = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            String sql = "SELECT * FROM BOARD WHERE num = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);

            rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String subject = rs.getString("subject");
                String content = rs.getString("content");
                int hitcount = rs.getInt("hitcount");
                Date created = rs.getDate("created");
                int grade = rs.getInt("grade");

                dto = new Dto(num, id, subject, content, hitcount, created, grade);
                System.out.println("조회 성공");
            } else {
                System.out.println("해당 번호의 게시글이 없습니다.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("에러: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dto;
    }
}