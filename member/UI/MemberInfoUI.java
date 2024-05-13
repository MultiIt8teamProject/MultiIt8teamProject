package com.recipe.member.UI;

import com.recipe.member.Session.SessionManager;
import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberInfoUI {

    private JTextField idField;
    private JTextField pwField;
    private JTextField confirmPwField;
    private JTextField nameField;
    private JTextField telField;
    private JTextField genderField;


    static int Flag = 0;

    public void open() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("회원 정보");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 238, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic


        JLabel idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("굴림", Font.BOLD, 25));
        idLabel.setBounds(108, 140, 134, 38);
        f.getContentPane().add(idLabel);

        idField = new JTextField();
        idField.setForeground(Color.BLACK);
        idField.setBackground(Color.WHITE);
        idField.setFont(new Font("굴림", Font.BOLD, 25));
        idField.setBounds(299, 140, 233, 38);
        f.getContentPane().add(idField);
        idField.setColumns(10);
        String memberId = SessionManager.getAttribute("userId");
        idField.setText(memberId);
        idField.setEnabled(false);
        //ID


        JLabel pwLabel = new JLabel("비밀번호");
        pwLabel.setFont(new Font("굴림", Font.BOLD, 25));
        pwLabel.setBounds(108, 207, 134, 38);
        f.getContentPane().add(pwLabel);

        pwField = new JTextField();
        pwField.setForeground(Color.BLACK);
        pwField.setBackground(Color.WHITE);
        pwField.setFont(new Font("굴림", Font.BOLD, 25));
        pwField.setColumns(10);
        pwField.setBounds(299, 207, 233, 38);
        f.getContentPane().add(pwField);
        //1st Password


        JLabel confirmPwLabel = new JLabel("비밀번호 확인");
        confirmPwLabel.setFont(new Font("굴림", Font.BOLD, 25));
        confirmPwLabel.setBounds(108, 282, 164, 38);
        f.getContentPane().add(confirmPwLabel);

        confirmPwField = new JTextField();
        confirmPwField.setForeground(Color.BLACK);
        confirmPwField.setBackground(Color.WHITE);
        confirmPwField.setFont(new Font("굴림", Font.BOLD, 25));
        confirmPwField.setColumns(10);
        confirmPwField.setBounds(299, 282, 233, 38);
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
        btnConfirmPw.setBounds(550, 282, 200, 38);
        f.getContentPane().add(btnConfirmPw);
        //Confirm Password Button


        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(new Font("굴림", Font.BOLD, 25));
        nameLabel.setBounds(108, 353, 134, 38);
        f.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setForeground(Color.BLACK);
        nameField.setBackground(Color.WHITE);
        nameField.setFont(new Font("굴림", Font.BOLD, 25));
        nameField.setColumns(10);
        nameField.setBounds(299, 353, 233, 38);
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
        String memberGender = SessionManager.getAttribute("userGender");
        genderField.setEnabled(false);
        f.getContentPane().add(genderField);

        if(memberGender.equals("M")){
            genderField.setText("남성");
        } else if(memberGender.equals("F")){
            genderField.setText("여성");
        }
        //Gender


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

        if(memberGender.equals("M")){
            chkGenderMale.setSelected(true);
        } else if(memberGender.equals("F")){
            chkGenderFemale.setSelected(true);
        }

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

        chkGenderMale.setEnabled(false);
        chkGenderFemale.setEnabled(false);
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


        JButton btnEditAccountInfo = new JButton("회원 정보 수정");
        btnEditAccountInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = idField.getText();
                String pw = pwField.getText();
                String pw2 = confirmPwField.getText();
                String name = nameField.getText();
                String tel = telField.getText();
                String gender = null;

                if (genderField.getText().equals("남성")) {
                    gender = "M";
                } else if (genderField.getText().equals("여성")) {
                    gender = "F";
                }


                if (pw.equals(pw2) && Flag == 1) {
                    MemberDto memberDto = new MemberDto(id, pw, name, gender, tel);
                    MemberDao memberDao = new MemberDao();
                    memberDao.update(memberDto);

                    System.out.println("회원 정보 수정 성공");
                    JOptionPane.showMessageDialog(null, "회원 정보 수정 성공");
                } else {
                    JOptionPane.showMessageDialog(null, "비밀번호 확인을 눌러주세요.");
                }

            }
        });
        btnEditAccountInfo.setFont(new Font("굴림", Font.BOLD, 23));
        btnEditAccountInfo.setForeground(Color.BLACK);
        btnEditAccountInfo.setBackground(Color.WHITE);
        btnEditAccountInfo.setBounds(300, 800, 200, 94);
        f.getContentPane().add(btnEditAccountInfo);
        //Edit Account Info


        f.setVisible(true);
    }
}
