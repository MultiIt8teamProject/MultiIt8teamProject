package com.recipe.member.UI;

import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MemberListUI {

    private static JScrollPane scroll = null;

    public void open() {

        JFrame f = new JFrame();
        JPanel p = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.setLayout(null); // 레이아웃 매니저를 null로 설정하여 절대 위치를 사용
        p.setBounds(0, 200, 860, 87);
        p.setBackground(Color.GRAY);

        JLabel lblNewLabel = new JLabel("회원 리스트");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 508, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic


        MemberDao dao = new MemberDao();
        ArrayList<MemberDto> list = dao.list(); // ArrayList<MemberDto>

        String[] header = {"회원 번호","아이디", "이름", "성별", "전화번호"};
        String[][] all = new String[list.size()][5];

        if (list.size() == 0) {
            System.out.println("검색결과 없음. ");
        } else {
            System.out.println("검색결과는 전체 " + list.size() + "개 입니다.");
            for (int i = 0; i < all.length; i++) { //13개의 가방,13개의 행
                all[i][0] = String.valueOf(list.get(i).getNo());
                all[i][1] = list.get(i).getId();
                all[i][2] = list.get(i).getName();
                all[i][3] = list.get(i).getGender();
                all[i][4] = list.get(i).getTel();
            }
        }//else

        JTable MemberListTable = new JTable(all, header);
        scroll = new JScrollPane(MemberListTable);


        //f.setLayout(new FlowLayout());
        f.add(p);
        MemberListTable.setEnabled(false);
        p.add(scroll);

        f.setVisible(true);
    }

}