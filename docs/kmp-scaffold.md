# KMP scaffold (Phase 0) — Margin of Victory native mobile

Authoritative plan: `docs/native-plan.md`. This scaffold is Phase 0 only:
a buildable project shape plus the types contract. No engine behaviour,
no content, no billing. Do not start Phase 1 work in this tree.

## Layout (lands at the repo root, next to `src-tauri/`)

```
shared/            KMP module: engine port home (commonMain/engine)
androidApp/        Jetpack Compose stub (Hello Margin of Victory)
iosApp/            SwiftUI stub (Xcode project, builds on macOS CI)
gradle/            version catalog + wrapper
.github/workflows/  kmp.yml (android ubuntu + ios macos)
```

`src-tauri/` is untouched: desktop stays Tauri. The Android/iOS Tauri shells
are deprecated per the plan; the mobile apps are KMP + native UI.

## Pinned versions (verified against live Maven metadata, 2026-09-26)

| Piece | Version | Note |
|---|---|---|
| Gradle wrapper | 8.14.5 | latest 8.x release |
| Android Gradle Plugin | 8.13.2 | latest 8.x (Gradle 9 needs AGP 9) |
| Kotlin (KMP + android + compose plugin) | 2.2.21 | latest 2.2.x stable |
| Compose BOM | 2025.08.00 | newest BOM fitting SDK 36 (2026.09.00 needs 37) |
| activity-compose | 1.13.0 | latest stable (needs compileSdk 36) |
| compileSdk / targetSdk | 36 | newest platform on the ops host |
| minSdk | 26 | |
| JVM target | 17 | AGP 8.x floor |

Package id `com.lakesidegames.electioneer` and product name
**Margin of Victory** are frozen (stores + entitlements key off them).

## Build

```bash
./gradlew :shared:jvmTest              # contract tests (JVM)
./gradlew :androidApp:assembleDebug    # debug APK (needs Android SDK 35)
```

iOS (macOS only):

```bash
xcodebuild -project iosApp/MOVGameiOS.xcodeproj -scheme MOVGameiOS \
  -destination 'platform=iOS Simulator,name=iPhone 16' build
```

## What was verified in the sandbox (2026-09-26)

Staging dir (this tree) was built end to end with Gradle 8.14.5, JDK 21,
and the ops-host SDK (android-36, build-tools 35.0.0):

- `:shared:jvmTest`: **6 tests, 0 failures** (`TypesTest`: all enum serials,
  optional-field defaults, two-party GameResult shape).
- `:androidApp:assembleDebug`: **BUILD SUCCESSFUL**, produced
  `androidApp-debug.apk` (9.9 MB). `aapt2 dump badging` confirms
  `package com.lakesidegames.electioneer`, launchable
  `.MainActivity`, compileSdk/target 36.
- Two scaffold bugs were found and fixed by these runs (documented so the
  next person trusts the pins, not the process): `compilerOptions` is not
  scoped inside the `android {}` block (moved to a top-level `kotlin {}`
  block), and Compose BOM 2026.09.00 forces compileSdk 37, which the host
  SDK does not have (pinned BOM 2025.08.00 + compileSdk 36 instead).
- iOS was NOT built here (no macOS on the ops host). The Xcode project +
  shared scheme are structured for the macos CI job; first green iOS build
  is a tracked follow-up issue.
- Sandbox caveat: this session could not write the repo worktree
  (`/root/projects` is read-only here), so this tree is staged for move-in
  (see below) rather than committed on `feat/kmp-scaffold`. Re-run
  `:shared:jvmTest :androidApp:assembleDebug` once after move-in.

## Types contract notes

Source: MOVGame `src/engine/types.ts` + `src/engine/system.ts`
(PartyId family) at web.pin `5647614f34fad7c05c004bf51c12040d6a9a774c`.
`web.pin` stays the single source of truth; bumping it is a reviewed change
followed by `npm run calibrate` in MOVGame.

- Closed TS unions are enums with `serial` = the exact TS string.
- `Record` -> `Map<String, …>` keyed by serial; `Partial` -> `emptyMap()`.
- `CandidateId | "tie"` winners stay `String` with `"tie"` documented;
  the Government / EventTrigger unions are sealed classes.
- `@Serializable` lands with the kotlinx.serialization wiring in Phase 2.

## Follow-ups live as GitHub issues

Every discrete Phase 1+ task discovered while scaffolding was filed on
`egg3901/MOVGame-native` (Phase 0 scaffold meta-issue tracks this tree).
Fix the worktree/branch first, then work the issues in phase order.

## Move-in (from an interactive session with repo write access)

The staging tree mirrors the repo root exactly. From the repo checkout:

```bash
git worktree add ./worktrees/kmp-scaffold -b feat/kmp-scaffold
cp -r /root/.hermes/work/kmp-scaffold/. <worktree>/
cd <worktree> && git add shared androidApp iosApp gradle \
  settings.gradle.kts build.gradle.kts gradle.properties \
  .github/workflows/kmp.yml docs/kmp-scaffold.md
git -c core.hooksPath=/dev/null commit -m \
  "feat(kmp): Phase 0 scaffold — shared module, androidApp, iosApp, CI"
./gradlew :shared:jvmTest :androidApp:assembleDebug
```

Stage explicit files only (never `git add .`): the checkout may carry
unrelated work. Do not touch `src-tauri/`, do not merge to main.
