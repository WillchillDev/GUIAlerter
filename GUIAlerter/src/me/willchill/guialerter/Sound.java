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

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;


public class Sound {
	
	public Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		URL is = getClass().getResource("sound.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(is);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clip.start();
	}
	
}
