package com.brian.translator_kmm.voicetotext.domain

data class VoiceToTextParserState(
    val result: String = "",
    val error: String? = null,
    val powerRatio: Float = 0f, // desribes how loud the user is speaking to draw bars when user is speaking
    val isSpeaking: Boolean = false
)
