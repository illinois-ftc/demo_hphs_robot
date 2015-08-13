package com.qualcomm.ftcrobotcontroller.opmodes.utility;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.lang.reflect.ParameterizedType;

/**
 * This class simplifies use of the <code>LinearOpMode</code>
 *
 * @param <T> The RobotHardware class configured for the specific robot.
 */
public abstract class RobotOpMode<T extends RobotHardware> extends OpMode {

    /**
     * The <code>RobotHardware</code> instance for the op mode, used to access the hardware.
     */
    protected T robot;

    public RobotOpMode(){
        try {
            robot = (T) ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        } catch (InstantiationException e) {
            //handle error
        } catch (IllegalAccessException e) {
            //handle error
        }
    }

    /**
     * Initializes <code>robot</code>, and then calls <code>initializeRobot()</code>.
     */
    @Override
    public void init() {
        robot.instantiateHardware(hardwareMap);

        initializeRobot();
    }

    /**
     * Initialize servo positions, sensors, etc.
     */
    public abstract void initializeRobot();

    /**
     * {@inheritDoc}
     */
    public abstract void loop();
}
