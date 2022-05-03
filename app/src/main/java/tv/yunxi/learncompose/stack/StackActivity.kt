package tv.yunxi.learncompose.stack

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.R
import tv.yunxi.learncompose.image.LocalResourceImageComponent

/**
 * @author: created by wangkm
 * @time: 2022/04/21 22:53
 * @desc：
 * @email: 1240413544@qq.com
 */

class StackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            stackComponent()
        }
    }
}

@Composable
fun stackComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LocalResourceImageComponent(resId = R.drawable.landscape)

        Surface(color = Color.Gray) {
            Text(
                text = "Title",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp
                ), modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

    }
}

@Preview
@Composable
fun StackActivityPreView() {
    stackComponent()
}