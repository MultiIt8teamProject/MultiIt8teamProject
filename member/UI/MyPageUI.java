package com.recipe.member.UI;

import com.recipe.member.Session.SessionManager;
import com.recipe.member.dao.MemberDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPageUI {

    public void open() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("마이페이지");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 238, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic


        JButton btnMemberInfoUI = new JButton("회원 정보");
        btnMemberInfoUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MemberInfoUI memberInfoUI = new MemberInfoUI();
                f.dispose();
                memberInfoUI.open();
            }
        });
        btnMemberInfoUI.setFont(new Font("굴림", Font.BOLD, 23));
        btnMemberInfoUI.setForeground(Color.BLACK);
        btnMemberInfoUI.setBackground(Color.WHITE);
        btnMemberInfoUI.setBounds(550, 282, 200, 38);
        f.getContentPane().add(btnMemberInfoUI);
        //Open MemberInfoUI Button


        JButton btnPostListUI = new JButton("내가 쓴 글");
        btnPostListUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PostListUI postListUI = new PostListUI();
                f.dispose();
                postListUI.open();
            }
        });
        btnPostListUI.setFont(new Font("굴림", Font.BOLD, 23));
        btnPostListUI.setForeground(Color.BLACK);
        btnPostListUI.setBackground(Color.WHITE);
        btnPostListUI.setBounds(550, 482, 200, 38);
        f.getContentPane().add(btnPostListUI);
        //Open btnPostListUI Button


        JButton btnScrapListUI = new JButton("스크랩 저장소");
        btnScrapListUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScrapListUI scrapListUI = new ScrapListUI();
                f.dispose();
                scrapListUI.open();
            }
        });
        btnScrapListUI.setFont(new Font("굴림", Font.BOLD, 23));
        btnScrapListUI.setForeground(Color.BLACK);
        btnScrapListUI.setBackground(Color.WHITE);
        btnScrapListUI.setBounds(550, 682, 200, 38);
        f.getContentPane().add(btnScrapListUI);
        //Confirm Password Button


        JButton btnMemberListUI = new JButton("회원 리스트");
        btnMemberListUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MemberListUI memberListUI = new MemberListUI();
                f.dispose();
                memberListUI.open();
            }
        });
        btnMemberListUI.setFont(new Font("굴림", Font.BOLD, 23));
        btnMemberListUI.setForeground(Color.BLACK);
        btnMemberListUI.setBackground(Color.WHITE);
        btnMemberListUI.setBounds(200, 282, 200, 38);
        f.getContentPane().add(btnMemberListUI);
        //Open MemberInfoUI Button


        JButton btndeleteAccount = new JButton("회원 탈퇴");
        btndeleteAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String userId = SessionManager.getAttribute("userId");

                int deleteAccount = JOptionPane.showConfirmDialog(null,
                        userId + "님 회원 탈퇴 하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);

                if (deleteAccount == JOptionPane.YES_OPTION) {
                    String input = JOptionPane.showInputDialog(f, "'탈퇴 확인'을 입력해주세요.");

                    if (input.equals("탈퇴 확인")) {

                        MemberDao memberDao = new MemberDao();
                        memberDao.deleteAccount(userId);
                    } else {
                        JOptionPane.showMessageDialog(null, "탈퇴를 취소합니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "탈퇴를 취소합니다.");
                }
            }
        });
        btndeleteAccount.setFont(new Font("굴림", Font.BOLD, 23));
        btndeleteAccount.setForeground(Color.BLACK);
        btndeleteAccount.setBackground(Color.WHITE);
        btndeleteAccount.setBounds(550, 882, 200, 38);
        f.getContentPane().add(btndeleteAccount);
        //Confirm Password Button


        f.setVisible(true);
    }
}
