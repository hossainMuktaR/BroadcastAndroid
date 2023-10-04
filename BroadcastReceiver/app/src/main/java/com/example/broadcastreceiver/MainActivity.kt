package com.example.broadcastreceiver

import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.example.broadcastreceiver.ui.theme.BroadcastReceiverTheme

class MainActivity : ComponentActivity() {
    // need for contextDeclaredReceiver implementation
    private val customBroadcastReceiver = CustomBroadcastReceiver()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // start of contextDeclaredReceiver implementation
        val isReceiverExported = true
        val registerFlags = if(isReceiverExported) {
            ContextCompat.RECEIVER_EXPORTED
        } else {
            ContextCompat.RECEIVER_NOT_EXPORTED
        }
        registerReceiver(
            customBroadcastReceiver,
            IntentFilter("com.example.broadcastsender.ACTION_FROM_BROADCAST_SENDER"),
            registerFlags
        )
        // end of contextDeclaredReceiver implementation
        setContent {
            BroadcastReceiverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ){
                        Text("Broadcast Receiver App",style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // need for contextDeclaredReceiver implementation
        unregisterReceiver(customBroadcastReceiver)
    }
}
