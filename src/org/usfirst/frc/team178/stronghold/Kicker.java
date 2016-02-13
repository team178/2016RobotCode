package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class Kicker {
	
	CANTalon kickerFront, kickerBack;
	Joystick joystick;
	
	public Kicker() {
		// TODO Auto-generated constructor stub
		kickerFront = new CANTalon(12);
		kickerBack = new CANTalon(13);
	}
	
	public void setKickerSpeed(double speed){
		kickerBack.set(speed);
		kickerFront.set(speed);
	}
	
	public void kick(Joystick joystick){
		this.joystick = joystick;
		if(this.joystick.getRawButton(12)){
			setKickerSpeed(-1);
		}
		else{
			setKickerSpeed(0);
		}
	}
	
}
