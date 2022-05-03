package tv.yunxi.learncompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tv.yunxi.learncompose.core.Amenity
import tv.yunxi.learncompose.core.getAmenityList
import tv.yunxi.learncompose.image.TitleComponent

/**
 * @author: created by wangkm
 * @time: 2022/05/03 10:23
 * @desc：
 * @email: 1240413544@qq.com
 */

class FlowRowActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlowRowActivityContent()
        }
    }
}


@Composable
fun FlowRowActivityContent() {
    Column {
        TitleComponent(title = "Tap to select options")
        SimpleFlowRow(getAmenityList())
    }
}


@Composable
fun SimpleFlowRow(amenityList: List<Amenity>) {

    Column(modifier = Modifier
        .padding(4.dp)
        .fillMaxSize()) {

//        FlowRow(
//            mainAxisAlignment = MainAxisAlignment.Center,
//            crossAxisSpacing = 16.dp,
//            mainAxisSpacing = 16.dp,
//            mainAxisSize = SizeMode.Expand
//        ) {
//            amenityList.forEachIndexed { index, amenity ->
//                // Box with clickable modifier wraps the child composable and enables it to react to
//                // a click through the onClick callback similar to the onClick listener that we are
//                // accustomed to on Android.
//                // Here, we just add the current index to the selectedIndices set every
//                // time a user taps on it.
//                Box(Modifier.clickable(onClick = { selectedIndices.add(index) }), children = {
//                    // Text is a predefined composable that does exactly what you'd expect it to -
//                    // display text on the screen. It allows you to customize its appearance using
//                    // style, fontWeight, fontSize, etc.
//                    Text(
//                        text = if (selectedIndices.contains(index)) "✓ ${amenity.name}" else amenity.name,
//                        overflow = TextOverflow.Ellipsis,
//                        modifier = Modifier.drawBackground(
//                            color = colors[index % colors.size], shape = RoundedCornerShape(15.dp)
//                        ) +
//                                Modifier.padding(8.dp)
//                    )
//                })
//            }
//        }


    }

}

@Preview
@Composable
fun FlowRowActivityPreView() {
    FlowRowActivityContent()

}