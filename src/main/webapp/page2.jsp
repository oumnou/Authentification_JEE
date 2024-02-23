<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
  // Create a Date object for the current date and time
  Date currentDate = new Date();

  // Create a SimpleDateFormat object to format the date
  SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

  // Format the current date
  String formattedDate = dateFormat.format(currentDate);
%>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    // Check if the cookie indicating user login is present
    boolean isLoggedIn = false;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loggedIn") && cookie.getValue().equals("true")) {
                isLoggedIn = true;
                break;
            }
        }
    }

    // If user is not logged in, redirect to login page
    if (!isLoggedIn) {
        response.sendRedirect("index.jsp");
        return; // Ensure no further content is processed
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	
	
</head>
<body>
<!-- Section: Design Block -->
<section class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col text-center mb-5">
          
           <h1 class="display-4 font-weight-bolder">Welcome ${sessionScope.user.username} !</h1>
    <p class="lead">Feel Free </p>
        </div>
      </div>
    <div class="row justify-content-center">
      
      <div class="col-sm-12 col-md-6 col-lg-4 mb-12 ">
        <div class="card text-dark align-middle card-has-bg click-col" style="background-image:url('https://source.unsplash.com/600x900/?tree,nature'); width: 500px;">
                 <img class="card-img d-none" src="https://source.unsplash.com/600x900/?tree,nature" alt="Creative Manner Design Lorem Ipsum Sit Amet Consectetur dipisi?">
          <div class="card-img-overlay d-flex flex-column">
           <div class="card-body">
              <small class="card-meta mb-2">${sessionScope.user.name} ${sessionScope.user.lastName}</small>
              <h4 class="card-title mt-0 ">${sessionScope.user.email} </h4>
              <h5 class="card-text mt-3 m-34 ">Be yourself  everyone else is already taken ... Oscar Wilde</h5>

             <small><i class="far fa-clock"></i> <%= formattedDate %></small>
            </div>
            <div class="card-footer text-center">
              <a href="servlet" style="color: inherit; text-decoration: none;"><svg xmlns="http://www.w3.org/2000/svg" width="46" height="46" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"/>
                <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z"/>
              </svg></a>
            </div>
          </div>
        </div>
    </div>
  </div>
    
  </div>
  </section>
  
  <!-- Section: Design Block -->
<style>
    body{
/* Created with https://www.css-gradient.com */
background: #ffffff;
}
h1{
  color:#33a8c5;
}
.lead{
  color:#aaa;
}

.wrapper{margin:4vh}

.card{
  border: none;
  transition: all 500ms cubic-bezier(0.19, 1, 0.22, 1);
  overflow:hidden;
  border-radius:20px;
  min-height:450px;
   box-shadow: 0 0 12px 0 rgba(0,0,0,0.2);

 @media (max-width: 768px) {
  min-height:350px;
}

@media (max-width: 420px) {
  min-height:300px;
}

 &.card-has-bg{
 transition: all 500ms cubic-bezier(0.19, 1, 0.22, 1);
  background-size:120%;
  background-repeat:no-repeat;
  background-position: center center;
  &:before {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: inherit;
    -webkit-filter: grayscale(1);
  -moz-filter: grayscale(100%);
  -ms-filter: grayscale(100%);
  -o-filter: grayscale(100%);
  filter: grayscale(100%);}

  &:hover {
    transform: scale(0.98);
     box-shadow: 0 0 5px -2px rgba(0,0,0,0.3);
    background-size:130%;
     transition: all 500ms cubic-bezier(0.19, 1, 0.22, 1);

    .card-img-overlay {
      transition: all 800ms cubic-bezier(0.19, 1, 0.22, 1);
      background: rgb(177, 215, 227);
     background: linear-gradient(0deg, rgb(119, 137, 143) 0%, rgba(177, 215, 227) 100%);
     }
  }
}
 .card-footer{
  background: none;
   border-top: none;
    .media{
     img{
       border:solid 3px rgba(255,255,255,0.3);
     }
   }
 }
  .card-title{font-weight:800}
 .card-meta{color:rgba(0,0,0,0.3);
  text-transform:uppercase;
   font-weight:500;
   letter-spacing:2px;}
 .card-body{ 
   transition: all 500ms cubic-bezier(0.19, 1, 0.22, 1);
 

  }
 &:hover {
   .card-body{
     margin-top:30px;
     transition: all 800ms cubic-bezier(0.19, 1, 0.22, 1);
   }
 cursor: pointer;
 transition: all 800ms cubic-bezier(0.19, 1, 0.22, 1);
}
 .card-img-overlay {
  transition: all 800ms cubic-bezier(0.19, 1, 0.22, 1);
 background: rgb(177, 215, 227);
background: linear-gradient(0deg, rgba(255, 251, 244, 0.379) 0%, rgba(177, 215, 227) 100%);
}
}

</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
