package ui

import androidx.compose.runtime.Composable
import model.Monitor

@Composable
fun drawMonitor(monitor: Monitor) {
    for (elem in monitor.rootElements) {
        drawUIElement(elem)
    }
    drawViewport(monitor.viewport)
}