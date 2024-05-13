package com.recipe.member.UI;

import com.recipe.member.Session.SessionManager;
import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {

        public void open() {

            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().setBackground(Color.GRAY);
            f.setSize(860, 1000);
            f.getContentPane().setLayout(null);

            JLabel lblNewLabel = new JLabel("로그인");
            lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
            lblNewLabel.setBounds(300, 27, 238, 53);
            f.getContentPane().add(lblNewLabel);
            //Main Topic


            JLabel idLabel = new JLabel("아이디");
            idLabel.setFont(new Font("굴림", Font.BOLD, 25));
            idLabel.setBounds(38, 140, 134, 38);
            f.getContentPane().add(idLabel);

            JTextField idField;
            idField = new JTextField();
            idField.setForeground(Color.BLACK);
            idField.setBackground(Color.WHITE);
            idField.setFont(new Font("굴림", Font.BOLD, 25));
            idField.setBounds(199, 140, 233, 38);
            f.getContentPane().add(idField);
            idField.setColumns(10);
            //ID


            JLabel pwLabel = new JLabel("비밀번호");
            pwLabel.setFont(new Font("굴림", Font.BOLD, 25));
            pwLabel.setBounds(38, 207, 134, 38);
            f.getContentPane().add(pwLabel);

            JTextField pwField;
            pwField = new JTextField();
            pwField.setForeground(Color.BLACK);
            pwField.setBackground(Color.WHITE);
            pwField.setFont(new Font("굴림", Font.BOLD, 25));
            pwField.setColumns(10);
            pwField.setBounds(199, 207, 233, 38);
            f.getContentPane().add(pwField);
            //Password


            JButton btnLogin = new JButton("로그인");
            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MemberDao memberDao = new MemberDao();
                    MemberDto memberDto = new MemberDto();

                    String idValue = idField.getText();
                    String pwValue = pwField.getText();
                    memberDto.setId(idValue);
                    memberDto.setPw(pwValue);
                    MemberDto rsDto = memberDao.login(memberDto);




                    System.out.println(rsDto);

                    if(rsDto != null){
                        //어떤 경우에 '로그인 성공'
                        MemberDto rsDto2 = memberDao.selectGender(idValue, pwValue);
                        String gender = rsDto2.getGender();

                        SessionManager.setAttribute("userGender", gender);
                        SessionManager.setAttribute("userId", idValue);
                        System.out.println("로그인 성공");
                        JOptionPane.showMessageDialog(null, "로그인 성공");
                        //f.dispose();
                    } else {
                        //else '로그인 실패'
                        System.out.println("로그인 실패");
                    }
                }
            });
            btnLogin.setForeground(Color.BLACK);
            btnLogin.setBackground(Color.WHITE);
            btnLogin.setFont(new Font("굴림", Font.BOLD, 23));
            btnLogin.setBounds(339, 436, 148, 94);
            f.getContentPane().add(btnLogin);
            //Login


            JButton btnSignUp = new JButton("회원가입");
            btnSignUp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SignUpUI signUpUI = new SignUpUI();
                    f.dispose();
                    signUpUI.open();
                }
            });
            btnSignUp.setForeground(Color.BLACK);
            btnSignUp.setBackground(Color.WHITE);
            btnSignUp.setFont(new Font("굴림", Font.BOLD, 23));
            btnSignUp.setBounds(209, 536, 148, 94);
            f.getContentPane().add(btnSignUp);
            //Open Sing Up


            JButton btnFindAccount = new JButton("ID / Password 찾기");
            btnFindAccount.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("이름을 입력 해주세요.");
                    String tel = JOptionPane.showInputDialog("전화번호를 입력 해주세요.");

                    MemberDao memberDao = new MemberDao();
                    MemberDto rsDto = memberDao.selectOne(name, tel);

                    if (rsDto != null) {
                        String id = rsDto.getId();
                        String pw = rsDto.getPw();
                        JOptionPane.showMessageDialog(null, "아이디 : " + id + "\n" + "비밀번호 : " + pw);
                    } else {
                        JOptionPane.showMessageDialog(null, "계정을 찾을 수 없습니다.");
                    }
                }
            });
            btnFindAccount.setForeground(Color.BLACK);
            btnFindAccount.setBackground(Color.WHITE);
            btnFindAccount.setFont(new Font("굴림", Font.BOLD, 23));
            btnFindAccount.setBounds(409, 536, 258, 94);
            f.getContentPane().add(btnFindAccount);
            //Find Account


            JButton btnMyPageUI = new JButton("마이페이지");
            btnMyPageUI.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MyPageUI myPageUI = new MyPageUI();
                    f.dispose();
                    myPageUI.open();
                }
            });
            btnMyPageUI.setForeground(Color.BLACK);
            btnMyPageUI.setBackground(Color.WHITE);
            btnMyPageUI.setFont(new Font("굴림", Font.BOLD, 23));
            btnMyPageUI.setBounds(409, 736, 148, 94);
            f.getContentPane().add(btnMyPageUI);
            //Open My Page


            f.setVisible(true);
        }
}
