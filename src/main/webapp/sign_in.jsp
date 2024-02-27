<%@ page import="oumnou.lp.model.User" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <title>Bootstrap demo</title>
  </head>
  
  <body>
<section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
            class="img-fluid" alt="Phone image">
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <form action="servlet" method="post">
            <!-- Email input -->
            <div class="form-outline mb-4">
              <input type="email" id="form1Example13" value='<%= (session.getAttribute("userfromLogin") != null) ? ((User)session.getAttribute("userfromLogin")).getEmail() : "" %>' name="email" placeholder="Email" class="form-control form-control-lg" />

            </div>
  
            <!-- Password input -->
            <div class="form-outline mb-4">
              <input type="password" id="form1Example13" value='<%= (session.getAttribute("userfromLogin") != null) ? ((User)session.getAttribute("userfromLogin")).getPassword() : "" %>' name="password" placeholder="Password" class="form-control form-control-lg" />
            </div>
            <input type="hidden" name="action" value="login">

                <% if (request.getAttribute("invalidInfo") != null) { %>
                <p style="color: red;">Invalid Information</p>
              <%  } %> 

            <div class="d-flex justify-content-around align-items-center mb-4">
              <!-- Checkbox -->
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
                <label class="form-check-label" for="form1Example3"> Remember me </label>
              </div>
            </div>
  
            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>
            <a href="signup.jsp" class="btn btn-secondary btn-lg btn-block">Sign up</a>


  
          
        
          </form>


        </div>
      </div>
    </div>
  </section>   
</body>
</html>
