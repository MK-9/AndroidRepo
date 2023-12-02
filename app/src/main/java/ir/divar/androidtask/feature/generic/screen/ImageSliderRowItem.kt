package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.divar.androidtask.feature.generic.uiState.ImageItem
import ir.divar.androidtask.feature.generic.uiState.PostItem

@Composable
fun ImageSliderRowItem(widget: PostItem) {
    widget.data?.items?.let {
        if (it.size == 1) {
            FullBanner(imageUrl = it[0].imageUrl)
        } else {
            SemiFullBanner(it)
        }
    }
}

@Composable
fun SemiFullBanner(images: List<ImageItem>) {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween, contentPadding = PaddingValues(8.dp)
    ) {
        items(images) {
            Card(
                modifier = Modifier
                    .size(240.dp, 180.dp)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(it.imageUrl).build(),
                    contentDescription = "widget",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.FillBounds,
                    placeholder = ColorPainter(Color.Gray)
                )
            }
        }
    }
}

@Composable
fun FullBanner(imageUrl: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(180.dp)
            .fillMaxWidth()

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl).build(),
            contentDescription = "widget",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.FillBounds,
            placeholder = ColorPainter(Color.Gray)
        )
    }
}