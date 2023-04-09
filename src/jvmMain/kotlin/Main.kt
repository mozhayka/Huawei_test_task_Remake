import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.fromFile
import ui.draw

fun main() = application {
    val path = "src/jvmMain/input/TestInput3.txt"
    val monitor = fromFile(path)
    Window(onCloseRequest = ::exitApplication) {
        draw(monitor)
    }
}
