package com.recipe.post.dao;

import com.recipe.post.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;

public class PostDao {

    public ArrayList<PostDto> postList(String id) {
        ArrayList<PostDto> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "recipe";
            String password = "recipe";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토커밋 설정 비활성화.");

            // String문 만들기
            // String문 만들기
            String sql = "SELECT RCATEGORY, TITLE FROM Recipe WHERE ID = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, id);


            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm

            ps = con.prepareStatement(sql);

            while (rs.next()) {
                PostDto postDto= new PostDto();
                postDto.setRCategory(rs.getString("RCATEGORY"));
                postDto.setTitle(rs.getString("TITLE"));

                list.add(postDto);
            }

        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {

                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

                System.out.println("트랜잭션 롤백.");
            }
        } finally {
            try {

                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {

                e.printStackTrace();
                e.printStackTrace();
            }
        }
        return list;
    }
    //Post List


    public ArrayList<PostDto> scrapList(String id) {
        ArrayList<PostDto> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. 드라이버 설정 성공..");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "recipe";
            String password = "recipe";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결 성공." + con);

            // 오토커밋을 false로 설정
            con.setAutoCommit(false);
            System.out.println("3. 오토커밋 설정 비활성화.");

            // String문 만들기
            // String문 만들기
            String sql = "SELECT A.RCategory, A.TITLE FROM HEART B JOIN Recipe A ON B.RecipeID = A.RecipeID WHERE B.ID = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, id);


            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm

            ps = con.prepareStatement(sql);

            while (rs.next()) {
                PostDto postDto= new PostDto();
                postDto.setRCategory(rs.getString("RCATEGORY"));
                postDto.setTitle(rs.getString("TITLE"));

                list.add(postDto);
            }

        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {

                    con.rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

                System.out.println("트랜잭션 롤백.");
            }
        } finally {
            try {

                ps.close(); // 먼저닫기
                con.close();
            } catch (SQLException e) {

                e.printStackTrace();
                e.printStackTrace();
            }
        }
        return list;
    }
    //Scrap List
}
