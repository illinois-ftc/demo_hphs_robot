package com.qualcomm.ftcrobotcontroller.opmodes.demo;

import com.qualcomm.ftcrobotcontroller.opmodes.utility.ActiveOpMode;
import com.qualcomm.ftcrobotcontroller.opmodes.utility.RobotLinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;

@ActiveOpMode("Autonomous")
public class DemoAuto extends RobotLinearOpMode<DemoRobot> {

    @Override
    public void initializeRobot() {
        robot.servoClaw.setPosition(DemoConstants.CLAW_RAISED_POSITION);
        robot.servoDump.setPosition(DemoConstants.DUMP_RAISED_POSITION);
    }

    @Override
    public void runRobot() {
        robot.motorBackLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        robot.motorBackRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        robot.motorFrontLeft.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        robot.motorFrontRight.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

    }
}
