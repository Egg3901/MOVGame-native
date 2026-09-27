# Release checklist (Phase 6, #24)

Owner-side runbook for the first store submissions. Code hooks are in the
tree; every unchecked box below needs a console action or a macOS run that
this track cannot perform headless.

## Android (Play)

- [ ] Play Console: create the app and first non-consumable products, then fill
  `SkuTable.entries` (`billing/SkuTable.kt`). Supply the license key as
  `MOV_PLAY_PUBLIC_KEY` through a build environment or Gradle property.
- [ ] Sandbox: purchase → refund → restore → reinstall → offline refresh,
  per docs/billing.md. Refunds must drop the pack on the next
  `queryPurchases`; a stale cache entry past grace must not re-grant
  (covered by `EntitlementsTest`, proven on device here).
- [ ] RTDN endpoint on the campaign server (web repo): revocation ->
  entitlement drop. Until it exists, refunds land on the next client check.
- [ ] Listing: title, short/full description, screenshots (tile map + EV bar
  + results), feature graphic, content rating questionnaire, privacy policy
  URL, data-safety form (no account, no ads SDK; Sentry crash reports only
  when a DSN is set).
- [ ] Release build with `MOV_SENTRY_DSN` set; verify a test crash arrives in
  Sentry before promoting to production.
- [ ] Attach gate evidence (gates 1-6 in README) to the Hub work item.

## iOS (App Store)

- [ ] macOS verify: `kmp.yml` iOS job green (blocked on billing; then
  proves the SwiftUI mirror + `embedAndSignAppleFrameworkForXcode`
  linkage compile).
- [ ] App Store Connect: products matching the SKU table, sandbox +
  TestFlight exercise of purchase/restore/refund through `StoreKitAdapter`.
- [ ] App Store Server Notifications endpoint on the campaign server (web
  repo) for refunds/revocations.
- [ ] sentry-cocoa via SPM + DSN (Android hook `MovApp` is the pattern to
  mirror; not added blind from Linux).
- [ ] Listing: screenshots, privacy manifest + nutrition label (gameplay
  only, no tracking), TestFlight beta notes, crash-free gate.
- [ ] Attach gate evidence per platform to the Hub work item.

## Launch-safe posture (from #23)

Ship store-scoped entitlements (billing.md option 1): a Play purchase
unlocks on that device/account only and never mints a Lakeside
entitlement. The receipt bridge (option 2) is deferred until Play sales
exist; `EntitlementCache.receiptFor` preserves the signed receipt payload
the bridge endpoint will need.
