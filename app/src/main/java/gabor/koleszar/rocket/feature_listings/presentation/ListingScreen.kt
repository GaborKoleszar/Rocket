package gabor.koleszar.rocket.feature_listings.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingScreen(
    listingType: ListingTypes,
    navController: NavController,
    viewModel: ListingViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        rememberTopAppBarState()
    )
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = ListingTypes.BestListingType.getName()) },
                navigationIcon = {
                    IconButton(
                        onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }) {
        val listState = rememberLazyListState()
        val listingList by viewModel.listingList.collectAsState()
        if (listingList.isEmpty())
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        else {
            LazyColumn(
                state = listState, modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                items(items = listingList,
                    itemContent = { post ->
                        ListingCard(post = post)
                    })
            }
        }
    }
}