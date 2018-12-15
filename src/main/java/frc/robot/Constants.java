//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot;
public class Constants{
    public double pie = Math.PI;

    /*
    --6 in wheel conversion--
    (60*Math.PI*ticks)/6144
    */
//  1023/794
    //Robot Joystick Constants
    public static int kJoystickPort = 0;
    public static int kJoystickLeftXAxis = 0;
    public static int kJoystickLeftYAxis = 1; 
    public static int kJoystickRightYAxis = 5; 
    public static int kJoystickRightXAxis = 2; 
    public static int kElevatorUp = 3;
    public static int kElevatorDown = 1;
    //Robot Talons Motors
    public static int kLeftA = 13;
    public static int kLeftB = 12;
    public static int kRightA = 2;
    public static int kRightB = 3;
    public static int kElev = 15;
    //Drive PID
    public static double driveKP = 3.7;
    public static double driveKI = 0.0;
    public static double driveKD = 0.0;
    public static double driveKF = 1.28841309824;
    public static int timoutMS = 10;
    public static int primaryPIDIDX = 0;
    public static int kmaxSpeed = 740;
}