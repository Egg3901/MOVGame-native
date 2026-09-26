import SwiftUI

// Phase 0 stub: proves the Xcode project builds on macOS CI. Real screens
// (Setup/Game/Results/Store/Account) mirror androidApp in Phase 4, and the
// shared KMP framework linkage is a tracked follow-up (see docs/kmp-scaffold.md).
struct ContentView: View {
    var body: some View {
        VStack(spacing: 12) {
            Text("Margin of Victory")
                .font(.largeTitle)
            Text("Hello from the iOS shell. The shared engine lands in Phase 1.")
                .font(.footnote)
                .multilineTextAlignment(.center)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
