package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.Math;

public class DriveTrain {
	CANTalon left1;
	CANTalon left2;
	CANTalon right1;
	CANTalon right2;
	CANTalon canMotor;
	CANTalon canMotor2;
	
	DriveTrain(){
		//This is the constructor. When it is called it initializes the drivetrain
		//Each of these variables below is a VictorSP. These are motor controllers. We create a variable to represent 
		//them and specify which PWM output they reside on in the constructor for them.
		left1 = new CANTalon(0);
		left2 = new CANTalon(1);
		right1 = new CANTalon(2);
		right2 = new CANTalon(3);
		canMotor = new CANTalon(10);
		canMotor2 = new CANTalon (11);
	}
	
	public void drive(Joystick joystick){
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		//TODO clean up this section. The negatives are quite ghetto. It's hard to understand.
		double yVal,twistVal;
		yVal = -1*joystick.getY();
		twistVal = -1*joystick.getTwist();
				
		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		//TODO Debug and optimize this code. It does things weirdly. It's more logical to turn based on twist.
		//The if condition implements what's called a dead zone. The controllers have some variances to them, 
		//and this makes sure that the robot doesn't do anything we don't want it to.
		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			left1.set(-twistVal+yVal);
			left2.set(-twistVal+yVal);
			right1.set(-twistVal-yVal);
			right2.set(-twistVal-yVal);
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
			startCANMotorTest(canMotor,canMotor2);
		}
		else {
			stopCANMotorTest(canMotor,canMotor2);
		}
		if(joystick.getRawButton(2)) {
			startCANMotorTest (canMotor,canMotor2);
		}
		else {
			stopCANMotorTest (canMotor,canMotor2);
		}
		//SmartDashboard.putNumber("Rotation", );
	}
	
	public void startCANMotorTest(CANTalon canTalon, CANTalon  canTalon2){
		canTalon.set(1);
		canTalon.set(1);
	}
	
	public void stopCANMotorTest(CANTalon canTalon, CANTalon canTalon2){
		canTalon.set(0);
		canTalon.set(0);
	}
	
}
