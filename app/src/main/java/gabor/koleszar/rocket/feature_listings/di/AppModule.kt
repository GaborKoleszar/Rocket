package gabor.koleszar.rocket.feature_listings.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gabor.koleszar.rocket.common.HeaderInterceptor
import gabor.koleszar.rocket.feature_listings.data.local_datasource.RedditDataBase
import gabor.koleszar.rocket.feature_listings.data.local_datasource.RedditDataBase.Companion.DATABASE_NAME
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BASE_URL
import gabor.koleszar.rocket.feature_listings.data.repository.ListingsRepositoryImpl
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRedditApi(client: OkHttpClient): RedditApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        return interceptor
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor = httpLoggingInterceptor)
        httpClient.addInterceptor(interceptor = headerInterceptor)
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideRedditRepository(api: RedditApi, db: RedditDataBase, simpleDateFormat: SimpleDateFormat): ListingsRepository {
        return ListingsRepositoryImpl(api, db, simpleDateFormat)
    }

    @Singleton
    @Provides
    fun provideRedditDatabase(app: Application): RedditDataBase {
        return Room.databaseBuilder(
            app,
            RedditDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideSimpleDateFormat(): SimpleDateFormat {
        return SimpleDateFormat("h:mm", Locale.getDefault())
    }
}
