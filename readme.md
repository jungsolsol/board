# 프로젝트 명세서

# 1. 아이템 선정

축구 커뮤니티 crud게시판 

# 2.개요

* 프로젝트 명칭 : soccer community 
* 2인(개인) 프로젝트
* 개발기간 2022 08 19 ~
* 기능
  * 게시판 - CRUD, Paging, 조회수, 검색기능
  * 사용자 - 회원가입, 로그인 , 네이버 + 카카오 api 로그인, 회원 정보 수정기능, 유효성 검사 중복 검사
  * 댓글 - CRUD
* 개발 언어 : Java 11 + Python 3.8
* 개발 환경 : springboot + jpa + (security) 
* db : Mysql
* 형상관리 : git

# 3. 요구 사항 분석

## 1. 회원가입 

* 유효성 검사
  * 세부사항 작성
* 중복 확인

## 2. 로그인

* 권한에 따른 페이지 이용 
  * 로그인시 이용가능 페이지
    * 세부사항 작성
  * 비 로그인시 이용가능 페이지
    * 세부사항 작성
  * 관리자로 로그인시 이용가능 페이지
    * 세부사항 작성
* 유효성 검사
  * 세부사항 작성
* 소셜 로그인 기능
  * 세부사항 작성

## 3. 회원 정보 수정

* 세부사항 작성

## 4. 게시글

* 게시글 유효성 검사
  * @Validated을 활용한 게시글 유효성검사
* 게시글 업로드 기능 
  * 세부사항 작성
* 게시글 조회수 기능
  * /api/post/{id}로 값을 조회시 조회수 증가
## 5. 댓글

#### (댓글 api는 Ajax로 비동기 구현예정)

* 댓글 유효성 검사
  * 세부사항 작성
* 댓글 비동기처리
  * 세부사항 작성 

# 4. DB 설계

# 5. API설계
# 게시판 API
#### 업로드 기능
* POST /api/post
#### 업데이트 기능
* PUT /api/post/{id}
#### 조회기능
* 전체 조회
  * GET /api/board/post 
* 아이디 조회
  * GET /api/post/{id}
* 유저이름 조회
  * GET /api/post/author/{author}
#### 검색기능
* GET /api/post/search
#### 삭제기능
* DELETE /api/post/delete/{id}
#### 파일업로드 기능
* POST /api/post/upload
#### 파일다운로드 기능
* GET /api/post/download/{fileName:.+}

# 댓글 API
