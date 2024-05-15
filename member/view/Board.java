package com.multi.jdbc.member.view;


import com.recipe.member.UI.LoginUI;
import com.recipe.member.UI.MyPageUI;
import com.recipe.member.UI.SignUpUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

public class Board {

    private JFrame f = new JFrame("게시판"); // 창의 제목을 추가함
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private String[] header = {"NO", "작성자", "제목", "작성일", "조회수", "수정", "삭제"};
    private JPanel panel = new JPanel();
    Font myFont1 = new Font("돋음", Font.BOLD, 13);
    Font myFont2 = new Font("돋음", Font.BOLD, 40);

    // 생성자: 버튼과 테이블 UI를 초기화하고 JFrame을 설정
    public Board() {
        button();
        tableUI();
        loadTableData();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(950, 600);
        f.setVisible(true);
    }

    // 버튼 스타일을 설정하는 메서드
    private void configureButton(JButton button) {
        button.setBackground(Color.white);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.black);
        button.setOpaque(true);
    }


    // 테이블 설정 메서드
    private void tableUI() {
        tableModel = new DefaultTableModel(null, header);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        panel.setLayout(new BorderLayout()); // BorderLayout 사용
        panel.add(scrollPane, BorderLayout.CENTER); // 스크롤 패널을 패널 중앙에 추가
        f.getContentPane().add(panel);

        // 테이블 행의 버튼 추가
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), "수정"));

        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), "삭제"));

table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        int col = table.columnAtPoint(e.getPoint());

        if (col == 2) {
            String title = (String) table.getValueAt(row, col);
            String content = loadContent((Integer) table.getValueAt(row, 0)); // 첫 번째 컬럼의 ID를 사용하여 내용 로드
            NoticeView.displayNotice("Example Title", "This is an example content for the notice. It can be multiple lines long and will be displayed in a JTextArea.", 123, "AuthorID123");
            Board.open();
        }
        super.mouseClicked(e);

    }
});
    }

    private static void open() {

    }

    private String loadContent(int num) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "scott";
        String password = "tiger";
        String content = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("SELECT content FROM BOARD WHERE num = ?")) {
            ps.setInt(1, num);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    content = rs.getString("content");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return content;
    }

    private void loadTableData() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "scott";
        String password = "tiger";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT num, id, subject, created, hitcount FROM BOARD")) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("num"));
                row.add(rs.getString("id"));
                row.add(rs.getString("subject"));
                row.add(rs.getDate("created"));
                row.add(rs.getInt("hitcount"));
                tableModel.addRow(row);
            }
        } catch (SQLException e) {



        }
    }

    // 버튼을 설정하는 메서드
    private void button() {
        JButton b1 = new JButton("로그인");
        JButton b2 = new JButton("회원가입");
        JButton b3 = new JButton("마이페이지");
        JButton b4 = new JButton("글쓰기");
        JButton b5 = new JButton("레시피");

        // 버튼 폰트 설정 및 스타일 적용
        b1.setFont(myFont1);
        b2.setFont(myFont1);
        b3.setFont(myFont1);
        b4.setFont(myFont1);
        b5.setFont(myFont1);
        configureButton(b1);
        configureButton(b2);
        configureButton(b3);
        configureButton(b4);
        configureButton(b5);

        // 버튼 패널을 생성하고 버튼을 추가
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);

        // 버튼 패널을 JFrame의 북쪽에 추가
        f.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        // 각 버튼에 대한 액션 리스너 설정
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI.login();
                f.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpUI.open();
                f.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyPageUI.open();
                f.dispose();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteView.writeUI();
                f.dispose();
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 여기에 레시피 버튼 클릭 시 동작을 추가하세요.
            }
        });
    }

    // 테이블 셀을 버튼으로 렌더링하는 클래스
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // 버튼 에디터 클래스
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            this.label = label;
            button = new JButton();
            button.setOpaque(true); // 버튼을 불투명하게 설정
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped(); // 버튼 클릭 시 편집을 중지
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());  // 선택된 상태의 텍스트 색상 설정
                button.setBackground(table.getSelectionBackground()); // 선택된 상태의 배경 색상 설정
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return new String(label);
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }


}
