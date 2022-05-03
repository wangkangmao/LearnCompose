package tv.yunxi.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text

/**
 * @author: created by wangkm
 * @time: 2022/05/03 21:51
 * @desc：
 * @email: 1240413544@qq.com
 */

class SeniorComposeActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text(text = "SeniorComposeActivity")
        }
    }
}