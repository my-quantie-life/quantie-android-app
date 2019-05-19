package io.github.z3r0c00l_2k.aquadroid.recievers

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.z3r0c00l_2k.aquadroid.R
import io.github.z3r0c00l_2k.aquadroid.helpers.NotificationHelper
import io.github.z3r0c00l_2k.aquadroid.utils.AppUtils

class NotifierReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val prefs = context.getSharedPreferences(AppUtils.USERS_SHARED_PREF, AppUtils.PRIVATE_MODE)

        val title = context.resources.getString(R.string.app_name)
        val messageToShow = prefs.getString(
            "message_to_show",
            context.resources.getString(R.string.pref_notification_message_value)
        )

        /* Notify */
        val nHelper = NotificationHelper(context)
        @SuppressLint("ResourceType") val nBuilder = nHelper
            .getNotification(title, messageToShow)
        nHelper.notify(1, nBuilder)

    }
}