package sample.ch8n.expandingcards.component


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import sample.ch8n.expandingcards.R

@ExperimentalAnimationApi
@Composable
fun CardComponent(isExpanded: Boolean) {


    Card(
        modifier = Modifier.padding(8.dp),
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
                    bitmap = it.asImageBitmap(),
                    contentScale = ContentScale.Crop
                )
            }

            if (isExpanded) {
                Text(
                    text = userName,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .padding(8.dp)
                )
            }

        }


    }


}