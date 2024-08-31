package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase {
    ServoEx RClaw;
    ServoEx LClaw;

    public Claw(HardwareMap hmap) {
    // This makes the new servos for the claw.
        RClaw = new SimpleServo(hmap, "rightClaw", -90, 90);
        LClaw = new SimpleServo(hmap, "leftClaw", -90, 90);
    }

    public void grab(){
    // As the name of the method suggests, this method allows the claw to grab an object.
        RClaw.setPosition(90);
        LClaw.setPosition(-90);
    }
    public void release() {
    // This method allows the claw to release an object that it has grabbed.
        RClaw.setPosition(-90);
        LClaw.setPosition(90);
    }
}
