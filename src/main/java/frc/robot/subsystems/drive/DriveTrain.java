package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.model.StarSubsystem;

public class DriveTrain extends StarSubsystem {

    private SpeedControllerGroup leftMotor;
    private SpeedControllerGroup rightMotor;
    private GTADrive drive;

    public DriveTrain() {
        loadSpeedControllers();
        loadDrive();
    }

    private void loadSpeedControllers() {
        leftMotor = new SpeedControllerGroup(new PWMTalonSRX(RobotMap.DRIVETRAIN_MOTOR_LEFT_1), new PWMTalonSRX(RobotMap.DRIVETRAIN_MOTOR_LEFT_2));
        rightMotor = new SpeedControllerGroup(new PWMTalonSRX(RobotMap.DRIVETRAIN_MOTOR_RIGHT_1), new PWMTalonSRX(RobotMap.DRIVETRAIN_MOTOR_RIGHT_2));
    }

    private void loadDrive() {
        drive = new GTADrive(new DifferentialDrive(leftMotor, rightMotor), Robot.oi.getPrimaryJoystick(), RobotMap.OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT, RobotMap.OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT, RobotMap.OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT);
    }


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveCommand());
    }

    public GTADrive getDrive() {
        return drive;
    }

    public SpeedControllerGroup getLeftMotor() {
        return leftMotor;
    }

    public SpeedControllerGroup getRightMotor() {
        return rightMotor;
    }
}
