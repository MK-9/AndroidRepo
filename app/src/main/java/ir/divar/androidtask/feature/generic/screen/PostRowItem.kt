package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import ir.divar.androidtask.feature.generic.uiState.PostItemUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostRowItem(widget: PostItemUI, onItemClicked: ((PostItemUI) -> Unit)?) {
    ElevatedCard(
        onClick = { onItemClicked?.invoke(widget) }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {


            // Intentionally not a state object to avoid recomposition.
            var placeholder: MemoryCache.Key? = null

            //thumbnail
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(widget.data?.thumbnail)
//                    .placeholderMemoryCacheKey()
                    .build(),
                contentDescription = "widget",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(12.dp)),
                onSuccess = { placeholder = it.result.memoryCacheKey },
                onError = { ColorPainter(Color.Red) },
                contentScale = ContentScale.FillWidth,
                placeholder = ColorPainter(Color.Gray)
            )

            //title
            Text(
                text = widget.data?.title ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge,
            )

            //district
            widget.data?.district?.run {
                Text(
                    text = widget.data.district,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }

            //price
            widget.data?.price?.run {
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = widget.data.price,
                        modifier = Modifier.padding(
                            start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp
                        ),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}