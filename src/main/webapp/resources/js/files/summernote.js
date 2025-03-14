$('#detail').summernote({
    height:400,
    callbacks:{
        onImageUpload:function(files){
            console.log(files[0]);//<input type="file">
            let f = new FormData();
            f.append("uploadFile", files[0]);

            fetch('./detailFiles', {
                method:'POST',
                body:f
            })
            .then(r=>r.text())
            .then(r=>{
                $('#detail').summernote('editor.insertImage', r.trim()); 
            })
        },
        onMediaDelete:async(files)=>{
            

            console.log(files[0].src)
            // console.log($(files[0].attr('src')))

            let fileName = files[0].src;
            let ar = fileName.split("/");
            console.log(ar[ar.length-1]);

            ar = fileName.substring(fileName.lastIndexOf("/")+1)
            console.log(ar)

            let f = new FormData();
            f.append("fileName", ar)
            let result = await fetch('detailFilesDelete', {
                method: 'POST',
                body: f
            });

            console.log(result.text())
        }
    }
})