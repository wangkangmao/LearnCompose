package tv.yunxi.learncompose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.yunxi.learncompose.core.Person
import tv.yunxi.learncompose.core.colors
import tv.yunxi.learncompose.core.getPersonList

/**
 * @author: created by wangkm
 * @time: 2022/03/08 14:07
 * @desc：
 * @email: 1240413544@qq.com
 */

class VerticalScrollableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumnItemsScrollableComponent(getPersonList())
        }
    }
}

@Composable
fun LazyColumnItemsScrollableComponent(personList: List<Person>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = personList, itemContent = { person ->
            val index = personList.indexOf(person)

            Row(modifier = Modifier.fillParentMaxWidth()) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = colors[index % colors.size],
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        person.name, style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        })
    }
}

@Composable
fun VerticalScrollableComponent(personList: List<Person>) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.scrollable(
            state = scrollState,
            orientation = Orientation.Vertical
        )
    ) {
        for ((index, person) in personList.withIndex()) {
            Row(modifier = Modifier.fillMaxWidth().padding(16.dp)){
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = colors[index % colors.size],
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        person.name, style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnItemsScrollableComponentPreview() {
    LazyColumnItemsScrollableComponent(
        getPersonList()
    )
}


@Preview
@Composable
fun VerticalScrollableComponentPreview() {
    VerticalScrollableComponent(
        getPersonList()
    )
}