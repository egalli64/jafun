/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafun
 */
package com.example.jafun.m1.s3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * High-Order Function in classic Java - Event manager example
 * <p>
 * A simple swing frame that deals with a couple of events
 * <p>
 * It defines an inner class implementing the action to be executed when one of
 * the two events is observed, then add an action listener on a button for it
 * <p>
 * The other event is managed by an action listener defined and created on the
 * fly. If the action performed is slim enough, this is the preferred approach
 */
@SuppressWarnings("serial")
public class HOF2Event extends JFrame {
    private final JButton btnLeft;
    private final JButton btnRight;
    private int counterLeft;
    private int counterRight;

    /**
     * A classic event listener
     */
    private class LeftButtonChanger implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnLeft.setText(Integer.toString(++counterLeft));
        }
    }

    public HOF2Event() {
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello");

        btnLeft = new JButton("Click me!");
        // create an object of the stated inner class as event listener
        btnLeft.addActionListener(new LeftButtonChanger());

        btnRight = new JButton("...or me!");

        // an anonymous event listener is created on the fly
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

    /**
     * Start this tiny swing application
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        new HOF2Event();
    }
}
