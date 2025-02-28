/**
 * 
 */
const login = document.getElementById("login");
const inputUserName = document.getElementById("inputUserName");
const inputPassword = document.getElementById("inputPassword");
let userName = "<c:out value='${user.userName}'/>"
let password = "<c:out value='${user.password}'/>"

login.addEventListener("click", function(){
    
    if(inputUserName.value == "" || inputPassword.value == ""){
        alert("아이디와 비밀번호 모두 입력해주세요.");
        location.href="./login";
    }
    
})