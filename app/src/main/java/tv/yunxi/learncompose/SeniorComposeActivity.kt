package tv.yunxi.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author: created by wangkm
 * @time: 2022/05/03 21:51
 * @desc：
 * @email: 1240413544@qq.com
 */

class SeniorComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SeniorComposeActivityContent()
        }
    }

    @Composable
    fun SeniorComposeActivityContent() {
    }

    @Preview(showBackground = true)
    @Composable
    fun SeniorComposeActivityPreView() {
        SeniorComposeActivityContent()
    }
}