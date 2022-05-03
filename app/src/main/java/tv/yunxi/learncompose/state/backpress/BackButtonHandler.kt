package tv.yunxi.learncompose.state.backpress

import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

/**
 * @author: created by wangkm
 * @time: 2022/05/03 19:02
 * @desc：
 * @email: 1240413544@qq.com
 */


private val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackHandle(enable: Boolean) : OnBackPressedCallback(enable) {
    lateinit var onBackPressed: () -> Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }
}

@Composable
internal fun handler(
    enable: Boolean = true,
    onBackPressed: () -> Unit
) {

    val dispatcher = (LocalBackPressedDispatcher.current ?: return).onBackPressedDispatcher

    val handler = remember { ComposableBackHandle(enable) }


    DisposableEffect(dispatcher) {
        dispatcher.addCallback(handler)
        onDispose { handler.remove() }
    }


    LaunchedEffect(enable) {
        handler.isEnabled = enable
    }

    LaunchedEffect(onBackPressed) {
        handler.onBackPressed = onBackPressed
    }

}

@Composable
internal fun BackButtonHandler(onBackPressed: () -> Unit) {

    var context = LocalContext.current

    while (context is ContextWrapper) {
        if (context is OnBackPressedDispatcherOwner) {
            break
        }
        context = context.baseContext
    }

    CompositionLocalProvider(LocalBackPressedDispatcher provides context as ComponentActivity) {
        handler {
            onBackPressed()
        }

    }

}