<%
    RequestDispatcher rd = application.getContext("/testsuite").getRequestDispatcher("/test_session.jsp");
    rd.forward(request, response);
%>