package me.willchill.guialerter;

/*******************************************************************************\
 *                This file is part of Will's GUI Alerter.					   *
 *																			   *
 *  Will's GUI Alerter is free software: you can redistribute it and/or modify *
 *  it under the terms of the GNU General Public License as published by	   *
 *  the Free Software Foundation, either version 3 of the License, or		   *
 *  (at your option) any later version.										   *
 *																			   *
 *  Will's GUI Alerter is distributed in the hope that it will be useful,	   *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of			   *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the			   *
 *  GNU General Public License for more details.							   *
 *																			   *
 *  You should have received a copy of the GNU General Public License          *
 *  along with Will's GUI Alerter.  If not, see <http://www.gnu.org/licenses/>.*
 \******************************************************************************/

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;



public class Window extends JFrame{
private static final long serialVersionUID = 1L;
	
	public JTextField timezoneField = new JTextField(5);
	public int timezone = 0;
	public JButton inputTimezone;
	public boolean hasInputTimezone = false;

	public JComboBox<Object> hourBox;
	public JComboBox<Object> minuteBox;
	public JComboBox<Object> secondBox;
	public JButton inputTimeButton;
	
	public int hour = 0;
	public int minute = 0;
	public int second = 0;
	
	private static String[] hourSelection = {"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12"};
	private static String[] minuteSecondSelection = {"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
		"17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
		"27", "28", "29", "30", "31", "32", "33", "34", "35", "36",
		"37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
		"47", "48", "49", "50", "51", "52", "53", "54", "55", "56",
		"57", "58", "59"};
	
	public Window(){
		setLayout(new FlowLayout());
		
		inputTimezone = new JButton("Input Timezone");
		inputTimezone.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//This executes when the button is pressed.
						timezone = Integer.parseInt(timezoneField.getText());
						System.out.println("Timezone: " + timezone);
						
						hasInputTimezone = true;
					}
				}
		);
		
		hourBox = new JComboBox<Object>(hourSelection);
		hourBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
							if(event.getStateChange() == ItemEvent.SELECTED)
								//This executes when an item is selected from the "hours" drop-down menu.
								hour = hourBox.getSelectedIndex();
					}
				}
		);
		
		minuteBox = new JComboBox<Object>(minuteSecondSelection);
		minuteBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
							if(event.getStateChange() == ItemEvent.SELECTED)
								//This executes when an item is selected from the "minutes" drop-down menu.
								minute = minuteBox.getSelectedIndex();
					}
				}
		);
		
		secondBox = new JComboBox<Object>(minuteSecondSelection);
		secondBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
							if(event.getStateChange() == ItemEvent.SELECTED)
								//This executes when an item is selected from the "seconds" drop-down menu.
								second = secondBox.getSelectedIndex();
					}
				}
		);
		
		inputTimeButton = new JButton("Save Input");
		inputTimeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//This executes when the button is pressed.
				if(Main.pm.isSelected()){
					Main.userAlertTime = new AlertTime(hour + 12, minute, second);
				} else {
					Main.userAlertTime = new AlertTime(hour, minute, second);
				}
				System.out.println("User Alert Time: " + Main.userAlertTime.hour + ":" + Main.userAlertTime.minute + ":" + Main.userAlertTime.second);
				getContentPane().removeAll();//Clears JFrame
				getContentPane().repaint();//Prepares JFrame for components.
				
				}
			}
		);
		
	}
}
