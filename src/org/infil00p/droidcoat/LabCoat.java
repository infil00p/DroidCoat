package org.infil00p.droidcoat;

import java.io.IOException;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;


public class LabCoat extends DroidCoatActivity {
	
	OutputController mOutputController;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);	
	}	

	protected void enableControls(boolean enable)
	{
		if (enable) {
			showControls();
		} else {
			hideControls();
		}
	}
	
	protected void hideControls() {
		setContentView(R.layout.no_device);
	}

	protected void showControls() {
		setContentView(R.layout.main);
		mOutputController = new OutputController(this, false);
		mOutputController.accessoryAttached();

	}
	
}
