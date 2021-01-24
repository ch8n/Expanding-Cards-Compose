package sample.ch8n.expandingcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import kotlinx.coroutines.ExperimentalCoroutinesApi
import sample.ch8n.expandingcards.component.ExpandingCardComponent
import sample.ch8n.expandingcards.ui.ExpandingCardsTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandingCardsTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SampleView()
                }
            }
        }
    }
}

@Composable
fun SampleView() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Expanding Cards Sample!",
            modifier = Modifier.padding(8.dp)
        )
        ExpandingCardComponent()
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun DefaultPreview() {
    ExpandingCardsTheme {
        SampleView()
    }
}