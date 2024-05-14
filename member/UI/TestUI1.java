package com.recipe.member.UI;

import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;

public class TestUI1 {

    public void open(String page){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("내가 쓴 글");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 238, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic



        JLabel test1 = new JLabel("");
        test1.setFont(new Font("굴림", Font.BOLD, 47));
        test1.setBounds(300, 227, 238, 53);
        f.getContentPane().add(test1);



        JLabel test2 = new JLabel("");
        test2.setFont(new Font("굴림", Font.BOLD, 47));
        test2.setBounds(300, 427, 238, 53);
        f.getContentPane().add(test2);

        MemberDao memberDao = new MemberDao();
        MemberDto rsDto = memberDao.selectPage(page);

        if (rsDto != null) {
            String id = rsDto.getId();
            String pw = rsDto.getPw();
            test1.setText(id);
            test2.setText(pw);
        } else {
            JOptionPane.showMessageDialog(null, "페이지를 찾을 수 없습니다..");
        }


        f.setVisible(true);

    }
}
