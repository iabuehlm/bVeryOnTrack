package ch.hslu.mobileapps.common.presentation.content

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ch.hslu.mobileapps.common.application.navigation.NavigationItem
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun LinksOverviewScreen(navController: NavController, navigationItems: List<NavigationItem>) {
    val vertScrollState = rememberScrollState()
    FlowRow(
        modifier = Modifier
            .verticalScroll(vertScrollState)
            .fillMaxSize()
            .padding(20.dp),
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 12.dp,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
        crossAxisAlignment = FlowCrossAxisAlignment.Center
    ) {
        navigationItems.forEach {
            NavigationBox(navController = navController, item = it)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun NavigationBox(navController: NavController, item: NavigationItem) {
    Box(
        modifier = Modifier
            .height(90.dp)
            .width(150.dp)
//            .border( 2.dp, color = MaterialTheme.colors.primary.copy(alpha = 0.8f), RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colors.primary.copy(alpha = 0.8f))
            .clickable {
                navController.navigate(item.route){
                    launchSingleTop = true
                    restoreState = true

                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(item.label, textAlign = TextAlign.Center)
    }
}