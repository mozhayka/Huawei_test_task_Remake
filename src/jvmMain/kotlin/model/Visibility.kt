package model

enum class Visibility {
    Visible, Invisible, Partially
}

fun getVisibility(intersection: Intersection) : Visibility {
    return when(intersection) {
        Intersection.Inside -> Visibility.Visible
        Intersection.Outside -> Visibility.Invisible
        Intersection.Intersect -> Visibility.Partially
    }
}