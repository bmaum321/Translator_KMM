package com.brian.translator_kmm.android.tranaslate.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.translator_kmm.android.R

@Composable
fun CustomAlertDialog(
    tag: String,
    title: String,
    text: String,
    onDismissRequest: () -> Unit,
    dismissButtonOnClick: () -> Unit,
    confirmButtonOnClick: () -> Unit,
    confirmText: String,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        // This test tag is used for semantics matching in UI testing
        modifier = Modifier.semantics { testTag = tag },
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        },
        text = { Text(text = text) },
        onDismissRequest = onDismissRequest,
        dismissButton = {
            TextButton(
                onClick = dismissButtonOnClick
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        confirmButton = {
            TextButton(
                onClick = confirmButtonOnClick
            ) {
                Text(text = confirmText)
            }
        },
        shape = RoundedCornerShape(4.dp),
        contentColor = MaterialTheme.colors.onSurface
    )
}