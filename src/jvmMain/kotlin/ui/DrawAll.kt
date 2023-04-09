package ui

import androidx.compose.runtime.*
import model.Monitor

@Composable
fun draw(monitor: Monitor) {
    var type by remember { mutableStateOf(DisplayType.AllWithSubelements) }
    drawMonitor(monitor, type)
    drawButtons(monitor, onChangeDisplayType = { type = nextDisplayType(type) })
}