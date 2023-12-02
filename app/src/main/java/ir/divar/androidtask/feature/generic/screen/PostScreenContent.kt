package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ir.divar.androidtask.feature.generic.uiState.PostItem
import ir.divar.androidtask.feature.generic.uiState.PostsData

@Composable
fun PostScreenContent(data: PostsData?, onItemClicked: (PostItem) -> Unit) {
    val widgets = data?.widgets ?: arrayListOf()
    LazyColumn {
        WidgetContent(widgets, onItemClicked)
    }
}