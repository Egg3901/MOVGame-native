import SwiftUI

// Phase 4 shells (#22): same copy contract as androidApp MiscScreens.
struct StoreView: View {
    var body: some View {
        shell(
            title: "Store",
            body: "Campaign funds and premium scenarios will be purchasable " +
                "here. Billing connects in Phase 5; nothing is for sale yet."
        )
    }
}

struct AccountView: View {
    var body: some View {
        shell(
            title: "Account",
            body: "Sign in with your Margin of Victory account to sync " +
                "campaigns across devices. Login connects after billing; " +
                "campaigns stay on this device for now."
        )
    }
}

private func shell(title: String, body: String) -> some View {
    VStack(spacing: 8) {
        Spacer()
        Text(title).font(.largeTitle)
        Text(body).multilineTextAlignment(.center)
        Spacer()
    }
    .padding()
}
