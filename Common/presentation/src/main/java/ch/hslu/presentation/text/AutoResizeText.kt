package ch.hslu.mobileapps.common.presentation.text

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun AutoResizeText (message: String, fontSize: TextUnit){
    var textSize by remember { mutableStateOf(fontSize) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        text = message,
        fontSize =  textSize,
        maxLines = 1,
        softWrap = false,
        modifier = Modifier.drawWithContent {
            if (readyToDraw) drawContent()
        },
        onTextLayout = { textLayoutResult ->
            if (textLayoutResult.hasVisualOverflow) {
                textSize = textSize.times(0.9f)
            } else {
                readyToDraw = true
            }
        },
    )
}