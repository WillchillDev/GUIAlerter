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



import javax.swing.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static JLabel requestTimeZone = new JLabel("Please enter your timezone.");
	
	public static JRadioButton am;
	public static JRadioButton pm;
	
	public static JLabel hourDivider = new JLabel(":");
	public static JLabel minuteDivider = new JLabel(":");
	
	public static JLabel currentTimeLabel = new JLabel(" ");
	
	static long totalHours = 0;
	static long totalMinutes = 0;
	static long totalSeconds = 0;
	static long totalMilliseconds = 0;
	
	static Time current = new Time();
	public static AlertTime userAlertTime;
	
	static Window gui;
	
	public static void alert(){
		try {
			playSound();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		    Thread.sleep(15000);//Attempt to pause execution for 15 seconds.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public static boolean alerted(){
		if(current.hour == userAlertTime.hour && current.minute == userAlertTime.minute && current.second == userAlertTime.second)
			//If the current time matches with the given alert time, return true, else return false.
			return true;
		else return false;
	}
	
	public static void playSound() throws Exception{
		Sound sound = new Sound();
	}
	
	public static void getTime(){
		
	    //Obtain total milliseconds since midnight, Jan 1, 1970
	    totalMilliseconds = System.currentTimeMillis();
	    //compute the current millisecond in the second in the minute in the hour
	    current.milliSecond = (int) (totalMilliseconds % 1000);
	    //obtain total seconds since midnight Jan 1, 1970
	    totalSeconds = totalMilliseconds / 1000;
	    //compute the current second in the minute in the hour
	    current.second = (int) (totalSeconds % 60);
	    //obtain total minutes
	    totalMinutes = totalSeconds / 60;
	    //compute the current minute in the hour
	    current.minute = (int) (totalMinutes % 60);
	    //obtain the total hours
	    totalHours = totalMinutes / 60;
	    totalHours += gui.timezone;
	    //compute current hour
	    current.hour = (int) (totalHours % 24);
	}
	
	public static void main(String args[]){
		
		am = new JRadioButton("AM (morning)");
		pm = new JRadioButton("PM (night)");
		ButtonGroup periodOfDay = new ButtonGroup();

		//Adds the radio buttons "am" and "pm" to the group.
		//This ensures that only one can be selected at any given time.
		periodOfDay.add(am);
		periodOfDay.add(pm);
		
		am.setSelected(true);
		
		gui = new Window();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(200,200);
		gui.setTitle("Alerter - Now With GUI!");

		gui.add(requestTimeZone);
		gui.add(gui.timezoneField);
		gui.add(gui.inputTimezone);
        gui.setVisible(true);
		while(true){
			try {
    		    Thread.sleep(1000);//Attempt to pause execution for 1 second.
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
			
			if(gui.hasInputTimezone) break;
		}
			
			gui.getContentPane().removeAll();//Wipe the JFrame
			gui.getContentPane().repaint();//Set up JFrame for components.
			gui.add(gui.hourBox);
			gui.add(hourDivider);
			gui.add(gui.minuteBox);
			gui.add(minuteDivider);
			gui.add(gui.secondBox);
			gui.add(am);
			gui.add(pm);
			gui.add(gui.inputTimeButton);
			gui.setVisible(true);

	
			while(true){ //This loop waits for the user's input.
	
				try {
	    		    Thread.sleep(1000);//Attempt to pause execution for ~1 second.
	    		} catch(InterruptedException ex) {
	    		    Thread.currentThread().interrupt();
	    		}
				
				if(userAlertTime != null) break;
			}//End user input loop
				//Everything after this line occurs once the user has input a time.
				gui.add(currentTimeLabel);
				gui.setSize(435,65);
				while(!alerted()){
					getTime();
					currentTimeLabel.setText("Current Time: " + current.hour + ":" + current.minute + ":" + current.second + " " +
										"You will be alerted at: " + userAlertTime.hour + ":" + userAlertTime.minute + ":" + userAlertTime.second);
				
					try {
						Thread.sleep(1000);//Attempt to pause execution for ~1 second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}//End try/catch
	
				}//End while(!alerted())

			alert();
	}//End public static void main(String[] args) method
}//End "Main" class
