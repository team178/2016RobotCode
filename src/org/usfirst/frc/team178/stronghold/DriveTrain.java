package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveTrain {
	VictorSP left1;
	VictorSP left2;
	VictorSP right1;
	VictorSP right2;
	
	DriveTrain(){
		left1 = new VictorSP(0);
		left2 = new VictorSP(1);
		right1 = new VictorSP(2);
		right2 = new VictorSP(3);
	}
	
	public void drive(Joystick joystick){
		double xVal,yVal,zVal;
		xVal = joystick.getX();
		yVal = joystick.getY();
		zVal = joystick.getZ();
		
	}
	
	
}
