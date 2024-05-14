package com.recipe.member.dao;

import com.recipe.member.dto.MemberDto;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {

    public void insert(String id, String pw, String name, String gender, String tel) {

        Connection con = null;
        PreparedStatement ps = null;

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
            String sql = "insert into MEMBERS (ID, PW, NAME, GENDER, TEL) values (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3, name);
            ps.setString(4, gender);
            ps.setString(5, tel);

            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();

            System.out.println("5. sql문 전송 성공, 결과1>> " + result);


            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }

            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
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
    }
    //Insert


    public void delete(String id) {

        Connection con = null;
        PreparedStatement ps = null;

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
            String sql = "DELETE FROM MEMBERS WHERE ID = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, id);

            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();

            System.out.println("5. sql문 전송 성공, 결과1>> " + result);


            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }

            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
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
    }
    //Delete
    //( 현재 사용 안함 )


    public void insert(MemberDto memberDto) {

        Connection con = null;
        PreparedStatement ps = null;

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
            String sql = "insert into MEMBERS (ID, PW, NAME, GENDER, TEL) values (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, memberDto.getId());
            System.out.println(memberDto.getGender());
            ps.setString(2, memberDto.getPw());
            ps.setString(3, memberDto.getName());
            ps.setString(4, memberDto.getGender());
            ps.setString(5, memberDto.getTel());

            System.out.println(memberDto.getGender());
            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();

            System.out.println("5. sql문 전송 성공, 결과1>> " + result);


            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }

            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
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
    }
    //Insert


    public MemberDto selectOne(String name, String tel) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto memberDto = null;

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
            String sql = "SELECT * FROM MEMBERS WHERE NAME = ? AND TEL = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, name);
            ps.setString(2, tel);

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if (rs.next()) {
                memberDto = new MemberDto();

                memberDto.setId(rs.getString("ID"));
                memberDto.setPw(rs.getString("PW"));
                memberDto.setName(rs.getString("NAME"));
                memberDto.setTel(rs.getString("TEL"));
                memberDto.setSignupDate(rs.getDate("SIGNUP_DATE"));
            }

            System.out.println("5. sql문 전송 성공, 결과1>> " + rs);


        } catch (ClassNotFoundException | SQLException e) {
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

        return memberDto;
    }
    //Select One


    public MemberDto login(MemberDto memberDto) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto rsDto = null;

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
            String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, memberDto.getId());
            ps.setString(2, memberDto.getPw());

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if (rs.next()) {
                rsDto = new MemberDto();

                memberDto.setId(rs.getString("ID"));
                memberDto.setPw(rs.getString("PW"));
                memberDto.setName(rs.getString("NAME"));
                memberDto.setTel(rs.getString("TEL"));
                memberDto.setSignupDate(rs.getDate("SIGNUP_DATE"));
            }

            System.out.println("5. sql문 전송 성공, 결과1>> " + rs);


        } catch (ClassNotFoundException | SQLException e) {
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

        return rsDto;
    }
    //Login


    public void update(MemberDto memberDto) {

        Connection con = null;
        PreparedStatement ps = null;

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
            String sql = "UPDATE MEMBERS SET PW = ?, NAME = ?, TEL = ? WHERE ID = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, memberDto.getPw());
            ps.setString(2, memberDto.getName());
            ps.setString(3, memberDto.getTel());
            ps.setString(2, memberDto.getId());


            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();

            System.out.println("5. sql문 전송 성공, 결과1>> " + result);


            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }

            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
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
    }
    //Update


    public void deleteAccount(String userId) {

        Connection con = null;
        PreparedStatement ps = null;

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
            String sql = "UPDATE MEMBERS SET DELETE_ACCOUNT_DATE = sysdate, DELETE_ACCOUNT = 'Y' WHERE ID = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, userId);


            System.out.println("4. sql문 객체 생성 성공.");
            int result = ps.executeUpdate();

            System.out.println("5. sql문 전송 성공, 결과1>> " + result);


            // 트랜잭션 커밋
            if (result >= 1) {
                System.out.println("데이터 입력 완료");
                con.commit();
                System.out.println("6. 트랜잭션 커밋 완료.");
            }

            // Query가 제대로 실행되지 않은 경우
            else {
                System.out.println("데이터 입력 실패");
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
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
    }

    public MemberDto selectGender(String idValue, String pwValue) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto memberDto = null;

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
            String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, idValue);
            ps.setString(2, pwValue);

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if (rs.next()) {
                memberDto = new MemberDto();

                memberDto.setId(rs.getString("ID"));
                memberDto.setPw(rs.getString("PW"));
                memberDto.setName(rs.getString("NAME"));
                memberDto.setGender(rs.getString("GENDER"));
                memberDto.setTel(rs.getString("TEL"));
                memberDto.setSignupDate(rs.getDate("SIGNUP_DATE"));
            }

            System.out.println("5. sql문 전송 성공, 결과1>> " + rs);


        } catch (ClassNotFoundException | SQLException e) {
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

        return memberDto;
    }

    public ArrayList<MemberDto> list() {
        ArrayList<MemberDto> list = new ArrayList<>();
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
            String sql = "SELECT * FROM MEMBERS";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기


            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setNo(rs.getInt("NO"));
                memberDto.setId(rs.getString("ID"));
                memberDto.setName(rs.getString("name"));
                memberDto.setGender(rs.getString("GENDER"));
                memberDto.setTel(rs.getString("tel"));

                list.add(memberDto);
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

    public MemberDto selectPage(String page) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDto memberDto = null;

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
            String sql = "SELECT * FROM MEMBERS WHERE NAME = ?";
            ps = con.prepareStatement(sql);

            // ? 에 입력할 순서대로 매핑시키기
            ps.setString(1, page);

            System.out.println("4. sql문 객체 생성 성공.");
            rs = ps.executeQuery();
            //https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
            if (rs.next()) {
                memberDto = new MemberDto();

                memberDto.setId(rs.getString("ID"));
                memberDto.setPw(rs.getString("PW"));
                memberDto.setName(rs.getString("NAME"));
                memberDto.setTel(rs.getString("TEL"));
                memberDto.setSignupDate(rs.getDate("SIGNUP_DATE"));
            }

            System.out.println("5. sql문 전송 성공, 결과1>> " + rs);


        } catch (ClassNotFoundException | SQLException e) {
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

        return memberDto;
    }
}