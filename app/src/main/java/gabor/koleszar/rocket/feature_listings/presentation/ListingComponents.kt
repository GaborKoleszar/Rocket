package gabor.koleszar.rocket.feature_listings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import gabor.koleszar.rocket.R
import gabor.koleszar.rocket.common.StringUtil
import gabor.koleszar.rocket.feature_listings.domain.model.Listing

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
        StringUtil.textShortener(title, 100),
        modifier = modifier.padding(16.dp),
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
            Text(text = StringUtil.textShortener(post.selftext, 300))
        }
    }
}

@Composable
fun ListingCardMetaData(
    post: Listing,
    modifier: Modifier = Modifier
) {
    val formattedDate = remember(post.created) { StringUtil.formatDate(post.created) }
    Row(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(post.author)
        Text(formattedDate)
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