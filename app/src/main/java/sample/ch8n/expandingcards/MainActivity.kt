package sample.ch8n.expandingcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import kotlinx.coroutines.ExperimentalCoroutinesApi
import sample.ch8n.expandingcards.component.CardComponent
import sample.ch8n.expandingcards.ui.ExpandingCardsTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
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


@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name!")

        var expandedPosition by remember { mutableStateOf(1) }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {

            Box(
                modifier = Modifier
                    .weight(if (expandedPosition == 1) 1f else 0.3f, fill = false)
                    .clickable(onClick = {
                        expandedPosition = 1
                    })
            ) {
                CardComponent(expandedPosition == 1)
            }

            Box(
                modifier = Modifier
                    .weight(if (expandedPosition == 2) 1f else 0.3f, fill = false)
                    .clickable(onClick = {
                        expandedPosition = 2
                    })
            ) {
                CardComponent(expandedPosition == 2)
            }

            Box(
                modifier = Modifier
                    .weight(if (expandedPosition == 3) 1f else 0.3f, fill = false)
                    .clickable(onClick = {
                        expandedPosition = 3
                    })
            ) {
                CardComponent(expandedPosition == 3)
            }
        }

    }

}

@ExperimentalAnimationApi
@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun DefaultPreview() {
    ExpandingCardsTheme {
        Greeting("Android")


    }
}