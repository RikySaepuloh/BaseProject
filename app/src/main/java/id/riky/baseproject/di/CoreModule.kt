package id.riky.baseproject.di

//import androidx.room.Room
import id.riky.baseproject.utils.Preferences
import id.riky.baseproject.BuildConfig
//import id.agis.core.data.source.RecipeRepository
//import id.agis.core.data.source.local.LocalDataSource
//import id.riky.baseproject.data.source.local.room.RecipeDatabase
//import id.agis.core.data.source.remote.RemoteDataSource
//import id.agis.core.data.source.remote.network.ApiService
//import id.agis.core.domain.repository.IRecipeRepository
//import net.sqlcipher.database.SQLiteDatabase
//import net.sqlcipher.database.SupportFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


val networkModule = module {
    single {
//        if we need certificate pinner just uncomment these codes below
//        val hostname = "https://devapi.simkug.com/api/"
////        val certificatePinner = CertificatePinner.Builder()
////            .add(hostname, "sha256/pvk3g76Lgd71C8n6o3RZOIM4+yWhIlyaJh5Nw97XYE0")
////            .add(hostname, "sha256/jQJTbIh0grw0/1TkHSumWb+Fs0Ggogr621gT3PvPKG0+yWhIlyaJh5Nw97XYE0")
////            .add(hostname, "sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M")
////            .build()
        var preferences  = Preferences().apply {
            setPreferences(androidApplication().applicationContext)
        }

        val intercept  = Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader(
                    "Authorization",
                    "bearer "+preferences.getToken()!!
                )
                .build()
            chain.proceed(newRequest)
        }
        OkHttpClient.Builder()
                //uncomment when you want to debug the response
            .addInterceptor(HttpLoggingInterceptor().apply { level =HttpLoggingInterceptor.Level.BODY })
            .addInterceptor (intercept)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
//            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
//        retrofit.create(ApiService::class.java)
    }
}

//val databaseModule = module {
//    factory { get<RecipeDatabase>().recipeDao() }
//    single {
//        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
//        val factory = SupportFactory(passphrase)
//        Room.databaseBuilder(
//            androidContext(),
//            RecipeDatabase::class.java, "recipe.db"
//        ).fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
//            .build()
//    }
//}


val repositoryModule = module {
//    single { RemoteDataSource(get()) }
////    single { LocalDataSource(get()) }
//    single<ILoginRepository> {
//        LoginRepository(get())
//    }
//
//    single<IPINLoginRepository> {
//        PINLoginRepository(get())
//    }
//    single<IMainRepository> {
//        MainRepository(get())
//    }
//
//    single<IDetailRepository> {
//        DetailRepository(get())
//    }
}