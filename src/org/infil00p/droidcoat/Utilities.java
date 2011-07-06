/*
 * Original Code Copyright (C) 2011 The Android Open Source Project
 * Modificatons Copyright (C) 2011 Joe Bowser
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

import android.graphics.drawable.Drawable;

public class Utilities {
	static void centerAround(int x, int y, Drawable d) {
		int w = d.getIntrinsicWidth();
		int h = d.getIntrinsicHeight();
		int left = x - w / 2;
		int top = y - h / 2;
		int right = left + w;
		int bottom = top + h;
		d.setBounds(left, top, right, bottom);
	}

}
