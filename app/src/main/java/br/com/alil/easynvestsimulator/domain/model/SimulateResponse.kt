package br.com.alil.easynvestsimulator.domain.model

import java.io.Serializable

data class SimulateResponse(val investmentParameter: InvestmentParamModel, val grossAmount: Double, val taxesAmount: Double,
                            val netAmount: Double, val grossAmountProfit: Double, val netAmountProfit: Double,
                            val annualGrossRateProfit: Double, val monthlyGrossRateProfit: Double, val dailyGrossRateProfit: Double,
                            val taxesRate: Double, val rateProfit: Double, val annualNetRateProfit: Double) : Serializable