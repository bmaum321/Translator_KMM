package com.brian.translator_kmm.voicetotext.data

import com.brian.translator_kmm.core.domain.util.CommonStateFlow
import com.brian.translator_kmm.core.domain.util.toCommonStateFlow
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeVoiceToTextParser : VoiceToTextParser {

    var voiceResult = "test result"
    private val _state = MutableStateFlow(VoiceToTextParserState())
    override val state: CommonStateFlow<VoiceToTextParserState>
        get() = _state.toCommonStateFlow()

    override fun startListening(languageCode: String) {
        _state.update {
            it.copy(
                result = "",
                isSpeaking = true
            )
        }
    }

    override fun stopListening() {
        _state.update {
            it.copy(
                result = voiceResult,
                isSpeaking = false
            )
        }
    }

    override fun cancel() = Unit

    override fun reset() {
        _state.update { VoiceToTextParserState() }
    }
}