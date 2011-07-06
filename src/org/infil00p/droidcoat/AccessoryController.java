package org.infil00p.droidcoat;

import android.content.res.Resources;
import android.view.View;

public abstract class AccessoryController {

	protected DroidCoatActivity mHostActivity;

	public AccessoryController(DroidCoatActivity activity) {
		mHostActivity = activity;
	}

	protected View findViewById(int id) {
		return mHostActivity.findViewById(id);
	}

	protected Resources getResources() {
		return mHostActivity.getResources();
	}

	void accessoryAttached() {
		onAccesssoryAttached();
	}

	abstract protected void onAccesssoryAttached();

}