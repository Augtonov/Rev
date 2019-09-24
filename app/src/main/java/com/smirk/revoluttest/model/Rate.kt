package com.smirk.revoluttest.model

data class Rate(
	val date: String? = null,
	val rates: Map<String, String>? = null,
	val base: String? = null
) {

	var convertedRates : ArrayList<CRate>? = null
}
