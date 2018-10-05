package br.com.alil.easynvestsimulator

import br.com.alil.easynvestsimulator.domain.RetrofitInitializer
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import br.com.alil.easynvestsimulator.main.interactor.MainInteractorImpl
import br.com.alil.easynvestsimulator.main.presenter.MainInteractorOutput
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun connectApi() {
        val interactorImpl = MainInteractorImpl(object : MainInteractorOutput {
            override fun onSimulateError(errorMessage: String) {
                assert(false)
            }

            override fun onSimulateSuccess(response: SimulateResponse) {
                assert(true)
            }
        })
        interactorImpl.simulate(1000.6, 123, "2025-03-03")
    }
}
