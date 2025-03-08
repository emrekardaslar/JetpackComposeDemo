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
- Remote Config


## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/emrekardaslar/JetpackComposeDemo.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle and build the project.

## Remote Config
Remote Config allows you to remotely configure certain aspects of your app without requiring an update.

### Downloading `google-services.json`
To use Remote Config, you need to download the `google-services.json` file:
1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Select your project.
3. Navigate to **Project Settings** > **General**.
4. Scroll down to **Your apps** and select the correct app.
5. Click **Download google-services.json**.
6. Place the downloaded file inside `app/` directory of your project.

### Using Remote Config
1. Add Firebase dependencies in `build.gradle.kts`:
   ```kotlin
   dependencies {
       implementation("com.google.firebase:firebase-config-ktx:21.3.0")
   }
   ```
2. Initialize Remote Config in your ViewModel or Application class:
   ```kotlin
   val remoteConfig = Firebase.remoteConfig
   remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
       if (task.isSuccessful) {
           val myValue = remoteConfig.getString("your_config_key")
       }
   }
   ```

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

