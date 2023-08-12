package frc.robot.interfaces;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface ICamera extends Subsystem {

	public boolean isCoherent();

	public int getNumberOfTargets();

	public boolean acquireTargets(boolean waitForNewInfo);
	
	public boolean checkForOpening();

	public double getDistanceToCompositeTargetUsingVerticalFov();
	
	public double getDistanceToCompositeTargetUsingHorizontalFov();

	public double getFilteredDistanceToCompositeTarget();

	public double getAngleToTurnToCompositeTarget();
	
	public double getPixelDisplacementToCenterToCompositeTarget();

	public double getVerticalOffsetToCompositeTarget();

	public double getFilteredVerticalOffsetToCompositeTarget();

	public double[] getArea();

	public double[] getWidth();

	public double[] getHeight();

	public double[] getCenterX();

	public double[] getCenterY();	

	public void setOffsetBetweenCameraAndTarget(double offset);

	public double getOffsetBetweenCameraAndTarget();

	public enum LedMode {
		PIPELINE,
		FORCE_OFF,
		FORCE_BLINK,
		FORCE_ON
	}

	//public void setLedMode(LedMode ledMode);
	
	public void setPipeline(byte pipeline);

	public double pidGet();
	
	public double pidGet2();
}
