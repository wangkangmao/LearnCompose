package tv.yunxi.learncompose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import tv.yunxi.learncompose.image.TitleComponent
import tv.yunxi.learncompose.R

/**
 * @author: created by wangkm
 * @time: 2022/04/30 20:39
 * @desc：
 * @email: 1240413544@qq.com
 */

class ConstraintLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            constraintLayoutActivityContent()
        }
    }
}

@Composable
fun constraintLayoutActivityContent() {

    LazyColumn {
        item {
            TitleComponent("Simple constraint layout example")
            simpleConstraintLayoutComponent()
        }

        item {
            TitleComponent("Constraint layout example with guidelines")
            guidelineConstraintLayoutComponent()
        }

        item {
            TitleComponent("Constraint layout example with barriers")
            barrierConstraintLayoutComponent()
        }

        item {
            TitleComponent("Constraint layout example with bias")
            biasConstraintLayoutComponent()
        }
    }

}

@Composable
fun simpleConstraintLayoutComponent() {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout {
            val (title, subtitle, image) = createRefs()

            Text(
                text = "Title",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp
                ),
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(image.end, margin = 16.dp)
                    top.linkTo(image.top)
                }
            )

            Text(
                "Subtitle", style = TextStyle(
                    fontFamily = FontFamily.Serif, fontWeight =
                    FontWeight.W900, fontSize = 14.sp
                ), modifier = Modifier.constrainAs(subtitle) {
                    bottom.linkTo(image.bottom)
                    start.linkTo(image.end, margin = 16.dp)
                }
            )
            Column(
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .constrainAs(image) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 16.dp)
                    }
            ) {
                Image(painterResource(R.drawable.landscape), contentDescription = null)
            }

        }

    }
}

@Composable
fun guidelineConstraintLayoutComponent() {

    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout {
            val (text1, text2) = createRefs()

            val quarter = createGuidelineFromStart(0.25f)
            val half = createGuidelineFromStart(0.5f)

            Text(
                text = "Quarter", style = TextStyle(fontFamily = FontFamily.Serif),
                fontWeight = FontWeight.W900, fontSize = 14.sp,
                modifier = Modifier.constrainAs(text1) {
                    centerVerticallyTo(parent)
                    end.linkTo(quarter)
                }
            )


            Text(text = "Half", style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W900, fontSize = 14.sp
            ),
                modifier = Modifier.constrainAs(text2) {
                    centerVerticallyTo(parent)
                    start.linkTo(half)
                })

        }

    }
}

@Composable
fun barrierConstraintLayoutComponent() {

    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        ConstraintLayout {

            val (text1, text2, text3) = createRefs()

            val barrier = createEndBarrier(text1, text2, margin = 16.dp)

            Text(
                text = "Short text", style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900, fontSize = 14.sp
                ),
                modifier = Modifier.constrainAs(text1) {
                    start.linkTo(parent.start, margin = 16.dp)
                    centerVerticallyTo(parent)
                }
            )

            Text(
                "This is a long text", style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900, fontSize = 14.sp
                ), modifier = Modifier.constrainAs(text2) {
                    start.linkTo(parent.start, margin = 16.dp)

                    // Constraint the top edge of the text2 to the bottom edge of text1
                    top.linkTo(text1.bottom, margin = 16.dp)

                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
            )
            Text(
                "Barrier Text", style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900, fontSize = 14.sp
                ), modifier = Modifier.constrainAs(text3) {
                    // Constraint the left edge of the text3 to the barrier we created above
                    start.linkTo(barrier)
                    // We want to vertically center the text3
                    centerVerticallyTo(parent)
                }
            )

        }

    }

}

@Composable
fun biasConstraintLayoutComponent() {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        ConstraintLayout {
            val (text1, text2) = createRefs()

            Text(
                "Left", style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900, fontSize = 14.sp
                ), modifier = Modifier.constrainAs(text1) {
                    centerVerticallyTo(parent)
                    linkTo(parent.start, parent.end, bias = 0.1f)
                }
            )
            Text(
                "Right", style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W900, fontSize = 14.sp
                ), modifier = Modifier.constrainAs(text2) {
                    centerHorizontallyTo(parent)
                    centerVerticallyTo(parent)
                    linkTo(parent.start, parent.end, bias = 0.9f)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutActivityPreView() {
    constraintLayoutActivityContent()
}