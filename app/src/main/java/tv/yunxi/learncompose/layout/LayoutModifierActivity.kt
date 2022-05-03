package tv.yunxi.learncompose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.colors

/**
 * @author: created by wangkm
 * @time: 2022/05/02 20:59
 * @desc：
 * @email: 1240413544@qq.com
 */

class LayoutModifierActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LayoutModifierActivityContent()
        }
    }
}

@Composable
fun LayoutModifierActivityContent() {
    LazyColumn{
        item { SamePaddingComponent() }
        item { CustomPaddingComponent() }
        item { OffsetComponent() }
        item { AspectRatioComponent() }
    }
}

@Composable
fun SamePaddingComponent() {

    Surface(color = colors[0]) {

        Text(
            text = "This text has equal padding of 16dp in all directions",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }

}

@Composable
fun CustomPaddingComponent() {
    Surface(color = colors[1]) {
        Text(
            text = "This text has 32dp start padding, 4dp end padding, 32dp top padding & 0dp " +
                    "bottom padding padding in each direction",
            modifier = Modifier.padding(start = 32.dp, end = 4.dp, top = 32.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }

}

@Composable
fun OffsetComponent() {
    Surface(color = colors[2], modifier = Modifier.offset(x = 8.dp, y = 8.dp)) {
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
                    " modifying the size of the layout. Using offset instead ensures that the " +
                    "size of the layout retains its size.",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun AspectRatioComponent() {
    Surface(
        color = colors[3], modifier = Modifier
            .aspectRatio(16 / 9f)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            modifier = Modifier.padding(16.dp)
        )
    }
}





@Preview(showBackground = true)
@Composable
fun LayoutModifierActivityPreView() {
    LayoutModifierActivityContent()
}