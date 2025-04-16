# 📘 Media Tracker Backend

A personal media tracking app backend built with Spring Boot.  
Inspired by **Letterboxd** + **Goodreads**, but supports **movies, shows, games, anime, manga, books** — all in one place.  
*(We're skipping comics/manga boys — only books + movies + games)*

---

## 🌟 Vision and Intended Flow

The app lets users **search**, **view**, and **log media** they've consumed.

---

## 🔁 Actual User Flow

1. **User registers or logs in** (auth to be added)

2. On homepage:

   - Clicks **"Log Media"**
   - _or_ starts typing in the **search bar**

3. Search triggers **Global Catalog check**:
   - Frontend queries `GET /api/catalog/all` (or performs a search)
   - ✅ If media exists → details (poster, title, etc.) are returned
   - ❌ If not → a **public API** call is made (e.g. TMDB), info fetched, saved to Global Catalog table, and then returned

   ✅ So next time no external API call is needed.

4. On selecting a media:
   - A **Media Detail Page** opens (poster, year, description, etc.)
   - User clicks **“Log Media”** → modal opens

5. User logs the media:
   - Fills fields like status, rating, current/total progress, etc.
   - Backend saves the log entry in `MediaItem` table, linked to the `User`

6. On the **User Profile page**:
   - All logged media shown (segmented: watching, completed, etc.)
   - Top 4 favorite media also shown

---

## 🧩 Schema Overview

```java
// 🧍 User.java
User {
  Long id;
  String username;
  String email;
  String passwordHash;
  LocalDateTime createdAt;
}

// 🎞 MediaItem.java (user-specific logs)
MediaItem {
  Long id;
  String title;
  String mediaType;
  String status; // watching, completed, etc.
  int currentProgress;
  int totalProgress;
  int rating;
  boolean liked;
  User user; // ManyToOne
  LocalDateTime createdAt;
}

// 🌐 GlobalMedia.java (shared global catalog)
GlobalMedia {
  Long id;
  String title;
  String type; // movie, show, game, etc.
  // Can be extended later to include imageURL, release year, etc.
}
```

---

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- H2 (in-memory) and MySQL (Docker-ready)
- Postman (for API testing)

---

## 📦 Package Structure

```bash
com.mediatrack.app
├── controller
│   ├── UserController
│   ├── MediaController
│   └── GlobalMediaController
│
├── model
│   ├── User
│   ├── MediaItem
│   └── GlobalMedia
│
├── repository
│   ├── UserRepository
│   ├── MediaItemRepository
│   └── GlobalMediaRepository
│
├── service
│   ├── interfaces
│   └── implementations
│
├── config               # Optional (Spring Security)
└── AppApplication.java  # Main entrypoint
```

---

## 🌐 API Endpoints

### 🔹 Users

- `POST /api/users/add` — Add new user
- `GET /api/users/all` — Get all users

### 🔹 Media (logged by user)

- `POST /api/media/add` — Add entry for user
- `GET /api/media/all` — View all logged media
- `GET /api/media/user/{userId}` — Media by user
- `GET /api/media/{id}` — Get media by ID
- `PUT /api/media/update` — Update entry

### 🔹 Global Media (search catalog)

- `POST /api/catalog/add` — Add to global catalog
- `GET /api/catalog/all` — View full catalog

---

## 📌 Example Use Case

- Username: `painofboredom`
- Searches: `"The Matrix"`

→ Not found in global catalog → backend hits public API → saves to global  
→ User clicks “Log Media” and fills the form  
→ Media entry saved in `MediaItem` with `User ID = 1`  
→ Entry shows up in user’s media list → `GET /api/media/user/1`

---

## 🧭 Roadmap

- 🔐 Add Spring Security + JWT login
- 🌍 Integrate TMDB, IGDB, RAWG for real-time metadata
- 🔍 Smart search suggestions
- 📺 Full media detail views
- ❤️ Favorite feature on media items
- 📊 Dashboard + analytics
- 🚀 Deploy on Render / Railway

---

```