package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.model.SolenoidGroup;
import frc.robot.model.StarSubsystem;

import java.util.stream.Stream;

public class Intake extends StarSubsystem {

    private SolenoidGroup hatchPistons;
    private SpeedControllerGroup intakeMotors;

    public Intake() {
        loadPistons();
        loadMotors();
    }

    private void loadPistons() {
        SolenoidGroup.SolenoidGroupBuilder builder = new SolenoidGroup.SolenoidGroupBuilder();
        Stream.of(RobotMap.INTAKE_SOLENOID_LEFT_PORT, RobotMap.INTAKE_SOLENOID_RIGHT_PORT).forEach(builder::add);
        hatchPistons = builder.create();
    }

    private void loadMotors() {
        intakeMotors = new SpeedControllerGroup(new PWMTalonSRX(RobotMap.INTAKE_MOTOR_LEFT_PORT), new PWMTalonSRX((RobotMap.INTAKE_MOTOR_RIGHT_PORT)));
    }

    public void setHatchPistons(boolean state) {
        hatchPistons.execute(solenoid -> solenoid.set(state));
    }

    public void setIntakeMotors(double value) {
        intakeMotors.set(value);
    }

    @Override
    protected void initDefaultCommand() {}

    public SolenoidGroup getHatchPistons() {
        return hatchPistons;
    }
}
