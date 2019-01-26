package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.model.StarCommand;
import frc.robot.subsystems.drive.Intake;

public class IntakePistonCommand extends StarCommand {

    private Intake intake;
    private boolean status;

    public IntakePistonCommand() {
        intake = Robot.subsystemManager.getIntake();
        status = false;
        requires(intake);
    }

    private void update(boolean status) {
        this.status = status;
        SmartDashboard.putBoolean("Intake Pistons", status);
        intake.setHatchPistons(status);
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
