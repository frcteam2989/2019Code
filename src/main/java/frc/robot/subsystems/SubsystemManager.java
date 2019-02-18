package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.drive.DriveTrain;
import frc.robot.subsystems.drive.Intake;

public class SubsystemManager {

    private DriveTrain driveTrain;
    private Intake intake;
    private OuterElevator outerElevator;

    public SubsystemManager() {
        enableSubsystems();
    }

    private void enableSubsystems() {
        driveTrain = new DriveTrain();
        if(RobotMap.MODULES_INTAKE_ENABLED) {
            intake = new Intake();
        }
        if(RobotMap.MODULES_ELEVATOR_ENABLED) {
            outerElevator = new OuterElevator();
        }
    }

    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public Intake getIntake() {
        return intake;
    }

    public OuterElevator getOuterElevator() {
        return outerElevator;
    }

}
