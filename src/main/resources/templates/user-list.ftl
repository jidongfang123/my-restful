<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end">
            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <table id="demo" lay-filter="test"></table>

</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    //JavaScript代码区域
    layui.use('table', function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 315
            , url: 'user/queryUserList' //数据接口
            , page: true //开启分页
            , curr: 1
            , limit: 3
            , limits: [3, 5, 8]
            , request: {
                pageName: 'curr' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            , cols: [[ //表头
                {checkbox: true}
                , {field: 'uid', title: 'ID', width: 80, sort: true}
                , {field: 'name', title: '用户名', width: 80}
                , {
                    field: 'sex',

                    title: '性别',
                    width: 80,
                    align: 'center',
                    templet: function (d) {
                        if (d.usex == 1) {
                            return "男";
                        }else if(d.usex == 2){
                            return "女";
                        } else {
                            return "保密"
                        }
                    }
                }
                , {field: 'age', title: '年龄', width: 80}
                , {field: 'pwd', title: '密码', width: 80}
                , {field: 'phone', title: '手机号', width: 150}
                , {
                    field: 'right',
                    title: '性别',
                    width: 80,
                    align: 'center',
                    templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">查看</a></div>'
                }
                , {
                    field: 'right',
                    title: '操作',
                    width: 80,
                    align: 'center',
                    templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">修改</a></div>'
                }
                , {
                    field: 'right',
                    title: '操作',
                    width: 80,
                    align: 'center',
                    templet: '<div><a href="/detail/{{d.id}}" class="layui-table-link">删除</a></div>'
                }
            ]]
        });

    });

</script>
</body>
</html>
