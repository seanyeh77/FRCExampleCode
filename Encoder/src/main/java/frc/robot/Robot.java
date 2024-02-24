package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;


public class Robot extends TimedRobot {
  Encoder enc;
  
  // // counts per revolution
  //private static final double cpr = 7/4; //if am-2861a
  private static final double cpr = 360; //if am-3132
  // private static final double cpr = 5; //if am-3314a
  // private static final double cpr = 1024; //if am-3445
  // private static final double cpr = 64; //if am-4027

  private static final double whd = 6; // for 6 inch wheel


  @Override
  public void robotInit() {
    enc = new Encoder(0,1);
    enc.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
  }

  @Override
  public void robotPeriodic()
  {
    double dist = enc.getSamplesToAverage();
    SmartDashboard.putNumber("Encoder", dist);
  }
}
