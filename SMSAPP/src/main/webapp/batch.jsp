<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>


                 <div class="d-flex justify-content-center align-center"> 
 
            <div class="w-50 align-middle border border-info  border-3 mt-2" 
               style="height: 500px">
               <h6 class="p-3 text-primary "> 
    <u>Instalment Details :-</u> 
   </h6> 
 
   <div class="border border-secondary m-3 p-2"> 
    
      <table class="table table-hover border border-secondary "> 
      <tbody> 
         <tr class="table-primary fs-6"> 
           <th>Student Id</th> 
           <td>${st.studentId}</td> 
         </tr> 
           <tr class="table-primary fs-6"> 
           <th>Student Name</th> 
           <td>${st.studentFullName}</td> 
        
           <tr class="table-primary fs-6"> 
           <th>Course Name</th> 
           <td>${st.studentCourse}</td> 
         </tr> 
        
           </tr> 
           <tr class="table-danger fs-6"> 
           <th>Fees Paid</th> 
           <td>${st.feesPaid}</td> 
         </tr> 
          
      </tbody> 
      </table> 
   
        <form action="batchshift"> 
        <input type="text" name="studentid" value="${st.studentId}" hidden="true"> 
        <div class="bg-dark p-2  d-flex justify-content-between"> 
        <select name="batchNumber">
        <c:forEach items="${data}" var="s">
        
        <option value="${s.batchNumber}">${s.batchNumber}</option>
        </c:forEach>
       
        
         </select>
        </div> 
         <div class="d-flex justify-content-center pt-5"> 
        <button class="btn btn-success btn-sm ">Shift Batch</button> 
        </div> 
        </form> 
   
     </div> 
  </div> 
 
 
 
 </div>
</body>
</html>