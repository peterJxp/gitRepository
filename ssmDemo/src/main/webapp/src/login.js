/*
---------------------------
-Click on the Button Join !-
---------------------------
*/

function login(){
    var uname=$("#uname").val();
    var password=$("#password").val();
    var code = $("#veryCode").val();
   if (code==""||uname==""||password==""){
    return  false;
    }else {
       isRightCode(code);
       }
}