package com.recipe.menuUI;

import com.recipe.run.MainController;
import com.recipe.member.Session.SessionManager;
import com.recipe.member.UI.LoginUI;
import com.recipe.member.UI.MyPageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SiteIntroduceUI {

    private JFrame frame;
    private JPanel panel;

    public void open() {

        frame = new JFrame();

        frame.setTitle("사이트 소개");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        panel = new JPanel(new BorderLayout());

        //----------------------------------------------

        // 헤더
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.PINK);
        headerPanel.setPreferredSize(new Dimension(headerPanel.getWidth(), 100)); // bar 높이 설정
        headerPanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("혼밥 요리 닷컴");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // 폰트 설정
        titleLabel.setForeground(Color.WHITE); // 텍스트 색상 설정
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 가운데 정렬
        headerPanel.add(titleLabel, BorderLayout.CENTER); // 텍스트 레이블을 headerPanel의 중앙에 추가
        panel.add(headerPanel, BorderLayout.NORTH); // 헤더 패널을 상단에 추가


        // 홈 버튼 추가
        JButton homeButton = new JButton(" Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // 현재 화면 닫기
                MainController.returnToHome(); // 홈 버튼을 눌렀을 때 초기화면으로 돌아가는 메서드 호출

            }
        });
        homeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(Color.PINK);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.pink, 2));
        headerPanel.add(homeButton, BorderLayout.WEST);


        // 로그인 버튼 추가
        JButton mainloginButton = new JButton("로그인 ");
        mainloginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI loginUI = new LoginUI();
                frame.dispose();
                loginUI.open();
            }
        });
        mainloginButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        mainloginButton.setForeground(Color.WHITE);
        mainloginButton.setBackground(Color.PINK);
        mainloginButton.setBorder(BorderFactory.createLineBorder(Color.pink, 2)); // 테두리 선 설정


        // 로그아웃 버튼 추가
        JButton mainlogoutButton = new JButton("로그아웃 ");
        mainlogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SessionManager.clearSession();
                JOptionPane.showMessageDialog(null, "로그아웃했습니다.");
                frame.dispose(); // 현재 화면 닫기
                MainController.returnToHome(); // 홈 버튼을 눌렀을 때 초기화면으로 돌아가는 메서드 호출
            }
        });
        mainlogoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        mainlogoutButton.setForeground(Color.WHITE);
        mainlogoutButton.setBackground(Color.PINK);
        mainlogoutButton.setBorder(BorderFactory.createLineBorder(Color.pink, 2)); // 테두리 선 설정


        String memberId = SessionManager.getAttribute("userId");
        if(memberId != null && !memberId.isEmpty()){
            headerPanel.add(mainlogoutButton, BorderLayout.EAST);
        } else  {
            headerPanel.add(mainloginButton, BorderLayout.EAST);
        }

        //---------------------------------------------------

        // 왼쪽 bar
        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.pink);
        navPanel.setPreferredSize(new Dimension(150, frame.getHeight())); // bar 크기 설정
        navPanel.setLayout(new BorderLayout());
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        // 공지사항 버튼
        JButton mainNoticeButton = new JButton("공지사항");
        // 공지사항 버튼 클릭 시
        mainNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //NoticeUI noticeUI = new NoticeUI();
                //NoticeUI.open();
            }
        });
        mainNoticeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        mainNoticeButton.setForeground(Color.WHITE);
        mainNoticeButton.setBackground(Color.PINK);
        mainNoticeButton.setPreferredSize(new Dimension(150, 50)); // 버튼 크기 설정
        mainNoticeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 테두리 선 설정
        navPanel.add(mainNoticeButton);

        // 레시피 버튼 추가
        JButton mainRecipeButton = new JButton("레시피");
        mainRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //레시피 오픈
                //recipUI.open();
            }
        });
        mainRecipeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        mainRecipeButton.setForeground(Color.WHITE);
        mainRecipeButton.setBackground(Color.PINK);
        mainRecipeButton.setPreferredSize(new Dimension(150, 50)); // 버튼 크기 설정
        mainRecipeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 테두리 선 설정
        navPanel.add(mainRecipeButton);

        // 사이트 소개 버튼 추가
        JButton SiteButton = new JButton("사이트 소개");
        SiteButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        SiteButton.setForeground(Color.WHITE);
        SiteButton.setBackground(Color.PINK);
        SiteButton.setPreferredSize(new Dimension(150, 50)); // 버튼 크기 설정
        SiteButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 테두리 선 설정
        navPanel.add(SiteButton); // 사이트 소개 버튼을 네비게이션 바에 추가
        SiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SiteIntroduceUI siteIntroduceUI = new SiteIntroduceUI();
                frame.dispose();
                siteIntroduceUI.open();
            }
        });

        // 마이페이지 버튼
        JButton mainMyPageButton = new JButton("마이페이지");
        mainMyPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = SessionManager.getAttribute("userId");
                if(memberId != null && !memberId.isEmpty()){
                    MyPageUI myPageUI = new MyPageUI();
                    frame.dispose();
                    myPageUI.open();
                } else  {
                    JOptionPane.showMessageDialog(null,"로그인을 해주세요.");
                }
            }
        });
        mainMyPageButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        mainMyPageButton.setForeground(Color.WHITE);
        mainMyPageButton.setBackground(Color.PINK);
        mainMyPageButton.setPreferredSize(new Dimension(150, 50)); // 버튼 크기 설정
        mainMyPageButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // 테두리 선 설정
        navPanel.add(mainMyPageButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(navPanel, BorderLayout.WEST); // 네비게이션 바를 서쪽에 배치
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH); // 헤더 패널을 북쪽에 배치

        //----------------------------------------------


        JLabel textLabel = new JLabel("<html>안녕하세요! 혼밥 요리 닷컴에 오신 것을 환영합니다.<br>" +
                "자취생들을 위해 다양한 요리 레시피를 제공하고 있습니다. 바쁜 일상 속에서도 " +
                "쉽고 빠르게 요리할 수 있는 레시피부터 가성비 좋은 요리까지, " + "여러분의 요리 경험을 더욱 " +
                "즐겁게 만들어 드립니다.<br>자세한 사항이나 궁금한 점이 있다면 언제든 문의해주세요.</html>");
        textLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        textLabel.setForeground(Color.BLACK); // 텍스트 색상 설정
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textLabel, BorderLayout.CENTER);
        frame.add(panel);


        frame.setVisible(true);
    }
}
