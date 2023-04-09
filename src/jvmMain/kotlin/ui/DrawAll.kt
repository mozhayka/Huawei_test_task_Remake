package ui

import androidx.compose.runtime.Composable
import model.Monitor

@Composable
fun draw(monitor: Monitor) {
    drawMonitor(monitor)
    drawButtons(monitor)
}
