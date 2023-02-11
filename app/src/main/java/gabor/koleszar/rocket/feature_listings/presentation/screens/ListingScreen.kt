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
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
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
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
    else {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            items(items = listingList,
                itemContent = { post ->
                    ListingCard(post = post)
                })
        }
    }
}

@Composable
fun ListingCard(post: Listing) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Card(

        ) {
            ListingCardTitle(post.title)
            ListingCardContent(post)
            ListingCardMetaData(post)
            ListingCardBottomIcons()
        }
    }
}

@Composable
fun ListingCardTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        textShortener(title, 100),
        modifier = modifier.padding(8.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ListingCardContent(
    post: Listing,
    modifier: Modifier = Modifier
) {
    if (post.postHint == "image") {
        AsyncImage(
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                .diskCachePolicy(CachePolicy.ENABLED)
                .data(post.url)
                .crossfade(true)
                .build(),
            contentDescription = null,
            filterQuality = FilterQuality.None
        )
    } else {
        Box(modifier = modifier.padding(12.dp))
        {
            Text(text = textShortener(post.selftext, 300))
        }
    }
}

@Composable
fun ListingCardMetaData(
    post: Listing,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(post.author)
        Text(post.created)
    }
}

@Composable
fun ListingCardBottomIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
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

private fun textShortener(text: String, maxLength: Int): String {
    return if (text.length <= maxLength)
        text
    else
        text.slice(0..maxLength) + "..."
}