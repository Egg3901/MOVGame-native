import SwiftUI

// Phase 4 shells (#22): same copy contract as androidApp MiscScreens.
struct StoreView: View {
    @StateObject private var store = StoreKitAdapter()

    var body: some View {
        if store.products.isEmpty {
            shell(
                title: "Store",
                body: "Campaign funds and premium scenarios will be purchasable " +
                    "here. Billing connects in Phase 5; nothing is for sale yet."
            )
        } else {
            List {
                if let notice = store.notice {
                    Text(notice).font(.caption)
                }
                ForEach(store.products) { product in
                    HStack {
                        VStack(alignment: .leading) {
                            Text(product.title).font(.headline)
                            Text(store.owned.contains(product.packId) ? "Owned" : product.price)
                                .font(.caption)
                        }
                        Spacer()
                        if !store.owned.contains(product.packId) {
                            Button("Buy") {
                                Task { await store.purchase(packId: product.packId) }
                            }
                            .buttonStyle(.bordered)
                        }
                    }
                }
                Button("Restore purchases") {
                    Task { await store.restore() }
                }
            }
            .navigationTitle("Store")
        }
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
