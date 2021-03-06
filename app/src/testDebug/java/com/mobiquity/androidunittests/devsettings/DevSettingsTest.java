package com.mobiquity.androidunittests.devsettings;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DevSettingsTest {

    private DevSettings devSettings;

    @Before
    public void setUp() {
        SharedPreferences devPreferences = RuntimeEnvironment.application
                .getSharedPreferences("dev_settings", Context.MODE_PRIVATE);
        devSettings = new DevSettings(devPreferences);
    }

    @Test
    public void testLeakCanary_DisabledByDefault() {
        assertThat(devSettings.isLeakCanaryEnabled()).isFalse();
    }

    @Test
    public void testSetLeakCanarySetting() {
        assertThat(devSettings.isLeakCanaryEnabled()).isFalse();
        devSettings.setLeakCanary(true);
        assertThat(devSettings.isLeakCanaryEnabled()).isTrue();
    }

}