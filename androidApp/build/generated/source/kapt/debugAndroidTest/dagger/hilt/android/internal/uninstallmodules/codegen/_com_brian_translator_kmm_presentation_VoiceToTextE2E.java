package dagger.hilt.android.internal.uninstallmodules.codegen;

import dagger.hilt.android.internal.uninstallmodules.AggregatedUninstallModules;

/**
 * This class should only be referenced by generated code! This class aggregates information across multiple compilations.
 */
@AggregatedUninstallModules(
    test = "com.brian.translator_kmm.presentation.VoiceToTextE2E",
    uninstallModules = {
        "com.brian.translator_kmm.android.di.AppModule",
        "com.brian.translator_kmm.android.voiceToText.di.VoiceToTextModule"
    }
)
public class _com_brian_translator_kmm_presentation_VoiceToTextE2E {
}
