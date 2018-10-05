package br.com.alil.easynvestsimulator.details.view

interface DetailsView {

    fun setOutputAnnualGrossRateProfit(annualGrossRateProfit: Double)
    fun setOutputGrossAmount(grossAmount: Double)
    fun setOutputGrossAmountProfit(grossAmountProfit: Double)
    fun setOutputInvestedAmount(investedAmount: Double)
    fun setOutputInvestmentTax(investmentTax: Double, taxesAmount: Double)
    fun setOutputMaturityDays(maturityDays: Int)
    fun setOutputMaturityDate(maturityDate: String)
    fun setOutputMonthlyGrossRateProfit(monthlyGrossRateProfit: Double)
    fun setOutputNetAmount(netAmount: Double)
    fun setOutputRate(rate: Double)
    fun setOutputRateProfit(rateProfit: Double)

}