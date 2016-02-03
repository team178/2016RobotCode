package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import java.lang.Math;

public class DriveTrain {
	VictorSP left1;
	VictorSP left2;
	VictorSP right1;
	VictorSP right2;
	CANTalon canMotor;
	
	DriveTrain(){
		//This is the constructor. When it is called it initializes the drivetrain
		//Each of these variables below is a VictorSP. These are motor controllers. We create a variable to represent 
		//them and specify which PWM output they reside on in the constructor for them.
		left1 = new VictorSP(0);
		left2 = new VictorSP(1);
		right1 = new VictorSP(2);
		right2 = new VictorSP(3);
		canMotor = new CANTalon(10);
	}
	
	public void drive(Joystick joystick){
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		//TODO clean up this section. The negatives are quite ghetto. It's hard to understand.
		double xVal,yVal,zVal;//-does zVal mean twist?
		xVal = -1*joystick.getY();
		yVal = -1*joystick.getX();//We should change/add another double twistValue(zVal), and use joystick.getTwist()
		zVal = -1*joystick.getTwist();
				
		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		//TODO Debug and optimize this code. It does things weirdly. It's more logical to turn based on twist.
		//The if condition implements what's called a dead zone. The controllers have some variances to them, 
		//and this makes sure that the robot doesn't do anything we don't want it to.
		if(Math.abs(xVal)>0.1 || Math.abs(yVal)>0.1){
			left1.set(-yVal+xVal);
			left2.set(-yVal+xVal);
			// Debugging code System.out.println(1*yVal);
			right1.set(-yVal-xVal);
			right2.set(-yVal-xVal);
		}
		//This is an attempt at twist code for turing.
		else if(Math.abs(zVal)>0.1){
			left1.set(zVal);
			left2.set(zVal);
			right1.set(zVal);
			right2.set(zVal);
		}
		//Without this, the motor speed is never unset. 
		//The robot would continue moving at its last speed. This makes it stop.
		else{
			left1.set(0);
			left2.set(0);
			right1.set(0);
			right2.set(0);
		}
		
		if(joystick.getRawButton(1)){
			startCANMotorTest(canMotor);
		}
		else {
			stopCANMotorTest(canMotor);
		}
		
	}
	
	public void startCANMotorTest(CANTalon canTalon){
		canTalon.set(1);
	}
	
	public void stopCANMotorTest(CANTalon canTalon){
		canTalon.set(0);
	}
	
}
