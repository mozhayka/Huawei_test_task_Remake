package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class UIElement(val body: Rectangle, val subelements: MutableList<UIElement> = mutableListOf()) {

    var visibility by mutableStateOf(Visibility.Partially)

    fun addSubelement(sub: UIElement)
    {
        if (!isInside(this.body, sub.body))
        {
            throw Exception("subElements is not inside parent ${this.body}, ${sub.body}")
        }
        subelements.add(sub)
    }
}