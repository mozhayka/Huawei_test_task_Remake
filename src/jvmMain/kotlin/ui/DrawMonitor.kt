package ui

import androidx.compose.runtime.Composable
import model.Monitor

@Composable
fun drawMonitor(monitor: Monitor, type: DisplayType) {
    for (elem in monitor.rootElements) {
        drawUIElement(elem, type)
    }
    drawViewport(monitor.viewport)
}
