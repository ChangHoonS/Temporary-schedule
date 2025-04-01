# ✅ Readme

## API 명세서

| Description | HTTP Method | URL | Path Variable | Request Body(dto) | Respnse | 상태 |
|----|-------------|-----|---------------|-------------------|---------|------|
| 일정 생성 | POST | /schedules | X | {<br> "user_name": String,<br> "e_mail": String,<br> "title": String,<br> "task": String,<br> "password": String<br>} | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "password": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 목록 조회 | GET | /schedules | ? | X | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "password": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 단건 조회 | GET | /schedules/{id} | id_(Long) | X | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "password": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 수정 | PUT | /schedules/{id} | id_(Long) | {<br> "user_name": String,<br> "e_mail": String,<br> "title": String,<br> "task": String,<br> "password": String<br>} | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "password": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 삭제 | DELETE | /schedules/{id} | ? | X | X | 200: OK |

초기 API 명세 임시 설정

ERD URL : https://www.erdcloud.com/d/ux29fWhQDASoxBRJd

ERD 링크 임시 첨부
