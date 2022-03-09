package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author: created by wangkm
 * @time: 2022/03/09 21:59
 * @desc：
 * @email: 1240413544@qq.com
 */

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                ClickableText()
            }
        }
    }
}

@Composable
fun ClickableText() {
    var showPopup by remember { mutableStateOf(false) }

    Column(Modifier.clickable(onClick = { showPopup = true }), content = {
        Card(
            shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp),
            backgroundColor = Color.LightGray
        ) {
            Text(
                text = "Click to see dialog", modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif)
            )
        }
    })

    val onPopupDismissed = { showPopup = false }

    if (showPopup) {
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = { Text("Congratulations! You just clicked the text successfully") },
            confirmButton = {
                Button(onClick = onPopupDismissed) {
                    Text(text = "Ok")
                }
            })

    }
}

@Preview
@Composable
fun ClickableTextPreview() {
    Column {
        ClickableText()
    }
}