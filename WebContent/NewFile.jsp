<%@page import="model.Item"%>
<%@page import="model.GetItemInformation"%>
<%@page import="model.GetReports"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<style type="text/css">
/* The Modal (background) */
table {
  table-layout: fixed;
  width: 100%;
  border-collapse: collapse;
  border: 3px solid purple;
}

thead th:nth-child(1) {
  width: 30%;
}

thead th:nth-child(2) {
  width: 20%;
}

thead th:nth-child(3) {
  width: 15%;
}

thead th:nth-child(4) {
  width: 35%;
}

th, td {
  padding: 20px;
}

html {

  font-family: 'helvetica neue', helvetica, arial, sans-serif;
}

thead th, tfoot th {
  font-family: 'Rock Salt', cursive;
}

th {
  letter-spacing: 2px;
}

td {
  letter-spacing: 1px;
}

tbody td {
  text-align: center;
}

tfoot th {
  text-align: right;
}
.inp {
    background-color: #4CAF50;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
}
p {
 font-size:20px;
 color: blue;
}
</style>
</head>
<body>
<h2>All Match Reports (Admin WebPage)</h2>
<table border="1px">
<tr>
<td>
<p>Item-Search </p>
</td>
<td>
<p>Match Items </p>
</td>
</tr>
<% 
GetReports getReports =new GetReports();
HashMap<Integer,ArrayList> map;
map =getReports.getReport();
//out.println(map);
	for(Integer i :map.keySet())
	{
		%>
	
	<tr>
	<td>
	<%GetItemInformation getItemInformation =new GetItemInformation(i);
	Item item =getItemInformation.getinfo(); %>
	<br/>
	<img src="<%=item.getImg()%>"  width="150" height="200"/>
	 <br/>
	 <%--
	 
	  <%
	out.println("userid "+ item.getUserId());
    %>
    <br/>
    <%
	out.println("Type "+ item.getType());
	%>
	 <br/>
	 <%
	out.println("imageid "+ i);
	 %>
	 <br/> 
	  --%>
	 
	
	 <%
	 int user_id=0;
	 String info="";
	 if(item.getInfo() != null)
	 {
		 out.println("Information "+ item.getInfo());
		 info=item.getInfo();
	 }
	
	 if(item.getType()==1)
	 {
		 user_id=item.getUserId();
	 }
	 %>
	
	</td>	
	<%
	ArrayList<Integer> arr=(ArrayList)map.get(i);
	for(Integer j :arr)
	{
		%>
		<td>
	<%getItemInformation =new GetItemInformation(j);
	item =getItemInformation.getinfo(); %>
	<img src="<%=item.getImg()%>"  width="100" height="100"/>
	 <br/>
	 <%-- <%
	out.println("userid "+ item.getUserId());
    %>
    <br/>
    <%
	out.println("Type "+ item.getType());
	%>
	 <br/>
	 <%
	out.println("imageid "+ j);
	 %> --%>
	 <%
	 if(item.getInfo()!=null)
	 {info=item.getInfo();
	 out.println("Information "+ item.getInfo());
	 }
	 if(item.getType()==1)
		
		 user_id=item.getUserId();
	 %>
	 <br/>

     <br/>
     <form action="ConfirmMatch" method="POST">
     <p>Insert security information</p>
      <input style="" type="text" name="info">
      <br/>
     <input type="hidden" name="search_id" value=<%=i %>>
     <input type="hidden" name="found_id" value=<%=j%>>
     <input type="hidden" name="user_id" value=<%=user_id %>>
     <br/>
     <input class="inp" type="submit" value="Confirm">   
     </form>
     <form action="DeleteMatch" method="POST">
     <input type="hidden" name="search_id" value=<%=i %>>
     <input type="hidden" name="found_id" value=<%=j%>>
     <input class="inp" type="submit" value="Delete">   
     </form>

	</td>	
		<%}%>
	</tr>
<% 	} %>
</table>
</body>
</html>