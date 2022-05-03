package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author: created by wangkm
 * @time: 2022/04/20 23:11
 * @desc：
 * @email: 1240413544@qq.com
 */

class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            preView()
        }
    }

}

@Composable
fun SimpleButtonComponent() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp)
    ) {
        Text(text = "Simple button", modifier = Modifier.padding(16.dp))

    }
}

@Composable
fun SimpleButtonWithBorderComponent() {
    Button(onClick = { /*TODO*/ },
    modifier = Modifier.padding(16.dp),
    elevation = ButtonDefaults.elevation(5.dp),
    border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Black))
    ) {
        Text(text = "Simple button with border", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RoundedCornerButtonComponent() {
    Button(onClick = { /*TODO*/ },
    modifier = Modifier.padding(16.dp),
    shape = RoundedCornerShape(16.dp),
    elevation = ButtonDefaults.elevation(5.dp)) {
        Text(text = "Button with rounded cornets", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(onClick = { /*TODO*/ },
    modifier = Modifier.padding(16.dp)) {
        Text(text = "Outlined Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TextButtonComponent() {
    TextButton(onClick = { /*TODO*/ },
    Modifier.padding(16.dp)) {
        Text(text = "Text Button",Modifier.padding(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun preView() {
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleButtonComponent()
        SimpleButtonWithBorderComponent()
        RoundedCornerButtonComponent()
        OutlinedButtonComponent()
        TextButtonComponent()
    }
}