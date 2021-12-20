package org.wit.swimmingpoolapp.models

interface SwimmingpoolappStore {
    fun findAll(): List<SwimmingpoolappModel>
    fun create(swimmingpoolapp: SwimmingpoolappModel)
    fun update(swimmingpoolapp: SwimmingpoolappModel)
}
