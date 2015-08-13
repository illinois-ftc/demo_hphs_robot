package com.qualcomm.ftcrobotcontroller.opmodes.utility;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.lang.reflect.ParameterizedType;

/**
 * This class simplifies use of the <code>LinearOpMode</code>
 *
 * @param <T> The RobotHardware class configured for the specific robot.
 */
public abstract class RobotLinearOpMode<T extends RobotHardware> extends LinearOpMode {

    /**
     * The <code>RobotHardware</code> instance for the op mode, used to access the hardware.
     */
    protected T robot;

    public RobotLinearOpMode(){
        try {
            robot = (T) ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        } catch (InstantiationException e) {
            //handle error
        } catch (IllegalAccessException e) {
            //handle error
        }
    }

    /**
     * Linearly executes a series of commands.
     * Initializes <code>robot</code>, and then calls <code>initializeRobot()</code>,
     * then <code>waitForStart()</code> until the driver station starts the op mode, and then
     * <code>runRobot()</code>.
     *
     * @throws InterruptedException {@inheritDoc}
     */
    @Override
    public final void runOpMode() throws InterruptedException {
        robot.instantiateHardware(hardwareMap);

        initializeRobot();

        waitForStart();

        runRobot();
    }

    /**
     * Initialize servo positions, sensors, etc.
     */
    public abstract void initializeRobot();

    /**
     * Execute the body of the op mode
     */
    public abstract void runRobot();
}
