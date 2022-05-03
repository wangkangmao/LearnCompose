package tv.yunxi.learncompose

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }


    @Composable
    fun MainActivityContent() {

        Column(modifier = Modifier.fillMaxSize()) {
            BaseCompose()
            SeniorCompose()
        }
    }
    private fun startBaseComposeActivity(){
        startActivity(Intent(this, BaseComposeActivity::class.java))
    }


    private fun startSeniorComposeActivity(){
        startActivity(Intent(this, SeniorComposeActivity::class.java))
    }



    @Composable
    fun BaseCompose() {
        Button(
            modifier = Modifier.padding(16.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            onClick = {
                startBaseComposeActivity()
            }) {
            Text(text = "Basic", modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun SeniorCompose() {
        Button(
            modifier = Modifier.padding(16.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            onClick = {
                startSeniorComposeActivity()
            }) {
            Text(text = "Serior", modifier = Modifier.padding(16.dp))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainActivityPreView() {
        MainActivityContent()
    }

}




