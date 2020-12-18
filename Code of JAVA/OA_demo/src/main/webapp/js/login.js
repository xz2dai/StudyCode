/**登陆判断
 *
 *
 */
function checkempty(){
    var input_name = document.getElementById("account");
    var input_pwd = document.getElementById("pwd")
    if(input_name.value == ""){
        alert("请输入用户名！");
        input_name.focus();
        return false;
    }
    if(input_pwd.value == ""){
        alert("请输入密码！");
        input_pwd.focus();
        return false;
    }
    return true;
}

function showMsg(){

}