# Làm việc nhóm với Cursor – MyBooksLibrary

Tài liệu này giúp **máy mới** hoặc **thành viên nhóm** mở repo và dùng Cursor với **ngữ cảnh giống nhau** sau khi đã commit các file: `.cursor/rules/`, `AGENTS.md`, `docs/BA_Requirements.md`.

## 1. Trên máy mới – chuẩn bị

1. **Cài đặt**
   - [Cursor](https://cursor.com) (bản mới).
   - **Android Studio** hoặc ít nhất **JDK 17+** (khuyến nghị 17 hoặc 21 tùy AGP; dự án hiện compile Java 11 cho bytecode nhưng Gradle/Android cần JVM đủ mới).
   - **Git**.

2. **Clone repo**

   ```bash
   git clone <URL-repo-của-bạn> MyBooksLibrary
   cd MyBooksLibrary
   ```

3. **File local (không commit)**

   - Sau khi mở project lần đầu bằng Android Studio hoặc `./gradlew`, tạo/cập nhật `local.properties` trỏ `sdk.dir` tới Android SDK trên máy đó.

4. **Kiểm tra build**

   ```bash
   ./gradlew :app:compileDebugKotlin
   ```

   Nếu lỗi mạng lần đầu: Gradle có thể tải distribution – chạy lại khi mạng ổn định.

## 2. Mở bằng Cursor để có “context” giống team

1. **File → Open Folder** → chọn thư mục root `MyBooksLibrary` (có `settings.gradle.kts`), **không** chỉ mở thư mục `app`.

2. Cursor sẽ tự đọc:
   - **Project rules**: `.cursor/rules/*.mdc` (rule `alwaysApply` áp dụng mọi chat trong project).
   - Bạn có thể thêm rule mới trong `.cursor/rules/` khi team thống nhất quy ước.

3. **Cho Agent biết spec**
   - Trong Composer/Agent, có thể `@` file: `@docs/BA_Requirements.md` hoặc `@AGENTS.md` khi bắt đầu task lớn.
   - Hoặc mở file đó trong editor – một số workflow vẫn hữu ích khi kèm `@`.

4. **Chat vs Composer**
   - **Chat**: hỏi nhanh, giải thích.
   - **Composer / Agent mode**: sửa nhiều file, feature end-to-end – phù hợp giống flow “làm bước 2, bước 3” đã làm.

## 3. Git – commit những gì để team đồng bộ Cursor

Nên commit (đã có trong repo sau khi bạn add):

| Mục | Mục đích |
|-----|----------|
| `.cursor/rules/` | Quy ước + context dự án cho AI |
| `AGENTS.md` | Checklist ngắn cho agent |
| `docs/BA_Requirements.md` | Đặc tả BA |
| `docs/CURSOR_TEAM_WORKFLOW.md` | Hướng dẫn máy mới (file này) |

**Không** commit: `local.properties`, `.gradle/` build cache (đã ignore trong `.gitignore`).

## 4. Mẹo làm việc hiệu quả trên máy khác

- **Một task một PR/commit nhỏ** – dễ review và ít conflict Gradle.
- Khi nhờ AI implement: ghi rõ **tab / màn hình** (Discover, Search, …) và **“theo BA_Requirements.md mục X”**.
- Sau khi AI sửa: luôn chạy `./gradlew :app:compileDebugKotlin` hoặc **Build** trong Android Studio.
- Nếu thêm thư viện: chỉnh `libs.versions.toml` + `app/build.gradle.kts`, tránh version rải rác.

## 5. Khi rule lỗi thời

Cập nhật `.cursor/rules/mybooks-library.mdc` và commit – toàn team pull là đồng bộ lại ngữ cảnh AI.
