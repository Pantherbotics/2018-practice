//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Constants;
//import frc.robot.commands.*;

public class OI{
    public Joystick stick = new Joystick(Constants.kJoystickPort);
    public Joystick newstick = new Joystick(1);
    public Button ZeroElevator = new JoystickButton(stick, Constants.kZeroElevator);
    public OI(){
        //ZeroElevator.whenPressed(new ZeroElevator());
    }
    public double getLeftXAxis(){
        return stick.getRawAxis(Constants.kJoystickLeftXAxis);
    }
    public double getLeftYAxis(){
        return stick.getRawAxis(Constants.kJoystickLeftYAxis);
    }
    public double getRightYAxis(){
        return stick.getRawAxis(Constants.kJoystickRightYAxis);
    }
    public double getRightXAxis(){
        return stick.getRawAxis(Constants.kJoystickRightXAxis);
    }
    public double get2ndStickLeftY(){
        return stick.getRawAxis(Constants.kJoystickLeftYAxis);
    }
    public int getPOV(){
        return stick.getPOV();
    }
}

