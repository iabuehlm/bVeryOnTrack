package ch.hslu.presentation.dragndrop

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * https://issuetracker.google.com/issues/181282427 - Comment #17
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragAndDropListContent(items: List<DraggableItems>, onSaveListEvent: (List<DraggableItems>) -> Unit) {
    var list by remember { mutableStateOf(items) }
    val listState = rememberLazyListState()
    val dragDropState = rememberDragDropState(listState) { fromIndex, toIndex ->
        list = list.toMutableList().apply {
            add(toIndex, removeAt(fromIndex))
        }
    }

    LazyColumn(
        modifier = Modifier.gridDragContainer(dragDropState, onDragEnd = {onSaveListEvent(list)}),
        state = listState,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(list) { index, item ->
            DraggableItem(dragDropState, index) { isDragging ->
                val elevation by animateDpAsState(if (isDragging) 4.dp else 1.dp)
                item.index = index
                Card(elevation = elevation) {
                    Text(
                        "Item ${item.itemName} , ${item.index}",
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}
