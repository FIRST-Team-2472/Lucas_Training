package frc.robot.commands;

import frc.robot.subsystems.MotorSubsystems;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

public class MotorCommand extends Command {
/** An example command that uses an example subsystem. */
 MotorSubsystems motorSubsystems;
  Supplier<Double> joysticks;

public MotorCommand(MotorSubsystems motorSubsystems, Supplier<Double> joysticks){
 this.motorSubsystems = motorSubsystems;
 this.joysticks = joysticks;

 addRequirements(motorSubsystems);

}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(joysticks.get())>.05){ 
    motorSubsystems.setSpeed(joysticks.get());
    }else{
      motorSubsystems.setSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorSubsystems.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

