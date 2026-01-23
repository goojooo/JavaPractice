<jsp:useBean id="emp" class="com.itp.beans.Employee" scope="request" />

<jsp:setProperty name="emp" property="*" />


<jsp:useBean id="service" class="com.itp.service.PaySlipGeneratorService" scope="application" />

<%
service.generatePaySlip(e);
%>

