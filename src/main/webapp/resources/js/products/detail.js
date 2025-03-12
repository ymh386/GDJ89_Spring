// 수정 버튼을 클릭했을 때 콘솔에 출력
// form method의 값을 콘솔에 출력

// 삭제 버튼을 클릭했을 때 콘솔에 출력
// form action의 주소값을 콘솔에 출력


const up = document.getElementById("up");
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const addCart = document.getElementById("addCart");
const addComments = document.getElementById("addComments");
const commentsContent = document.getElementById("commentsContent");
const commentsListResult = document.getElementById("commentsListResult");
const pages = document.getElementsByClassName("pages");
const deleteComments = document.getElementsByClassName("deleteComments");
const modal_change = document.getElementById("modal_change");



addCart.addEventListener("click", ()=>{
    let num = addCart.getAttribute("data-product-num")
    let userName = addCart.getAttribute("data-user-name")
    let s = '1234'
        fetch('../users/addCart?productNum=' + num)
        .then(res=>res.text())
        .then(res=>{
            if(res.trim()=='1'){
                let r = confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?")
                if(r){
                    alert("장바구니로 이동합니다.")
                    location.href="../users/cart"
                }
            }else {
                alert("로그인 후 이용해주세요")
            }
    
        }).catch(e=>{
            alert("로그인 후 이용해주세요")
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


//------------- 등록 버튼 ----------------------
addComments.addEventListener("click", async()=>{
    console.log(commentsContent.value);
    console.log(addCart.getAttribute("data-product-num"));
    
    await add()
    await getList(1)
    

})

function makeForm(pn, content){
    let f = new FormData();
    f.append("productNum", pn);
    f.append("boardContent", content)

    return f;
}

function makeParam(pn, content){

    let p = new URLSearchParams();
    p.append("productNum", pn);
    p.append("boardContent", content)

    return p;
}

getList(1)

async function getList(page){
    let pn = addCart.getAttribute("data-product-num");
    fetch(`listComments?productNum=${pn}&page=${page}`)
    .then(r => r.text())
    .then(r => {
        commentsListResult.innerHTML=r;
    })
    .catch(e=> console.log(e))

}

async function add(){

    let pn = addCart.getAttribute("data-product-num");

    //let p = makeParam(pn, commentsContents.value);
    let p = makeForm(pn, commentsContent.value)


    fetch('./addComments', {
        method:'POST',
        // headers: {
        //     "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
        // },
        //body: `productNum=${pn}&boardContents=${commentsContents.value}`
        body:p
    })
    .then(r=>r.text())
    .then(r=>{
        // getList()
        if(r.trim()*1>0){
            alert("댓글 등록 완료")
        }else {
            alert("댓글 등록 실패")
        }

        commentsContent.value="";

    })
    .catch(e => {
        alert('에러발생')
    })
}

async function delComments(bn){
    fetch(`deleteComments?boardNum=${bn}`)
    .then(r => r.text())
    .then(r => {
        if(r.trim()*1>0){
            alert("삭제 성공")
        }else{
            alert("삭제 실패")
        }
    })
    .catch(e=> console.log(e))
}

commentsListResult.addEventListener('click', async (e)=>{
    if(e.target.classList.contains('pages')){
        let p = e.target.getAttribute("data-page-num");
        getList(p)
    }

    if(e.target.classList.contains('deleteComments')){
        let bn = e.target.getAttribute("id")
        await delComments(bn)
        await getList(1)

    }
    
})

//------------------------ Update --------------------------------
commentsListResult.addEventListener('click', async (e)=>{
    if(e.target.classList.contains('updateComments')){
        let ud = e.target;//button
        let ud_s = ud.parentElement.previousElementSibling.previousElementSibling
        
        let c = ud_s.innerHTML;
        
        let bn = ud.getAttribute("id")
        // ud_s.innerHTML=`<textarea>${c}</textarea>`;
        document.getElementById('message-text').value=c;
        document.getElementById('message-text').setAttribute('data-boardNum', bn)
        

        
    }
})

modal_change.addEventListener('click', async ()=>{
    let m = document.getElementById('message-text')

    let f = new FormData();
    f.append("boardNum", m.getAttribute('data-boardNum'))
    f.append("boardContent", m.value)

    //commentsUpdate post
    fetch("./updateComments", {
        method: "POST",
        body: f
    })
    .then(r => r.text())
    .then(r => {
        document.getElementById(`c${m.getAttribute("data-boardNum")}`).innerHTML=m.value;
        if(r.trim()*1>0){
            alert("수정 완료")
        }else{
            alert("수정 실패")
        }
    })
    .catch(e => console.log(e))
    .finally(()=>{
        m.value="";
        m.setAttribute("data-boardNum", "");
        document.getElementById('modal_close').click();
    })
})


