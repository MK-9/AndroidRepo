package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.memory.MemoryCache
import coil.request.ImageRequest
import ir.divar.androidtask.feature.generic.uiState.PostDataItemUI

@Composable
fun HeaderRowItem(widget: PostDataItemUI?) {
    widget?.run {
        if (showThumbnail) {
            HeaderRowWithThumbnail(widget)
        } else {
            HeaderRowWithoutThumbnail(widget)
        }
    }
}

@Composable
fun HeaderRowWithThumbnail(widget: PostDataItemUI) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            // Intentionally not a state object to avoid recomposition.
            var placeholder: MemoryCache.Key? = null


            Column(
                modifier = Modifier.weight(1f, true), horizontalAlignment = Alignment.Start
            ) {
                //title
                widget.title?.run {
                    Text(
                        text = this,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }

                //subtitle
                widget.subtitle?.run {
                    Text(
                        text = this,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Gray
                    )
                }
            }

            //thumbnail
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(widget.imageUrl)
//                    .placeholderMemoryCacheKey()
                    .build(),
                contentDescription = "widget",
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(12.dp)),
                onSuccess = { placeholder = it.result.memoryCacheKey },
                onError = { ColorPainter(Color.Red) },
                contentScale = ContentScale.Fit,
                placeholder = ColorPainter(Color.Gray)
            )

        }
    }

}

@Composable
fun HeaderRowWithoutThumbnail(widget: PostDataItemUI) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
    ) {
        //title
        widget.title?.run {
            Text(
                text = this,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge,
            )
        }

        //subtitle
        widget.subtitle?.run {
            Text(
                text = this,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray
            )
        }
    }
}