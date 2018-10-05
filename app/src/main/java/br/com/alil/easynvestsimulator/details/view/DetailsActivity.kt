package br.com.alil.easynvestsimulator.details.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alil.easynvestsimulator.EXTRA_SIMULATE
import br.com.alil.easynvestsimulator.R
import br.com.alil.easynvestsimulator.details.presenter.DetailsPresenter
import br.com.alil.easynvestsimulator.details.presenter.DetailsPresenterImpl
import br.com.alil.easynvestsimulator.domain.model.SimulateResponse
import kotlinx.android.synthetic.main.activity_detail.*

class DetailsActivity : AppCompatActivity(), DetailsView {

    private var presenter: DetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter = DetailsPresenterImpl(this)
        presenter?.onActivityCreated(intent.getSerializableExtra(EXTRA_SIMULATE) as SimulateResponse)
        bt_simulate_again.setOnClickListener { presenter?.onSimulateAgainClicked() }
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null

        super.onDestroy()
    }

    override fun setOutputAnnualGrossRateProfit(annualGrossRateProfit: Double) {
        tv_output_annual_gross_rate_profit.text = getString(R.string.formatted_percent, annualGrossRateProfit)
    }

    override fun setOutputGrossAmount(grossAmount: Double) {
        tv_output_gross_amount.text = getString(R.string.formatted_currency, grossAmount)
        tv_gross_amount.text = getString(R.string.formatted_currency, grossAmount)
    }

    override fun setOutputGrossAmountProfit(grossAmountProfit: Double) {
        tv_output_gross_amount_profit.text = getString(R.string.formatted_currency, grossAmountProfit)
        tv_gross_amount_profit.text = getString(R.string.label_details_gross_amount_formatted, grossAmountProfit)
    }

    override fun setOutputInvestedAmount(investedAmount: Double) {
        tv_output_invested_amount.text = getString(R.string.formatted_currency, investedAmount)
    }

    override fun setOutputInvestmentTax(investmentTax: Double, taxesAmount: Double) {
        tv_output_investment_tax.text = getString(R.string.formatted_tax, investmentTax, taxesAmount)
    }

    override fun setOutputMaturityDays(maturityDays: Int) {
        tv_output_maturity_days.text = "$maturityDays"
    }

    override fun setOutputMaturityDate(maturityDate: String) {
        tv_output_maturity_date.text = maturityDate
    }

    override fun setOutputMonthlyGrossRateProfit(monthlyGrossRateProfit: Double) {
        tv_output_monthly_gross_rate_profit.text = getString(R.string.formatted_percent, monthlyGrossRateProfit)
    }

    override fun setOutputNetAmount(netAmount: Double) {
        tv_output_net_amount.text = getString(R.string.formatted_currency, netAmount)
    }

    override fun setOutputRate(rate: Double) {
        tv_output_rate.text = getString(R.string.formatted_percent, rate)
    }

    override fun setOutputRateProfit(rateProfit: Double) {
        tv_output_rate_profit.text = getString(R.string.formatted_currency, rateProfit)
    }

}