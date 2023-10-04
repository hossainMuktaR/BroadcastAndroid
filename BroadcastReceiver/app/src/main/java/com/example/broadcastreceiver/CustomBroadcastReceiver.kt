package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

private val TAG = "broadcastrevicer"

class CustomBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "ACTION_FROM_BROADCAST_SENDER") {
            Log.i(TAG, "Broadcast received from ${intent.action.toString()}")
        }
    }
}