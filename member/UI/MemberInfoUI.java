package com.recipe.member.UI;

import com.recipe.menuUI.SiteIntroduceUI;
import com.recipe.run.MainController;
import com.recipe.member.Session.SessionManager;
import com.recipe.member.dao.MemberDao;
import com.recipe.member.dto.MemberDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberInfoUI {

    private JFrame frame;
    private JPanel panel;
    private JTextField idField;
    private JPasswordField pwField;
    private JTextField confirmPwField;
    private JTextField nameField;
    private JTextField telField;
    private JTextField genderField;

    private static JScrollPane scroll = null;


    static int Flag = 0;

    public void open() {

        frame = new JFrame();
        frame.setTitle("자취생 레시피 사이트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        panel = new JPanel(new BorderLayout());

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
        if (memberId != null && !memberId.isEmpty()) {
            headerPanel.add(mainlogoutButton, BorderLayout.EAST);
        } else {
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
                if (memberId != null && !memberId.isEmpty()) {
                    MyPageUI myPageUI = new MyPageUI();
                    frame.dispose();
                    myPageUI.open();
                } else {
                    JOptionPane.showMessageDialog(null, "로그인을 해주세요.");
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

        JLabel lblNewLabel = new JLabel("회원 정보");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNewLabel.setBounds(330, 50, 238, 53);
        panel.add(lblNewLabel);
        //Main Topic


        JLabel idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        idLabel.setBounds(200, 140, 134, 38);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setForeground(Color.BLACK);
        idField.setBackground(Color.WHITE);
        idField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        idField.setBounds(300, 140, 200, 38);
        panel.add(idField);
        idField.setColumns(10);
        idField.setText(memberId);
        idField.setEnabled(false);
        //ID


        JLabel pwLabel = new JLabel("비밀번호");
        pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pwLabel.setBounds(200, 200, 134, 38);
        panel.add(pwLabel);

        pwField = new JPasswordField();
        pwField.setForeground(Color.BLACK);
        pwField.setBackground(Color.WHITE);
        pwField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pwField.setColumns(10);
        pwField.setBounds(300, 200, 200, 38);
        panel.add(pwField);
        //1st Password


        JLabel confirmPwLabel = new JLabel("비밀번호 확인");
        confirmPwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        confirmPwLabel.setBounds(200, 260, 134, 38);
        panel.add(confirmPwLabel);

        confirmPwField = new JPasswordField();
        confirmPwField.setForeground(Color.BLACK);
        confirmPwField.setBackground(Color.WHITE);
        confirmPwField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        confirmPwField.setColumns(10);
        confirmPwField.setBounds(300, 260, 200, 38);
        panel.add(confirmPwField);
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
        btnConfirmPw.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnConfirmPw.setForeground(Color.BLACK);
        btnConfirmPw.setBackground(Color.WHITE);
        btnConfirmPw.setBounds(520, 260, 150, 38);
        panel.add(btnConfirmPw);
        //Confirm Password Button


        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        nameLabel.setBounds(200, 320, 134, 38);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setForeground(Color.BLACK);
        nameField.setBackground(Color.WHITE);
        nameField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        nameField.setColumns(10);
        nameField.setBounds(300, 320, 200, 38);
        panel.add(nameField);
        //Name


        JLabel genderLabel = new JLabel("성별");
        genderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        genderLabel.setBounds(200, 380, 134, 38);
        panel.add(genderLabel);

        genderField = new JTextField();
        genderField.setForeground(Color.BLACK);
        genderField.setBackground(Color.WHITE);
        genderField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        genderField.setColumns(10);
        genderField.setBounds(300, 380, 200, 38);
        String memberGender = SessionManager.getAttribute("userGender");
        genderField.setEnabled(false);
        panel.add(genderField);

        if (memberGender.equals("M")) {
            genderField.setText("남성");
        } else if (memberGender.equals("F")) {
            genderField.setText("여성");
        }
        //Gender


        JCheckBox chkGenderMale = new JCheckBox("남성");
        chkGenderMale.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        chkGenderMale.setForeground(Color.BLACK);
        chkGenderMale.setBackground(Color.WHITE);
        chkGenderMale.setBounds(520, 380, 60, 38);
        panel.add(chkGenderMale);
        //Gender CheckBox - Male


        JCheckBox chkGenderFemale = new JCheckBox("여성");
        chkGenderFemale.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        chkGenderFemale.setForeground(Color.BLACK);
        chkGenderFemale.setBackground(Color.WHITE);
        chkGenderFemale.setBounds(600, 380, 60, 38);
        panel.add(chkGenderFemale);
        //Gender CheckBox - Female

        ButtonGroup group = new ButtonGroup();
        group.add(chkGenderMale);
        group.add(chkGenderFemale);

        if (memberGender.equals("M")) {
            chkGenderMale.setSelected(true);
        } else if (memberGender.equals("F")) {
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
        telLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        telLabel.setBounds(200, 440, 134, 38);
        panel.add(telLabel);

        telField = new JTextField();
        telField.setForeground(Color.BLACK);
        telField.setBackground(Color.WHITE);
        telField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        telField.setColumns(10);
        telField.setBounds(300, 440, 200, 38);
        panel.add(telField);
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

                if (!idField.getText().isEmpty()) {
                    char[] password = pwField.getPassword();
                    if (password.length > 0) {
                        if (!nameField.getText().isEmpty()) {
                            if (!genderField.getText().isEmpty()) {
                                if (!telField.getText().isEmpty()) {
                                    if (pw.equals(pw2) && Flag == 1) {
                                        MemberDto memberDto = new MemberDto(id, pw, name, gender, tel);
                                        MemberDao memberDao = new MemberDao();
                                        memberDao.update(memberDto);

                                        System.out.println("회원 정보 수정 성공");
                                        JOptionPane.showMessageDialog(null, "회원 정보 수정 성공");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "비밀번호 확인을 눌러주세요.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "연락처를 입력해주세요.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "성별을 골라주세요.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
                }

            }
        });
        btnEditAccountInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnEditAccountInfo.setForeground(Color.BLACK);
        btnEditAccountInfo.setBackground(Color.WHITE);
        btnEditAccountInfo.setBounds(305, 500, 150, 50);
        panel.add(btnEditAccountInfo);
        //Edit Account Info

        scroll = new JScrollPane(panel);
        frame.add(panel);
        panel.add(scroll);

        frame.setVisible(true);
    }
}
