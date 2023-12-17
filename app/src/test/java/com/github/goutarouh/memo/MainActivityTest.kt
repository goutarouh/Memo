package com.github.goutarouh.memo

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.runner.AndroidJUnit4
import com.github.goutarouh.memo.feature.list.MAIN_SCREEN_SUCCESS_TAG
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@HiltAndroidTest
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    sdk = [30],
    qualifiers = RobolectricDeviceQualifiers.Pixel5,
    application = HiltTestApplication::class
)
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun captureComposeComponent() {
        composeTestRule.waitUntilExactlyOneExists(
            matcher = hasTestTag(MAIN_SCREEN_SUCCESS_TAG),
        )
        composeTestRule.onNodeWithTag(MAIN_SCREEN_SUCCESS_TAG)
            .captureRoboImage()
    }
}