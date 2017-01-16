/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.settings.security;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.core.TogglePreferenceController;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.R;

public class ScramblePinLayoutPreferenceController extends TogglePreferenceController {

    private static final String KEY_SCRAMBLE_PIN_LAYOUT = "scramble_pin_layout";

    public ScramblePinLayoutPreferenceController(Context context) {
        super(context, KEY_SCRAMBLE_PIN_LAYOUT);
    }

    @Override
    public boolean isChecked() {
        return Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.SCRAMBLE_PIN_LAYOUT, 0) != 0;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        Settings.System.putInt(mContext.getContentResolver(), Settings.System.SCRAMBLE_PIN_LAYOUT,
                isChecked ? 1 : 0);
        return true;
    }

    @Override
    public int getAvailabilityStatus() {
        return mContext.getResources().getBoolean(R.bool.config_show_scramble_pin_layout)
                ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

}

