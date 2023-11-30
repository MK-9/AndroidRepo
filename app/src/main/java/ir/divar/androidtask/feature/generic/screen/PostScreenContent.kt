package ir.divar.androidtask.feature.generic.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ir.divar.androidtask.feature.generic.uiState.PostItem
import ir.divar.androidtask.feature.generic.uiState.PostsData

@Composable
fun PostScreenContent(data: PostsData?, onItemClicked: (PostItem) -> Unit) {
    val widgets = data?.widgets ?: arrayListOf()

    LazyColumn {
        items(items = widgets) { widgetItem ->
            when {
                widgetItem.widgetType == PostItem.WidgetType.TITLE_ROW.name -> {
                    TitleRowItem(widgetItem)
                }

                widgetItem.widgetType == PostItem.WidgetType.SUBTITLE_ROW.name -> {
                    SubtitleRowItem(widgetItem)
                }

                widgetItem.widgetType == PostItem.WidgetType.POST_ROW.name -> {
                    PostRowItem(widgetItem, onItemClicked)
                }
            }
        }
    }
}