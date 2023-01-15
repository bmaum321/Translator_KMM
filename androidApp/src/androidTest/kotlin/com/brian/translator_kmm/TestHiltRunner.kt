package com.brian.translator_kmm

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication


/**
 * We need to specify this is a test runner in gradle build file with:
 * testInstrumentationRunner = "com.brian.translator_kmm.TestHiltRunner"
 */
class TestHiltRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}