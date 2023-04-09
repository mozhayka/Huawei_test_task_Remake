package model

class Viewport(private val body: Rectangle) {
    fun scrollHorizontally(distanceToTheRight: Float) {
        body.left += distanceToTheRight
        body.right += distanceToTheRight
    }

    fun scrollVertically(distanceToTheTop: Float) {
        body.top += distanceToTheTop
        body.bottom += distanceToTheTop
    }

    fun isVisible(element: UIElement) : Visibility {
        return getVisibility(intersect(body, element.body))
    }
}