package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.model.StarCommand;
import frc.robot.subsystems.OuterElevator;

public class ElevatorMoveCommand extends StarCommand {

    private double targetValue;
    private OuterElevator elevator;
    private boolean status;

    public ElevatorMoveCommand(double targetValue) {
        this.targetValue = targetValue;
        elevator = Robot.subsystemManager.getOuterElevator();
        status = false;
        requires(elevator);
    }

    private void update(boolean status) {
        this.status = status;
        SmartDashboard.putBoolean("Elevator Moving", status);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        update(true);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void terminate() {
        update(false);
    }

}
