package tv.yunxi.learncompose.state

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.colors
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/05/02 21:02
 * @desc：
 * @email: 1240413544@qq.com
 */

class ProcessDeathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProcessDeathActivityContent()
        }
    }
}


@Composable
fun ProcessDeathActivityContent() {
    TitleComponent("Enter your credit card number below")
    ProcessDeathComponent()
}

@Composable
fun ProcessDeathComponent() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(300.dp)
                .aspectRatio(16 / 9f),
            backgroundColor = colors[0]
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                var textValue by rememberSaveable { mutableStateOf("1234567812345678") }

                TextField(
                    value = TextFieldValue(textValue),
                    modifier = Modifier.padding(16.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontSize = 25.sp, fontWeight = FontWeight.Bold
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = CreditCardVisualTransformation(),
                    onValueChange = { newTextValue ->
                        textValue = newTextValue.text
                    }
                )

                Text(
                    text = "John Doe",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

    }


}

val creditCardOffsetMap = object : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int = offset + (offset / 4)
    override fun transformedToOriginal(offset: Int): Int = offset - (offset / 4)

}

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString(text.text.replace("....".toRegex(), "$0")),
            creditCardOffsetMap
        )
    }

}


@Preview
@Composable
fun ProcessDeathActivityPreView() {
    ProcessDeathActivityContent()
}