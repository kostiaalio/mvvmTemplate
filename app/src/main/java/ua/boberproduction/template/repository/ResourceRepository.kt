package ua.boberproduction.template.repository

import android.app.Application

interface ResourceRepository {
    fun getString(stringRes: Int): String

    fun getString(stringRes: Int, vararg params: Any): String
}

class AppResourceRepository(private val app: Application) : ResourceRepository {
    override fun getString(stringRes: Int): String {
        return app.getString(stringRes)
    }

    override fun getString(stringRes: Int, vararg params: Any): String {
        return app.getString(stringRes, *params)
    }
}