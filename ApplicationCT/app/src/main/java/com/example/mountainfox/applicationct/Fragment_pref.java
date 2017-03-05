package com.example.mountainfox.applicationct;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Mountainfox on 02-Mar-17.
 */

public class Fragment_pref extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
