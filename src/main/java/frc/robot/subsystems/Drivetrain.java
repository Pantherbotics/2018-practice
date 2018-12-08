//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        mLeftA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mRightA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mLeftA.setSensorPhase(false);
        mRightA.setSensorPhase(false);
        mLeftA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mRightA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mLeftA.config_kP(Constants.primaryPIDIDX, Constants.driveKP, Constants.timoutMS);
        mLeftA.config_kI(Constants.primaryPIDIDX, Constants.driveKI, Constants.timoutMS);
        mLeftA.config_kD(Constants.primaryPIDIDX, Constants.driveKD, Constants.timoutMS);
        mLeftA.config_kF(Constants.primaryPIDIDX, Constants.driveKF, Constants.timoutMS);
        mRightA.config_kP(Constants.primaryPIDIDX, Constants.driveKP, Constants.timoutMS);
        mRightA.config_kI(Constants.primaryPIDIDX, Constants.driveKI, Constants.timoutMS);
        mRightA.config_kD(Constants.primaryPIDIDX, Constants.driveKD, Constants.timoutMS);
        mRightA.config_kF(Constants.primaryPIDIDX, Constants.driveKF, Constants.timoutMS);
        mLeftA.configSelectedFeedbackCoefficient(1.0, Constants.primaryPIDIDX, Constants.timoutMS);
        mRightA.configSelectedFeedbackCoefficient(1.0, Constants.primaryPIDIDX, Constants.timoutMS);
    }

    public void initDefaultCommand(){
        setDefaultCommand(new Drive());
    }
    
    public double getLeftVelocity() {
        return mLeftA.getSelectedSensorVelocity(Constants.primaryPIDIDX);
    }

    public double getRightVelocity() {
        return mRightA.getSelectedSensorVelocity(Constants.primaryPIDIDX);
    }

    public void setVelocity(double left, double right){
        mLeftA.set(ControlMode.Velocity, left*Constants.kmaxSpeed);
        mRightA.set(ControlMode.Velocity, right*Constants.kmaxSpeed);
    }

    public void setPower(double left, double right){
        mLeftA.set(ControlMode.PercentOutput, left);
        mRightA.set(ControlMode.PercentOutput, right);
        SmartDashboard.putNumber("Left Power", left);
        SmartDashboard.putNumber("Right Power", right);
    }
}
