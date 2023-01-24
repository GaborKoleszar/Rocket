package gabor.koleszar.rocket.feature_listings.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gabor.koleszar.rocket.feature_listings.data.repository.ListingsRepositoryImpl
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractAppModule {

    @Binds
    abstract fun bindListingsRepository(
        listingsRepositoryImpl: ListingsRepositoryImpl
    ): ListingsRepository
}