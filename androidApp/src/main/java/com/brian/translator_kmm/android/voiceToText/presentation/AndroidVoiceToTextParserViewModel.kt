package com.brian.translator_kmm.android.voiceToText.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import com.brian.translator_kmm.voicetotext.presentation.VoiceToTextEvent
import com.brian.translator_kmm.voicetotext.presentation.VoiceToTextViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidVoiceToTextViewModel @Inject constructor(
    private val parser: VoiceToTextParser
): ViewModel() {

    private val viewModel by lazy {
        VoiceToTextViewModel(
            parser = parser,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: VoiceToTextEvent) {
        viewModel.onEvent(event)
    }
}