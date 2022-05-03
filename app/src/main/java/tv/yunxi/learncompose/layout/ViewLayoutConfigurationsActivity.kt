package tv.yunxi.learncompose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/04/21 23:09
 * @desc：
 * @email: 1240413544@qq.com
 */

class ViewLayoutConfigurationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            content()
        }
    }
}

@Composable
fun content() {
    LazyColumn {
        item {
            TitleComponent("Child views with equal weights")
            rowEqualWeightComponent()
        }

        item {
            TitleComponent("Child views with unequal weights")
            rowUnequalWeightComponent()
        }

        item {
            TitleComponent("Child view with auto space in between")
            rowAddSpaceBetweenViewsComponent()
        }

        item {
            TitleComponent("Child views spaced evenly")
            rowSpaceViewsEvenlyComponent()
        }

        item {
            TitleComponent("Space added around child views")
            rowSpaceAroundViewsComponent()
        }

        item {
            TitleComponent("Child views centered")
            rowViewsCenteredComponent()
        }

        item {
            TitleComponent("Child views arranged in end")
            rowViewsArrangedInEndComponent()
        }

        item {
            TitleComponent("Baseline of child views aligned")
            rowBaselineAlignComponent()
        }

        item {
            TitleComponent("Baseline of child views not aligned")
            rowBaselineUnalignedComponent()
        }
    }
}

@Composable
fun rowEqualWeightComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier
            .weight(1f)
            .padding(4.dp), onClick = {}) {

            Text(text = "Button 1", style = TextStyle(fontSize = 20.sp))
        }

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Text(text = "Button 2", style = TextStyle(fontSize = 20.sp))

        }

    }
}

@Composable
fun rowUnequalWeightComponent() {
    Row(Modifier.fillMaxWidth()) {
        Button(modifier = Modifier
            .weight(0.66f)
            .padding(4.dp), onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

    }
}

@Composable
fun rowAddSpaceBetweenViewsComponent() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(4.dp), Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun rowSpaceViewsEvenlyComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun rowSpaceAroundViewsComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun rowViewsCenteredComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun rowViewsArrangedInEndComponent() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun rowBaselineAlignComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Text 1",
            style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic),
            modifier = Modifier.alignBy(alignmentLine = FirstBaseline)
        )
        Text(
            text = "Text 2",
            style = TextStyle(
                fontSize = 40.sp, fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.alignBy(alignmentLine = FirstBaseline)
        )
    }
}

@Composable
fun rowBaselineUnalignedComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = "Text 1",
            style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
        )
        Text(
            text = "Text 2",
            style = TextStyle(
                fontSize = 40.sp, fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview
@Composable
fun ViewLayoutConfigurationsPreView() {
    content()
}