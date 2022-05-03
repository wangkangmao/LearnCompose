package tv.yunxi.learncompose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.hideKeyboard
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/04/21 21:45
 * @desc：
 * @email: 1240413544@qq.com
 */

class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldActivityPreView()
        }
    }
}

@Composable
fun simpleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember {
            mutableStateOf(TextFieldValue("Enter your text here"))
        }
        BasicTextField(value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = { textValue = it })


    }
}

@Composable
fun customStyleTextInputComponent() {

    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {

        var textValue by remember { mutableStateOf(TextFieldValue("Enter your text here")) }

        BasicTextField(value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            ),
            onValueChange = { textValue = it }
        )

    }

}

@Composable
fun numberTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember {
            mutableStateOf(TextFieldValue("123"))
        }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = { textValue = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

    }
}

@Composable
fun searchImeActionInputComponent() {
    val context = LocalContext.current

    Surface(
        color = Color.LightGray, modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your search query here")) }

        BasicTextField(
            value = textValue, onValueChange = { textValue = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { hideKeyboard(context) })
        )
    }
}

@Composable
fun passwordVisualTransformationInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {

        var textValue by remember { mutableStateOf(TextFieldValue("Enter your password here")) }

        BasicTextField(
            value = textValue, onValueChange = { textValue = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Composable
fun materialTextInputComponent() {
    var textValue by remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(value = textValue, onValueChange = { textValue = it },
    label = {Text("Enter Your Name")},
    placeholder = {Text("wangkm")},
    modifier = Modifier.padding(16.dp).fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
fun TextFieldActivityPreView() {


    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        TitleComponent(title = "This is a Simple Text Input Field")
        simpleTextInputComponent()

        TitleComponent("This is a TextInput with custom text style")
        customStyleTextInputComponent()

        TitleComponent("This is a TextInput suitable for typing numbers")
        numberTextInputComponent()

        TitleComponent("This is a search view created using TextInput")
        searchImeActionInputComponent()

        TitleComponent("This is a TextInput that uses a Password Visual Transformation")
        passwordVisualTransformationInputComponent()

        TitleComponent("This is a filled TextInput field based on Material Design")
        materialTextInputComponent()

    }
}