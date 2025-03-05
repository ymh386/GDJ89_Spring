/**
 * 
 */
const login = document.getElementById("login");
const inputUserName = document.getElementById("inputUserName");
const inputPassword = document.getElementById("inputPassword");


login.addEventListener("click", function(){

    alert("userName은 : " + inputUserName.value);
    alert("password는 : " + inputPassword.value);
    
    if(inputUserName.value == "" || inputPassword.value == ""){
        alert("아이디와 비밀번호 모두 입력해주세요.");
        location.href="./login";
    }
    
})