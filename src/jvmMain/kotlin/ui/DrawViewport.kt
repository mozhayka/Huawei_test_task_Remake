package ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import model.Viewport

@Composable
fun drawViewport(viewport: Viewport) {
    val color = Color.Black
    val size = Size(viewport.body.right - viewport.body.left, viewport.body.bottom - viewport.body.top)
    val topLeft = Offset(viewport.body.left, viewport.body.top)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color, topLeft = topLeft, size = size, style = Stroke(width = 1.dp.toPx()))
    }
}