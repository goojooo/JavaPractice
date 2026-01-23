<jsp:useBean id="id1" class="cm.itp.javabean.StudentInfo" scope="session" />

<jsp:setProperty name="id1"  property="sno"  value="101"/>
<jsp:setProperty  name="id1" property="sname" value="Nayan"/>
<jsp:setProperty  name="id1" property="sadd" value="Nagpur"/>
<jsp:setProperty  name="id1" property="avg" value="201"/>

<b>Values are set in java bean properties</b>