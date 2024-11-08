/*
 * This file is part of HyperCeiler.

 * HyperCeiler is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.

 * Copyright (C) 2023-2024 HyperCeiler Contributions
 */
package com.sevtinge.hyperceiler.ui.fragment.app;

import static com.sevtinge.hyperceiler.utils.devicesdk.SystemSDKKt.isMoreHyperOSVersion;

import android.view.View;

import com.sevtinge.hyperceiler.R;
import com.sevtinge.hyperceiler.ui.base.BaseSettingsActivity;
import com.sevtinge.hyperceiler.ui.fragment.base.SettingsPreferenceFragment;

import androidx.preference.SwitchPreference;

public class AodFragment extends SettingsPreferenceFragment {
    @Override
    public int getPreferenceScreenResId() {
        return R.xml.aod;
    }

    @Override
    public View.OnClickListener addRestartListener() {
        return view -> ((BaseSettingsActivity) getActivity()).showRestartDialog(
                getResources().getString(!isMoreHyperOSVersion(1f) ? R.string.aod : R.string.aod_hyperos),
                "com.miui.aod"
        );
    }

    @Override
    public void initPrefs() {
        SwitchPreference aod = findPreference("prefs_key_aod_unlock_always_on_display");
        aod.setVisible(!isMoreHyperOSVersion(1f));
        SwitchPreference aodH = findPreference("prefs_key_aod_unlock_always_on_display_hyper");
        aodH.setVisible(isMoreHyperOSVersion(1f));
    }
}
