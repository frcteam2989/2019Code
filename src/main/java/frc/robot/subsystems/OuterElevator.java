package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

public class OuterElevator extends PIDSubsystem {

    private PWMSpeedController motor;
    private Encoder encoder;

    public OuterElevator() {
        super("Elevator", RobotMap.ELEVATOR_PID_P, RobotMap.ELEVATOOR_PID_I, RobotMap.ELEVATOR_PID_D);
        encoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1, RobotMap.ELEVATOR_ENCODER_PORT_2, false);
        motor = new PWMVictorSPX(RobotMap.ELEVATOR_ENCODER_PORT_1);
        setAbsoluteTolerance(RobotMap.ELEVATOR_PID_TOLERANCE);
        getPIDController().setContinuous(RobotMap.ELEVATOR_PID_CONTINOUS);
    }

    @Override
    protected double returnPIDInput() {
        return encoder.get();
    }

    @Override
    protected void usePIDOutput(double output) {
        motor.pidWrite(output);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
