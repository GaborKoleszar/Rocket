package gabor.koleszar.rocket.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gabor.koleszar.rocket.data.remote.RedditApi
import gabor.koleszar.rocket.data.remote.RedditApiImpl
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient() {
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

    @Provides
    fun provideRedditApi(httpClient: HttpClient): RedditApi {
        return RedditApiImpl(httpClient)
    }
}
