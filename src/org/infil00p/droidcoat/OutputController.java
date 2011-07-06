/*
 * Original Code Copyright (C) 2011 The Android Open Source Project
 * Modications Copyright (C) 2011 Joe Bowser
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

import android.view.ViewGroup;

public class OutputController extends AccessoryController {

	private boolean mVertical;

	OutputController(DroidCoatActivity hostActivity, boolean vertical) {
		super(hostActivity);
		mVertical = vertical;
	}

	protected void onAccesssoryAttached() {

		setupLedController(1, R.id.leds1);
	}


	private void setupLedController(int index, int viewId) {
		ColorLEDController ledC = new ColorLEDController(mHostActivity, index,
				getResources(), mVertical);
		ledC.attachToView((ViewGroup) findViewById(viewId));
	}

}
