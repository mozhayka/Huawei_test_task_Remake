package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
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
                DrawVisibilityButton(monitor, onChangeDisplayType)
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
    DrawMoveButton(monitor,
        onClick = { monitor.scrollVertically(10f) },
        icon = Icons.Default.KeyboardArrowUp)
}

@Composable
fun DownButton(monitor: Monitor) {
    DrawMoveButton(monitor,
        onClick = { monitor.scrollVertically(-10f) },
        icon = Icons.Default.KeyboardArrowDown)
}

@Composable
fun LeftButton(monitor: Monitor) {
    DrawMoveButton(monitor,
        onClick = { monitor.scrollHorizontally(-10f) },
        icon = Icons.Default.KeyboardArrowLeft)
}

@Composable
fun RightButton(monitor: Monitor) {
    DrawMoveButton(monitor,
        onClick = { monitor.scrollHorizontally(10f) },
        icon = Icons.Default.KeyboardArrowRight)
}

@Composable
fun DrawMoveButton(monitor: Monitor, onClick: () -> Unit, icon: ImageVector) {
    Button(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 4.dp))
    }
}

@Composable
fun DrawVisibilityButton(monitor: Monitor, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Display type")
    }
}