package tv.yunxi.learncompose.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
 * @time: 2022/05/02 10:48
 * @desc：
 * @email: 1240413544@qq.com
 */

class ListAnimationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { ListAnimationActivityContent(getPersonList()) }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListAnimationActivityContent(personList: List<Person>) {

    val deletedPersonList = remember { mutableStateListOf<Person>() }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(
            items = personList,
            itemContent = { index, person ->
                AnimatedVisibility(
                    visible = !deletedPersonList.contains(person),
                    enter = expandVertically(),
                    exit = shrinkVertically(
                        animationSpec = tween(durationMillis = 1000)
                    )
                ) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = colors[index % colors.size],
                        modifier = Modifier.fillParentMaxWidth()
                    ) {

                        Row(
                            modifier = Modifier.fillParentMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = person.name, style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                ), modifier = Modifier.padding(16.dp)
                            )

                            IconButton(onClick = { deletedPersonList.add(person) }) {

                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "Delete"
                                )
                            }
                        }


                    }
                }

            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ListAnimationActivityPreView() {
    ListAnimationActivityContent(getPersonList())
}