package tv.yunxi.learncompose.state.coroutine

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author: created by wangkm
 * @time: 2022/05/03 10:35
 * @desc：
 * @email: 1240413544@qq.com
 */

class CoroutineFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CoroutineFlowActivityContent(countdownFlow())
        }
    }
}

@Composable
fun countdownFlow() = flow<Int> {
    for (i in 9 downTo 0) {
        delay(1000L)
        emit(i)
    }

}


@Composable
fun CoroutineFlowActivityContent(flow: Flow<Int>) {
    val countDownValue by flow.collectAsState(initial = 10)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (countDownValue) {
            in 1..10 -> {
                CountdownText(text = "Countdown:  $countDownValue")
            }
            else -> {
                CountdownText(text = "HAPPY NEW YEAR!!!", Color.Magenta)
            }
        }


    }
}

@Composable
fun CountdownText(text: String, color: Color = Color.Black) {

    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
    )

}

@Preview(showBackground = true)
@Composable
fun CoroutineFlowActivityPreView() {
    CoroutineFlowActivityContent(countdownFlow())
}

