<jsp:useBean id="id1" class="cm.itp.javabean.StudentInfo" scope="session" />

<b>SNO :: </b> <jsp:getProperty name="id1" property="sno" /> <br>
<b>SNAME :: </b> <jsp:getProperty name="id1" property="sname" /> <br>
<b>SADD :: </b> <jsp:getProperty name="id1" property="sadd" /> <br>
<b>AVG :: </b> <jsp:getProperty name="id1" property="avg" /> <br>

<b>DONE!</b>