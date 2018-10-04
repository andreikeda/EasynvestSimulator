package br.com.alil.easynvestsimulator.domain

import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EasynvestService {

    @GET("calculator/simulate")
    fun simulate(@Query("investedAmount") investedAmout: Double, @Query("index") index: String = "CDI",
                 @Query("rate") rate: Int, @Query("isTaxFree") isTaxFree: Boolean = false,
                 @Query("maturityDate") maturityDate: String) : Call<SimulateResponse>

}