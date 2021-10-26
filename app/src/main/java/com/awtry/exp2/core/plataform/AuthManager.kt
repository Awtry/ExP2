package com.awtry.exp2.core.plataform

import android.content.Context
import android.content.SharedPreferences
import com.awtry.exp2.domain.model.User
import com.squareup.moshi.Moshi
import java.lang.Exception
import javax.inject.Inject


class AuthManager @Inject constructor(private val context: Context) {

    private val PREFS_KEY = "FOOD_PREFS"
    private val USER_KEY = "USER"

    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    private val moshi = Moshi.Builder().build()

    //TODO: Hay que verificar si realmente se usara
    var user: User?
        set(value) = preferences.edit()
            .putString(USER_KEY, moshi.adapter(User::class.java).toJson(value)).apply()
        get() = preferences.getString(USER_KEY, null)?.let {
            return@let try {
                moshi.adapter(User::class.java).fromJson(it)
            } catch (e: Exception) {
                null
            }
        }

}