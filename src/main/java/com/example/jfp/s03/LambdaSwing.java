package com.example.jfp.s03;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class LambdaSwing extends JFrame {
    private final JButton btnLeft;
    private final JButton btnRight;
    private int counterLeft;
    private int counterRight;

    public LambdaSwing() {
        setSize(300, 100);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello");

        btnLeft = new JButton("Click me!");
        ActionListener changer = e -> btnLeft.setText(Integer.toString(++counterLeft));
        btnLeft.addActionListener(changer);

        btnRight = new JButton("...or me!");
        btnRight.addActionListener(e -> btnRight.setText(Integer.toString(++counterRight)));

        JPanel panel = new JPanel();
        panel.add(btnLeft);
        panel.add(btnRight);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LambdaSwing();
    }
}