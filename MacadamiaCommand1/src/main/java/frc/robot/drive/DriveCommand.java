/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.HumanInput;
import frc.robot.Robot;

public class DriveCommand extends Command {
  public static final double PERCENT_OUTPUT_MAX = 1.0;

  public DriveCommand() {
    requires(Robot.driveSys);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("we rollin!!!");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.driveSys.getFrontUltrasonic() < 30) {
        Robot.driveSys.drive.tankDrive(0, 0);
    }
    else {
        System.out.println("Working");
        Robot.driveSys.drive.tankDrive(HumanInput.xbox.getY(Hand.kLeft)*0.5, HumanInput.xbox.getY(Hand.kRight)*0.5);
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}