# IK Partner – Financial Partner Demo App

IK Partner is a comprehensive financial services platform that enables users to become financial partners and earn commissions by selling loans, insurance, and investment products.

This project is built using **Kotlin + Jetpack Compose** and follows a clean, modular structure. All displayed data is **dummy data** for UI and flow demonstration.

---

## App Overview

This demo application includes:

* Splash Screen
* Login Screen
* OTP Verification
* Bottom Navigation (Home, Leads, Scanner, Content)
* Modern Material 3 UI
* Dummy data for design & testing

---

## Demo Video

*Add your demo video link here*

```
https://github.com/yourusername/IKPartner/demo/video.mp4
```

---

## Download APK

👉 **Download APK**

```
https://github.com/yourusername/IKPartner/releases/download/v1.0/app-debug.apk
```

---

## Screenshots

(Upload images inside `/screenshots/` folder and replace file names.)

| Splash                      | Login                      | OTP                      |
| --------------------------- | -------------------------- | ------------------------ |
| ![](screenshots/splash.png) | ![](screenshots/login.png) | ![](screenshots/otp.png) |

| Home                      | Leads                      | Scanner                      | Content                      |
| ------------------------- | -------------------------- | ---------------------------- | ---------------------------- |
| ![](screenshots/home.png) | ![](screenshots/leads.png) | ![](screenshots/scanner.png) | ![](screenshots/content.png) |

---

# Features

### Splash Screen

* Smooth entry animation
* Branding + fast loading

### Login Screen

* Mobile number input
* Clean Material UI

### OTP Verification

* 4/6 digit OTP input
* Auto-focus + smooth interaction

### Bottom Navigation

* Home
* Leads
* Scanner
* Content
* Material 3 UI
* Active/Inactive icon animations

---

# Screens Description

### Home Screen

* Dashboard-style layout
* Cards, stats, and quick sections
* Placeholder dummy values

### Leads Screen

* List of leads with status badges
* Add new lead using FAB
* Dummy customer data

### Scanner Screen

* Scanner layout UI placeholder
* Camera preview box
* Dummy Scan/Upload button

### Content Screen

* Articles/content feed
* Text + image cards
* Static dummy content

---

## Tech Stack

| Category         | Technology                 |
| ---------------- | -------------------------- |
| Language         | Kotlin                     |
| UI               | Jetpack Compose, Material3 |
| Architecture     | MVVM, StateFlow            |
| Navigation       | Navigation Compose         |
| State Management | ViewModel                  |
| Data             | Dummy JSON / Fake data     |

---

# Project Structure

```
app/
 ├── ui/
 │    ├── splash/
 │    ├── login/
 │    ├── otp/
 │    ├── home/
 │    ├── leads/
 │    ├── scanner/
 │    ├── content/
 │    └── components/
 │
 ├── navigation/
 │    ├── NavGraph.kt
 │    └── BottomNav.kt
 │
 ├── data/
 │    ├── dummy/
 │    ├── model/
 │
 ├── viewmodel/
 │
 └── MainActivity.kt
```

---

# Architecture

### MVVM

* Separation of UI + business logic using ViewModels

### StateFlow

* Modern reactive UI updates

### Navigation Compose

* Single-activity architecture
* Smooth transitions

### Reusable Components

* Cards, text fields, buttons, containers

---

# Dummy Data

All data used in this project is **fake/dummy** for UI, design, and flow testing:

* Leads list
* Home stats
* Scanner preview
* Content feed
* User info

No backend or API is connected.

---

# Developer

**Kanhaiya Yadav**
Built using **Kotlin + Jetpack Compose ❤️**
