package ua.boberproduction.template.di

import ua.boberproduction.template.repository.AppPreferenceRepository
import ua.boberproduction.template.repository.PreferenceRepository
import org.koin.dsl.module
import ua.boberproduction.template.repository.AppResourceRepository
import ua.boberproduction.template.repository.ResourceRepository

val viewModelModule = module {
    //viewModel { StartViewModel(get(), get(), get()) }
}

val appModule = module {
    single { AppPreferenceRepository(get()) as PreferenceRepository }
    single { AppResourceRepository(get()) as ResourceRepository }
}

val retrofitModule = module {
    //single { createWebService<ServerApi>(SyncStateContract.Constants.API_HOST_URL) }
}

//inline fun <reified T> createWebService(hostUrl: String): T {
//    val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.tag("OkHttp").d(message) })
//    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//
//    val okHttpClientBuilder = OkHttpClient.Builder()
//        .addInterceptor(loggingInterceptor)
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(hostUrl)
//        .client(okHttpClientBuilder.build())
//        .addConverterFactory(MoshiConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .build()
//
//    return retrofit.create(T::class.java)
//}

val appModules = listOf(viewModelModule, appModule, retrofitModule)