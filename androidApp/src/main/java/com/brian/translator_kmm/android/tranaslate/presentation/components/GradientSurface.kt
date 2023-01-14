package com.brian.translator_kmm.android.tranaslate.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Background changes based on device theme.
 * Since this composable relies on state we used the composed block
 * AKA a stateful composable
 */
fun Modifier.gradientSurface(): Modifier = composed {
    if(isSystemInDarkTheme()) {
        Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF23262E),
                    Color(0xFF212329)
                )
            )
        )
    } else Modifier.background(MaterialTheme.colorScheme.surface)
}