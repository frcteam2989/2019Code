package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.RobotMap;

public class OuterElevator extends PIDSubsystem {

    private PWMSpeedController motor;
    private Potentiometer potentiometer;

    public OuterElevator() {
        super("Elevator", RobotMap.ELEVATOR_PID_P, RobotMap.ELEVATOOR_PID_I, RobotMap.ELEVATOR_PID_D);
        potentiometer = new AnalogPotentiometer(RobotMap.ELEVATOR_POTENTIOMETER_PORT);
        motor = new PWMVictorSPX(RobotMap.ELEVATOR_POTENTIOMETER_PORT);
        setAbsoluteTolerance(RobotMap.ELEVATOR_PID_TOLERANCE);
        getPIDController().setContinuous(RobotMap.ELEVATOR_PID_CONTINOUS);
    }

    @Override
    protected double returnPIDInput() {
        return potentiometer.get();
    }

    @Override
    protected void usePIDOutput(double output) {
        motor.pidWrite(output);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
