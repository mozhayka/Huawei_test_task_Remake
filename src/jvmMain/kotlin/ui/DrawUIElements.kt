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
import model.UIElement
import model.Visibility

@Composable
fun drawUIElement(elem: UIElement, type: DisplayType) {
    when (type) {
        DisplayType.AllWithSubelements -> drawAllWithSubelements(elem)
        DisplayType.AllWithoutSubelements -> drawAllWithoutSubelements(elem)
        DisplayType.OnlyVisibleWithSubelements -> drawOnlyVisibleWithSubelements(elem)
        DisplayType.OnlyVisibleWithoutSubelements -> drawOnlyVisibleWithoutSubelements(elem)
    }
    if (elem.visibility == Visibility.Partially) {
        for (sub in elem.subelements) {
            drawUIElement(sub, type)
        }
    }
}

@Composable
fun drawAllWithSubelements(elem: UIElement) {
    drawBody(elem)
    for (sub in elem.subelements) {
        if (elem.visibility != Visibility.Partially)
            sub.visibility = elem.visibility
        drawAllWithSubelements(sub)
    }
}


@Composable
fun drawAllWithoutSubelements(elem: UIElement) {
    drawFilledBody(elem)
    if (elem.visibility == Visibility.Partially) {
        for (sub in elem.subelements) {
            drawAllWithoutSubelements(sub)
        }
    }
}

@Composable
fun drawOnlyVisibleWithSubelements(elem: UIElement) {
    if (elem.visibility == Visibility.Invisible) {
        return
    }
    drawBody(elem)
    for (sub in elem.subelements) {
        if (elem.visibility == Visibility.Visible)
            sub.visibility = Visibility.Visible
        drawOnlyVisibleWithSubelements(sub)
    }
}

@Composable
fun drawOnlyVisibleWithoutSubelements(elem: UIElement) {
    if (elem.visibility == Visibility.Invisible) {
        return
    }
    drawFilledBody(elem)
    if (elem.visibility == Visibility.Partially) {
        for (sub in elem.subelements) {
            drawOnlyVisibleWithoutSubelements(sub)
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
    val size = Size(elem.body.right - elem.body.left, elem.body.bottom - elem.body.top)
    val topLeft = Offset(elem.body.left, elem.body.top)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color, topLeft = topLeft, size = size, style = Stroke(width = 1.dp.toPx()))
    }
}

@Composable
fun drawFilledBody(elem: UIElement) {
    val color = when (elem.visibility) {
        Visibility.Visible -> Color.Red
        Visibility.Invisible -> Color.Blue
        Visibility.Partially -> Color.Green
    }
    val size = Size(elem.body.right - elem.body.left, elem.body.bottom - elem.body.top)
    val topLeft = Offset(elem.body.left, elem.body.top)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color, topLeft = topLeft, size = size)
        drawRect(Color.Magenta, topLeft = topLeft, size = size, style = Stroke(width = 1.dp.toPx()))
    }
}