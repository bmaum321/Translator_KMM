package com.brian.translator_kmm.android.tranaslate.presentation

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brian.translator_kmm.translate.presentation.TranslateEvent
import com.brian.translator_kmm.translate.presentation.TranslateState
import com.brian.translator_kmm.android.R
import com.brian.translator_kmm.android.tranaslate.presentation.components.*
import com.brian.translator_kmm.core.domain.language.Language
import com.brian.translator_kmm.core.presentation.UiLanguage
import com.brian.translator_kmm.translate.domain.translate.TranslateError
import com.brian.translator_kmm.translate.presentation.UiHistoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * An advantage of passing a state here instead of a viewmodel is that it makes the UI much easier to test.
 * If you passed a viewmodel that had several dependencies you would have to create fakes for all of them
 * just to write a UI tests. Here we just pass a state instead
 *
 *
 */
@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun TranslateScreen(
    state: TranslateState,
    onEvent: (TranslateEvent) -> Unit,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    listState: LazyListState = rememberLazyListState(),
) {
    var openClearHistoryDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val showTextToSpeechButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex == 0 }
    }
    val snackbarHostState = remember { SnackbarHostState() }


    if (openClearHistoryDialog) {
        CustomAlertDialog(
            tag = "",
            title = stringResource(id = R.string.clear_history),
            text = stringResource(id = R.string.clear_history_dialog),
            onDismissRequest = { openClearHistoryDialog = false },
            dismissButtonOnClick = { openClearHistoryDialog = false },
            confirmButtonOnClick = {
                onEvent(TranslateEvent.ClearTranslateHistory)
                openClearHistoryDialog = false
                coroutineScope.launch {
                    val snacbarResult = snackbarHostState.showSnackbar(
                        message = context.getString(R.string.history_deleted),
                        duration = SnackbarDuration.Short,
                        actionLabel = context.getString(R.string.undo)
                    )

                    when(snacbarResult) {
                        SnackbarResult.ActionPerformed -> {
                            onEvent(TranslateEvent.InsertAllHistoryItems)
                        }
                        SnackbarResult.Dismissed -> {

                        }
                    }
                }

            },
            confirmText = stringResource(id = R.string.confirm),
            modifier = Modifier
        )
    }
    LaunchedEffect(key1 = state.error) {
        val message = when (state.error) {
            TranslateError.SERVICE_UNAVAILABLE -> context.getString(R.string.error_service_unavailable)
            TranslateError.CLIENT_ERROR -> context.getString(R.string.client_error)
            TranslateError.SERVER_ERROR -> context.getString(R.string.server_error)
            TranslateError.UNKNOWN_ERROR -> context.getString(R.string.unknown_error)
            else -> null
        }
        message?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            /**
             * Reset the error state after handling the event
             */
            onEvent(TranslateEvent.OnErrorScreen)
        }
    }


    /**
     * Close current translation if scrolling through history
     *
     * This gets called after submitting a voice result via tts, because it seems like the state
     * isn't surviving recomposition, which effectively breaks the feature
     * because it sets to from text to an empty string. There are a few ways to solve this,
     * could track if from text in state came from tts or text.
     *
     * I decided to just not clear the text field for simplicity using a new callback
     */
    LaunchedEffect( showTextToSpeechButton ) {
        onEvent(TranslateEvent.CloseTranslationOnHistoryScroll)
    }

    Scaffold(
        floatingActionButton = {
            AnimatedContent(
                targetState = listState
            ) {
                if (showTextToSpeechButton) {
                    FloatingActionButton(
                        onClick = { onEvent(TranslateEvent.RecordAudio) },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(75.dp),
                        shape = RoundedCornerShape(18.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = stringResource(id = R.string.record_audio),
                            modifier = Modifier.size(42.dp)
                        )
                    }
                } else {
                    FloatingActionButton(
                        onClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(0)
                            }
                        },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(32.dp),
                        shape = RoundedCornerShape(18.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExpandLess,
                            contentDescription = stringResource(id = R.string.scroll_to_top)
                        )
                    }
                }

            }

        },
        floatingActionButtonPosition = FabPosition.Center,
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .animateContentSize()
            ) { data ->
                Snackbar(
                    snackbarData = data,
                    modifier = Modifier,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary,
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LanguageDropDown(
                    language = state.fromLanguage,
                    isOpen = state.isChoosingFromLanguage,
                    onClick = { onEvent(TranslateEvent.OpenFromLanguageDropDown) },
                    onDismiss = { onEvent(TranslateEvent.StopChoosingLanguage) },
                    onSelectLanguage = { onEvent(TranslateEvent.ChooseFromLanguage(it)) }
                )
                Spacer(modifier = Modifier.weight(1f))
                SwapLanguagesButton(onClick = { onEvent(TranslateEvent.SwapLanguages) })
                Spacer(modifier = Modifier.weight(1f))
                LanguageDropDown(
                    language = state.toLanguage,
                    isOpen = state.isChoosingToLanguage,
                    onClick = { onEvent(TranslateEvent.OpenToLanguageDropDown) },
                    onDismiss = { onEvent(TranslateEvent.StopChoosingLanguage) },
                    onSelectLanguage = { onEvent(TranslateEvent.ChooseToLanguage(it)) }
                )
            }

            val clipBoardManager = LocalClipboardManager.current
            val keyboardController = LocalSoftwareKeyboardController.current
            val tts = rememberTextToSpeech()
            TranslateTextField(
                fromText = state.fromText,
                toText = state.toText,
                isTranslating = state.isTranslating,
                fromLanguage = state.fromLanguage,
                toLanguage = state.toLanguage,
                onTranslateClick = {
                    keyboardController?.hide()
                    onEvent(TranslateEvent.Translate)
                },
                onTextChange = {
                    onEvent(TranslateEvent.ChangeTranslationText(it))
                },
                onCopyClick = { text ->
                    clipBoardManager.setText(
                        buildAnnotatedString {
                            append(text)
                        }
                    )
                    Toast.makeText(
                        context,
                        context.getString(R.string.copied_to_clipboard),
                        Toast.LENGTH_LONG
                    ).show()
                },
                onSpeakerClick = {
                    tts.language = state.toLanguage.toLocale() ?: Locale.ENGLISH
                    tts.speak(
                        state.toText,
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                    )
                },
                onTextFieldClick = {
                    onEvent(TranslateEvent.EditTranslation)
                },
                onCloseClick = {
                    onEvent(TranslateEvent.CloseTranslation)
                },
                modifier = Modifier.fillMaxWidth(),
                onClearClick = {
                    onEvent(TranslateEvent.ClearFromText)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            if (state.history.isNotEmpty()) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(id = R.string.history),
                        style = MaterialTheme.typography.titleMedium
                    )

                    IconButton(
                        onClick = { openClearHistoryDialog = true }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(id = R.string.delete_translate_history),
                            //tint = Color.Red
                        )
                    }
                }

            }

            LazyColumn(
                modifier = Modifier,
                //   .fillMaxSize()
                //  .padding(paddingValues)
                //  .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                state = listState
            ) {
                items(state.history) { item ->
                    TranslateHistoryItem(
                        item = item,
                        onClick = { onEvent(TranslateEvent.SelectHistoryItem(item)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TranslateScreenPreview() {
    TranslateScreen(
        state = TranslateState(
            history = listOf(
                UiHistoryItem(
                    id = 0,
                    fromText = "",
                    toText = "",
                    fromLanguage = UiLanguage(
                        language = Language.ENGLISH,
                        drawableRes = com.brian.translator_kmm.R.drawable.english
                    ),
                    toLanguage = UiLanguage(
                        language = Language.ENGLISH,
                        drawableRes = com.brian.translator_kmm.R.drawable.english
                    )
                )
            )
        ),
        onEvent = { TranslateEvent.Translate })
}