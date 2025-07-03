# BookCollection

BookCollection is an Android application designed for students to browse, access, and read academic books semester-wise. The app includes a secure login system, OTP-based verification, and a user-friendly interface to explore and download books categorized by engineering branch and semester.

---

## Features

- **User Authentication**
  - Login, forgot password, and OTP-based mobile number verification.
  - Secure password reset functionality.

- **Branch & Semester Selection**
  - Dynamic UI to select branch (e.g., CSE, ECE) and corresponding semesters.
  - Loads relevant subjects and book lists.

- **Book Access**
  - View academic books as PDFs in grid layout.
  - Download or read directly within the app using an integrated PDF viewer.

- **OTP System**
  - 6-digit OTP sent for verification.
  - Expires after 1 minute with retry option.
  - Password can only be reset after OTP verification.

---

## Tech Stack

- **Language:** Java  
- **UI Layout:** XML  
- **PDF Viewer:** AndroidPdfViewer or similar library  
- **Database:** SQLite or Firebase (optional)  
- **OTP Logic:** Custom backend or simulated logic (no Firebase required)

---

## Project Structure

BookCollection/
├── app/
│ └── src/main/
│ ├── java/com/yourpackage/
│ │ ├── SplashActivity.java
│ │ ├── LoginActivity.java
│ │ ├── OTPVerificationActivity.java
│ │ ├── BookGridActivity.java
│ │ ├── BookViewerActivity.java
│ │ └── ... (other activities)
│ ├── res/
│ ├── assets/
│ │ └── (PDF files if included)
│ └── AndroidManifest.xml
