package frc.robot.subsystems;

import frc.robot.subsystems.drive.DriveTrain;
import frc.robot.subsystems.drive.Intake;

public class SubsystemManager {

    private DriveTrain driveTrain;
    private Intake intake;

    public SubsystemManager() {
        enableSubsystems();
    }

    private void enableSubsystems() {
        driveTrain = new DriveTrain();
        intake = new Intake();
    }

    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public Intake getIntake() {
        return intake;
    }

}
