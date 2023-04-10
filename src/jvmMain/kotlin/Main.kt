import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.fromFile
import ui.draw

fun main() = application {
    val path = "src/jvmMain/input/TestInput3.txt"
    val m = fromFile(path)
    val monitor by remember { mutableStateOf(m) }
    Window(onCloseRequest = ::exitApplication) {
        draw(monitor)
    }
}
