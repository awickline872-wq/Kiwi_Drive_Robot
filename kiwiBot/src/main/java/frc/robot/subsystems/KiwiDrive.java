package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class KiwiDrive extends SubsystemBase{
private final PWMSparkMax m_motor1 = new PWMSparkMax(Constants.DriveConstants.kMotor1Port);
private final PWMSparkMax m_motor2 = new PWMSparkMax(Constants.DriveConstants.kMotor2Port);
private final PWMSparkMax m_motor3 = new PWMSparkMax(Constants.DriveConstants.kMotor3Port);
    public KiwiDrive(){

    }
    public void drive(double x, double y, double rot){
            double raw1 = rot - x;
            double raw2 = rot + (Constants.DriveConstants.kKiwiXFactor * x) + (Constants.DriveConstants.kKiwiYFactor * y);
            double raw3 = rot + (Constants.DriveConstants.kKiwiXFactor * x) - (Constants.DriveConstants.kKiwiYFactor * y);
    // Normalize outputs so no single motor exceeds 1.0/-1.0 power
    double max = Math.max(1.0, Math.max(Math.abs(raw1), Math.max(Math.abs(raw2), Math.abs(raw3))));

    m_motor1.set(raw1 / max);
    m_motor2.set(raw2 / max);
    m_motor3.set(raw3 / max);
    }
    public void stop(){
        m_motor1.stopMotor();
        m_motor2.stopMotor();
        m_motor3.stopMotor();
    }



}