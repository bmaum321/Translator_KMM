package com.brian.translator_kmm.presentation

import android.Manifest
import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.GrantPermissionRule
import com.brian.translator_kmm.android.MainActivity
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import com.brian.translator_kmm.android.R
import com.brian.translator_kmm.android.di.AppModule
import com.brian.translator_kmm.android.voiceToText.di.VoiceToTextModule
import com.brian.translator_kmm.translate.data.remote.FakeTranslateClient
import com.brian.translator_kmm.translate.domain.translate.TranslateClient
import com.brian.translator_kmm.voicetotext.data.FakeVoiceToTextParser
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import javax.inject.Inject

@HiltAndroidTest
// Need to uninstall our production modules from the Main Activity
@UninstallModules(AppModule::class, VoiceToTextModule::class)
class VoiceToTextE2E {

    /**
     * Our compose test rule here uses main activity, so the app just launches and we cant inject fake
     * viewmodels manually.
     *
     * So we use dagger hilt to then inject fakes into our main activity
     */
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(Manifest.permission.RECORD_AUDIO)

    @Inject
    lateinit var fakeVoiceParser: VoiceToTextParser

    @Inject
    lateinit var fakeClient: TranslateClient

    /**
     * Inject our fake dependencies
     */
    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun recordAndTranslate(): Unit = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val parser = fakeVoiceParser as FakeVoiceToTextParser
        val client = fakeClient as FakeTranslateClient

        composeRule.onNodeWithContentDescription(context.getString(R.string.record_audio)).performClick()

        composeRule.onNodeWithContentDescription(context.getString(R.string.record_audio)).performClick()

        composeRule.onNodeWithContentDescription(context.getString(R.string.stop_recording)).performClick()

        composeRule.onNodeWithText(parser.voiceResult)
            .assertIsDisplayed()

        composeRule.onNodeWithContentDescription(context.getString(R.string.apply)).performClick()

        composeRule.onNodeWithText(parser.voiceResult)
            .assertIsDisplayed()

        composeRule
            .onNodeWithText(context.getString(R.string.translate), ignoreCase = true)
            .performClick()

        composeRule.onNodeWithText(parser.voiceResult)
            .assertIsDisplayed()

        composeRule.onNodeWithText(client.translatedText)
            .assertIsDisplayed()
    }
}