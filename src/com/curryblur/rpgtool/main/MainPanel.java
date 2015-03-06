package com.curryblur.rpgtool.main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.curryblur.rpgtool.ui.DicePanel;
import com.curryblur.rpgtool.ui.HeroPanel;
import com.curryblur.rpgtool.ui.WeaponPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DicePanel dicePanel;
	HeroPanel heroPanel;
	WeaponPanel weaponPanel;
	JPanel mainPanel;
	JPanel buttonPanel;
	JButton dice, hero, weapon;
	
	public MainPanel(){
		this.dicePanel = new DicePanel();
		this.heroPanel = new HeroPanel();
		this.weaponPanel = new WeaponPanel();
		this.mainPanel = new JPanel();
		this.buttonPanel = new JPanel();
		
		setUpButtonPanel(buttonPanel);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		mainPanel.setLayout(new GridBagLayout());
		
		c.weightx = 2;
		c.weighty = 2;
		c.gridy = 0;
		c.gridx = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(heroPanel, c);
		
		this.add(mainPanel, c);
		
		c.gridy = 1;
		this.add(buttonPanel, c);
	}
	
	private void setUpButtonPanel(JPanel buttonPanel){
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		dice = new JButton("Dice Generator");
		hero = new JButton("Hero Generator");
		weapon = new JButton("Weapon Generator");
		
		dice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				updateMainPanel(dicePanel);
			}
		});
		
		hero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				updateMainPanel(heroPanel);
			}
		});
		
		weapon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				updateMainPanel(weaponPanel);
			}
		});
		
		
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(dice,c);
		
		c.gridx = 1;
		buttonPanel.add(hero, c);
		
		c.gridx = 2;
		buttonPanel.add(weapon, c);
		
	}
	
	private void updateMainPanel(JPanel panel){
		GridBagConstraints c = new GridBagConstraints();
		this.remove(mainPanel);
		this.invalidate();
		c.weightx = 2;
		c.weighty = 2;
		c.gridy = 0;
		c.gridx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(panel, c);
		this.validate();
		this.repaint();
		mainPanel = panel;
	}
	
}
