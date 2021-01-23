package sample.ch8n.expandingcards.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import sample.ch8n.expandingcards.R

@Composable
fun CardComponent() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 8.dp
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {

            val (userName, imageUrl) = getRandomSample()

            loadImage(
                url = imageUrl,
                placeholder = R.drawable.ic_launcher_background
            ).value?.let {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    asset = it.asImageAsset(),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = userName,
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(8.dp)
            )

        }


    }
}