package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.R
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/04/30 18:34
 * @desc：
 * @email: 1240413544@qq.com
 */

class MaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { content() }
    }

}


@Composable
fun content() {
    LazyColumn {
        item {
            TitleComponent("This is a simple Material card")
            materialCardComponent()
        }

        item {
            TitleComponent("This is a loading progress indicator ")
            materialLinearProgressIndicatorComponent()
        }

        item {
            TitleComponent("This is a determinate progress indicator")
            materialDeterminateLinearProgressIndicatorComponent()
        }

        item {
            TitleComponent("This is a loading circular progress indicator")
            materialCircularProgressIndicatorComponent()
        }

        item {
            TitleComponent("This is a determinate circular progress indicator")
            materialDeterminateCircularProgressIndicatorComponent()
        }

        item {
            TitleComponent("This is a material Snackbar")
            materialSnackbarComponent()
        }

        item {
            TitleComponent("This is a non-discrete slider")
            materialContinousSliderComponent()
        }

        item {
            TitleComponent("This is a discrete slider")
            materialDiscreteSliderComponent()
        }

        item {
            TitleComponent("This is a checkbox that represents two states")
            materialCheckboxComponent()
        }

        item {
            TitleComponent("This is a checkbox that represents three states")
            materialTriStateCheckboxComponent()
        }

        item {
            TitleComponent("This is a radio button group")
            materialRadioButtonGroupComponent()
        }

        item {
            TitleComponent("This is a switch component")
            materialSwitchComponent()
        }

        item {
            TitleComponent("This is how you add a ripple effect to a view")
            materialRippleComponent()
        }

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun materialCardComponent() {

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {


        ListItem(text = { Text(text = "Title") },
            secondaryText = { Text(text = "Subtitle") },
            icon = {
                Column(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.landscape),
                        contentDescription = "Landscape"
                    )
                }
            })

    }

}

@Composable
fun materialLinearProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {


        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator()
        }
    }
}

@Composable
fun materialDeterminateLinearProgressIndicatorComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator(progress = 0.3f)
        }
    }
}

@Composable
fun materialCircularProgressIndicatorComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Composable
fun materialDeterminateCircularProgressIndicatorComponent() {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CircularProgressIndicator(
            progress = 0.5f,
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun materialSnackbarComponent() {
    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Snackbar(content = {
            Text(text = "I'm a very nice Snackbar")
        }, action = {
            Text(text = "OK", style = TextStyle(color = MaterialTheme.colors.secondary))
        })
    }
}

@Composable
fun materialContinousSliderComponent() {
    var sliderValue by remember { mutableStateOf(0f) }

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Slider(value = sliderValue, onValueChange = { newValue ->
            sliderValue = newValue
        })

    }

}

@Composable
fun materialDiscreteSliderComponent() {
    var sliderValue by remember { mutableStateOf(0f) }

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {

        Slider(
            value = sliderValue,
            valueRange = 0f..10f,
            steps = 4,
            onValueChange = { sliderValue = it })
    }

    Text(text = "Slider value is %.1f".format(sliderValue), Modifier.padding(8.dp))

}

@Composable
fun materialCheckboxComponent() {
    var checked by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(4.dp), modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Checkbox(checked = checked, onCheckedChange = { checked = !checked })

            Text(text = "Use Jetpack Compose", Modifier.padding(start = 8.dp))

        }
    }
}

@Composable
fun materialTriStateCheckboxComponent() {

    val toggleableStateArray =
        listOf(ToggleableState.Off, ToggleableState.On, ToggleableState.Indeterminate)

    var counter by remember { mutableStateOf(0) }

    Card(
        shape = RoundedCornerShape(4.dp), modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.padding(16.dp)) {

            TriStateCheckbox(state = toggleableStateArray[counter % 3], onClick = {
                counter++
            })

            Text(text = "Use Jetpack Compose", modifier = Modifier.padding(start = 8.dp))

        }

    }


}

@Composable
fun materialRadioButtonGroupComponent() {

    var selected by remember { mutableStateOf("Andoid") }
    val radioGroupOptions = listOf("Android", "ios", "windows")

    Card(
        shape = RoundedCornerShape(4.dp), modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        val onSelectedChange = { text: String ->
            selected = text
        }

        Column {

            radioGroupOptions.forEach { text ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .selectable(selected = (text == selected),
                        onClick = { onSelectedChange(text) }
                    )) {

                    RadioButton(selected = (text == selected), onClick = { onSelectedChange(text) })

                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun materialSwitchComponent() {
    var checked by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = Color(249, 249, 249)
    ) {
        Row(modifier = Modifier.padding(16.dp)){
            Switch(checked = checked,onCheckedChange = {
                checked = !checked
            })

            Text(text = "Enable Dark Mode", modifier = Modifier.padding(start = 8.dp))
        }

    }
}

@Composable
fun materialRippleComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = {})
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Text(
                text = "Click Me",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 12.sp, fontFamily = FontFamily.Serif)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MaterialActivityPreView() {
    content()
}


