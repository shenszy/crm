
/**
 * 页面尺寸自动化
 * */
$(function () {
    var height = $(window).height() - $("header >nav").height();
    $("main").height(height);
    $("main >div").height(height);
    $("#main_nav").height(height - $("#footer").height() - 22);
    //min-height: 30px;
    $("#main_context").css('height', (height - $("#main_context_nav").height() - 11) + "px");
    $(window).resize(function () {
        var height = $(window).height() - $("header >nav").height();
        $("main").height(height);
        $("main >div").height(height);
        $("#main_context").css('height', (height - $("#table_nav").height() - 11) + "px");
        $("#main_nav").height(height - $("#footer").height() - 22);
    });
});





    /**
     * 当有主体内容添加实践的时候
     * 添加主体内容
     * 添加标签
     * */
    function onloada(t, a) {
        // console.log($(a).html());
        var name = $(a).text().trim();
        if ($("#" + name).length > 0) {
            showTable(name);
            return;
        }
        $("#main_context").find(">div").hide();
        var sbtn = $("<button id = 'table_btn_" + name + "'type='button' class='btn btn-sm' onclick='showTable(\"" + name + "\")'>");
        sbtn.append($(a).html());
        var xbtn = $("<button type='button' class='btn btn-warning btn-sm' onclick='hideTable(\"" + name + "\");'><span class='glyphicon glyphicon-remove'></span></button>");

        var li = $("<li><div class='btn-group'></div></li>");
        li.children().append(sbtn);
        li.children().append(xbtn);
        $("#main_context_nav").find(">div >div >ul").append(li);
        //添加主体
        var context = $("<div id='" + name + "'></div>");
        context.load(t);
        $("#main_context").append(context);
        showTable(name);
    }

/**
 * 这俩函数是负责 切换 标题栏的
 * */
    function showTable(name) {
        if ($("#" + name).length > 0) {
            $("#main_context").find(">div").hide();
            $("#" + name).show();
            $("[id^='table_btn_']").removeClass("btn-success");
            $("#table_btn_" + name).addClass("btn-success");
        }
    }
    function hideTable(name) {
        if ($("#" + name).length > 0) {
            $("#table_btn_" + name).parent().parent().remove();
            $("#" + name).remove();
            var las = $("#main_context").find(">div").last();
            if (las.length > 0) {
                las.show();
                showTable(las.attr('id'));
            }

        }
    }

/**
 * 添加按钮点击后的添加弹出框
 * */
function onAdd(a,html) {
    $(a).parent().next().load(html, function () {
        $(a).parent().next().modal({keyboard: true});
    });

}

/*
*
 * 显示模态框
 *
function shoModal(btn,htmlUrl){
    $(btn).parent().next().load(htmlUrl, function () {
        $(btn).parent().next().find("#addModal").modal({keyboard: true});
    });

}*/
