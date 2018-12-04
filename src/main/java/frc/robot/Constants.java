//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot;
public class Constants{
    public double pie = Math.PI;

    /*
    --6 in wheel conversion--
    (60*Math.PI*ticks)/6144
    */
    //Buttons
    public static int kZeroElevator = 8;
    public static int kElevatorUp = 4;
    public static int kElevatorDown= 2;
    //Robot Joystick Constants
    public static int kJoystickPort = 0;
    public static int kJoystickLeftXAxis = 0;
    public static int kJoystickLeftYAxis = 1; 
    public static int kJoystickRightYAxis = 5; 
    public static int kJoystickRightXAxis = 2; 
    //Robot Talons Motors
    public static int kLeftA = 13;
    public static int kLeftB = 12;
    public static int kRightA = 2;
    public static int kRightB = 3;
    //Drive PID
    public static double driveKP = 8.0;
    public static double driveKI = 0.0;
    public static double driveKD = 0.0;
    public static double driveKF = 1023.0/23.0;
    public static double elevatorKP = 8.0;
    public static double elevatorKI = 0.0;
    public static double elevatorKD = 0.0;
    public static double elevatorKF = 0.0; //not using
    public static int timoutMS = 10;
    public static int primaryPIDIDX = 0;
    //Elevator
    public static int kElevatorID = 15;
    //Intake
    public static int kIntakeLeft = 0;
    public static int kIntakeRight = 1;
}