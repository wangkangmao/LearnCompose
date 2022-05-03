package tv.yunxi.learncompose.customview

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author: created by wangkm
 * @time: 2022/04/21 09:02
 * @desc：
 * @email: 1240413544@qq.com
 */

class CustomViewPaintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            customViewPaintPreView()
        }
    }
}


@Composable
fun customDrawableViewComponent() {
    drawingBoardComposable()

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun drawingBoardComposable() {
    val paths = remember {
        mutableStateListOf<Paths>()
    }

    Column(
        Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        paths += Paths(it.x, it.y)
                        true
                    }
                    else -> false
                }
            }) {


        Canvas(modifier = Modifier) {
            val p = Path()
            for (path in paths) {
                p.lineTo(path.x, path.y)
                p.moveTo(path.x, path.y)
            }
            drawPath(p, color = Color.Black, style = Stroke(3f, join = StrokeJoin.Round))
        }


    }
}

data class Paths(val x: Float, val y: Float)

@Preview(showBackground = true)
@Composable
fun customViewPaintPreView() {
    customDrawableViewComponent()
}