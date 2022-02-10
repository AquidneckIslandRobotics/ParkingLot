// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis.Chassis;

public class Tank extends CommandBase {

  private Chassis m_chassis;
  private XboxController m_controller;
  
  /** Creates a new Tank. */
  public Tank(Chassis chassis, XboxController xbox) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_chassis = chassis;
    m_controller = xbox;
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double lSpeed = triggerAdjustedSpeed(m_controller.getLeftY(), 0.3);
    double rSpeed = triggerAdjustedSpeed(m_controller.getRightY(), 0.3);

    boolean motorToggle = SmartDashboard.getBoolean("Exponential?", false);
    if(motorToggle){
      m_chassis.setSpeed(Math.abs(lSpeed) * lSpeed, Math.abs(rSpeed) * rSpeed);
    }else{
      m_chassis.setSpeed(lSpeed, rSpeed);
    }
    
    SmartDashboard.putNumber("Left Joystick Value", lSpeed);
    SmartDashboard.putNumber("Right Joystick Value", rSpeed);
  }

  public double triggerAdjustedSpeed(double inputSpeed, double maxAdjust){
    double tempSpeed = m_controller.getRightTriggerAxis() - m_controller.getLeftTriggerAxis();
    tempSpeed = ((1 - maxAdjust) * inputSpeed) + (inputSpeed * maxAdjust * tempSpeed);

    //clamping the output to make sure it doesnt exit -1 and 1 (for safetey)
    return Math.max(-1, Math.min(1, tempSpeed));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_chassis.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
