// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.KiwiDrive;

public class RobotContainer {

    private final KiwiDrive m_kiwiDrive = new KiwiDrive();
    
    private final CommandXboxController m_Controller = new CommandXboxController(Constants.OIConstants.kDriverControllerPort);

  public RobotContainer() {
    m_kiwiDrive.setDefaultCommand(
        m_kiwiDrive.run(
            () -> m_kiwiDrive.drive(
                MathUtil.applyDeadband(m_Controller.getLeftX(), Constants.OIConstants.kJoystickDeadband),
                MathUtil.applyDeadband(-m_Controller.getLeftY(), Constants.OIConstants.kJoystickDeadband),
                MathUtil.applyDeadband(m_Controller.getRightX(), Constants.OIConstants.kJoystickDeadband)
            )
        )
    );
  }
}



