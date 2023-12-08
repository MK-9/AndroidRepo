package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.divar.androidtask.feature.generic.uiState.PostDataItemUI

@Composable
fun InfoRowItem(widget: PostDataItemUI?) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            //value
            widget?.value?.run {
                Text(
                    text = this,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Gray
                )
            }

            //title
            widget?.title?.run {
                Text(
                    text = this,
                    modifier = Modifier
                        .padding(start = 4.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}