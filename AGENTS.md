# AGENTS.md – Hướng dẫn cho AI / Cursor Agent

Dự án **MyBooksLibrary**: app đọc truyện **local-first**, gọi **MangaDex API**, lưu thư viện bằng **Room**.

## Đọc trước khi code

- `docs/BA_Requirements.md` – nguồn truth cho tab, entity, luồng Auth / Main / Detail / Reader.

## Kiến trúc nhanh

| Layer | Vị trí | Ghi chú |
|--------|--------|---------|
| UI | `app/.../ui/` | Screens, `navigation`, `theme`, `viewmodel` |
| Domain | `app/.../domain/model/` | `MangaModel`, … (không Android) |
| Data local | `app/.../data/local/` | Room entities, DAO, `AppDatabase` |
| Data remote | `app/.../data/remote/` | `MangaDexApi`, `NetworkModule`, DTO `models/` |
| Repository | `app/.../data/repository/` | `MangaRepository`, `LibraryRepository`, … |

## MangaDex

- Base API: `https://api.mangadex.org/` (đã cấu hình trong `NetworkModule`).
- List manga Discover: `GET /manga` với `includes[]=cover_art`.
- Cover URL: helper trong `data/remote/models/MangaDtos.kt` – `extractCoverUrl()` / `toDomainModel()`.

## Gradle

- Catalog: `gradle/libs.versions.toml`.
- Room dùng **KSP**; nếu build báo lỗi Kotlin source sets + KSP, kiểm tra `gradle.properties`.

## Mở rộng an toàn

- Thêm endpoint: `MangaDexApi` + DTO + map sang domain model + `MangaRepository` (hoặc repo mới).
- Thêm màn hình: route trong `MainNavGraph.kt` hoặc nested graph sau này.
- Auth / DataStore: chưa bắt buộc trong skeleton; làm theo mục A trong BA.
