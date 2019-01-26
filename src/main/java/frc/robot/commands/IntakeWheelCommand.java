package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.model.StarCommand;
import frc.robot.subsystems.SubsystemManager;
import frc.robot.subsystems.drive.Intake;

public class IntakeWheelCommand extends StarCommand {

    private Intake intake;
    private double direction;

    public IntakeWheelCommand(double direction) {
        intake = Robot.subsystemManager.getIntake();
        this.direction = direction;
        requires(intake);
    }

    @Override
    protected void initialize() {
        intake.setIntakeMotors(direction * RobotMap.INTAKE_MOTOR_SPEED);
    }

    @Override
    protected void terminate() {
        intake.setIntakeMotors(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
