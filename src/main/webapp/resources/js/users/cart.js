const allCheck = document.getElementById("allCheck");
const checks = document.getElementsByClassName("checks");

allCheck.addEventListener("click", ()=>{
    //console.log(allCheck.getAttribute("checked")) null
    for(let check of checks){
        check.checked = allCheck.checked;
    }
})

for(let check of checks){
    check.addEventListener("click", ()=>{
        let r=true;
        for(let c of checks){
            if(!c.checked){
                r=false;
            }
        }

        allCheck.checked=r;
    })
}


const cartDelete = document.getElementById("cart-delete");

cartDelete.addEventListener("click", ()=>{
    let url = new URL("cartDelete", window.location);
    // url.search="productNum=1&productNum2";

    let nums = [];

    for(let check of checks){
        if(check.checked){
            url.searchParams.append("productNum", check.value)
            nums.push(check.value) 
        }
    }
    
    fetch(url)
    .then(result => result.text())
    .then(result=>{
        alert('삭제되었습니다.')
        location.reload();
        // for(let n of nums) {
        //     document.getElementById(n).remove();
        // }
    })
    .catch(e=>{
        alert("관리자에게 문의하세요.")
    })
})

const accountAdd = document.getElementById("account-add")

accountAdd.addEventListener("click", ()=>{
    let params = new URLSearchParams();
    for(let check of checks){
        if(check.checked){
            params.append("productNum", check.value)
        }
    }

    // let f = new FormData()//form 객체 생성
    // f.append("", )
    // f.set()

    //GET방식
    // let url = "../accounts/add?"+params.toString();
    // let url = '../accounts/add${params.toString()}';

    //JS에서의 객체생성(자바에서의 클래스와 같음)
    // let c ={
    //     a:10,
    //     b:'name',
    //     c: function(){
    //         console.log("df");
    //     }
    // }

    //enctype=multipart/form-data
    fetch("../accounts/add", {
        method:"POST",
        headers:{
            'Content-type' : 'application/x-www-form-urlencoded; charset=URF-8'
        },
        body:params
    })
        //promise
        .then(r=>r.text())
        .then(r=>{
            if(parseInt(r.trim()) > 0){
                alert('가입 성공')
                location.reload();
            }
        })
        .catch(e=>{
            alert('관리자에게 문의')
        })
})
