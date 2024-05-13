package com.recipe.member.UI;

import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpUI {

    private JTextField idField;
    private JTextField pwField;
    private JTextField confirmPwField;
    private JTextField nameField;
    private JTextField genderField;
    private JTextField telField;

    static int Flag = 0;

    public void open() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("회원 가입");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(116, 27, 238, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic


        JLabel idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("굴림", Font.BOLD, 25));
        idLabel.setBounds(38, 140, 134, 38);
        f.getContentPane().add(idLabel);

        idField = new JTextField();
        idField.setForeground(Color.BLACK);
        idField.setBackground(Color.WHITE);
        idField.setFont(new Font("굴림", Font.BOLD, 25));
        idField.setBounds(199, 140, 233, 38);
        f.getContentPane().add(idField);
        idField.setColumns(10);
        idField.setText("");
        //ID


        JLabel pwLabel = new JLabel("비밀번호");
        pwLabel.setFont(new Font("굴림", Font.BOLD, 25));
        pwLabel.setBounds(38, 207, 134, 38);
        f.getContentPane().add(pwLabel);

        pwField = new JTextField();
        pwField.setForeground(Color.BLACK);
        pwField.setBackground(Color.WHITE);
        pwField.setFont(new Font("굴림", Font.BOLD, 25));
        pwField.setColumns(10);
        pwField.setBounds(199, 207, 233, 38);
        f.getContentPane().add(pwField);
        //1st Password


        JLabel confirmPwLabel = new JLabel("비밀번호 확인");
        confirmPwLabel.setFont(new Font("굴림", Font.BOLD, 25));
        confirmPwLabel.setBounds(38, 282, 134, 38);
        f.getContentPane().add(confirmPwLabel);

        confirmPwField = new JTextField();
        confirmPwField.setForeground(Color.BLACK);
        confirmPwField.setBackground(Color.WHITE);
        confirmPwField.setFont(new Font("굴림", Font.BOLD, 25));
        confirmPwField.setColumns(10);
        confirmPwField.setBounds(199, 282, 233, 38);
        f.getContentPane().add(confirmPwField);
        //2nd Password


        JButton btnConfirmPw = new JButton("비밀번호 확인");
        btnConfirmPw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pw = pwField.getText();
                String pw2 = confirmPwField.getText();

                if (pw.equals(pw2)) {
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
                    Flag = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
                    Flag = 0;
                }
            }
        });
        btnConfirmPw.setFont(new Font("굴림", Font.BOLD, 23));
        btnConfirmPw.setForeground(Color.BLACK);
        btnConfirmPw.setBackground(Color.WHITE);
        btnConfirmPw.setBounds(450, 282, 200, 38);
        f.getContentPane().add(btnConfirmPw);
        //Confirm Password Button


        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(new Font("굴림", Font.BOLD, 25));
        nameLabel.setBounds(38, 353, 134, 38);
        f.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setForeground(Color.BLACK);
        nameField.setBackground(Color.WHITE);
        nameField.setFont(new Font("굴림", Font.BOLD, 25));
        nameField.setColumns(10);
        nameField.setBounds(199, 353, 233, 38);
        f.getContentPane().add(nameField);
        //Name


        JLabel genderLabel = new JLabel("성별");
        genderLabel.setFont(new Font("굴림", Font.BOLD, 25));
        genderLabel.setBounds(38, 424, 134, 38);
        f.getContentPane().add(genderLabel);

        genderField = new JTextField();
        genderField.setForeground(Color.BLACK);
        genderField.setBackground(Color.WHITE);
        genderField.setFont(new Font("굴림", Font.BOLD, 25));
        genderField.setColumns(10);
        genderField.setBounds(199, 424, 233, 38);
        genderField.setText("");
        genderField.setEnabled(false);
        f.getContentPane().add(genderField);
        //gender



        JCheckBox chkGenderMale = new JCheckBox("남성");
        chkGenderMale.setFont(new Font("굴림", Font.BOLD, 23));
        chkGenderMale.setForeground(Color.BLACK);
        chkGenderMale.setBackground(Color.WHITE);
        chkGenderMale.setBounds(450, 424, 104, 38);
        f.getContentPane().add(chkGenderMale);
        //Gender CheckBox - Male


        JCheckBox chkGenderFemale = new JCheckBox("여성");
        chkGenderFemale.setFont(new Font("굴림", Font.BOLD, 23));
        chkGenderFemale.setForeground(Color.BLACK);
        chkGenderFemale.setBackground(Color.WHITE);
        chkGenderFemale.setBounds(500, 424, 104, 38);
        f.getContentPane().add(chkGenderFemale);
        //Gender CheckBox - Female

        ButtonGroup group = new ButtonGroup();
        group.add(chkGenderMale);
        group.add(chkGenderFemale);

        chkGenderMale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderField.setText("남성");
                String gender = "M";
                chkGenderFemale.setSelected(false);
            }
        });
        chkGenderFemale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderField.setText("여성");
                String gender = "F";
                chkGenderMale.setSelected(false);
            }
        });
        //Gender CheckBox Group - Action


        JLabel telLabel = new JLabel("전화번호");
        telLabel.setFont(new Font("굴림", Font.BOLD, 25));
        telLabel.setBounds(38, 495, 134, 38);
        f.getContentPane().add(telLabel);

        telField = new JTextField();
        telField.setForeground(Color.BLACK);
        telField.setBackground(Color.WHITE);
        telField.setFont(new Font("굴림", Font.BOLD, 25));
        telField.setColumns(10);
        telField.setBounds(199, 495, 233, 38);
        f.getContentPane().add(telField);
        //Tel


        JButton btnSignUp = new JButton("회원가입");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String pw = pwField.getText();
                String pw2 = confirmPwField.getText();
                String name = nameField.getText();
                String tel = telField.getText();
                String gender = null;

                if(genderField.getText().equals("남성")){
                    gender = "M";
                } else if (genderField.getText().equals("여성")){
                    gender = "F";
                }

                if (pw.equals(pw2) && Flag == 1) {
                    MemberDto memberDto = new MemberDto(id, pw, name, gender ,tel);

                    MemberDao memberDao = new MemberDao();
                    memberDao.insert(memberDto);

//                    Login login = new Login();
//                    login.open();

                    System.out.println("회원 가입 성공");
                    JOptionPane.showMessageDialog(null,"회원 가입 성공");
                } else {
                    JOptionPane.showMessageDialog(null, "비밀번호 확인을 눌러주세요.");
                }
            }
        });
        btnSignUp.setFont(new Font("굴림", Font.BOLD, 23));
        btnSignUp.setForeground(Color.BLACK);
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setBounds(12, 578, 155, 94);
        f.getContentPane().add(btnSignUp);
        //Sign Up


        f.setVisible(true);
    }
}
