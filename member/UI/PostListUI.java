package com.recipe.member.UI;

import javax.swing.*;
import java.awt.*;

public class PostListUI {

    public void open() {

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


        f.setVisible(true);
    }
}
