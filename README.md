App Overview

IK Partner is a comprehensive financial services platform that enables users to become financial partners and earn commissions by selling loans, insurance, and investment products. Built with modern Android development technologies using Kotlin and Jetpack Compose.InvestKraft is a demo Android app designed using Jetpack Compose and follows a clean, modular structure.

It includes:

 Splash Screen
 Login Screen
 OTP Verification
 Bottom Navigation (Home, Leads, Scanner, Content)
 Modern Material 3 UI
 Dummy data for layout & flow testing

 Add your demo video link here:
 
 Download APK

👉 Download APK

Screenshots




(Upload images inside /screenshots/ folder and replace file names.)

 Features
 Splash Screen

Smooth entry animation

App branding and quick load

 Login Screen

Mobile number input

Clean Material UI

 OTP Verification

4/6 box OTP input

Auto-focus and smooth interaction

 Bottom Navigation

Includes Home, Leads, Scanner, Content

Material 3 bottom bar

Icon animations & highlight state

Screens Description
 Home Screen

Simple dashboard layout

Cards, stats, and quick sections

Uses placeholder dummy data

📇 Leads Screen

List of leads with status badges

Add new lead FAB

Dummy customer information

 Scanner Screen

Scanner layout UI

Camera preview placeholder

Scan/Upload button (dummy)

Content Screen

Articles or content feed

Text + image cards

Static dummy content

| Category         | Technology                 |
| ---------------- | -------------------------- |
| Language         | Kotlin                     |
| UI               | Jetpack Compose, Material3 |
| Architecture     | MVVM, StateFlow            |
| Navigation       | Navigation Compose         |
| State Management | ViewModel                  |
| Data             | Dummy JSON / Fake data     |


Project Structure
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


 Architecture
 MVVM

Clear separation of UI + logic using ViewModels.

 StateFlow

Modern reactive UI updates.

 Navigation Compose

Single-activity Compose Navigation.

 Reusable Components

Buttons, cards, text fields etc.


Dummy Data

All data in the app is fake / dummy for UI, design & testing:

Leads list

Home stats

Scanner layout

Content articles

User info

No backend is connected.

Developer

Kanhaiya Yadav
Built using Kotlin + Jetpack Compose ❤️

