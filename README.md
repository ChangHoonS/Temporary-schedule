# ✅ Readme

## Skilled-Schedule-Project

## API 명세서

| Description | HTTP Method | URL | Path Variable | Request Body(dto) | Respnse | 상태 |
|----|-------------|-----|---------------|-------------------|---------|------|
| 일정 생성 | POST | /schedules | X | {<br> "user_name": String,<br> "e_mail": String,<br> "title": String,<br> "task": String,<br>} | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 목록 조회 | GET | /schedules | ? | X | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 단건 조회 | GET | /schedules/{id} | id_(Long) | X | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 수정 | PUT | /schedules/{id} | id_(Long) | {<br> "user_name": String,<br> "e_mail": String,<br> "title": String,<br> "task": String,<br>} | {<br> "id": Long,<br> "user_name": String,<br> "title": String,<br> "task": String,<br> "created_date": String,<br> "edited_date": String <br>} | 200: OK |
| 일정 삭제 | DELETE | /schedules/{id} | ? | X | X | 200: OK |

<br>
**ERD 링크**<br>
ERD URL : https://www.erdcloud.com/d/ux29fWhQDASoxBRJd <br>

### 프로젝트 소개
Spring JPA를 활용하여 일정 관리 앱을 만드는 프로젝트입니다.

### 개발기간
- 2025.03.26(수) ~ 2025.04.04(금)

### 개발 내용
- 필수 과제 Lv0 ~ Lv3
- Lv4는 진행했지만 완료하지는 못함
- 한번에 개발 진행하지 않고 Lv1 부터 Lv3까지 차근차근 만들면서 리펙토링
- 각각 일정과 유저의 CRUD를 개발하고 유저 필드에 Password까지 만듬
- Base Entity 생성으로 상속하도록 만듬 (작성일, 수정일 자동부여) 

- #### Lv.0
  - ReadMe에 API명세 작성과 ERD 링크 첨부
 
- #### Lv.1
  - 일정 Entity에 필요한 필드 생성
  - JPA Auditing 활용하여 상속 부여
  - 기본적인 일정 CRUD 작성
 
- #### Lv.2
  - 유저 Entity에 필요한 필드 생성
  - JPA Auditing 활용하여 상속 부여
  - 기본적인 유저 CRUD 작성
  - 일정 필드에 연관관계를 적용하여 유저 고유 식별자인 유저 id를 부여
 
 - #### Lv.3
   - 유저 필드에 비밀번호 속성 추가
   - 비밀번호 속성을 추가하면서 미리 개바했던 코드들에 필요에 따라 비밀번호를 추가해봄
   - 생성 및 조회에서 설정은하되 POSTMAN으로 호출해도 보이지않게 설정
   - 유저 정보 변경에 비밀번호는 변경되지않게 설정하고 비밀번호 설정 변경을 따로 생성
  
