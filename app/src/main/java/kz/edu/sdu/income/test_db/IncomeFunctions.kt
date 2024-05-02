package kz.edu.sdu.income.test_db

import kz.edu.sdu.income.data.DataBase

// Function to calculate federal tax based on gross income
fun calculateFederalTax(grossIncome: Double): Double {
    // Apply federal tax brackets (simplified example)
    val brackets = listOf(
        Pair(9950.0, 0.10), // Up to $9,950 at 10%
        Pair(40525.0, 0.12), // Up to $40,525 at 12%
        Pair(86375.0, 0.22)  // More brackets as necessary
    )
    var remainingIncome = grossIncome
    var tax = 0.0
    var previousBracketCap = 0.0

    for (bracket in brackets) {
        if (remainingIncome <= 0) break
        val taxableAtThisBracket = minOf(bracket.first - previousBracketCap, remainingIncome)
        tax += taxableAtThisBracket * bracket.second
        remainingIncome -= taxableAtThisBracket
        previousBracketCap = bracket.first
    }

    return tax
}

// Calculate net paycheck considering all deductions
fun calculateNetPaycheck(gross: Double, deductions: Map<String, Double>): Double {
    return deductions.entries.fold(gross) { acc, deduction -> acc - deduction.value }
}

fun getStateInformation(stateName: String) {
    val dataBase = DataBase().fillList

    dataBase.find { it.stateName == stateName }?.let { state ->
        val grossPayWeekly = state.hourlyRate * state.hoursWorkedPerWeek
        val grossPayTotal = grossPayWeekly * state.stayPeriod

        val federalTaxWeekly = calculateFederalTax(grossPayWeekly)
        val federalTaxTotal = federalTaxWeekly * state.stayPeriod

        val deductionsWeekly = mapOf(
            "Federal Tax" to federalTaxWeekly,
            "State Tax" to state.stateTax * grossPayWeekly, // Assuming stateTax is a percentage
            "Rent" to state.rent,
            "Food Expense" to state.foodExpense,
            "Tips Tax" to state.tips * state.tipsTax // Assuming tips are per week
        )
        val deductionsTotal = deductionsWeekly.mapValues { it.value * state.stayPeriod }

        val netPaycheckWeekly = calculateNetPaycheck(grossPayWeekly, deductionsWeekly)
        val netPaycheckTotal = netPaycheckWeekly * state.stayPeriod + state.tips * state.stayPeriod - deductionsTotal["Tips Tax"]!!

        println("State: ${state.stateName}")
        println("Gross Pay Total: $grossPayTotal")
        println("")
        println("Net Paycheck Total: $netPaycheckTotal")
        println("Gross Pay per Week: $grossPayWeekly")
        println("Net Paycheck per Week: $netPaycheckWeekly")
    } ?: println("No state found with the name $stateName")
}

fun main() {
    getStateInformation("Alaska")
}
