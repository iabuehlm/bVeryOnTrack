package ch.hslu.mobileapps.common.presentation.progressbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(15.dp),
            backgroundColor = Color.LightGray,
            color = MaterialTheme.colors.primary //progress color
        )
    }
}