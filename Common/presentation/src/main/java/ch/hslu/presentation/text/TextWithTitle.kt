package ch.hslu.mobileapps.common.presentation.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextWithTitle(
    title: String,
    content: @Composable (() -> Unit)?
) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
    if (content != null) {
        content()
    }
    Spacer(modifier = Modifier.height(5.dp))

}

@Composable
fun TextWithTitle(title: String, text: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = text,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(5.dp))
}

@Preview(showBackground = true)
@Composable
fun TextWithTitlePreview() {
    TextWithTitle("Titel", "Text")
    Spacer(modifier = Modifier.height(10.dp))
    TextWithTitle("Titel"){
        Column {
            Text("Beispiel.")
            Text("Beispiel.")
        }
    }
}