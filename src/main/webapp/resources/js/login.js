/**
 * 
 */
const login = document.getElementById("login");
const inputUserName = document.getElementById("inputUserName");
const inputPassword = document.getElementById("inputPassword");

login.addEventListener("click", function(){
    if(inputUserName.value == "admin" && inputPassword.value == "admin"){
        console.log("입력한 아이디 : " + inputUserName.value)
        console.log("입력한 비밀번호 : " + inputPassword.value)
        alert("로그인 성공");
        location.href="../";
    }else if(inputUserName.value == "" || inputPassword.value == ""){
        alert("아이디와 비밀번호 모두 입력해주세요.")
        location.href="./login";
    }
    else {
        console.log("입력한 아이디 : " + inputUserName.value)
        console.log("입력한 비밀번호 : " + inputPassword.value)
        alert("로그인 실패");
        location.href="./login";
    }
})