/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.ctre.phoenix.motorcontrol.can.*;                     //MAY NEED
//import com.ctre.phoenix.motorcontrol.ControlMode;               //MAY NEED
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import frc.robot.Constants;                                     //MAY NEED
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //private TalonSRX mLeft = new TalonSRX(0);
  public static final OI oi = new OI();
  //private TalonSRX thisIsMyTalonSRX = new TalonSRX(Constants.kTalonOne);
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public double oldLeftVelocity;
  public double oldRightVelocity;
  public double leftVel;
  public double rightVel;
  public static final Drivetrain kDrivetrain = new Drivetrain();
  public static Elevator kElevator = new Elevator();
  
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.addDefault("Default Auto", kDefaultAuto);
    m_chooser.addObject("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * 
   * 
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Left Velocity ", kDrivetrain.getLeftVelocity());
    SmartDashboard.putNumber("Right Velocity ", kDrivetrain.getRightVelocity());
    SmartDashboard.putNumber("Left Accurate", kDrivetrain.getLeftVelocity());
    SmartDashboard.putNumber("Right Accurate", kDrivetrain.getRightVelocity());
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    //commandd k = new ...;
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
        // Shedular.getInstance.run();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //thisIsMyTalonSRX.set(ControlMode.PercentOutput, oi.getLeftXAxis());
    Scheduler.getInstance().run();
      if (kDrivetrain.getLeftVelocity() >= oldLeftVelocity){
          leftVel= kDrivetrain.getLeftVelocity();
      }
      if (kDrivetrain.getRightVelocity() >= oldRightVelocity){
        rightVel = kDrivetrain.getRightVelocity();
      }
      System.out.println(kElevator.getPosition());
      oldLeftVelocity = kDrivetrain.getLeftVelocity();
      oldRightVelocity = kDrivetrain.getRightVelocity();
      System.out.println(leftVel);
      System.out.println(rightVel);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

