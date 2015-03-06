package com.curryblur.rpgtool.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.*;

import com.curryblur.rpgtool.dice.Dice;

public class DicePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton rollDice;
	BufferedImage Img1, Img2, Img3;
	Dice dice1, dice2, dice3;
	JLabel label1, label2, label3, labelTotal, labelTitle;
	ImagePanel imgPanel1; 
	ImagePanel imgPanel2;
	ImagePanel imgPanel3; 
	
	public DicePanel(){
		//set up initial status
		UIManager.put("Label.font", new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 25));
		dice1 = new Dice(6);
		dice2 = new Dice(6);
		dice3 = new Dice(6);
		labelTitle = new JLabel("Dice Roller");
		labelTitle.setFont(new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 30));
		label1 = new JLabel("You rolled: ");
		label2 = new JLabel("You rolled: ");
		label3 = new JLabel("You rolled: ");
		labelTotal = new JLabel("Your total is: ");
		label1.setForeground(Color.white);
		label2.setForeground(Color.white);
		label3.setForeground(Color.white);
		labelTotal.setForeground(Color.white);
		labelTitle.setForeground(Color.white);
		Img1 = dice1.getImage();
		Img2 = dice2.getImage();
		Img3 = dice3.getImage();
		
		//get dice button ready
		rollDice = new JButton("Roll Dice!");
		rollDice.addActionListener(new DiceListener());
		
		//set overall layout
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.setBackground(Color.DARK_GRAY);
		
		imgPanel1 = new ImagePanel(Img1, Color.DARK_GRAY, 0);
		imgPanel2 = new ImagePanel(Img2, Color.DARK_GRAY, 0);
		imgPanel3 = new ImagePanel(Img3, Color.DARK_GRAY, 0);
		
		c.weightx = 2;
		c.weighty = 2;
		c.gridx = 1;
		c.gridy = 0;
		this.add(labelTitle,c);
		
		c.gridx = 0;
		c.gridy = 1;
		
		this.add(imgPanel1, c);
		
		c.gridx = 1;
		this.add(imgPanel2, c);
		
		c.gridx = 2;
		this.add(imgPanel3, c);
		
		c.gridy = 2;
		c.gridx = 0;
		this.add(label1, c);
		
		c.gridx = 1;
		this.add(label2, c);
		
		c.gridx = 2;
		this.add(label3, c);
		
		c.gridx = 1;
		c.gridy = 3;
		this.add(labelTotal, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 3;
		c.fill=GridBagConstraints.CENTER;
		this.add(rollDice, c);
	}
	
	public void resetDice(){
		//get new dice numbers
		dice1.reset();
		dice2.reset();
		dice3.reset();
		
		//retrieve new dice info
		Img1 = dice1.getImage();
		Img2 = dice2.getImage();
		Img3 = dice3.getImage();
		label1.setText("You rolled: " + dice1.getNumber());
		label2.setText("You rolled: " + dice2.getNumber());
		label3.setText("You rolled: " + dice3.getNumber());
		int sum = dice1.getNumber() + dice2.getNumber() + dice3.getNumber();
		labelTotal.setText("Your total is: " + sum);
		
		//set panels with new Images and repaint
		imgPanel1.setImg(Img1);
		imgPanel2.setImg(Img2);
		imgPanel3.setImg(Img3);
		imgPanel1.repaint();
		imgPanel2.repaint();
		imgPanel3.repaint();
	}
	
	private class DiceListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			resetDice();
		}
	}
	
	
}
