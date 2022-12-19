package ch.hslu.presentation.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(48.dp)
            .widthIn(min = 48.dp),
        shape = RoundedCornerShape(20)   ,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.button,

            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    MaterialTheme {
        SecondaryButton(Modifier, "Bearbeiten") { }
    }
}