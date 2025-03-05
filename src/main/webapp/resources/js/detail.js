// 수정 버튼을 클릭했을 때 콘솔에 출력
// form method의 값을 콘솔에 출력

// 삭제 버튼을 클릭했을 때 콘솔에 출력
// form action의 주소값을 콘솔에 출력


const up = document.getElementById("up");
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const addCart = document.getElementById("addCart");



addCart.addEventListener("click", ()=>{
    let num = addCart.getAttribute("data-product-num")
    let userName = addCart.getAttribute("data-user-name")
    let s = '1234'
        fetch('../users/addCart?productNum=' + num)
        .then(res=>res.text())
        .then(res=>{
            if(res.trim()=='1'){
                if(confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?")){
                    alert("장바구니로 이동합니다.")
                    location.href="../users/cart?userName=" + userName
                }
            }else {
                alert("로그인 후 이용해주세요")
            }
    
        })
})


up.addEventListener("click", function(){
    console.log(frm.method) //GET
    console.log(frm.getAttribute("method"))//null
    console.log("수정")
    frm.action="./update";
    frm.submit();
})

del.addEventListener("click", function(){
    console.log(frm.action); //url
    console.log(frm.getAttribute("action"));//uri
    console.log("삭제")

    let check = confirm("정말 삭제???");
    if(check){
        frm.action="./delete";
        frm.method="POST";
        frm.submit();
    }
})