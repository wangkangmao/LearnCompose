package tv.yunxi.learncompose.interop

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.colors
import tv.yunxi.learncompose.databinding.ActivityComposeInClassicAndroidBinding
import tv.yunxi.learncompose.databinding.ActivityMainBinding

/**
 * @author: created by wangkm
 * @time: 2022/05/03 10:36
 * @desc：
 * @email: 1240413544@qq.com
 */

class ComposeInClassicAndroidActivity : AppCompatActivity() {

    private var mBinding: ActivityComposeInClassicAndroidBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityComposeInClassicAndroidBinding.inflate(layoutInflater)
        val mView: View = mBinding!!.root
        setContentView(mView)

        mBinding?.composeView?.setContent {
            ComposeInClassicAndroidActivityContent()
        }
    }
}

@Composable
fun ComposeInClassicAndroidActivityContent() {
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Card(modifier = Modifier.fillMaxWidth()
            .height(200.dp)
            .padding(16.dp),
        backgroundColor = colors[1]) {
            Text(
                "This is an example of a Jetpack Compose composable inside a classic Android " +
                        "view",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeInClassicAndroidActivityPreView() {
    ComposeInClassicAndroidActivityContent()
}