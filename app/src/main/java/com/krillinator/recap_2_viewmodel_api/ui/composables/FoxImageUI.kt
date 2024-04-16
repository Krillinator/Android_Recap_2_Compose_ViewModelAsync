package com.krillinator.recap_2_viewmodel_api.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.krillinator.recap_2_viewmodel_api.ui.viewModels.FoxViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun FoxImageUI(viewModel: FoxViewModel = viewModel()) {

    val fox by viewModel.foxUiState

    // Trigger fetch on initial composition
    LaunchedEffect(true) {
        viewModel.fetchFoxImage()
    }

    if (fox != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = fox?.image.toString())
            AsyncImage(
                model = fox?.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(shape = CircleShape)
            )
            // NetworkImage(url = )
        }
    } else {
        Text(text = "Loading...")
    }
}
