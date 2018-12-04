//this code was made by team 3863 FIRST Robotics, Newbury Park, CA 91320
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

public class Elevator extends Subsystem{
    private TalonSRX mElevator = new TalonSRX(Constants.kElevatorID);

    public Elevator(){
        mElevator.setInverted(false);
        mElevator.setSensorPhase(false);
        mElevator.config_kP(Constants.primaryPIDIDX, Constants.elevatorKP, Constants.timoutMS);
        mElevator.config_kI(Constants.primaryPIDIDX, Constants.elevatorKI, Constants.timoutMS);
        mElevator.config_kD(Constants.primaryPIDIDX, Constants.elevatorKD, Constants.timoutMS);
        mElevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.primaryPIDIDX, Constants.timoutMS);
        mElevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    }
    public void initDefaultCommand(){

    }
    public double getPos(){
        return mElevator.getSelectedSensorPosition(Constants.primaryPIDIDX);
    }
    public void setVelocity(double power){
        mElevator.set(ControlMode.PercentOutput, power);
    }
    public boolean getLimitSwitch(){
        return mElevator.getSensorCollection().isRevLimitSwitchClosed();
    } 
    public void setElevatorEncoder(int pos){
        mElevator.setSelectedSensorPosition(pos, Constants.primaryPIDIDX, Constants.timoutMS);
    }
    //set encoder pos, get limit switch
}