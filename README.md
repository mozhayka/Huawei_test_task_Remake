# Тестовое задание, переписанное на kotlin
### Description
Given a quite large tree describing UI elements with size and position inside parent (child elements are always contained in parent) and current viewport (that it, (x, y, width, height)) implement fast visibility tester quickly finding partially or fully visible elements in the viewport. Algorithm must be optimized for cases like scrolling (in both axis) when fixed size viewport slides over UI elements.

Concurrent algorithm would be a plus

### UI
UI реализован с помощью Jetpack Compose. 

На экране изображены UI элементы в виде разноцветных прямоугольников, а также окно наблюдения, которое является прозрачным прямоугольником с черной границей.

Цвет прямоугольника зависит от того, находится ли он внутри окна: 
лежащие внутри - красные, снаружи - синие, пересекающиеся с окном - зеленые.

Окно наблюдения можно двигать во всех направлениях с помощью кнопок, при этом цвета прямоугольников автоматически изменяются в зависимости от их текущей видимости.

Также есть возможность переключать тип отображения по нажатию на кнопку со звездой. При этом будут выводиться либо все прямоугольники, либо только видимые и частично видимые с их дочерними элементами. Сами прямоугольники будут прозрачными с границей нужного цвета. 
Также можно выводить все прямоугольники, но без внутренних элементов, или только видимые без внутренних элементов. При этом вместо границ будут заполненные прямоугольники.
