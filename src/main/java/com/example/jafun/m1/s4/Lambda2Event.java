/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s4;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * High-Order Function in modern Java - Event manager example
 * <p>
 * A simple swing frame that deals with a couple of events.
 * <li>A lambda is used to define an ActionListener that is passed to a button
 * by addActionListener
 * <li>Another lambda is passed directly to addActionListener
 */
@SuppressWarnings("serial")
public class Lambda2Event extends JFrame {
    private final JButton btnLeft;
    private final JButton btnRight;
    private int counterLeft;
    private int counterRight;

    public Lambda2Event() {
        setSize(300, 100);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello");

        btnLeft = new JButton("Click me!");
        // Explicitly define a lambda action listener, and then pass it to addActionListener()
        ActionListener changer = e -> btnLeft.setText(Integer.toString(++counterLeft));
        btnLeft.addActionListener(changer);

        btnRight = new JButton("...or me!");
        // Pass a lambda to addActionListener(), that matches to the required action listener
        btnRight.addActionListener(e -> btnRight.setText(Integer.toString(++counterRight)));

        JPanel panel = new JPanel();
        panel.add(btnLeft);
        panel.add(btnRight);
        add(panel);

        setVisible(true);
    }

    /**
     * Start this tiny swing application
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        new Lambda2Event();
    }
}