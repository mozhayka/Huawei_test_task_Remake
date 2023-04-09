package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

class Viewport(initialBody: Rectangle) {

    val body by mutableStateOf(initialBody)
    fun scrollHorizontally(distanceToTheRight: Float) {
        body.left += distanceToTheRight
        body.right += distanceToTheRight
    }

    fun scrollVertically(distanceToTheTop: Float) {
        println("scroll vertically $body")
        body.top += distanceToTheTop
        body.bottom += distanceToTheTop
    }

    fun isVisible(element: UIElement) : Visibility {
        return getVisibility(intersect(body, element.body))
    }
}