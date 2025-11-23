package org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import org.dieschnittstelle.mobile.android.kotlin.skeleton.AppViewModelProvider
import org.dieschnittstelle.mobile.android.kotlin.skeleton.R
import org.dieschnittstelle.mobile.android.kotlin.skeleton.model.MediaItem
import org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.theme.MADDemoTheme

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    mediaItemViewModel: MediaItemViewModel = viewModel(factory = AppViewModelProvider.Factory)
){

    val mediaItemListUiState = mediaItemViewModel.mediaItemListUiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp),
                onClick = {  },
            ) {
                Icon(Icons.Filled.Add, "Floating action Button")
            }
        }
    ) { innerPadding ->
        ListScreenBody(
            mediaItemListUiState.value.mediaItems,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ListScreenBody(
    mediaItems: List<MediaItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = mediaItems) { item ->
            ListItem(
                mediaItem = item
            )
        }
    }


}

@Composable
fun ListItem(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier
) {
    Box {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            modifier = modifier.padding(2.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ListItemIcon()
                Spacer(modifier.width(10.dp))
                ListItemInformation(
                    mediaItem.title,
                    mediaItem.src,
                    modifier = modifier.weight(1f)
                )
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}



@Composable
fun ListItemInformation(
    name: String,
    date: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name,
        )
        Text(
            text = date
        )
    }
}

@Composable
fun ListItemIcon(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = "https://picsum.photos/60/50",
        contentDescription = "",
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp))
            .width(60.dp)
            .height(60.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(

) {
    androidx.compose.material3.TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.TopBarTitle)
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    )
}



@Preview
@Composable
fun ListScreenPreview() {
    MADDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ListScreen(
                Modifier.padding(innerPadding)
            )
        }
    }
}