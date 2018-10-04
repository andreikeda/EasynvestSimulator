package br.com.alil.easynvestsimulator.main.presenter

import android.app.Activity
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import br.com.alil.easynvestsimulator.main.interactor.MainInteractor
import br.com.alil.easynvestsimulator.main.interactor.MainInteractorImpl
import br.com.alil.easynvestsimulator.main.router.MainRouter
import br.com.alil.easynvestsimulator.main.router.MainRouterImpl
import br.com.alil.easynvestsimulator.main.view.MainView

class MainPresenterImpl(var view: MainView?) : MainPresenter, MainInteractorOutput {

    private var interactor: MainInteractor? = MainInteractorImpl(this)
    private var router: MainRouter? = MainRouterImpl(view as Activity)

    override fun onSimulateClicked(investedAmout: String, rate: String, maturityDate: String) {
        view?.showLoading()
        interactor?.simulate(investedAmout.toDouble(), rate.toInt(), maturityDate)
    }

    override fun unregister() {
        interactor?.unregister()
        interactor = null
        router?.unregister()
        router = null
        view = null
    }

    override fun onSimulateError(errorMessage: String) {
        view?.showError(errorMessage)
    }

    override fun onSimulateSuccess(response: SimulateResponse) {
        router?.goToDetails(response)
    }

}