package com.curryblur.rpgtool.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.curryblur.rpgtool.main.MainPanel;

public class UserInterface {
	
	public UserInterface(){
	}
	
	public void start(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("RPG Toolkit of Awesomeness!");
				frame.setBackground(Color.DARK_GRAY);
				frame.setSize(800, 500);
				frame.setMinimumSize(new Dimension(600, 400));
				frame.setLocation(200, 150);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.add(new MainPanel());
				frame.setVisible(true);
			}
		});
	}
}
