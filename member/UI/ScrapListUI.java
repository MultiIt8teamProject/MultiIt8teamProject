package com.recipe.member.UI;

import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;
import com.recipe.member.moveButton.MoveButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScrapListUI {

    private static JScrollPane scroll = null;

    public void open() {

        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.setLayout(null); // 레이아웃 매니저를 null로 설정하여 절대 위치를 사용


        JLabel lblNewLabel = new JLabel("스크랩 저장소");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 508, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic

        MemberDao dao = new MemberDao();
        ArrayList<MemberDto> list = dao.list(); // ArrayList<MemberDto>

        JPanel p = new JPanel(new GridLayout(list.size(), 1));
        p.setBounds(0, 200, 860, 87);
        p.setBackground(Color.GRAY);



        // 테이블에서 가져온 각 ID에 대해 버튼 생성 및 추가
        for (MemberDto dto : list) {
            JButton button = new JButton(dto.getId());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 해당 ID에 대한 동작 수행
                    JButton clickedButton = (JButton) e.getSource();
                    String clickedID = clickedButton.getText();
                    MoveButton.move(clickedID);
                }
            });
            p.add(button);
        }

        //f.setLayout(new FlowLayout());
        scroll = new JScrollPane(p);
        f.add(p);
        p.add(scroll);

        f.setVisible(true);
    }


}
