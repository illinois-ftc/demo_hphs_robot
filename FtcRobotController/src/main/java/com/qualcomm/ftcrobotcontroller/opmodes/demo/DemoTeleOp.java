package com.qualcomm.ftcrobotcontroller.opmodes.demo;

import com.qualcomm.ftcrobotcontroller.opmodes.utility.ActiveOpMode;
import com.qualcomm.ftcrobotcontroller.opmodes.utility.RobotOpMode;
import com.qualcomm.robotcore.util.Range;

@ActiveOpMode("TeleOp")
public class DemoTeleOp extends RobotOpMode<DemoRobot> {

    private double leftPower;
    private double rightPower;
    private double liftPower;
    private double harvesterPower;
    private double clawPosition;
    private double dumpPosition;

    @Override
    public void initializeRobot() {
        clawPosition = DemoConstants.CLAW_RAISED_POSITION;
        dumpPosition = DemoConstants.DUMP_RAISED_POSITION;
    }

    @Override
    public void loop() {

        //Drive tank control, scaled quadratically
        rightPower = quadScaleInput(gamepad1.left_stick_y);
        leftPower = quadScaleInput(gamepad1.right_stick_y);

        //Lift controls: D-Pad up to raise, down to lower
        if (gamepad1.dpad_up) {
            liftPower = DemoConstants.LIFT_UP_POWER;
        } else if (gamepad1.dpad_down) {
            liftPower = DemoConstants.LIFT_DOWN_POWER;
        } else {
            liftPower = DemoConstants.MOTOR_STOP;
        }

        //Harvester controls: B to intake, A to reverse
        if (gamepad1.b) {
            harvesterPower = DemoConstants.HARVESTER_FORWARD_POWER;
        } else if (gamepad1.a) {
            harvesterPower = DemoConstants.HARVESTER_REVERSE_POWER;
        } else {
            harvesterPower = DemoConstants.MOTOR_STOP;
        }

        //Claw controls: RB to grip, RT to release
        if (gamepad1.right_bumper) {
            clawPosition = DemoConstants.CLAW_RAISED_POSITION;
        } else if (gamepad1.right_trigger > 0.9) {
            clawPosition = DemoConstants.CLAW_LOWERED_POSITION;
        }

        //Dump controls: LB to dump, LT to collect
        if (gamepad1.left_bumper) {
            dumpPosition = DemoConstants.DUMP_RAISED_POSITION;
        } else if (gamepad1.left_trigger > 0.9) {
            dumpPosition = DemoConstants.DUMP_LOWERED_POSITION;
        }

        clawPosition = Range.clip(clawPosition, DemoConstants.CLAW_MIN_RANGE, DemoConstants.CLAW_MAX_RANGE);
        dumpPosition = Range.clip(dumpPosition, DemoConstants.DUMP_MIN_RANGE, DemoConstants.DUMP_MAX_RANGE);

        robot.motorFrontRight.setPower(rightPower);
        robot.motorBackRight.setPower(rightPower);
        robot.motorFrontLeft.setPower(leftPower);
        robot.motorBackLeft.setPower(leftPower);
        robot.motorLift.setPower(liftPower);
        robot.motorHarvester.setPower(harvesterPower);
        robot.servoClaw.setPosition(clawPosition);
        robot.servoDump.setPosition(dumpPosition);

        telemetry.addData("Drive power", String.format("%.2f : %.2f", leftPower, rightPower));
        telemetry.addData("Lift power", String.format("%.2f", liftPower));
        telemetry.addData("Harvester power", String.format("%.2f", harvesterPower));
        telemetry.addData("Claw position", String.format("%.2f", clawPosition));
        telemetry.addData("Dump position", String.format("%.2f", dumpPosition));

    }

    private double quadScaleInput(double val) {
        return val * val * Math.signum(val);
    }
}
