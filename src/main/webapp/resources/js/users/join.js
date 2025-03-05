const inputUserName=document.getElementById("inputUserName");
const userNameResult=document.getElementById("userNameResult");

inputUserName.addEventListener("change", ()=>{

    console.log(inputUserName.value);

    fetch("./check?userName="+inputUserName.value)
    .then(res=> res.text())
    .then(res =>{
        if(res.trim()=='0'){
            //가입X
            userNameResult.innerHTML="중복된 ID 입니다." 
        }else {
            //가입O
            userNameResult.innerHTML="사용가능한 ID 입니다."
        }
    })
})