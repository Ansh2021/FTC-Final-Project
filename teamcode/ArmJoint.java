package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmJoint extends SubsystemBase {
    DcMotorEx joint;

    // This links the arm joint's dc motor to the hardware map.
    public ArmJoint(HardwareMap hmap) {
        joint = hmap.get(DcMotorEx.class, "joint");
    }

    // This sets the joint's power to 1 and allows the arm to move up.
    public void moveUp() {
        joint.setPower(1);

    }

    // This sets the joint's power to -1 and allows the arm to move down.
    public void moveDown() {
        joint.setPower(-1);

    }

    // This sets the joint's power to 0 and stops the arm.
    public void stop() {
        joint.setPower(0);

    }

    // This method returns the current position of the arm.
    public double getPos() {
        return joint.getCurrentPosition();

    }
}
