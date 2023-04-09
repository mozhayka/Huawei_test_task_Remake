package model

class UIElement(
    val body: Rectangle,
    val subElements: MutableList<UIElement> = mutableListOf(),
    var visibility: Visibility = Visibility.Partially) {

    fun addSubelement(sub: UIElement)
    {
        if (!isInside(this.body, sub.body))
        {
            throw Exception("subElements is not inside parent")
        }
        subElements.add(sub)
    }
}