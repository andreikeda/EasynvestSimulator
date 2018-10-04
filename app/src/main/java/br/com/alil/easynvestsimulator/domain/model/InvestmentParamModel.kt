package br.com.alil.easynvestsimulator.domain.model

import java.io.Serializable

data class InvestmentParamModel(val investedAmount: Double, val yearlyInterestRate: Double, val maturityTotalDays: Int,
                                val maturityBusinessDays: Int, val maturityDate: String, val rate: Int, val isTaxFree: Boolean) : Serializable