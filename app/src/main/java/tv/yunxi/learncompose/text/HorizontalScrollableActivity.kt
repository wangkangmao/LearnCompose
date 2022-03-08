package tv.yunxi.learncompose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.Person
import tv.yunxi.learncompose.core.colors
import tv.yunxi.learncompose.core.getPersonList

/**
 * @author: created by wangkm
 * @time: 2022/03/08 14:46
 * @desc：
 * @email: 1240413544@qq.com
 */

class HorizontalScrollableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                HorizontalScrollableComponent(getPersonList())
                HorizontalScrollableComponentWithScreenWidth(getPersonList())
            }
        }
    }
}

@Composable
fun HorizontalScrollableComponent(personList: List<Person>) {
    val scrollState = rememberScrollState()

    Row(modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(state = scrollState), content = {
        for ((index, person) in personList.withIndex()) {
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = colors[index % colors.size],
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    person.name,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(color = Color.Black, fontSize = 20.sp)
                )
            }
        }
    })
}

@Composable
fun HorizontalScrollableComponentWithScreenWidth(personList: List<Person>) {
    val scrollState = rememberScrollState()

    Row(modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(state = scrollState),
        content = {
            val context = LocalContext.current
            val resource = context.resources
            val displayMetrics = resource.displayMetrics
            val screenWidth = displayMetrics.widthPixels / displayMetrics.density
            val spacing = 16.dp


            Row {
                for ((index, person) in personList.withIndex()) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = colors[index % colors.size],
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.width(screenWidth.dp - (spacing * 2)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = person.name,
                                modifier = Modifier.padding(16.dp),
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp
                                )
                            )
                        }
                    }
                }
            }

        })

}


@Preview("Horizontal Scrollable Carousel")
@Composable
fun HorizontalScrollableComponentPreview() {
    HorizontalScrollableComponent(
        getPersonList()
    )
}

@Preview("Horizontal Scrolling Carousel where each item occupies the width of the screen")
@Composable
fun HorizontalScrollableComponentWithScreenWidthPreview() {
    HorizontalScrollableComponentWithScreenWidth(
        getPersonList()
    )
}