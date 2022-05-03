package tv.yunxi.learncompose.livedata

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import tv.yunxi.learncompose.core.Person
import tv.yunxi.learncompose.core.getSuperheroList
import tv.yunxi.learncompose.image.NetworkImageComponentPicasso

/**
 * @author: created by wangkm
 * @time: 2022/05/02 21:23
 * @desc：
 * @email: 1240413544@qq.com
 */

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(SuperheroesViewModel::class.java)

        setContent {
            LiveDataActivityContent(viewModel.superheroes)
        }
    }
}

@Composable
fun LiveDataActivityContent(personListLiveData: LiveData<List<Person>>) {

    val personList by personListLiveData.observeAsState(initial = emptyList())

    if (personList.isEmpty()) {
        LiveDataLoadingComponent()
    } else {
        LiveDataComponentList(personList)
    }


}

@Composable
fun LiveDataLoadingComponent() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(CenterHorizontally))

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LiveDataComponentList(personList: List<Person>) {

    LazyColumn {
        items(items = personList, itemContent = { person ->
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(8.dp)
            ) {

                ListItem(text = {
                    Text(
                        text = person.name,
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }, secondaryText = {
                    Text(
                        text = "Age:  ${person.age}",
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp, fontWeight = FontWeight.Light,
                            color = Color.DarkGray
                        )
                    )
                }, icon = {
                    person.profilePictureUrl?.let { mImageUrl ->
                        NetworkImageComponentPicasso(
                            url = mImageUrl,
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                    }
                })


            }
        })
    }

}

@Preview(showBackground = true)
@Composable
fun LiveDataComponentListPreview() {
    LiveDataComponentList(getSuperheroList())
}

@Preview(showBackground = true)
@Composable
fun LiveDataLoadingComponentPreview() {
    LiveDataLoadingComponent()
}