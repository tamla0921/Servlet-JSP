<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Book Output</title>
</head>
<body>
    책제목 : ${book.title} <br>
    <!-- ((BookBean)request.getAttibute("book")).getTitle(); -->
    책저자 : ${book.author} <br>
    <!-- ((BookBean)request.getAttibute("book")).getAuthor(); -->
    출판사 : ${book.publisher}
    <!-- ((BookBean)request.getAttibute("book")).getPublisher(); -->
    
    <!-- EL 구문으로 속성 값을 찾을 경우, request, session, application 순으로 속성을 찾음. -->
    <!-- request.getAttribute("book"), session.getAttribute("book"), application.getAttribute("book") -->
    <!-- 추출된 정보가 있으면 추출된 정보를 원래 등록된 객체의 타입으로 캐스팅, 그 다음은 진행하지 않음. -->
    <!-- 여기서 ${book} 명령문은 (BookBean)request.getAttribute("book")으로 동작. -->
</body>
</html>