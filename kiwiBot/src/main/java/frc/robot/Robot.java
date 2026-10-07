package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    // This instantiates your RobotContainer, which sets up your Kiwi drive and joysticks
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    // This single line is critical! It constantly runs the scheduler loop, 
    // which processes your joystick inputs and runs your KiwiDriveCmd.
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    // If you add autonomous code later, it will be called from here via RobotContainer
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}