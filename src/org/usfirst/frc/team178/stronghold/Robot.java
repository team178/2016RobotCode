
package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    DriveTrain drivetrain;
	Joystick joystick;
	Relay lightRelay;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//This code intializes the robot. It is one of the first things called.
    	joystick = new Joystick(0);
        drivetrain = new DriveTrain();
        //The code below initializes the relay that controls the light on the front camera.
        lightRelay = new Relay(0);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	//Place Autonomous initialization code here.
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//This is the code that will run during the autonomous period.
    	
    	//The code below is for the relay controlling the light on front camera, it sets a direction(forward) and turns it on.
    	lightRelay.value(kForward);
    	lightRelay.value(kOn);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //The following code refers to a different class. It passes the joystick as the argument.
    	drivetrain.drive(joystick);
    	//The code below is for the relay controlling the light on front camera, it sets a direction(forward) and turns it on.
    	lightRelay.value(kForward);
    	lightRelay.value(On);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	//We never really use test mode. Maybe we can this year?
    
    }
    
}
