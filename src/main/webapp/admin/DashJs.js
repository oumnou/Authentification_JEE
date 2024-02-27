function loadTable() {
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "https://dummyjson.com/users");
  xhttp.send();
  xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
          var trHTML = "";
          const objects = JSON.parse(this.responseText);
          for (let object of objects["users"]) {
            trHTML += "<tr>";
            trHTML += "<td>" + object["id"] + "</td>";
          trHTML +=
            '<td><img width="50px" src="' +
            object["image"] +
            '" class="avatar"></td>';
          trHTML += "<td>" + object["firstName"] + "</td>";
          trHTML += "<td>" + object["lastName"] + "</td>";
          trHTML += "<td>" + object["maidenName"] + "</td>";
          trHTML +=
            '<td><button type="button" class="btn btn-outline-secondary" onclick="showUserEditBox(' +
            object["id"] +
            ')">Edit</button>';
          trHTML +=
            '\t <button type="button" class="btn btn-outline-danger" onclick="userDelete(' +
            object["id"] +
            ')">Del</button></td>';
          trHTML += "</tr>";
        }
        document.getElementById("mytable").innerHTML = trHTML;
      }
    };
  }
  
  loadTable();

  function showUserCreateBox() {
    Swal.fire({
      title: "Create user",
      html:
        '<input id="id" type="hidden">' +
        '<input id="firstName" class="swal2-input" placeholder="First">' +
        '<input id="lname" class="swal2-input" placeholder="Last">' +
        '<input id="username" class="swal2-input" placeholder="Username">' +
        '<input id="email" class="swal2-input" placeholder="Email">',
      focusConfirm: false,
      preConfirm: () => {
        userCreate();
      },
    });
  }
  
  function userCreate() {
    const firstName = document.getElementById("firstName").value;
    const lname = document.getElementById("lname").value;
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
  
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "https://www.mecallapi.com/api/users/create");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
      JSON.stringify({
        firstName: firstName,
        lname: lname,
        username: username,
        email: email,
        avatar: "https://www.mecallapi.com/users/cat.png",
      })
    );
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        const objects = JSON.parse(this.responseText);
        Swal.fire(objects["message"]);
        loadTable();
      }
    };
  }

  function showUserEditBox(id) {
    console.log(id);
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "https://dummyjson.com/users" + id);
    xhttp.send();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        const objects = JSON.parse(this.responseText);
        const user = objects["user"];
        console.log(user);
        Swal.fire({
          title: "Edit User",
          html:
            '<input id="id" type="hidden" value=' +
            user["id"] +
            ">" +
            '<input id="firstName" class="swal2-input" placeholder="First" value="' +
            user["firstName"] +
            '">' +
            '<input id="lname" class="swal2-input" placeholder="Last" value="' +
            user["lastname"] +
            '">' +
            '<input id="username" class="swal2-input" placeholder="Username" value="' +
            user["maidenName"] +
            '">' +
            '<input id="email" class="swal2-input" placeholder="Email" value="' +
            user["email"] +
            '">',
          focusConfirm: false,
          preConfirm: () => {
            userEdit();
          },
        });
      }
    };
  }
  
  function userEdit() {
    const id = document.getElementById("id").value;
    const firstName = document.getElementById("firstName").value;
    const lname = document.getElementById("lname").value;
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
  
    const xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "https://www.mecallapi.com/api/users/update");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
      JSON.stringify({
        id: id,
        firstName: firstName,
        lname: lname,
        username: username,
        email: email,
        avatar: "https://www.mecallapi.com/users/cat.png",
      })
    );
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        const objects = JSON.parse(this.responseText);
        Swal.fire(objects["message"]);
        loadTable();
      }
    };
  }