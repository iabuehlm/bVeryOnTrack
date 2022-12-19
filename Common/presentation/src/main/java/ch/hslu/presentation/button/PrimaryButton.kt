package ch.hslu.presentation.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(0.8f).defaultMinSize(48.dp).widthIn(min = 48.dp)
            .heightIn(min = TextFieldDefaults.MinHeight),
        shape = RoundedCornerShape(20)
    ) {
        Text(
            text = title,
            Modifier.padding(2.dp),
            style = MaterialTheme.typography.button,
        )
    }
}
