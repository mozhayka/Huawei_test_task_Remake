package model

import java.io.File
import java.io.InputStream

class Monitor(var viewport: Viewport? = null, val rootElements: MutableList<UIElement> = mutableListOf()) {

    constructor(path: String) : this() {
        val inputStream: InputStream = File(path).inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lineList.add(it) }
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

        viewport = createViewport(lineList.last())
        updateVisibility()
    }

    fun fromFile(path: String)
    {
        val inputStream: InputStream = File(path).inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lineList.add(it) }
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

        viewport = createViewport(lineList.last())
        updateVisibility()
    }

    fun scrollHorizontally(distToTheRight: Float) {
        viewport?.scrollHorizontally(distToTheRight)
        updateVisibility()
    }

    fun scrollVertically(distToTheTop: Float) {
        viewport?.scrollVertically(distToTheTop)
        updateVisibility()
    }

    private fun updateVisibility() {
        rootElements.forEach {updateVisibility(it)}
    }

    private fun updateVisibility(element: UIElement) {
        val visibility = viewport?.isVisible(element)
        if (visibility != null) {
            element.visibility = visibility
        }
        if (visibility == Visibility.Partially) {
            for (sub in element.subElements) {
                updateVisibility(sub)
            }
        }
    }

    private fun createUIElement(s: String) : Pair<UIElement, Int> {
        val args = s.split(' ')
        val prev = args[0].toInt()
        val top = args[1].toFloat()
        val left = args[2].toFloat()
        val bottom = top + args[3].toFloat()
        val right = left + args[4].toFloat()

        return Pair(UIElement(body = Rectangle(top, bottom, left, right)), prev)
    }

    private fun createViewport(s: String) : Viewport {
        val args = s.split(' ')

        val top = args[0].toFloat()
        val left = args[1].toFloat()
        val bottom = top + args[2].toFloat()
        val right = left + args[3].toFloat()

        return Viewport(body = Rectangle(top, bottom, left, right))
    }
}