package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.material3.Snackbar

private val TAG = "broadcastrevicer"

class CustomBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "Broadcast received from ${intent?.action.toString()}")
        Toast.makeText(
            context?.applicationContext,
            "Broadcast received from ${intent?.action.toString()}",
            Toast.LENGTH_SHORT
        ).show()

    }
}