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
