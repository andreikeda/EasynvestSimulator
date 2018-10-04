package br.com.alil.easynvestsimulator.main.interactor

import br.com.alil.easynvestsimulator.domain.RetrofitInitializer
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import br.com.alil.easynvestsimulator.main.presenter.MainInteractorOutput
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractorImpl(var output: MainInteractorOutput?) : MainInteractor {

    override fun simulate(investedAmout: Double, rate: Int, maturityDate: String) {
        RetrofitInitializer().easynvestService()
                .simulate(investedAmout = investedAmout, rate = rate, maturityDate = maturityDate)
                .enqueue(object : Callback<SimulateResponse> {
                    override fun onFailure(call: Call<SimulateResponse>, t: Throwable) {
                        output?.onSimulateError(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<SimulateResponse>, response: Response<SimulateResponse>) {
                        when (response.isSuccessful) {
                            true -> {
                                response.body()?.let { output?.onSimulateSuccess(it) } ?: run { output?.onSimulateError("Erro ao montar o objeto response") }
                            }
                            false -> output?.onSimulateError(response.message())
                        }
                    }

                })
    }

    override fun unregister() {
        output = null
    }

}