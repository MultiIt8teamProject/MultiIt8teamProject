package com.multi.jdbc.member.view;

import javax.swing.*;
import java.awt.*;

public class NoticeView {

    public static void displayNotice(String title, String content, int views, String authorId) {
        // Create and set up the frame
        JFrame frame = new JFrame("게시글 조회");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Set up fonts
        Font titleFont = new Font("돋음", Font.BOLD, 20);
        Font contentFont = new Font("돋음", Font.PLAIN, 16);

        // Main panel setup with BoxLayout for vertical alignment
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title label
        JLabel titleLabel = new JLabel("제목");
        titleLabel.setFont(titleFont);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title area
        JTextArea titleArea = new JTextArea(1, 40);
        titleArea.setText(title);
        titleArea.setFont(contentFont);
        titleArea.setLineWrap(true);
        titleArea.setWrapStyleWord(true);
        titleArea.setEditable(false);
        JScrollPane titleScrollPane = new JScrollPane(titleArea);

        // Content label
        JLabel contentLabel = new JLabel("내용");
        contentLabel.setFont(titleFont);
        contentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Content area
        JTextArea contentArea = new JTextArea(20, 40);
        contentArea.setFont(contentFont);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setEditable(false);
        JScrollPane contentScrollPane = new JScrollPane(contentArea);

        // Bottom panel for author ID, close button, and views
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Author ID label
        JLabel authorLabel = new JLabel("작성자: " + authorId);
        authorLabel.setFont(contentFont);
        authorLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(authorLabel, BorderLayout.WEST);

        // Close button
        JButton closeButton = new JButton("닫기");
        closeButton.setFont(contentFont);
        closeButton.setPreferredSize(new Dimension(100, 30));
        closeButton.addActionListener(e -> frame.dispose());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(closeButton);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Views label
        JLabel viewsLabel = new JLabel("조회수: " + views);
        viewsLabel.setFont(contentFont);
        viewsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(viewsLabel, BorderLayout.EAST);

        // Add components to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(titleScrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between components
        mainPanel.add(contentLabel);
        mainPanel.add(contentScrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between components
        mainPanel.add(bottomPanel);

        // Add main panel to the frame
        frame.getContentPane().add(mainPanel);

        // Validate and display the frame
        frame.validate();
        frame.setVisible(true);
    }


}
