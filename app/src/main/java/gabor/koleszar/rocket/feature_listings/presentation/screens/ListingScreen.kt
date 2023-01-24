package gabor.koleszar.rocket.feature_listings.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import gabor.koleszar.rocket.R
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.presentation.viewmodels.ListingViewModel

@Composable
fun ListingScreen(
    navController: NavController,
    viewModel: ListingViewModel
) {
    val listState = rememberLazyListState()
    val listingList by viewModel.listingList.collectAsState()
    if (listingList.isEmpty())
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    else {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            items(items = listingList,
                itemContent = { post ->
                    ListingCard(post = post)
                    Divider(modifier = Modifier, color = Color.DarkGray, thickness = 1.dp)
                })
        }
    }
}

@Composable
fun ListingCard(post: Listing) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(post.title, modifier = Modifier.padding(bottom = 5.dp), fontWeight = FontWeight.Bold)
        if (post.postHint == "image") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.url)
                        .crossfade(true)
                        .transformations(RoundedCornersTransformation(20f))
                        .build(),
                    contentDescription = null,
                    filterQuality = FilterQuality.Medium
                )
            }
        } else {
            if (post.selftext.length <= 100)
                Text(post.selftext)
            else
                Text(post.selftext.slice(0..100) + "...")
        }
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(post.author)
            Text(post.created)
        }
        ListingCardBottomIcons()
    }
}

@Composable
fun ListingCardBottomIcons() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_message_24),
            contentDescription = null,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_share_24),
            contentDescription = null,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_keyboard_double_arrow_down_24),
            contentDescription = null,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_keyboard_double_arrow_up_24),
            contentDescription = null,
        )
    }
}