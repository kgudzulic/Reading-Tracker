document.addEventListener('DOMContentLoaded', function() {
        document.getElementsByClassName("navbar-nav")[0].innerHTML =
            `  <li class="nav-item">
                      <a class="nav-link" id="login" href="/login.html">Prijava</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="registracija" href="/register.html">Registracija</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="knjige" href="/knjige.html">Knjige</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="police" href="/police.html">Police</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" id="korisnici" href="/korisnici.html">Korisnici</a>
                  </li>
                   <li class="nav-item">
                       <a class="nav-link" id="odjava" href="/login.html" onclick="localStorage.removeItem('uloga')">Odjava</a>
                    </li>
                  `;

        function sakrijNav(listNav){
            for(let navId of listNav){
                document.getElementById(navId).style.display = "none";
            }

        }

        var uloga = localStorage.getItem("uloga");
        if(uloga == null){
            sakrijNav(["police", "odjava"]);
        }
        else if(uloga == "CITALAC"){
            sakrijNav(["login", "registracija"]);
        }
    }






);

