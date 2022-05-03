package tv.yunxi.learncompose.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author: created by wangkm
 * @time: 2022/05/02 10:23
 * @desc：
 * @email: 1240413544@qq.com
 */

class Animation2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Animation2ActivityContent()
        }
    }
}

@Composable
fun Animation2ActivityContent() {

    val currentColor by remember { mutableStateOf(Color.Red) }
    val transition = updateTransition(currentColor, label = "")


    val color by transition.animateColor(
        transitionSpec = { TweenSpec<Color>(durationMillis = 2000) }, label = ""
    ) { state ->
        when (state) {
            Color.Red -> Color.Green
            Color.Green -> Color.Blue
            Color.Blue -> Color.Red
            else -> Color.Red
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color)
    ) {
    }


}

@Preview(showBackground = true)
@Composable
fun Animation2ActivityPreView() {
    Animation2ActivityContent()
}

