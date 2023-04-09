package ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import model.UIElement
import model.Visibility

@Composable
fun drawUIElement(elem: UIElement) {
    drawBody(elem)
    if (elem.visibility == Visibility.Partially) {
        for (sub in elem.subElements) {
            drawUIElement(sub)
        }
    }
}

@Composable
fun drawBody(elem: UIElement) {
    val color = when (elem.visibility) {
        Visibility.Visible -> Color.Red
        Visibility.Invisible -> Color.Blue
        Visibility.Partially -> Color.Green
    }
    val size = Size(elem.body.right - elem.body.left, elem.body.top - elem.body.bottom)
    val topLeft = Offset(elem.body.left, elem.body.top)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color, topLeft = topLeft, size = size)
    }
}