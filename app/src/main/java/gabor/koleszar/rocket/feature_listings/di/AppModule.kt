package gabor.koleszar.rocket.feature_listings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApiImpl
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                gson()
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
