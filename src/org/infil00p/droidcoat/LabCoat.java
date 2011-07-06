/*
 * Original Code Copyright (C) 2011 The Android Open Source Project
 * Modifications Copyright (C) 2011 Joe Bowser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
