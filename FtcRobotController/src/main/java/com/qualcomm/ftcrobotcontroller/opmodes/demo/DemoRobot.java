package com.qualcomm.ftcrobotcontroller.opmodes.demo;

import com.qualcomm.ftcrobotcontroller.opmodes.utility.RobotHardware;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DemoRobot extends RobotHardware {
    public DcMotor motorFrontRight;
    public DcMotor motorFrontLeft;
    public DcMotor motorBackRight;
    public DcMotor motorBackLeft;
    public DcMotor motorLift;
    public DcMotor motorHarvester;
    public Servo servoClaw;
    public Servo servoDump;

    @Override
    public void instantiateHardware(HardwareMap hardwareMap) {
        //Drive Motor Setup
        motorFrontRight = hardwareMap.dcMotor.get("right_front");
        motorFrontLeft = hardwareMap.dcMotor.get("left_front");
        motorBackRight = hardwareMap.dcMotor.get("right_back");
        motorBackLeft = hardwareMap.dcMotor.get("left_back");
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);

        //Auxiliary motor setup
        motorLift = hardwareMap.dcMotor.get("lift");
        motorHarvester = hardwareMap.dcMotor.get("harvester");
        motorLift.setDirection(DcMotor.Direction.REVERSE);
        motorHarvester.setDirection(DcMotor.Direction.REVERSE);

        //Servo setup
        servoClaw = hardwareMap.servo.get("claw");
        servoDump = hardwareMap.servo.get("dump");
    }
}
