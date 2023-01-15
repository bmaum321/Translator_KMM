package com.brian.translator_kmm.voicetotext.presentation

sealed interface VoiceToTextEvent {
    object Close : VoiceToTextEvent
    data class PermissionResult(
        val isGranted: Boolean,
        val isPermanentlyDeclined: Boolean
    ) : VoiceToTextEvent
    data class ToggleRecording(val languageCode: String) : VoiceToTextEvent
    object Reset: VoiceToTextEvent
}
