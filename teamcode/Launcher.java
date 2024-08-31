package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher extends SubsystemBase {
    DcMotorEx RightLaunchWheel;
    DcMotorEx LeftLaunchWheel;

    public Launcher(HardwareMap hmap) {
        RightLaunchWheel = hmap.get(DcMotorEx.class, "RightLaunchWheel");
        LeftLaunchWheel = hmap.get(DcMotorEx.class, "LeftLaunchWheel");
    }

    public void LAUNCH() {
        RightLaunchWheel.setPower(1);
        LeftLaunchWheel.setPower(-1);
    }

    public void STOPLAUNCH() {
        RightLaunchWheel.setPower(0);
        LeftLaunchWheel.setPower(0);
    }
}

