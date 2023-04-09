package ui

import androidx.compose.runtime.Composable
import model.Monitor

@Composable
fun draw(monitor: Monitor) {
    for (elem in monitor.rootElements) {
        drawUIElement(elem)
    }
    monitor.viewport?.let { drawViewport(it) }
}