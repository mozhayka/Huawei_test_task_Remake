package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import model.Monitor

@Composable
fun drawButtons(monitor: Monitor, onChangeDisplayType: () -> Unit) {
    MaterialTheme {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                UpButton(monitor)
            }
            Row {
                LeftButton(monitor)
                DrawVisibilityButton(onChangeDisplayType)
                RightButton(monitor)
            }
            Row {
                DownButton(monitor)
            }
        }
    }
}

@Composable
fun UpButton(monitor: Monitor) {
    DrawMoveButton(
        onClick = { monitor.scrollVertically(10f) },
        icon = Icons.Default.KeyboardArrowUp
    )
}

@Composable
fun DownButton(monitor: Monitor) {
    DrawMoveButton(
        onClick = { monitor.scrollVertically(-10f) },
        icon = Icons.Default.KeyboardArrowDown
    )
}

@Composable
fun LeftButton(monitor: Monitor) {
    DrawMoveButton(
        onClick = { monitor.scrollHorizontally(-10f) },
        icon = Icons.Default.KeyboardArrowLeft
    )
}

@Composable
fun RightButton(monitor: Monitor) {
    DrawMoveButton(
        onClick = { monitor.scrollHorizontally(10f) },
        icon = Icons.Default.KeyboardArrowRight
    )
}

@Composable
fun DrawMoveButton(onClick: () -> Unit, icon: ImageVector) {
    Button(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier)
    }
}

@Composable
fun DrawVisibilityButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier)
    }
}