package tv.yunxi.learncompose.state

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/04/21 08:45
 * @desc：
 * @email: 1240413544@qq.com
 */

class StateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            preView()

        }
    }
}

@Composable
fun StateComponent() {
    var counter by remember { mutableStateOf(0) }
    TitleComponent(title = "Example using state class to store state")
    Row(Modifier.fillMaxWidth()) {

        Button(
            onClick = { counter++ },
            Modifier
                .padding(16.dp)
                .weight(1f),
            elevation = ButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Increment", Modifier.padding(16.dp))
        }


        Button(
            onClick = { counter = 0 },
            Modifier
                .padding(16.dp)
                .weight(1f),
            elevation = ButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Rest", Modifier.padding(16.dp))
        }
    }

    Text(text = "Counter value is $counter", Modifier.padding(16.dp))

}

@Composable
fun ModelComponent() {
    var counterState by remember {
        mutableStateOf(CounterState())
    }

    TitleComponent("Example using Model class to store state")

    Row(Modifier.fillMaxWidth()) {
        Button(
            onClick = { counterState = counterState.copy(counter = counterState.counter + 1) },
            Modifier.padding(16.dp),
            elevation = ButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Increment",Modifier.padding(16.dp))
        }

        Button(
            onClick = { counterState = counterState.copy(counter = 0) },
            Modifier.padding(16.dp),
            elevation = ButtonDefaults.elevation(5.dp)
        ) {
            Text(text = "Reset",Modifier.padding(16.dp))
        }
    }

    Text(text = "Counter value is ${counterState.counter}",Modifier.padding(16.dp))
}

data class CounterState(val counter: Int = 0)

@Preview
@Composable
fun preView() {
    Column(Modifier.fillMaxWidth()) {
        StateComponent()
        Divider()
        ModelComponent()
    }
}