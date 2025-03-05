// 수정 버튼을 클릭했을 때 콘솔에 출력
// form method의 값을 콘솔에 출력

// 삭제 버튼을 클릭했을 때 콘솔에 출력
// form action의 주소값을 콘솔에 출력


const updateBtn = document.getElementById("updateBtn");
const deleteBtn = document.getElementById("deleteBtn");
const form1 = document.getElementById("form1");
const proceed = document.getElementById("proceed");

updateBtn.addEventListener("click", function(){
    console.log("updateBtn");
    console.log(form1.action); //url
    console.log(form1.getAttribute("action")); //uri
    console.log(form1.method); //get
    console.log(form1.getAttribute("method")); //null
    form1.action="./update";    
    
})

deleteBtn.addEventListener("click", function(){
    console.log("deleteBtn");
    console.log(form1.action);
    console.log(form1.getAttribute("action"));
    console.log(form1.method); //get
    console.log(form1.getAttribute("method")); //null
    form1.action="./delete";
    form1.method="post";
    console.log(form1.method);    
    
})

proceed.addEventListener("click", function(){ 
    
    let check = confirm("정말 진행하시겠습니까?");
    if(check) {
        form1.submit();
    }

})