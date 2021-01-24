package sample.ch8n.expandingcards.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ExpandingCardComponent() {

    var expandedPosition by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(if (expandedPosition == 1) 1f else 0.3f, fill = false)
                .clickable(onClick = {
                    expandedPosition = 1
                })
        ) {
            CardComponent(expandedPosition == 1)
        }

        Box(
            modifier = Modifier
                .weight(if (expandedPosition == 2) 1f else 0.3f, fill = false)
                .clickable(onClick = {
                    expandedPosition = 2
                })
        ) {
            CardComponent(expandedPosition == 2)
        }

        Box(
            modifier = Modifier
                .weight(if (expandedPosition == 3) 1f else 0.3f, fill = false)
                .clickable(onClick = {
                    expandedPosition = 3
                })
        ) {
            CardComponent(expandedPosition == 3)
        }
    }
}