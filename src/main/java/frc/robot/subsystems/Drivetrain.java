//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.*;

public class Drivetrain extends Subsystem{
    private TalonSRX mLeftA = new TalonSRX(Constants.kLeftA);
    private TalonSRX mLeftB = new TalonSRX(Constants.kLeftB);
    private TalonSRX mRightA = new TalonSRX(Constants.kRightA);
    private TalonSRX mRightB = new TalonSRX(Constants.kRightB);

    public Drivetrain(){
        mLeftB.follow(mLeftA);
        mRightB.follow(mRightA);
        mLeftA.setInverted(true);
        mLeftB.setInverted(true);
        mRightA.setInverted(false);
        mRightB.setInverted(false);
        mLeftA.setSensorPhase(true);
        mRightA.setSensorPhase(true);
        mLeftA.config_kP(Constants.primaryPIDIDX, Constants.driveKP, Constants.timoutMS);
        mLeftA.config_kI(Constants.primaryPIDIDX, Constants.driveKI, Constants.timoutMS);
        mLeftA.config_kD(Constants.primaryPIDIDX, Constants.driveKD, Constants.timoutMS);
        mLeftA.config_kF(Constants.primaryPIDIDX, Constants.driveKF, Constants.timoutMS);
        mRightA.config_kP(Constants.primaryPIDIDX, Constants.driveKP, Constants.timoutMS);
        mRightA.config_kI(Constants.primaryPIDIDX, Constants.driveKI, Constants.timoutMS);
        mRightA.config_kD(Constants.primaryPIDIDX, Constants.driveKD, Constants.timoutMS);
        mRightA.config_kF(Constants.primaryPIDIDX, Constants.driveKF, Constants.timoutMS);
        mLeftA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mLeftA.configSelectedFeedbackCoefficient(((60.0*Math.PI)/6144.0), Constants.primaryPIDIDX, Constants.timoutMS);
        mRightA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mRightA.configSelectedFeedbackCoefficient(((60.0*Math.PI)/6144.0), Constants.primaryPIDIDX, Constants.timoutMS);
    }
    public void initDefaultCommand(){
        setDefaultCommand(new Drive());
    }
    public double getRightVelocityFt(){
        return mRightA.getSelectedSensorVelocity(Constants.primaryPIDIDX);
    }
    public double getLeftVelocityFt(){
        return mLeftA.getSelectedSensorVelocity(Constants.primaryPIDIDX);
    }
    public void setVelocity(double left, double right){
        mLeftA.set(ControlMode.Velocity, left*22);
        mRightA.set(ControlMode.Velocity, right*22);
    }
}
