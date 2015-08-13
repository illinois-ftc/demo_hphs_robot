package com.qualcomm.ftcrobotcontroller.opmodes.utility;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * <p>
 * This class represents a hardware configuration on the robot.
 * Subclasses should contain public motors, servos, and sensors properties
 * corresponding to the devices defined in the robot config file,
 * </p>
 * <p>
 * For example:
 * </p>
 * <pre>
 * <code>
 * public class DemoRobot implements RobotHardware {
 *     public DcMotor motorRight;
 *     public DcMotor motorLeft;
 *     public DcMotor motorHarvester;
 *     public Servo servoClaw;
 *
 *    {@literal @}Override
 *     public void instantiateHardware(HardwareMap hardwareMap) {
 *         //Drive Motor Setup
 *         motorLeft = hardwareMap.dcMotor.get("left");
 *         motorRight = hardwareMap.dcMotor.get("right");
 *         motorLeft.setDirection(DcMotor.Direction.REVERSE);
 *
 *         //Auxiliary motor setup
 *         motorHarvester = hardwareMap.dcMotor.get("harvester");
 *
 *         //Servo setup
 *         servoClaw = hardwareMap.servo.get("claw");
 *     }
 * }
 * </code>
 * </pre>
 */
public abstract class RobotHardware {
    /**
     * Instantiates motor, sensor, and servo properties with appropriate objects
     *
     * @param hardwareMap Contains mappings from config names to objects
     */
    public abstract void instantiateHardware(HardwareMap hardwareMap);
}
