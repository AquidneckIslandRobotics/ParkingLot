// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.Auto;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.Auto.AutoTurn;
import frc.robot.commands.Shoot.SpinUp;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Chassis.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoTurnandSpinUp extends ParallelRaceGroup {
  /** Creates a new AutoTurnandSpinUp. */
  public AutoTurnandSpinUp(Chassis chassis, Shooter shooter, double spinupVel, double degrees, double turnSpeed, boolean isHood) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoTurn(chassis, degrees, turnSpeed),
      new SpinUp(shooter, spinupVel, isHood)
    );
  }
}
