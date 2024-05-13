package com.recipe.member.UI;

import javax.swing.*;
import java.awt.*;

public class ScrapListUI {

    public void open() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.GRAY);
        f.setSize(860, 1000);
        f.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("스크랩 저장소");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 47));
        lblNewLabel.setBounds(300, 27, 508, 53);
        f.getContentPane().add(lblNewLabel);
        //Main Topic


        f.setVisible(true);
    }
}
