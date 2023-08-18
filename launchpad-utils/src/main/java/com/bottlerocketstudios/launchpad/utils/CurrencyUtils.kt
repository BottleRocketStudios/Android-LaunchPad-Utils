package com.bottlerocketstudios.launchpad.utils

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

/* Formats a double value as a currency */
fun Double?.toCurrency(): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance(Locale.getDefault())
    return numberFormat.format(this ?: 0.0000)
}
