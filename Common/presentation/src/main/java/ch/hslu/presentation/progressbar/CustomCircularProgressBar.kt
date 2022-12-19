package ch.hslu.mobileapps.common.presentation.progressbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomCircularProgressBar(){
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        CircularProgressIndicator(
            modifier = Modifier
                //.fillMaxWidth(0.4f)
               .height(24.dp),
            color = MaterialTheme.colors.primary //progress color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomCircularProgressBarPreview() {
    CustomCircularProgressBar()
}