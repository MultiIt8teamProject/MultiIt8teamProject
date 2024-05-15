package com.multi.jdbc.member.view;

import com.multi.jdbc.member.model.dto.Dto;
import com.multi.jdbc.member.model.dao.NoticeDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WriteView {

    public static void writeUI() {

        JFrame frame = new JFrame("글쓰기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(950, 600);  // 프레임의 크기를 950x600으로 설정
        frame.setLocationRelativeTo(null);  // 창을 화면 중앙에 위치시키기
        Font myFont2 = new Font("돋음", Font.BOLD, 40);
        Font myFont1 = new Font("돋음", Font.BOLD, 13);

        // 메인 패널 설정, BoxLayout으로 컴포넌트를 세로로 정렬
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // 게시판 제목 라벨 패널
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitle = new JLabel("제목");
        labelTitle.setFont(myFont2);
        titlePanel.add(labelTitle);
        mainPanel.add(titlePanel);


        // 제목 입력 필드 패널
        JPanel titleInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField textTitle = new JTextField(40);
        titleInputPanel.add(textTitle);
        mainPanel.add(titleInputPanel);

        JPanel titlePanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelcon = new JLabel("내용");
        labelcon.setFont(myFont1);
        titlePanel1.add(labelcon);
        mainPanel.add(titlePanel1);

        // 내용 입력 필드 패널
        JPanel contentInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextArea textContent = new JTextArea(10, 80);
        contentInputPanel.add(new JScrollPane(textContent));
        mainPanel.add(contentInputPanel);

        // 저장 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = "작성자ID";     // 실제 로그인된 사용자의 아이디로 변경
                String subject = textTitle.getText();
                String content = textContent.getText();

                Dto dto = new Dto(1, id, subject, content, 0, new Date(), 0);

                NoticeDao dao = new NoticeDao();
                dao.insert(dto);

            }
        });
        buttonPanel.add(btnSave);
        mainPanel.add(buttonPanel);

        // 프레임에 메인 패널 추가
        frame.getContentPane().add(mainPanel);

        // 모든 설정 후 프레임을 화면에 보이기 전에 validate()를 호출하여 레이아웃을 새로 계산
        frame.validate();
        frame.setVisible(true);
    }


}
