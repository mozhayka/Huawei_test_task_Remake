package model

import androidx.compose.runtime.*
import java.io.File
import java.io.InputStream

class Monitor(viewport: Viewport, rootElements: MutableList<UIElement>) {

    val viewport by mutableStateOf(viewport)
    val rootElements by mutableStateOf(rootElements)

    fun scrollHorizontally(distToTheRight: Float) {
        viewport.scrollHorizontally(distToTheRight)
        updateVisibility()
    }

    fun scrollVertically(distToTheTop: Float) {
        viewport.scrollVertically(distToTheTop)
        updateVisibility()
    }

    fun updateVisibility() {
        rootElements.forEach {updateVisibility(it)}
    }

    private fun updateVisibility(element: UIElement) {
        val visibility = viewport.isVisible(element)
        element.visibility = visibility

        if (visibility == Visibility.Partially) {
            for (sub in element.subelements) {
                updateVisibility(sub)
            }
        }
    }
}

@Composable
fun fromFile(path: String) : Monitor
{
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val rootElements: MutableList<UIElement> = mutableListOf()
    val elements = lineList.dropLast(1).map {createUIElement(it)}
    for (elem in elements) {
        val element = elem.first
        val prev = elem.second
        if (prev == -1)
        {
            rootElements.add(element)
            continue
        }
        elements[prev].first.addSubelement(element)
    }

    val viewport = createViewport(lineList.last())
    val monitor = Monitor(viewport, rootElements)
    monitor.updateVisibility()
    return monitor
}

@Composable
private fun createUIElement(s: String) : Pair<UIElement, Int> {
    val args = s.split(' ')
    val prev = args[0].toInt()
    val top = args[1].toFloat()
    val left = args[2].toFloat()
    val bottom = top + args[3].toFloat()
    val right = left + args[4].toFloat()

    val elem = remember {UIElement(Rectangle(top, bottom, left, right))}
    return Pair(elem, prev)
}

@Composable
private fun createViewport(s: String): Viewport {
    val args = s.split(' ')

    val top = args[0].toFloat()
    val left = args[1].toFloat()
    val bottom = top + args[2].toFloat()
    val right = left + args[3].toFloat()

    return remember { Viewport(Rectangle(top, bottom, left, right)) }
}