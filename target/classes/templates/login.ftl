<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./jquery-3.1.1.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" id="layform">
        <input name="phone" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="pwd" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
        <input value="注册" lay-submit lay-filter="reg" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>

<script>
    $(function () {
        layui.use('form', function () {
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //   //关闭后的操作
            //   });
            //监听提交

            form.on('submit(login)', function (datas) {
                var data = $("#layform").serialize()
                $.ajax({
                    url: '/user/userLogin',
                    type: 'post',
                    dataType: 'json',
                    data: data,
                    success: function (msg) {
                        if (msg.returnCode == 0) {
                            layer.msg(msg.errorMsg + '！跳转页面请稍等!', function (){
                                location.href = 'index';
                            });
                        }else{
                            layer.msg(msg.errorMsg, function (){
                            });
                        }
                    }
                });
                return false;
            });

            form.on('submit(reg)', function (datas) {
                var data = $("#layform").serialize()
                $.ajax({
                    url: '/insertUser',
                    type: 'post',
                    dataType: 'json',
                    data: data,
                    success: function (msg) {
                        if (msg.returnCode == 0) {
                            layer.msg(msg.errorMsg + '！跳转页面请稍等!', function (){
                                location.href = 'index';
                            });
                        }else{
                            layer.msg(msg.errorMsg, function (){
                            });
                        }
                    }
                });
                return false;
            });

        });
    })
</script>
</body>
</html>