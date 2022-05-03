package tv.yunxi.learncompose

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import tv.yunxi.learncompose.animation.Animation1Activity
import tv.yunxi.learncompose.animation.Animation2Activity
import tv.yunxi.learncompose.animation.ListAnimationActivity
import tv.yunxi.learncompose.animation.TextAnimationActivity
import tv.yunxi.learncompose.customview.MeasuringScaleActivity
import tv.yunxi.learncompose.customview.ZoomableActivity
import tv.yunxi.learncompose.image.ImageActivity
import tv.yunxi.learncompose.interop.ComposeInClassicAndroidActivity
import tv.yunxi.learncompose.layout.ConstraintLayoutActivity
import tv.yunxi.learncompose.layout.LayoutModifierActivity
import tv.yunxi.learncompose.livedata.LiveDataActivity
import tv.yunxi.learncompose.material.*
import tv.yunxi.learncompose.state.ProcessDeathActivity
import tv.yunxi.learncompose.state.backpress.BackPressActivity
import tv.yunxi.learncompose.state.coroutine.CoroutineFlowActivity
import tv.yunxi.learncompose.text.CustomTextActivity
import tv.yunxi.learncompose.text.HorizontalScrollableActivity
import tv.yunxi.learncompose.text.SimpleTextActivity
import tv.yunxi.learncompose.text.VerticalScrollableActivity
import tv.yunxi.learncompose.theme.DarkModeActivity

/**
 * @author: created by wangkm
 * @time: 2022/05/03 20:39
 * @desc：
 * @email: 1240413544@qq.com
 */

class BaseComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_compose)
    }

    fun startSimpleTextExample(view: View){
        startActivity(Intent(this, SimpleTextActivity::class.java))
    }

    fun startCustomTextExample(view: View) {
        startActivity(Intent(this, CustomTextActivity::class.java))
    }

    fun startVerticalScrollableExample(view: View) {
        startActivity(Intent(this, VerticalScrollableActivity::class.java))
    }

    fun startHorizontalScrollableExample(view: View) {
        startActivity(Intent(this, HorizontalScrollableActivity::class.java))
    }

    fun starLoadImageExample(view: View) {
        startActivity(Intent(this, ImageActivity::class.java))
    }

    fun startAlertDialogExample(view: View) {
        startActivity(Intent(this, AlertDialogActivity::class.java))
    }

    fun startDrawerExample(view: View) {
        startActivity(Intent(this, MaterialActivity::class.java))
    }
    fun startViewAlignExample(view: View) {
        startActivity(Intent(this, FixedActionButtonActivity::class.java))
    }

    fun startConstraintLayoutExample(view: View) {
        startActivity(Intent(this, ConstraintLayoutActivity::class.java))
    }

    fun startBottomNavigationExample(view: View) {
        startActivity(Intent(this, BottomNavigationActivity::class.java))
    }

    fun startAnimation1Example(view: View) {
        startActivity(Intent(this, Animation1Activity::class.java))
    }

    fun startAnimation2Example(view: View) {
        startActivity(Intent(this, Animation2Activity::class.java))
    }

    fun startTextInlineContentExample(view: View) {
        startActivity(Intent(this, TextAnimationActivity::class.java))
    }

    fun startListAnimation(view: View) {
        startActivity(Intent(this, ListAnimationActivity::class.java))
    }

    fun startThemeExample(view: View) {
        startActivity(Intent(this, DarkModeActivity::class.java))
    }

    fun startLayoutModifierExample(view: View) {
        startActivity(Intent(this, LayoutModifierActivity::class.java))
    }

    fun startProcessDeathExample(view: View) {
        startActivity(Intent(this, ProcessDeathActivity::class.java))
    }

    fun startLiveDataExample(view: View) {
        startActivity(Intent(this, LiveDataActivity::class.java))
    }

    fun startFlowRowExample(view: View) {
        startActivity(Intent(this, FlowRowActivity::class.java))
    }

    fun startShadowExample(view: View) {
        startActivity(Intent(this, ShadowActivity::class.java))
    }


    fun startCoroutineFlowExample(view: View) {
        startActivity(Intent(this, CoroutineFlowActivity::class.java))
    }

    fun startComposeWithClassicAndroidExample(view: View) {
        startActivity(Intent(this, ComposeInClassicAndroidActivity::class.java))
    }

    fun startMeasuringScaleExample(view: View) {
        startActivity(Intent(this, MeasuringScaleActivity::class.java))
    }

    fun startBackPressExample(view: View) {
        startActivity(Intent(this, BackPressActivity::class.java))
    }

    fun startZoomableExample(view: View) {
        startActivity(Intent(this, ZoomableActivity::class.java))
    }
}