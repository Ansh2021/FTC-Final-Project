package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Run Robot")
public class RunRobot extends LinearOpMode {

    ArmJoint joint;
    Claw claw;
    Drivetrain drivetrain;
    Launcher launcher;

    public void runOpMode() {
        /* Anything (variables, connections to the hardwareMap, etc.) between this comment and
        ifStopRequested() will be happen/be declared. */
        joint = new ArmJoint(hardwareMap);
        claw = new Claw(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        launcher = new Launcher(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while(opModeIsActive()) {
            /* Anything in this while loop will constantly run while the robot is on.
            The code will constantly be checking for any updates with the game pad. */

            /* drivetrain.drive is checking for stick updates on the gamepad. As updates are
            received, the y, x, and rx variables in the drivetrain file are updated. */

            drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            /* These if-else statements check to see if the gamepad has either the a or b buttons
            pressed (boolean) and execute the corresponding block of code. The code inside the
            if-else statements can be found in either the arm joint or the claw file. */

            if (gamepad1.right_trigger == 1) {
                joint.moveUp();
            } else {
                joint.stop();
            }

            if (gamepad1.left_trigger == 1) {
                joint.moveDown();
            } else {
                joint.stop();
            }

            if (gamepad1.b) {
                claw.grab();
            } else {
                claw.release();
            }

            if (gamepad1.x) {
                launcher.LAUNCH();
            } else {
                launcher.STOPLAUNCH();
            }
        }
    }
}
