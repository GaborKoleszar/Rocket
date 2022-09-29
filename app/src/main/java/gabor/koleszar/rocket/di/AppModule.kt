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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
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
                logger = Logger.ANDROID
                level = LogLevel.BODY
            }
        }
    }

    @Singleton
    @Provides
    fun provideRedditApi(httpClient: HttpClient): RedditApi {
        return RedditApiImpl(httpClient)
    }
}
