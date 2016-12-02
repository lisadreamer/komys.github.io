/*function checkPasswords() {
    
    var password1 = document.getElementById("pw1");
    var password2 = document.getElementById("pw2");
    if (password1.value !== password2.value) {
        console.log("111");
        password2.setCustomValidity('Passwords do not match'); } 
    else {console.log("22");
        password2.setCustomValidity(''); }
 	}

checkPasswords();

var colorInputField = document.querySelector("#colorChooser");
    
    colorInputField.addEventListener('input', function(evt) {
        console.log("123");      
        document.body.style.backgroundColor = this.value;
      }, false);*/

//window.onload = function(){ 
        
        var field = document.getElementById("db");
     
        field.oninput = function(evt) {
            var date = this.value;
            if(this.valueAsDate <= new Date()) {
                 console.log("birthdate is past");
                field.style.backgroundColor= "white";
            } else {
                console.log("birthdate in future");
                field.style.backgroundColor= "lightpink";
            }
        }