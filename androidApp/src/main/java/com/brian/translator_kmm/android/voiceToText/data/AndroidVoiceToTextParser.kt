package com.brian.translator_kmm.android.voiceToText.data

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.compose.ui.res.stringResource
import com.brian.translator_kmm.android.R
import com.brian.translator_kmm.core.domain.util.CommonMutableStateFlow
import com.brian.translator_kmm.core.domain.util.CommonStateFlow
import com.brian.translator_kmm.core.domain.util.toCommonMutableStateFlow
import com.brian.translator_kmm.core.domain.util.toCommonStateFlow
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AndroidVoiceToTextParser(
    private val app: Application
) : VoiceToTextParser, RecognitionListener {
    private val _state = MutableStateFlow(VoiceToTextParserState())
    override val state: CommonStateFlow<VoiceToTextParserState> =
        _state.toCommonStateFlow()

    private val recognizer = SpeechRecognizer.createSpeechRecognizer(app)

    /**
     * When we start listening just start with a brand new state
     */
    override fun startListening(languageCode: String) {
        _state.update { VoiceToTextParserState() }

        if (!SpeechRecognizer.isRecognitionAvailable(app)) {
            _state.update {
                it.copy(
                    error = app.getString(R.string.error_speeach_recog_not_available)
                )
            }
            return
        }

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCode)
        }
        recognizer.setRecognitionListener(this)
        recognizer.startListening(intent)
        _state.update {
            it.copy(
                isSpeaking = true
            )
        }
    }

    override fun stopListening() {
        _state.update { VoiceToTextParserState() }
        recognizer.stopListening()
    }

    override fun cancel() {
        recognizer.cancel()
    }

    override fun reset() {
        _state.value = VoiceToTextParserState()
    }

    override fun onReadyForSpeech(p0: Bundle?) {
        _state.update { it.copy(error = null) }
    }

    override fun onBeginningOfSpeech() = Unit

    // A function that gives us info on how loud the user is speaking
    // This function normalizes the values from the api to a value between 1 and 0
    override fun onRmsChanged(rmsDb: Float) {
        _state.update {
            it.copy(
                powerRatio = rmsDb * (1f / (12f - (-2f)))
            )
        }
    }

    override fun onBufferReceived(p0: ByteArray?) = Unit

    override fun onEndOfSpeech() {
        _state.update {
            it.copy(
                isSpeaking = false
            )
        }
    }

    override fun onError(code: Int) {
        _state.update {
            it.copy(
                error = "Error: $code"
            )
        }
    }

    override fun onResults(result: Bundle?) {
        result
            ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            ?.getOrNull(0)// relevant result is at the first index
            ?.let { text ->
                _state.update {
                    it.copy(
                        result = text
                    )
                }
            }
    }

    override fun onPartialResults(p0: Bundle?) = Unit


    override fun onEvent(p0: Int, p1: Bundle?) = Unit
}