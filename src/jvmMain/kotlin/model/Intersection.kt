package model

enum class Intersection {
    Inside, Outside, Intersect
}

fun intersectSegments(parentLeft: Float, parentRight: Float, childLeft: Float, childRight: Float) : Intersection {
    if (childRight < parentLeft || parentRight < childLeft)
        return Intersection.Outside
    if (parentLeft <= childLeft && childRight <= parentRight)
        return Intersection.Inside
    return Intersection.Intersect
}

fun mergeIntersections(x : Intersection, y: Intersection) : Intersection {
    if (x == Intersection.Inside && y == Intersection.Inside)
        return Intersection.Inside
    if (x == Intersection.Outside || y == Intersection.Outside)
        return Intersection.Outside
    return Intersection.Intersect
}