package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Rectangle(top: Float, bottom: Float, left: Float, right: Float) {
    var top by mutableStateOf(top)
    var bottom by mutableStateOf(bottom)
    var left by mutableStateOf(left)
    var right by mutableStateOf(right)
}

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
