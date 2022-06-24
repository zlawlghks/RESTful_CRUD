# RESTful_CRUD
<br>
상세 조회 / 목록 조회 / 생성 / 수정 / 삭제 기능을 가진 게시판
<br>
h2, lombok, jpa, web 사용

---
2022.06.22
<br>
- 회원 추가, 기능은 생성, 수정, 삭제, 조회(전체, 상세)로 동일
- ResponseDto, RequestDto, EntityClass 나눠서 데이터 전달
- 기존 게시글 삭제, 새로운 게시글(Board) 추가, 전체적인 코드 수정
- 게시글회원과 동일하게 DTO 나눠서 데이터 전달
- 회원, 게시글 생성, 수정 시간 추가 
---
2022.06.23
<br>
- BoardService에 전체 조회, 삭제 부분 ResponseDto로 변경
---
2022.06.24
<br>
- UsersController, BoardController ResponseEntity 수정
- 회원, 게시글 서비스, 컨트롤러 추가 (BoardByUserService, BoardByUserController)
- 회원이 생성한 게시글, 회원이 생성한 게시글 조회 기능
