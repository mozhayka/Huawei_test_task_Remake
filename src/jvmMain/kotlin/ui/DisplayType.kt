package ui

enum class DisplayType {
    AllWithSubelements, AllWithoutSubelements, OnlyVisibleWithSubelements, OnlyVisibleWithoutSubelements
}

fun nextDisplayType(type: DisplayType) : DisplayType {
    return when(type) {
        DisplayType.AllWithSubelements -> DisplayType.OnlyVisibleWithSubelements
        DisplayType.OnlyVisibleWithSubelements -> DisplayType.AllWithoutSubelements
        DisplayType.AllWithoutSubelements -> DisplayType.OnlyVisibleWithoutSubelements
        DisplayType.OnlyVisibleWithoutSubelements -> DisplayType.AllWithSubelements
    }
}