package com.recipe.member.UI;

import com.recipe.member.Session.SessionManager;
import com.recipe.menuUI.SiteIntroduceUI;
import com.recipe.post.dao.PostDao;
import com.recipe.post.dto.PostDto;
import com.recipe.run.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScrapListUI {

    private JFrame frame;
    private JPanel panel;

    private static JScrollPane scroll = null;

    public void open() {

        frame = new JFrame();
        frame.setTitle("자취생 레시피 사이트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        panel = new JPanel();
        panel.setBounds(0, 200, 860, 87);

        //----------------------------------------------

        // 헤더
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.PINK);
        headerPanel.setPreferredSize(new Dimension(headerPanel.getWidth(), 100)); // bar 높이 설정
        headerPanel.setLayout(new BorderLayout());
        JLabel textLabel = new JLabel("혼밥 요리 닷컴");
        textLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // 폰트 설정
        textLabel.setForeground(Color.WHITE); // 텍스트 색상 설정
        textLabel.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 가운데 정렬
        headerPanel.add(textLabel, BorderLayout.CENTER); // 텍스트 레이블을 headerPanel의 중앙에 추가
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
        JButton mainlogoutButton = new JButton("로그아웃");
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


        JLabel lblNewLabel = new JLabel("스크랩 저장소");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 508, 53);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblNewLabel);
        //Main Topic


        PostDao postDao = new PostDao();
        ArrayList<PostDto> list = postDao.scrapList(memberId);

        if (list.size() == 0) {
            // 검색결과가 없는 경우
            System.out.println("검색결과 없음.");
        } else {
            System.out.println("검색결과는 전체 " + list.size() + "개 입니다.");
            // 테이블에 표시할 데이터를 담을 배열
            String[] header = {"카테고리", "제목"};
            String[][] all = new String[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                // 각 행에 데이터 설정
                all[i][0] = list.get(i).getRCategory();
                all[i][1] = list.get(i).getTitle();
            }
            JTable scrapListTable = new JTable(all, header);
            scrapListTable.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            scrapListTable.setEnabled(false);
            //ScrapListTable

            JScrollPane scroll = new JScrollPane(scrapListTable);
            scroll.setPreferredSize(new Dimension(200, 400));
            panel.add(scroll);
        }

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
