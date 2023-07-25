<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
</head>
<body>
    <%
    int total = out.getBufferSize();
    // 자바 언어는 출력스트림을 이용해 외부로 데이터를 출력할 때 버퍼를 이용.
    // getBufferSize(): 기본 버퍼의 크기를 추출하는 메서드.
    out.print("첫번째 텍스트입니다.");
    out.clearBuffer();
    // clearBuffer(): 버퍼에 있는 내용을 삭제하는 메서드.
    // "첫번째 텍스트입니다" 문자열은 실제 전송되지 않고 버퍼에 있음.
    // 버퍼에 있는 상태에서 clearBuffer() 메서드가 실행됐으므로 실제 전송이 이루어지지 않고 삭제 됨.
    out.print("출력 버퍼의 크기 : " + total);
    out.print("<br>사용되지 않은 버퍼의 크기 : " + out.getRemaining());
    // getRemaining() 메서드는 버퍼의 전체 크기에서 남은 용량을 추출.
    out.flush();
    // flush() 메서드는 버퍼에 있는 내용을 강제로 전송. 버퍼가 꽉 차있는지(full)와 상관없이 버퍼의 내용을 전송.
    out.print("<br>flush 후 버퍼의 크기 : " + out.getRemaining());
    // 버퍼에 남은 것이 없으므로 버퍼의 전체 크기와 일치.
    %>
    
    <hr>
    <h3>out.print() 메서드</h3>
    
    <%
    out.print(100);
    out.print(true);
    out.print(3.14);
    out.print("TEST");
    out.print('가');
    out.print(new java.io.File("\\"));
    out.print("버퍼의 크기:"+out.getRemaining());
    %>
</body>
</html>