package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ir.divar.androidtask.feature.generic.uiState.PostDetailsData

@Composable
fun PostScreenDetailsContent(data: PostDetailsData?) {
    val widgets = data?.widgets ?: arrayListOf()
    val enableContact = data?.enableContact
    val contactButtonText = data?.contactButtonText

    LazyColumn {
        WidgetContent(widgets, null)
    }
}