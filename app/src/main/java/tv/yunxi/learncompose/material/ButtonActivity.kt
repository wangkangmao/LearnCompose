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
            ButtonActivityContent()
        }
    }

}

@Composable
fun ButtonActivityContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleButtonComponent()
        SimpleButtonWithBorderComponent()
        RoundedCornerButtonComponent()
        OutlinedButtonComponent()
        TextButtonComponent()
    }
}


@Composable
fun SimpleButtonComponent() {
    Button(
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
        onClick = {}) {
        Text(text = "Simple button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SimpleButtonWithBorderComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
        // Provide a border for this button
        border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Black))
    ) {
        Text(text = "Simple button with border", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RoundedCornerButtonComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
    ) {
        Text(text = "Button with rounded corners", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Outlined Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TextButtonComponent() {
    TextButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Text Button", modifier = Modifier.padding(16.dp))
    }
}

@Preview("Example showing a simple button")
@Composable
fun SimpleButtonComponentPreview() {
    Column {
        SimpleButtonComponent()
    }
}

@Preview("Example showing a button with border")
@Composable
fun SimpleButtonWithBorderComponentPreview() {
    Column {
        SimpleButtonWithBorderComponent()
    }
}

@Preview("Example showing a button with corners")
@Composable
fun RoundedCornerButtonComponentPreview() {
    Column {
        RoundedCornerButtonComponent()
    }
}

@Preview("Example showing a outline button")
@Composable
fun OutlinedButtonComponentPreview() {
    Column {
        OutlinedButtonComponent()
    }
}

@Preview("Example showing a text button")
@Composable
fun TextButtonComponentPreview() {
    Column {
        TextButtonComponent()
    }
}