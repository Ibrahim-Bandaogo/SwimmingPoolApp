package org.wit.swimmingpoolapp.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class SwimmingpoolappMemStore : SwimmingpoolappStore {

    val swimmingpoolappList = ArrayList<SwimmingpoolappModel>()

    override fun findAll(): List<SwimmingpoolappModel> {
        return swimmingpoolappList
    }

    override fun create(swimmingpoolapp: SwimmingpoolappModel) {
        i("adding" +swimmingpoolapp.toString())
        swimmingpoolapp.id = getId()
        swimmingpoolappList.add(swimmingpoolapp)
        logAll()
    }

    override fun update(swimmingpoolapp: SwimmingpoolappModel) {
        var foundSwimmingpoolapp: SwimmingpoolappModel? = swimmingpoolappList.find { p -> p.id == swimmingpoolapp.id }
        if (foundSwimmingpoolapp != null) {
            foundSwimmingpoolapp.title = swimmingpoolapp.title
            foundSwimmingpoolapp.description = swimmingpoolapp.description
            logAll()
        }
    }

    private fun logAll() {
        swimmingpoolappList.forEach { i("$it") }
    }
}
