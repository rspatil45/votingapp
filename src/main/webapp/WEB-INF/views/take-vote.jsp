<%--old uri : <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Voting App</title>
</head>
<body>
  <div align="right">Hi ${student.studentName}</div>
  <h1 align="center" style="color: blue">Please record your vote</h1>
  <h2>Vote for one of the below candidate : </h2>
  <c:forEach var="candidate" items="${candidateList}">
    Vote For : <a href="/submitVote/${candidate.candidateId}">${candidate.candidateName}</a>
      <br>
  </c:forEach>

</body>
</html>