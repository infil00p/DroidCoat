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


import org.infil00p.droidcoat.Slider.SliderPositionListener;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class ColorLEDController {
	private int mLEDNumber;

	private Drawable mGreen;
	private Drawable mRed;
	private Drawable mBlue;
	private DroidCoatActivity mActivity;

	class LedValueUpdater implements Slider.SliderPositionListener {
		private TextView mTarget;
		private final byte mCommandTarget;

		LedValueUpdater(TextView target, int colorIndex) {
			mTarget = target;
			mCommandTarget = (byte) ((mLEDNumber - 1) * 3 + colorIndex);
		}

		public void onPositionChange(double value) {
			int v = (int) (255 * value);
			mTarget.setText(String.valueOf(v));
			if (mActivity != null) {
				mActivity.sendCommand(DroidCoatActivity.LED_SERVO_COMMAND,
						mCommandTarget, (byte) v);
			}
		}
	}

	class LabelClickListener implements OnClickListener {
		final private double mValue;
		private final Slider mSlider;

		public LabelClickListener(Slider slider, double value) {
			mSlider = slider;
			mValue = value;
		}

		public void onClick(View v) {
			mSlider.setPosition(mValue);
		}

	}

	public ColorLEDController(DroidCoatActivity activity, int number,
			Resources res, boolean vertical) {
		mActivity = activity;
		mLEDNumber = number;
		mRed = res.getDrawable(R.drawable.scrubber_horizontal_red_holo_dark);
		mGreen = res.getDrawable(R.drawable.scrubber_horizontal_green_holo_dark);
		mBlue = res.getDrawable(R.drawable.scrubber_horizontal_blue_holo_dark);
	}

	public void attachToView(ViewGroup targetView) {
		for (int i = 0; i < 3; ++i) {
			ViewGroup g = (ViewGroup) targetView.getChildAt(i);
			TextView label = (TextView) g.getChildAt(0);
			Slider slider = (Slider) g.getChildAt(1);
			TextView valueText = (TextView) g.getChildAt(2);
			SliderPositionListener positionListener = new LedValueUpdater(
					valueText, i);
			slider.setPositionListener(positionListener);
			LabelClickListener leftLabelListener = new LabelClickListener(
					slider, 0);
			label.setOnClickListener(leftLabelListener);
			LabelClickListener rightLabelListener = new LabelClickListener(
					slider, 1);
			valueText.setOnClickListener(rightLabelListener);
			valueText.setText("0");
			if (i == 0) {
				String labelText = "Led";
				SpannableStringBuilder ssb = new SpannableStringBuilder(
						labelText);
				ssb.append(String.valueOf(mLEDNumber));
				int spanStart = labelText.length();
				int spanEnd = spanStart + 1;
				ssb.setSpan(new SubscriptSpan(), spanStart, spanEnd, 0);
				ssb.setSpan(new RelativeSizeSpan(0.7f), spanStart, spanEnd, 0);
				label.setText(ssb);
				slider.setSliderBackground(mRed);
			} else {
				label.setText("");
				if (i == 1) {
					slider.setSliderBackground(mGreen);
				} else {
					slider.setSliderBackground(mBlue);
				}
			}
		}
	}
}
