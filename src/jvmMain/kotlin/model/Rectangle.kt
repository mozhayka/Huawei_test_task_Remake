package model

data class Rectangle(var top: Float, var bottom: Float, var left: Float, var right: Float)

fun isInside(parent: Rectangle, child: Rectangle) : Boolean {
    return intersect(parent, child) == Intersection.Inside
}

fun intersect(parent: Rectangle, child: Rectangle) : Intersection {
    return mergeIntersections(horizontalIntersect(parent, child), verticalIntersect(parent, child))
}

fun horizontalIntersect(parent: Rectangle, child: Rectangle) : Intersection {
    return intersectSegments(parent.left, parent.right, child.left, child.right)
}

fun verticalIntersect(parent: Rectangle, child: Rectangle) : Intersection {
    return intersectSegments(parent.top, parent.bottom, child.top, child.bottom)
}
