package tv.yunxi.learncompose

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import tv.yunxi.learncompose.image.ImageActivity
import tv.yunxi.learncompose.material.AlertDialogActivity
import tv.yunxi.learncompose.material.DrawerAppActivity
import tv.yunxi.learncompose.text.CustomTextActivity
import tv.yunxi.learncompose.text.HorizontalScrollableActivity
import tv.yunxi.learncompose.text.SimpleTextActivity
import tv.yunxi.learncompose.text.VerticalScrollableActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimpleTextExample(view: View){
        startActivity(Intent(this,SimpleTextActivity::class.java))
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
        startActivity(Intent(this, DrawerAppActivity::class.java))
    }
}
