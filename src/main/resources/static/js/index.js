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
 * 统一弹出框 //可以携带一个ID参数
 * */
function onShowModal(html, id) {
    if (id === undefined) {
        $("#public_modal_div").load(html, function () {
            $("#public_modal_div").children().modal({keyboard: true});
        });
    }
    else {
        $("#public_modal_div").load(html + "?id=" + id, function () {
            $("#public_modal_div").children().modal({keyboard: true});
        });
    }
}

/**
 *统一分页
 *
 * */
function pageChange(a, pageNum) {
    var pageUl = $(a).parents("ul:first");
    var dataUrl = pageUl.attr("dataUrl");
    var table = pageUl.attr("table");
    var searchFrom = pageUl.attr("search");
    if (searchFrom !== null || searchFrom !== undefined || searchFrom !== '') {
        var search = $(searchFrom).serialize();
        console.log(search);
        if (search !== null || search !== undefined || search !== '') {
            dataUrl += "?" + search
        }
    }
    $(table).parent().load(dataUrl + " .main_context_body > *", data = {
        pageNum: pageNum,
        onlyData: true
    }, function (response, status) {
        if (status === "error")
            alert("加载错误");
    });
}

/**
 * 点击查询按钮
 * */
function onSelect(btn) {
    var li = $(btn).parents(".main_table:first").find("ul.pager >li:eq(0)");
    pageChange(li, 0);
}

/**
 * 删除
 * */
function deleteById(deleteUrl, a, id) {
    $.jq_Confirm({
        message: "确定要删除吗",
        btnOktext: "确定",
        btnCanceltext: "取消",
        btnOkClick: function () {
            $.post(deleteUrl, {id: id}, function (r) {
                if (r) {
                    $.jq_Alert({
                        message: "删除成功",
                        btnOktext: "确定",
                        btnOkClick: function () {
                            var li = $(a).parents(".main_table:first").find("ul.pager >li:eq(0)");
                            var pageUl = $(li).parents("ul:first");
                            var thispage = pageUl.attr("thispage");
                            pageChange(li, thispage);
                        }
                    });
                } else {
                    $.jq_Alert({
                        message: "删除失败",
                        btnOktext: "确定"
                    });
                }
            })

        },
        btnCancelClick: function () {
        }
    });
}

/**
 * 模态框的异步修改
 * */
function modalUpdateSubmit(){
    $("#public_modal_div").find("form").ajaxSubmit(function (d) {
        if (d) {
            $("#public_modal_div >div").modal('hide');
            $.jq_Alert({message: "修改成功", btnOktext: "确定",
                btnOkClick: function () {
                    var li = $("#main_context >div:visible").find("ul.pager >li:eq(0)")
                    var pageUl = $(li).parents("ul:first");
                    var thispage = pageUl.attr("thispage");
                    pageChange(li, thispage);
                }
            });
        } else {
           alert("信息有误，修改失败！");
        }
    });

};

/**
 * 模态框的异步添加
 * */
function modalAddSubmit() {
    $("#public_modal_div").find("form").ajaxSubmit(function (d) {
        if (d) {
            $("#public_modal_div >div").modal('hide');
            $.jq_Alert({message: "添加成功", btnOktext: "确定",
                btnOkClick: function () {

                    var li = $("#main_context >div:visible").find("ul.pager >li:eq(0)")
                    pageChange(li, 9999);
                }
            });
        } else {
            alert("信息有误，添加失败！");
        }
    });

};