package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.divar.androidtask.feature.generic.uiState.PostDetailsDataUI

@Composable
fun PostScreenDetailsContent(data: PostDetailsDataUI?) {
    val widgets = data?.widgets ?: arrayListOf()
    val enableContact = data?.enableContact ?: false
    val contactButtonText = data?.contactButtonText
    LazyColumn {
        WidgetContent(widgets = widgets, null)

        ContactButton(enableContact = enableContact, contactButtonText = contactButtonText)
    }
}


private fun LazyListScope.ContactButton(enableContact: Boolean, contactButtonText: String?) {
    item {
        contactButtonText?.let {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = {}, enabled = enableContact) {
                    Text(
                        text = contactButtonText,
                        modifier = Modifier.padding(4.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        }
    }
}