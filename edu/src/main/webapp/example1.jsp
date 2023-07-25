<html>
<body>
    <%
        String user = request.getParameter("name");
        if (user == null)
            user = "Guest";
    %>
    
    <h1>
        hello
        <%=user%>!
    </h1>
</body>
</html>