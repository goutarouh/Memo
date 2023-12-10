package com.github.goutarouh.memo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    sdk = [30],
    qualifiers = RobolectricDeviceQualifiers.NexusOne
)
class MainActivityTest {

    @Test
    @Config(qualifiers = "+land")
    fun captureMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(ViewMatchers.isRoot())
            .captureRoboImage()
    }

}