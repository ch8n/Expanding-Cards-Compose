package sample.ch8n.expandingcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
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
        var expandedPositionState by remember { mutableStateOf(1) }

        Row(modifier = Modifier.fillMaxWidth(1f).background(Color.Blue)) {

            CardComponent(
                modifier = Modifier.fillMaxWidth(
                    if (expandedPositionState == 1) {
                        0.5f
                    } else {
                        0.25f
                    }
                ).clickable(onClick = {
                    expandedPositionState = 1
                })
            )
            CardComponent(
                modifier = Modifier.fillMaxWidth(
                    if (expandedPositionState == 2) {
                        0.5f
                    } else {
                        0.25f
                    }
                ).clickable(onClick = {
                    expandedPositionState = 2
                })
            )
            CardComponent(
                modifier = Modifier.fillMaxWidth(
                    if (expandedPositionState == 3) {
                        0.5f
                    } else {
                        0.25f
                    }
                ).clickable(onClick = {
                    expandedPositionState = 3
                })
            )
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