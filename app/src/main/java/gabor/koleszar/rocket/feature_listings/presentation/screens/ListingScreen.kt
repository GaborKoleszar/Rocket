package gabor.koleszar.rocket.feature_listings.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.PostDto
import gabor.koleszar.rocket.feature_listings.presentation.viewmodels.ListingViewModel
import java.util.*

@Composable
fun ListingScreen(
    navController: NavController,
    viewModel: ListingViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
        items(items = viewModel.listing.value.listOfPosts,
            itemContent = { post ->
                ListingCard(post = post)
                Divider(modifier = Modifier, color = Color.DarkGray, thickness = 1.dp)
            })
    }
}

@Composable
fun ListingCard(post: PostDto) {
    Column(Modifier.fillMaxSize().padding(15.dp)) {
        Text(post.title, modifier = Modifier.padding(bottom = 5.dp))
        if (post.post_hint == "image") {
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
        }else   {
            Text(post.selftext)
        }
        Row(modifier = Modifier.padding(top = 5.dp)) {
            Text(post.author)
            Text(Date(post.created * 1000).toString())
        }
    }
}