/** index.js By Beginner Emain:zheng_jinfan@126.com HomePage:http://www.zhengjinfan.cn */
var ifram = {};
var tab;
var g_navbar;
var stompClient;
layui.config({
    base: JFATTY.basePath() + 'js/',
    version: new Date().getTime()
}).use(['element', 'layer', 'navbar', 'tab'], function () {
    var element = layui.element,
        $ = layui.jquery,
        layer = layui.layer,
        navbar = layui.navbar();
    g_navbar = navbar;

    var socket = new SockJS(JFATTY.basePath() + '/webSocket', undefined, {protocols_whitelist: ['websocket']});//连接服务端的端点，连接以后才可以订阅广播消息和个人消息
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        //订阅广播消息
        stompClient.subscribe('/privilege/all', function (message) {
            g_navbar.render();
            //监听点击事件
            g_navbar.on('click(side)', function (data) {
                tab.tabAdd(data.field);
            });
            console.log(JSON.parse(message.body));
            console.log('/privilege/all 订阅广播消息');
        });

        //订阅个人信息
        stompClient.subscribe('/user/1/testUser', function (message) {
            console.log('订阅个人信息');
        });
    });
    tab = layui.tab({
        elem: '.admin-nav-card' //设置选项卡容器
        ,
        //maxSetting: {
        //	max: 5,
        //	tipMsg: '只能开5个哇，不能再开了。真的。'
        //},
        contextMenu: true,
        onSwitch: function (data) {
            //console.log(data.id); //当前Tab的Id
            //console.log(data.index); //得到当前Tab的所在下标
            //console.log(data.elem); //得到当前的Tab大容器
            //console.log(tab.getCurrentTabId())
        },
        closeBefore: function (obj) { //tab 关闭之前触发的事件
            //console.log(obj);
            //obj.title  -- 标题
            //obj.url    -- 链接地址
            //obj.id     -- id
            //obj.tabId  -- lay-id
            if (obj.title === 'BTable') {
                layer.confirm('确定要关闭' + obj.title + '吗?', {icon: 3, title: '系统提示'}, function (index) {
                    //因为confirm是非阻塞的，所以这里关闭当前tab需要调用一下deleteTab方法
                    tab.deleteTab(obj.tabId);
                    layer.close(index);
                });
                //返回true会直接关闭当前tab
                return false;
            } else if (obj.title === '表单') {
                layer.confirm('未保存的数据可能会丢失哦，确定要关闭吗?', {icon: 3, title: '系统提示'}, function (index) {
                    tab.deleteTab(obj.tabId);
                    layer.close(index);
                });
                return false;
            }
            return true;
        }
    });
    //iframe自适应
    $(window).on('resize', function () {
        var $content = $('.admin-nav-card .layui-tab-content');
        $content.height($(this).height() - 147);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();


    function childrenUse() {
        //iframe自适应
        $(window).on('resize', function () {
            var $content = $('.admin-nav-card .layui-tab-content');
            $content.height($(this).height() - 147);
            $content.find('iframe').each(function () {
                $(this).height($content.height());
            });
        }).resize();
    }

    ifram.childrenUse = childrenUse;

    //设置navbar
    navbar.set({
        spreadOne: true,
        elem: '#admin-navbar-side',
        cached: false,
        url: JFATTY.basePath() + 'privilege/getMenu'
        /*cached:true,
        url: '/JFATTY/privilege/get'data: navs*/
    });
    //渲染navbar
    navbar.render();
    //监听点击事件
    navbar.on('click(side)', function (data) {
        tab.tabAdd(data.field);
    });
    //清除缓存
    $('#clearCached').on('click', function () {
        navbar.cleanCached();
        layer.alert('清除完成!', {icon: 1, title: '系统提示'}, function () {
            location.reload();//刷新
        });
    });

    $('.admin-side-toggle').on('click', function () {
        var sideWidth = $('#admin-side').width();
        if (sideWidth === 200) {
            $('#admin-body').animate({
                left: '0'
            }); //admin-footer
            $('#admin-footer').animate({
                left: '0'
            });
            $('#admin-side').animate({
                width: '0'
            });
        } else {
            $('#admin-body').animate({
                left: '200px'
            });
            $('#admin-footer').animate({
                left: '200px'
            });
            $('#admin-side').animate({
                width: '200px'
            });
        }
    });
    $('.admin-side-full').on('click', function () {
        var docElm = document.documentElement;
        //W3C  
        if (docElm.requestFullscreen) {
            docElm.requestFullscreen();
        }
        //FireFox  
        else if (docElm.mozRequestFullScreen) {
            docElm.mozRequestFullScreen();
        }
        //Chrome等  
        else if (docElm.webkitRequestFullScreen) {
            docElm.webkitRequestFullScreen();
        }
        //IE11
        else if (elem.msRequestFullscreen) {
            elem.msRequestFullscreen();
        }
        layer.msg('按Esc即可退出全屏');
    });

    //个人信息
    $('#setting').on('click', function () {
        tab.tabAdd({
            href: JFATTY.basePath() + 'html/userInfo.h5',
            icon: 'fa-gear',
            title: '个人信息'
        });
    });

    //修改密码
    $('#edit-pw').on('click', function () {
        tab.tabAdd({
            href: JFATTY.basePath() + 'html/editpw.h5',
            icon: 'fa-gear',
            title: '修改密码'
        });
    });

    //锁屏
    $(document).on('keydown', function () {
        var e = window.event;
        if (e.keyCode === 76 && e.altKey) {
            //alert("你按下了alt+l");
            lock($, layer);
        }
    });
    $('#lock').on('click', function () {
        //跳转到锁屏函数
        lock($, layer);
    });
    //修改密码
    $('#edit-pw111').on('click', function () {
        //跳转到锁屏函数
        editPw($, layer);
    });

    //手机设备的简单适配
    var treeMobile = $('.site-tree-mobile'),
        shadeMobile = $('.site-mobile-shade');
    treeMobile.on('click', function () {
        $('body').addClass('site-mobile');
    });
    shadeMobile.on('click', function () {
        $('body').removeClass('site-mobile');
    });
});

function gNavbar() {
    g_navbar.render();
    //监听点击事件
    g_navbar.on('click(side)', function (data) {
        tab.tabAdd(data.field);
    });
}

var isShowLock = false;

function lock($, layer) {
    if (isShowLock)
        return;
    //自定页
    layer.open({
        title: false,
        type: 1,
        closeBtn: 0,
        anim: 6,
        content: $('#lock-temp').html(),
        shade: [0.9, '#393D49'],
        success: function (layero, lockIndex) {
            isShowLock = true;
            //给显示用户名赋值
            layero.find('div#lockUserName').text($("#userName").html());
            layero.find('input[name=username]').val($("#account").val());
            layero.find('input[name=password]').on('focus', function () {
                var $this = $(this);
                if ($this.val() === '输入密码解锁..') {
                    $this.val('').attr('type', 'password');
                }
            }).on('blur', function () {
                var $this = $(this);
                if ($this.val() === '' || $this.length === 0) {
                    $this.attr('type', 'text').val('输入密码解锁..');
                }
            });
            //在此处可以写一个请求到服务端删除相关身份认证，因为考虑到如果浏览器被强制刷新的时候，身份验证还存在的情况			
            //do something...
            //e.g.
            //退出系统
            $.getJSON(JFATTY.basePath() + "logout", null, function (res) {
                if (!res.ok) {
                    layer.msg(res.msg);
                }
            }, 'json');

            //绑定解锁按钮的点击事件
            layero.find('button#unlock').on('click', function () {
                var $lockBox = $('div#lock-box');

                var userName = $lockBox.find('input[name=username]').val();
                var pwd = $lockBox.find('input[name=password]').val();
                if (pwd === '输入密码解锁..' || pwd.length === 0) {
                    layer.msg('请输入密码..', {
                        icon: 2,
                        time: 1000
                    });
                    return;
                }
                //解锁
                unlock(userName, pwd);
            });
            /**
             * 解锁操作方法
             * @param {String} 用户名
             * @param {String} 密码
             */
            var unlock = function (un, pwd) {
                //这里可以使用ajax方法解锁
                JFATTY.doPost({
                    url: JFATTY.basePath() + "user/unlock",
                    data: {userName: un, password: pwd},
                    success: function (value, type) {
                        if (value.ok) {
                            //关闭锁屏层
                            layer.close(lockIndex);
                            isShowLock = false;
                        } else {
                            layer.msg(value.msg, {icon: 2, time: 1000});
                        }
                    }
                });

                //isShowLock = false;
                //演示：默认输入密码都算成功
                //关闭锁屏层
                //layer.close(lockIndex);
            };
        }
    });
};
var pwBoxIndex = -1;

//修改密码具体实现
function editPw($, layer) {
    if (pwBoxIndex !== -1)
        return;
    //本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
    $.get('./html/editpw.html', null, function (form) {
        pwBoxIndex = layer.open({
            type: 1,
            title: '修改密码',
            content: form,
            btn: ['确认', '取消'],
            shade: false,
            offset: ['100px', '30%'],
            area: ['600px', '400px'],
            zIndex: 19950924,
            maxmin: true,
            yes: function (index) {
                //触发表单的提交事件
                $('form.layui-form').find('button[lay-filter=edit]').click();
            },
            full: function (elem) {
                var win = window.top === window.self ? window : parent.window;
                $(win).on('resize', function () {
                    var $this = $(this);
                    elem.width($this.width()).height($this.height()).css({
                        top: 0,
                        left: 0
                    });
                    elem.children('div.layui-layer-content').height($this.height() - 95);
                });
            },
            success: function (layero, index) {
                //弹出窗口成功后渲染表单
                var form = layui.form;
                form.render();
                form.on('submit(edit)', function (data) {
                    console.log(data.field);
                    //layero.close(index);
                    layer.msg("22222");
                    //layer.close(pwBoxIndex);
                    //这里可以写ajax方法提交表单
                    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                });

            },
            end: function () {
                pwBoxIndex = -1;
            }
        });
    });
};
