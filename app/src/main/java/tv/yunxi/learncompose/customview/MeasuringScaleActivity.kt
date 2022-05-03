package tv.yunxi.learncompose.customview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author: created by wangkm
 * @time: 2022/05/03 10:36
 * @desc：
 * @email: 1240413544@qq.com
 */

class MeasuringScaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeasuringScaleActivityContent()
        }
    }
}

@Composable
fun MeasuringScaleActivityContent() {
    CustomTheme {
        MeasuringScaleComponent()
    }
}

@Composable
fun MeasuringScaleComponent() {
    val scrollState = rememberScrollState()

    Row(modifier = Modifier.horizontalScroll(scrollState).padding(top = 16.dp).fillMaxWidth(),
        content = {
            for (i in -20..1020) {
                ScaleLineComponent(i)
            }
        })
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
    ) {
        ScaleCenterPointer()
    }
}

@Composable
fun ScaleLineComponent(index: Int) {
    val isDivisibleBy10 = index % 10 == 0
    val surfaceColor = MaterialTheme.colors.surface
    val onSurfaceColor = MaterialTheme.colors.onSurface

    Column(modifier = Modifier.background(color = surfaceColor)) {
        Canvas(
            modifier = Modifier.padding(5.dp).height(100.dp).width(3.dp)
        ) {
            drawLine(
                color = onSurfaceColor,
                start = Offset(0f, 0f),
                end = Offset(0f, if (isDivisibleBy10) size.height else size.height * 0.2f),
                strokeWidth = if (isDivisibleBy10) size.width else size.width * 0.3f
            )
        }
        Text(
            text = if (isDivisibleBy10) "${index / 10}" else "",
            textAlign = TextAlign.Center,
            style = TextStyle(fontFamily = FontFamily.Monospace),
            color = onSurfaceColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun ScaleCenterPointer() {
    // Primary color from the color palette specified by the applied Theme. In our case, its
    // what we specify in the CustomTheme composable.
    val primaryColor = MaterialTheme.colors.primary
    // Column is a composable that places its children in a vertical sequence. You
    // can think of it similar to a LinearLayout with the vertical orientation.
    Column {
        // We use the Canvas composable that gives you access to a canvas that you can draw
        // into. We also pass it a modifier.

        // You can think of Modifiers as implementations of the decorators pattern that are
        // used to modify the composable that its applied to. In this example, we give it a
        // padding of 5 dp, height of 120dp & width of 3dp.
        Canvas(
            modifier = Modifier.padding(5.dp).height(120.dp).width(3.dp)
        ) {
            // Allows you to draw a line between two points (p1 & p2) on the canvas.
            drawLine(
                color = primaryColor,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height),
                strokeWidth = size.width
            )
        }
    }
}

@Composable
fun CustomTheme(children: @Composable () -> Unit) {

    val lightColors = lightColors()

    var darkColors = darkColors()

    val color = if (isSystemInDarkTheme()) darkColors else lightColors

    MaterialTheme(colors = color) {
        children
    }

}

@Preview
@Composable
fun MeasuringScaleActivityPreView() {
    MeasuringScaleActivityContent()
}