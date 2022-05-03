package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/05/01 10:36
 * @desc：
 * @email: 1240413544@qq.com
 */

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            bottomNavigationContent()
        }
    }
}

@Composable
fun bottomNavigationContent() {

    Column() {
        TitleComponent("This is a simple bottom navigation bar that always shows label")
        Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
            bottomNavigationAlwaysShowLabelComponent()
        }
        TitleComponent(
            "This is a bottom navigation bar that only shows label for " +
                    "selected item"
        )
        Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
            bottomNavigationOnlySelectedLabelComponent()
        }

    }
}

val listItems = listOf("Games", "Apps", "Movies", "Books")

@Composable
fun bottomNavigationAlwaysShowLabelComponent() {

    var selectedIndex by remember { mutableStateOf(0) }

    BottomNavigation(modifier = Modifier.padding(16.dp)) {
        listItems.forEachIndexed { index, s ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                },
                label = { Text(text = s) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index })
        }

    }

}

@Composable
fun bottomNavigationOnlySelectedLabelComponent() {

    var selectedIndex by remember { mutableStateOf(0) }
    BottomNavigation(modifier = Modifier.padding(16.dp)) {
        listItems.forEachIndexed { index, label ->
            BottomNavigationItem(
                icon = {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
                },
                label = {
                    Text(text = label)
                },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                alwaysShowLabel = false
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BottomNavigationActivityPreView() {
    bottomNavigationContent()
}