package gabor.koleszar.rocket.common

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.platform.android.AndroidLogHandler.setLevel
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("deviceplatform", "android")
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "User-Agent: gabor.koleszar.rocket:v0.1 (by /u/Carpenter92)")
                .build()
        )
    }
}