package org.wit.swimmingpoolapp.models

import timber.log.Timber

class SwimmingpoolappMemStore {
    val swimmingpoolappList = ArrayList<SwimmingpoolappModel>()

    fun findAll(): List<SwimmingpoolappModel> {
        return swimmingpoolappList
    }
     fun create(swimmingpoolapp: SwimmingpoolappModel) {
        swimmingpoolappList.add(swimmingpoolapp)
        logAll()
    }

    fun logAll() {
        swimmingpoolappList.forEach{ Timber.i("${it}") }
    }
}
