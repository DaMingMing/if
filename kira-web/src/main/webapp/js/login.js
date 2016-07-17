/**
 * Created by kira on 2016/7/16.
 */
/**
 * ajax异步提交登录信息
 */
function checkUserInfo(){
    $("#loginButton").attr({"disabled":"disabled"});
    var username = $('#form-username').val();
    var password = $('#form-password').val();
    var verifyCode = $('#form-verifyCode').val();
    $.ajax({
        url:"checkUserInfo.htmls",
        type:"post",
        data:{username:username,password:password,verifyCode:verifyCode},
        success:function(result){
            alert(result);
            /**
             * 404登录成功直接跳转main.jsp
             */
            if('404'==result){
                window.location.href="toMain.htmls";
            }
            //将按钮可用
            $("#loginButton").removeAttr("disabled");
            $("#returnMessage").text("result");
        },
        error: function(){
            $("#loginButton").removeAttr("disabled");
            $("#returnMessage").text("请求出错");
        }
    });






}
