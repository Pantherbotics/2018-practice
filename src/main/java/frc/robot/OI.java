//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.command.PrintCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class OI{
    public Joystick stick = new Joystick(Constants.kJoystickPort);
    public JoystickButton topbutton = new JoystickButton(stick, Constants.kElevatorUp);
    public JoystickButton bottombutton = new JoystickButton(stick, Constants.kElevatorDown);
    public Elevator elevator = new Elevator();
    public OI(){ //CONTRUCTOR
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
    
    public void initJoystick() {
        //topbutton.whileHeld();
    }
}