package com.example.jfp.s02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ClassicSwing extends JFrame {
    private final JButton btnLeft;
    private final JButton btnRight;
    private int counterLeft;
    private int counterRight;

    private class LeftButtonChanger implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnLeft.setText(Integer.toString(++counterLeft));
        }
    }

    public ClassicSwing() {
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello");

        btnLeft = new JButton("Click me!");
        btnLeft.addActionListener(new LeftButtonChanger());

        btnRight = new JButton("...or me!");
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRight.setText(Integer.toString(++counterRight));
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnLeft);
        panel.add(btnRight);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClassicSwing();
    }
}