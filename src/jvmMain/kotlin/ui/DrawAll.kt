package ui

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme

import model.Monitor

@Composable
fun draw(monitor: Monitor) {
    drawMonitor(monitor)
    MaterialTheme {
        Button(onClick = {
            monitor.scrollHorizontally(10f)
        }) {}
    }
}

@Composable
fun drawMonitor(monitor: Monitor) {
    println("Redraw monitor println(${monitor.viewport.body})")
    for (elem in monitor.rootElements) {
        drawUIElement(elem)
    }
    drawViewport(monitor.viewport)
}
