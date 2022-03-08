package tv.yunxi.learncompose.image

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import tv.yunxi.learncompose.R

/**
 * @author: created by wangkm
 * @time: 2022/03/08 15:44
 * @desc：
 * @email: 1240413544@qq.com
 */
val mImageUrl = "https://img-home.csdnimg.cn/images/20220308093733.png"
class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                displayImageComponent()
            }
        }
    }
}

fun LazyListScope.displayImageComponent() {
    item {
        TitleComponent(title = "Load image from the resource folder")
        LocalResourceImageComponent(R.drawable.landscape)
    }

    item {
        TitleComponent("Load image from url using Picasso")
        NetworkImageComponentPicasso(
            url = mImageUrl
        )
    }

    item {
        TitleComponent("Load image from url using Glide")
        NetworkImageComponentGlide(
            url = mImageUrl
        )
    }

    item {
        TitleComponent("Image with rounded corners")
        ImageWithRoundedCorners(R.drawable.landscape)
    }
}

@Composable
fun TitleComponent(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
            fontSize = 14.sp,
            color = Color.Black
        ), modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}


@Composable
fun LocalResourceImageComponent(@DrawableRes resId: Int) {
    val image = painterResource(id = resId)

    Image(
        painter = image, contentDescription = null,
        modifier = Modifier
            .sizeIn(maxHeight = 200.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ImageWithRoundedCorners(@DrawableRes resId: Int) {
    val image = painterResource(id = resId)

    Column(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
        Image(painter = image, contentDescription = null, modifier = Modifier.height(200.dp))
    }
}

@Composable
fun NetworkImageComponentPicasso(url: String, modifier: Modifier = Modifier) {

    val sizeModifier = modifier
        .fillMaxWidth()
        .sizeIn(maxHeight = 200.dp)

    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    var drawable by remember { mutableStateOf<Drawable?>(null) }


    DisposableEffect(url) {
        val picasso = Picasso.get()
        val target = object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                // TODO(lmr): we could use the drawable below
                drawable = placeHolderDrawable
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                drawable = errorDrawable
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                image = bitmap?.asImageBitmap()
            }
        }
        picasso
            .load(url)
            .into(target)
        onDispose {
            image = null
            drawable = null
            picasso.cancelRequest(target)
        }
    }

    val theImage = image
    val theDrawable = drawable
    if (theImage != null) {
        Column(
            modifier = sizeModifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(bitmap = theImage, contentDescription = null)
        }
    } else {
        Canvas(modifier = sizeModifier) {
            drawIntoCanvas { canvas ->
                theDrawable?.draw(canvas.nativeCanvas)
            }
        }
    }


}

@Composable
fun NetworkImageComponentGlide(
    url: String, modifier: Modifier = Modifier
) {
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    var drawable by remember { mutableStateOf<Drawable?>(null) }
    val sizeModifier = modifier
        .fillMaxWidth()
        .sizeIn(maxHeight = 200.dp)

    val context = LocalContext.current
    DisposableEffect(url) {
        val glide = Glide.with(context)
        val target = object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) {
                image = null
                drawable = placeholder
            }

            override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
                image = bitmap.asImageBitmap()
            }
        }
        glide
            .asBitmap()
            .load(url)
            .into(target)

        onDispose {
            image = null
            drawable = null
            glide.clear(target)
        }
    }

    val theImage = image
    val theDrawable = drawable
    if (theImage != null) {
        Column(
            modifier = sizeModifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(bitmap = theImage, contentDescription = null)
        }
    } else if (theDrawable != null) {
        Canvas(modifier = sizeModifier) {
            drawIntoCanvas { canvas ->
                theDrawable.draw(canvas.nativeCanvas)
            }
        }
    }
}

@Preview("Load image stored in local resources folder")
@Composable
fun LocalResourceImageComponentPreview() {
    Column {
        LocalResourceImageComponent(R.drawable.landscape)
    }
}

@Preview("Load an image over the network using the Picasso library")
@Composable
fun NetworkImageComponentPicassoPreview() {
    NetworkImageComponentPicasso("https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
}

@Preview("Load an image over the network using the Glide library")
@Composable
fun NetworkImageComponentGlidePreview() {
    NetworkImageComponentGlide("https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
}

@Preview("Add round corners to an image")
@Composable
fun ImageWithRoundedCornersPreview() {
    ImageWithRoundedCorners(R.drawable.landscape)
}



