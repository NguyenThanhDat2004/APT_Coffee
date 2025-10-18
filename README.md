# ☕ APT Coffee – Smart Café Management App

<p align="center">
  <img src="https://github.com/user-attachments/assets/034bf6de-db0a-4c17-9306-e9227bcbade7" width="300" alt="APT Coffee Logo">
</p>

<p align="center">
  <strong>An Android-based café management system designed to simplify daily operations — from order handling to employee and revenue management.</strong>
</p>

---

## 🚀 Overview

**APT Coffee** is an all-in-one café management application built for Android.
It helps administrators and staff efficiently manage **menu items, orders, employees, and sales** — all in one intuitive interface.

With a clean design and optimized navigation, the app ensures smooth operation even during rush hours.

---

## ✨ Core Features

### 🧾 1. Order Management

* Manage **open and completed orders**.
* Add or remove items from tables in real time.
* Generate and view **invoices (ChiTietHoaDonActivity, HoaDonActivity)**.

---

### 🧍 2. Employee Management

* Add, update, and view employee details (**ThemNhanVienActivity**, **CapNhatNhanVienActivity**, **ChiTietNhanVienActivity**).
* Manage employee accounts and access levels.

---

### 🍰 3. Menu & Inventory

* Add new food and beverage items (**ThemMonActivity**, **ThemHangHoaActivity**).
* Update existing menu categories (**SuaLoaiActivity**, **ThemLoaiActivity**, **LoaiThucUongActivity**, **ThucUongActivity**).
* Track stock levels and restock efficiently.

---

### 💰 4. Revenue & Reports

* Access daily or monthly **revenue statistics** via **DoanhThuActivity**.
* View performance reports and analyze sales trends.

---

### ⚙️ 5. Account & Settings

* Manage user profiles (**ThietLapTaiKhoanActivity**).
* Change passwords (**DoiMatKhauActivity**).
* Sign up and log in (**SignUpActivity**, **SignInActivity**).

---

### 📞 6. Support & Contact

* Built-in contact page (**LienHeActivity**) for user feedback and assistance.

---

## 🧩 Tech Stack

| Component        | Description                          |
| ---------------- | ------------------------------------ |
| **Language**     | Java / Kotlin                        |
| **Framework**    | Android SDK                          |
| **Architecture** | MVVM (Model–View–ViewModel)          |
| **UI Design**    | XML-based Layouts, Material Design   |
| **Database**     | SQLite / Room (local storage)        |
| **Min SDK**      | Android 8.0 (API Level 26) or higher |

---

## 🛠️ Permissions

The app requests the following permissions for functionality:

* `READ_EXTERNAL_STORAGE` – for reading images or menu data.
* `CALL_PHONE` – to enable quick customer support calls.

---

## ▶️ How to Run

1️⃣ **Clone the Repository**

```bash
git clone https://github.com/NguyenThanhDat2004/APT-Coffee-App.git
cd APT-Coffee-App
```

2️⃣ **Open in Android Studio**

* Open the project folder.
* Let Gradle sync automatically.

3️⃣ **Build & Run**

* Connect a device or start an emulator.
* Press ▶️ “Run” to launch **APT Coffee**.

---

## 👨‍💻 Activities Structure

| Activity                                   | Purpose             |
| ------------------------------------------ | ------------------- |
| `SplashActivity`                           | Launch screen       |
| `MainActivity`                             | Dashboard / Home    |
| `SignInActivity`, `SignUpActivity`         | Authentication      |
| `OderActivity`                             | Ordering screen     |
| `HoaDonActivity`, `ChiTietHoaDonActivity`  | Invoices            |
| `NhanVienActivity`, `ThemNhanVienActivity` | Employee management |
| `ThucUongActivity`, `LoaiThucUongActivity` | Menu management     |
| `DoanhThuActivity`                         | Revenue statistics  |
| `ThietLapTaiKhoanActivity`                 | Account settings    |
| `LienHeActivity`                           | Contact / support   |

---

## 📜 License

This project is licensed under the **MIT License**.
See the [`LICENSE`](LICENSE) file for more details.

---

<p align="center">⭐ If you find this project helpful, please give it a <b>Star</b> to support development!</p>
