package sample.ch8n.expandingcards.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target


fun getRandomSample(): Pair<String, String> {
    val sampleUrls = mapOf<String, String>(
        "Daniel Olah" to "https://images.unsplash.com/photo-1611334312954-c8924c8f789d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=640&q=80",
        "Jonny Caspari" to "https://images.unsplash.com/photo-1610917887095-8541e4ecd869?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=640&q=80",
        "Marco De Hevia" to "https://images.unsplash.com/photo-1610643748471-2eae4a44bd18?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=640&q=80",
        "Daniel Diesenreither" to "https://images.unsplash.com/photo-1610311696840-8b6a7388c937?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=640&q=80",
    )
    return sampleUrls.entries.shuffled().first().toPair()
}

@Composable
fun loadImage(url: String, @DrawableRes placeholder: Int): MutableState<Bitmap?> {

    val bitmapState = mutableStateOf<Bitmap?>(null)
    Picasso.get().load(placeholder).into(object : Target {
        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
            bitmapState.value = bitmap
        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
            println(e)
        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

        }

    })

    Picasso.get().load(url).into(object : Target {
        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
            bitmapState.value = bitmap
        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
            println(e)
        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

        }

    })

    return bitmapState
}