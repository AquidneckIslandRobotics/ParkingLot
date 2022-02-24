// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.Auto;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.Shoot.SpinUp;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.FeedWheel;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Chassis.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoTaxi1Par extends ParallelRaceGroup {
  /** Creates a new AutoTaxi1Par. */
  public AutoTaxi1Par(Shooter m_shooter, Chassis m_chassis, Indexer m_indexer, Feed m_feed, FeedWheel m_feedWheel) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SpinUp(m_shooter, Constants.spinupVel),
      new AutoTaxi1Seq(m_chassis, m_indexer, m_feed, m_feedWheel)
    );
  }
}
