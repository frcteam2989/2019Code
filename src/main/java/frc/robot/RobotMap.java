/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    /**
     * DriveTrain
     * (Motor Ports)
     */
    public static int DRIVETRAIN_MOTOR_LEFT_1 = 0;
    public static int DRIVETRAIN_MOTOR_LEFT_2 = 1;

    public static int DRIVETRAIN_MOTOR_RIGHT_1 = 2;
    public static int DRIVETRAIN_MOTOR_RIGHT_2 = 3;

    /**
     * DriveTrain
     * (Sensor Ports)
     */
    public static int DRIVETRAIN_SENSOR_ENCODER = 0;

    /**
     * Operator Interface
     * (Primary Joystick Ports)
     */
    public static int OI_JOYSTICK_PRIMARY_PORT = 1;
    public static int OI_JOYSTICK_PRIMARY_LEFT_TRIGGER_PORT = 2;
    public static int OI_JOYSTICK_PRIMARY_RIGHT_TRIGGER_PORT = 3;
    public static int OI_JOYSTICK_PRIMARY_LEFT_Y_AXIS_PORT = 1;
    public static int OI_JOYSTICK_PRIMARY_RIGHT_X_AXIS_PORT = 4;

    /**
     * Operator Interface
     * (Secondary Joystick Ports)
     */
    public static int OI_JOYSTICK_SECONDARY_PORT= 0;
    public static int OI_JOYSTICK_SECONDARY_INTAKE_PORT = 2;
    public static int OI_JOYSTICK_SECONDARY_SHOOT_PORT = 5;
    public static int OI_JOYSTICK_SECONDARY_TRIGGER_PORT = 1;
    public static int OI_JOYSTICK_SECONDARY_ELEVATOR_AXIS = 1;

    /**
     * Intake
     * (Solenoid Ports)
     */
    public static int INTAKE_SOLENOID_LEFT_PORT = 0;
    public static int INTAKE_SOLENOID_RIGHT_PORT = 1;

    /**
     * Intake
     * (Motor Ports)
     */
    public static int INTAKE_MOTOR_LEFT_PORT = 0;
    public static int INTAKE_MOTOR_RIGHT_PORT = 1;
    public static double INTAKE_MOTOR_SPEED = 0.45;

    public static int ELEVATOR_POTENTIOMETER_PORT = 0;
    public static double ELEVATOR_PID_P = 2.0;
    public static double ELEVATOOR_PID_I = 0.0;
    public static double ELEVATOR_PID_D = 0.0;
    public static double ELEVATOR_PID_TOLERANCE = 0.05;
    public static boolean ELEVATOR_PID_CONTINOUS = false;
    public static int ELEVATOR_MOTOR_PORT = 4;


}
