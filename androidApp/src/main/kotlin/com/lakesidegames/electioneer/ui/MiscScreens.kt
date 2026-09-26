package com.lakesidegames.electioneer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Phase 3 shells (#21): Store wires to Play Billing in Phase 5 (#8),
// Account to the web auth session after that. Screens exist now so the
// bottom nav and gate criteria are real; both say what is coming.
@Composable
fun StoreScreen() {
    Shell(
        title = "Store",
        body = "Campaign funds and premium scenarios will be purchasable " +
            "here. Billing connects in Phase 5; nothing is for sale yet.",
    )
}

@Composable
fun AccountScreen() {
    Shell(
        title = "Account",
        body = "Sign in with your Margin of Victory account to sync " +
            "campaigns across devices. Login connects after billing; " +
            "campaigns stay on this device for now.",
    )
}

@Composable
private fun Shell(title: String, body: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(title, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text(body, style = MaterialTheme.typography.bodyMedium)
    }
}
