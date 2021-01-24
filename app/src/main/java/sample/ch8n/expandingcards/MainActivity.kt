package sample.ch8n.expandingcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import kotlinx.coroutines.ExperimentalCoroutinesApi
import sample.ch8n.expandingcards.component.CardComponent
import sample.ch8n.expandingcards.ui.ExpandingCardsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandingCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}


@ExperimentalCoroutinesApi
@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name!")


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {

            CardComponent()
            CardComponent()
            CardComponent()
        }

    }

}

@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun DefaultPreview() {
    ExpandingCardsTheme {
        Greeting("Android")


    }
}