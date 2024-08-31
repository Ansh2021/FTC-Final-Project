package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain extends SubsystemBase {
// The next four lines create the four motors used for the wheels on the drivetrain.
    DcMotorEx FRMotor;
    DcMotorEx FLMotor;
    DcMotorEx BRMotor;
    DcMotorEx BLMotor;

    // hmap.get links the motors to the hardware map. This allows us to use the motors.
    public Drivetrain(HardwareMap hmap) {
        FRMotor = hmap.get(DcMotorEx.class, "FRMotor");
        FLMotor = hmap.get(DcMotorEx.class, "FLMotor");
        BRMotor = hmap.get(DcMotorEx.class, "BRMotor");
        BLMotor = hmap.get(DcMotorEx.class, "BLMotor");
    }

    /* This code is the math for our mecanum op drive.
    Without this code, we would not be able to strafe.
    The joystick code for mecanum op is located in the RunRobot file in the runOpMode method */
    public void drive(double y, double x, double rx) {
        double divisor = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double FRPower = (y - x - rx) / divisor;
        double FLPower = (y + x + rx) / divisor;
        double BRPower = (y + x - rx) / divisor;
        double BLPower = (y - x + rx) / divisor;

        FRMotor.setPower(FRPower);
        FLMotor.setPower(FLPower);
        BRMotor.setPower(BRPower);
        BLMotor.setPower(BLPower);
    }
}
