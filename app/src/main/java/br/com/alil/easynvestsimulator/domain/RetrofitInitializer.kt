package br.com.alil.easynvestsimulator.domain

import br.com.alil.easynvestsimulator.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun easynvestService() : EasynvestService {
        return retrofit.create(EasynvestService::class.java)
    }
}