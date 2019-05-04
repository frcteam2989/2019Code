/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import frc.robot.RobotMap;
import frc.robot.commands.ElevatorMoveCommand;
import frc.robot.commands.IntakePistonCommand;
import frc.robot.commands.IntakeWheelCommand;
import frc.robot.model.StarJoystick;

import java.util.stream.Stream;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private StarJoystick primaryJoystick;
    private StarJoystick secondaryJoystick;

    public OI() {
        loadPrimaryJoystick();
        loadSecondaryJoystick();
    }

    private void loadPrimaryJoystick() {
        primaryJoystick = new StarJoystick(RobotMap.OI_JOYSTICK_PRIMARY_PORT);
    }

    private void loadSecondaryJoystick() {
        secondaryJoystick = new StarJoystick(RobotMap.OI_JOYSTICK_SECONDARY_PORT);
        Stream.of(
                RobotMap.OI_JOYSTICK_SECONDARY_INTAKE_PORT,
                RobotMap.OI_JOYSTICK_SECONDARY_SHOOT_PORT,
                RobotMap.OI_JOYSTICK_SECONDARY_TRIGGER_PORT,
                RobotMap.OI_JOYSTICK_SECONDARY_HATCH_PORT,
                RobotMap.OI_JOYSTICK_SECONDARY_ELEVATOR_AXIS
        ).forEach(secondaryJoystick::addButton);

    }

    public void assignCommands() {
        secondaryJoystick.getButton(RobotMap.OI_JOYSTICK_SECONDARY_INTAKE_PORT).ifPresent(button -> button.whileHeld(new IntakeWheelCommand(-1)));
        secondaryJoystick.getButton(RobotMap.OI_JOYSTICK_SECONDARY_SHOOT_PORT).ifPresent(button -> button.whileHeld(new IntakeWheelCommand(1)));
        secondaryJoystick.getButton(RobotMap.OI_JOYSTICK_SECONDARY_TRIGGER_PORT).ifPresent(button -> button.whileHeld(new ElevatorMoveCommand(RobotMap.ELEVATOR_END_TO_END_ENCODER_COUNT)));
        secondaryJoystick.getButton(RobotMap.OI_JOYSTICK_SECONDARY_HATCH_PORT).ifPresent(button -> button.toggleWhenPressed(new IntakePistonCommand()));
    }

    public StarJoystick getPrimaryJoystick() {
        return primaryJoystick;
    }

    public StarJoystick getSecondaryJoystick() {
        return secondaryJoystick;
    }
}
