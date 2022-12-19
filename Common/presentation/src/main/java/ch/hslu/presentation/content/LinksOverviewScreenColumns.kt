package ch.hslu.mobileapps.common.presentation.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ch.hslu.mobileapps.common.application.navigation.NavigationItem

@Composable
fun LinksOverviewColumnsScreen(
    navController: NavController,
    navigationItems: List<NavigationItem>
) {
    val vertScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(vertScrollState)
            .fillMaxSize()
            .padding(20.dp),
        //horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        navigationItems.forEach {
            Divider(modifier = Modifier.padding(1.dp), color = MaterialTheme.colors.primary)
            NavigationRowBox(navController = navController, item = it)
        }
    }
}

@Composable
fun NavigationRowBox(navController: NavController, item: NavigationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(10.dp)
            .clickable {
                navController.navigate(item.route){
                    launchSingleTop = true
                    restoreState = true
                }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        //Icon(imageVector = item.icon, contentDescription = "icon")
        Text(item.label, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(10.dp))
        Icon(
            imageVector = Icons.Outlined.ArrowForward,
            contentDescription = "arrow",
            tint = MaterialTheme.colors.primary.copy(alpha = 0.5f)
        )
    }
}