package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tv.yunxi.learncompose.core.colors

/**
 * @author: created by wangkm
 * @time: 2022/04/30 20:13
 * @desc：
 * @email: 1240413544@qq.com
 */

class FixedActionButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldWithBottomBarAndCutout()
        }
    }
}

@Composable
fun ScaffoldWithBottomBarAndCutout() {
    val fabShape = RoundedCornerShape(50)

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Scaffold Examples") })

    },
        bottomBar = {
            BottomAppBar(cutoutShape = fabShape) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = fabShape,
                backgroundColor = MaterialTheme.colors.secondary
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
                }

            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .scrollable(scrollState, orientation = Orientation.Vertical)
            ) {

                repeat(100) {
                    Card(
                        backgroundColor = colors[it % colors.size],
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp))
                    }
                }

            }

        }
    )
}

@Preview("Fixed Aaction Button Example")
@Composable
fun FixedActionButtonActivityPreView() {
    ScaffoldWithBottomBarAndCutout()
}