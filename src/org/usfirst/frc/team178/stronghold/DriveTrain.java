package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import java.lang.Math;

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
		double xVal,yVal;//zVal;
		xVal = joystick.getX();
		yVal = joystick.getY();
		//ZVal not needed. We don't really know what the Z axis is.
		//zVal = joystick.getZ();
		
		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		if(Math.abs(xVal)>0.2 || Math.abs(yVal)>0.2){
			left1.set(1*yVal*(-xVal));
			left2.set(1*yVal*(-xVal));
			right1.set(1*yVal*xVal);
			right2.set(1*yVal*xVal);
		}
		
		
	}
	
	
}
