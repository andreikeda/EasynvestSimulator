package br.com.alil.easynvestsimulator.details.presenter

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import br.com.alil.easynvestsimulator.convertDateToHumanFormat
import br.com.alil.easynvestsimulator.details.router.DetailsRouter
import br.com.alil.easynvestsimulator.details.router.DetailsRouterImpl
import br.com.alil.easynvestsimulator.details.view.DetailsView
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse

class DetailsPresenterImpl(var view: DetailsView?) : DetailsPresenter {

    var data: MutableLiveData<SimulateResponse> = MutableLiveData()

    private var router: DetailsRouter? = DetailsRouterImpl(view as Activity)

    override fun onActivityCreated(response: SimulateResponse?) {
        response?.let { data.value = it }

        data.value?.let {
            view?.setOutputAnnualGrossRateProfit(it.annualGrossRateProfit)
            view?.setOutputGrossAmount(it.grossAmount)
            view?.setOutputGrossAmountProfit(it.grossAmountProfit)
            view?.setOutputInvestedAmount(it.investmentParameter.investedAmount)
            view?.setOutputInvestmentTax(it.taxesRate, it.taxesAmount)
            view?.setOutputMaturityDate(it.investmentParameter.maturityDate.convertDateToHumanFormat())
            view?.setOutputMaturityDays(it.investmentParameter.maturityTotalDays)
            view?.setOutputMonthlyGrossRateProfit(it.monthlyGrossRateProfit)
            view?.setOutputNetAmount(it.netAmount)
            view?.setOutputRate(it.taxesRate)
            view?.setOutputRateProfit(it.rateProfit)
        }
    }

    override fun onSimulateAgainClicked() {
        router?.goBackToMain()
    }

    override fun unregister() {
        router?.unregister()
        router = null
        view = null
    }

}