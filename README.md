# Spring-Web-Board

[Spring]게시판 입니다.

Heroku로 호스팅 된 주소는 https://ts-spring-web-board.herokuapp.com/ 입니다.

----------
![Alt text](/spring-project-main.png)

처음 들어가실때 시간이 조금 소요됩니다.

< java >

[ Controller ]
  - MemberController.java (회원관련 컨트롤러)
  - BoardController.java (게시판&댓글 컨트롤러)

[ Service ]
  - member
    - MemberService.java (MemberService 인터페이스)
    - MemberServiceImpl.java (컨트롤러에서 매개변수를 받고 DAO를 호출하여 비지니스 로직을 처리)
  - board
    - BoardService.java (BoardService 인터페이스)
    - BoardServiceImpl.java (컨트롤러에서 매개변수를 받고 DAO를 호출하여 비즈니스 로직을 처리)
  - reply
    - ReplyService.java (ReplyService 인터페이스)
    - ReplyServiceImpl.java (컨트롤러에서 매개변수를 받고 DAO를 호출하여 비지니스 로직을 처리)
    
[ Dao ]
  - member
      - MemberDao.java (MemberDao 인터페이스)
      - MemberDaoImpl.java (DB에 접근해 데이터 처리)
  - board
      - BoardDao.java (BoardDao 인터페이스)
      - BoardDaoImpl.java (DB에 접근해 데이터 처리)
  - reply
      - ReplyDao.java (ReplyDao 인터페이스)
      - ReplyDaoImpl.java (DB에 접근해 데이터 처리)
      
[ Domain ]
  - member
    - MemberVO.java (DB의 레코드의 데이터를 매핑하기위한 Member데이터 객체)
  - board
    - BoardVO.java (DB의 레코드의 데이터를 매핑하기위한 Board데이터 객체)
  - reply
    - ReplyVO.java (DB의 레코드의 데이터를 매핑하기위한 Reply데이터 객체)
    
[ Intercepter ]
  - AuthenticationInterceptor.java (페이지 접근시 로그인 인증을 위한 컨트롤러)
  
[ Validator ]
  - MemberValidator.java (Validator 인터페이스를 상속받아 회원가입시 서버측에서 폼값 검증을 위한 클래스)
  - MemberUpdateValidator.java (Validator 인터페이스를 상속받아 회원정보 수정시 서버측에서 폼값 검증을 위한 클래스)
  
  ---------------
< javascript >

  sign_up.js (회원 가입시 프론트에서 폼값의 유효성 검사 with ajax)
  modify_member.js (회원 정보 수정시 프론트에서 폼값의 유효성 검사 with ajax)
  
-------------------------  

< jsp >

[ webapp/view ]

  - home.jsp
  - board
    - list_board.jsp (게시판리스트 뷰)
    - update_board.jsp (게시글 수정 뷰)
    - view_board.jsp (게시글 자세히보기 뷰)
    - write_board.jsp (게시글 작성 뷰)
  - member
    - change_password.jsp (비밀번호변경폼 뷰)
    - delete_member.jsp (회원탈퇴폼 뷰)
    - login.jsp (로그인폼 뷰)
    - modify_member.jsp (회원정보수정 폼 뷰)
    - mypage.jsp (마이페이지 뷰)
    - sign_up.jsp (회원가입 폼 뷰)
  - common
    - errorPage.jsp (에러페이지 뷰)
