package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.KiwiDrive;
import java.util.function.DoubleSupplier;

public class KiwiDriveCommand extends Command{
    private final KiwiDrive m_kiwiDrive;
    private final DoubleSupplier m_xSupplier, m_ySupplier, m_rotSupplier;
    
    public KiwiDriveCommand(
        KiwiDrive kiwiDrive,
        DoubleSupplier xSupplier,
        DoubleSupplier ySupplier,
        DoubleSupplier rotSupplier){
        m_kiwiDrive = kiwiDrive;
        m_xSupplier = xSupplier;
        m_ySupplier = ySupplier;
        m_rotSupplier = rotSupplier;

        addRequirements(m_kiwiDrive);
        }

       
    @Override
    public void execute() {
        double xSpeed = MathUtil.applyDeadband(m_xSupplier.getAsDouble(), Constants.OIConstants.kJoystickDeadband);
        double ySpeed = MathUtil.applyDeadband(m_ySupplier.getAsDouble(), Constants.OIConstants.kJoystickDeadband);
        double rotSpeed = MathUtil.applyDeadband(m_rotSupplier.getAsDouble(), Constants.OIConstants.kJoystickDeadband);

   
        m_kiwiDrive.drive(xSpeed, -ySpeed, rotSpeed);
    }
        @Override
        public void end(boolean interrupted) {
            m_kiwiDrive.stop();
        }

}
