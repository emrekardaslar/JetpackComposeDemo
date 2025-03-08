# JetpackComposeDemo

This is a simple Jetpack Compose app demonstrating navigation, ViewModel integration, and UI components.

## Features
- Uses Jetpack Compose for UI.
- Implements navigation between Home and Detail screens.
- Uses `ViewModel` and `StateFlow` for state management.
- Clickable messages that navigate to a detail screen.

## Screenshots
(Add screenshots here)

## Installation

### Build and Install Debug APK
To build and install the debug APK on your phone, run:
```sh
./gradlew assembleDebug
```
The APK will be available at:
```
app/build/outputs/apk/debug/app-debug.apk
```

### Build Signed APK for Release
1. Generate a keystore (if you don’t have one):
   ```sh
   keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-key-alias
   ```
2. Build the release APK:
   ```sh
   ./gradlew assembleRelease
   ```
3. The signed APK will be available at:
   ```
   app/build/outputs/apk/release/app-release.apk
   ```

## Running the App
To run the app in Android Studio:
1. Open the project in Android Studio.
2. Click **Run** ▶️ to launch the app on an emulator or a physical device.

## Project Structure
```
📦 JetpackComposeDemo
├── 📂 app
│   ├── 📂 src/main
│   │   ├── 📂 java/emre/workspace/jetpackcomposedemo
│   │   │   ├── 📂 ui/navigation  # Navigation setup
│   │   │   ├── 📂 ui/screens     # Screens (Home, Detail)
│   │   │   ├── 📂 ui/components  # Reusable UI components
│   │   │   ├── 📂 viewmodel      # ViewModels
│   │   │   ├── 📂 data/model     # Data models
├── 📜 build.gradle.kts          # Build script
├── 📜 settings.gradle.kts       # Gradle settings
```

## Dependencies
- Jetpack Compose
- Navigation Component
- ViewModel & StateFlow

## Git Ignore Configuration
Add the following to `.gitignore` to keep sensitive files out of version control:
```
# Android
*.iml
/.gradle
/local.properties
/.idea/
/build/
/captures/
/.cxx/

# Google Services
android/app/google-services.json
```

## License
This project is open-source. Feel free to modify and use it as needed.

---

