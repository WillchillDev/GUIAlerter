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

public class AlertTime{
	int hour;
	int minute;
	int second;
	
	public AlertTime(int alerthour, int alertminute, int alertsecond){
		this.hour = alerthour;
		this.minute = alertminute;
		this.second = alertsecond;
	}
}