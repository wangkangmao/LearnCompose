package tv.yunxi.learncompose.customview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author: created by wangkm
 * @time: 2022/04/21 08:58
 * @desc：
 * @email: 1240413544@qq.com
 */

class CustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            preView()
        }
    }
}

@Composable
fun customViewComponent() {

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(Color.Red,300f)
        drawCircle(Color.Green,200f)
        drawCircle(Color.Blue,100f)
    }


}

@Preview(showBackground = true)
@Composable
fun preView() {
    customViewComponent()
}