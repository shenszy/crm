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
        $("#public_modal_div").load(html,  function (response,status,xhr) {
            if (status==="success") {
                $("#public_modal_div").children().modal({keyboard: true});
            }else {
                $.jq_Alert({
                    message: "加载错误",
                    btnOktext: "确定"
                });
            }
        });
    }
    else {
        $("#public_modal_div").load(html + "?id=" + id, function (response,status,xhr) {
            if (status==="success") {
                $("#public_modal_div").children().modal({keyboard: true});
            }else {
                $.jq_Alert({
                    message: "加载错误",
                    btnOktext: "确定"
                });
            }
        });
    }
}

/**
 *统一分页
 *
 * */
function pageChange(a, pageNum) {
    var pageUl = $(a).parents("ul:first");

    var dataUrl = pageUl.data("dataurl");
    var table = pageUl.data("table");
    var searchFrom = pageUl.data("search");
    console.log(dataUrl);
    console.log(pageUl);

    if (searchFrom !== null && searchFrom !== undefined && searchFrom !== '') {
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
        if (status === "error"){
            $.jq_Alert({
                message: "加载错误",
                btnOktext: "确定"
            });
        }

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
function deleteById(deleteUrl, a, id,message) {
    var mes = (message === undefined ? '删除' : message);
    $.jq_Confirm({
        message: "确定要"+mes+"吗!",
        btnOktext: "确定",
        btnCanceltext: "取消",
        btnOkClick: function () {
            $.post(deleteUrl, {id: id}, function (r) {
                if (r) {
                    $.jq_Alert({
                        message: mes+"成功",
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
                        message: mes+"失败",
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
           /* $.jq_Alert({
                message: "信息有误，修改失败！",
                btnOktext: "确定"
            });*/
        }
    });

};

/**
 * 模态框的form 的异步添加
 * */
function modalAddSubmit(formSelector) {
    var form;
    if(formSelector === undefined) {
        form =  $("#public_modal_div").find("form");
    }else{
        form = $(formSelector);
    }
    if(form.length !== 1){
        console.error("未能找到form表单!!");
        return;
    }
    form.ajaxSubmit(function (d) {
        if (d) {
            $("#public_modal_div >div").modal('hide');
            $.jq_Alert({message: "添加成功", btnOktext: "确定",
                btnOkClick: function () {

                    var li = $("#main_context >div:visible").find("ul.pager >li:eq(0)")
                    pageChange(li, 9999);
                }
            });
        } else {
            alert("信息有误，修改失败！");
            /* $.jq_Alert({
                 message: "信息有误，修改失败！",
                 btnOktext: "确定"
             });*/
        }
    });

};

/** 初始化图表显示*/
$(document).ready(function () {
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {cx: 0.5, cy: 0.3, r: 0.7},
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });
});

/**同步获取数据*/
function getData(url,data) {
    var res;
    if(data ===undefined){
        $.ajax({
            url: url,  async: false, success: function (result) {
               res = result;
            }
        });
    }else {
        $.ajax({
            url: url, data: data, async: false, success: function (result) {
                res = result;
            }
        });
    }
    return res;
}

/**显示饼状图*/
function showPie(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false
    };
    var title = {
        text: '员工销售饼状图'
    };
    var tooltip = {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    };
    var plotOptions = {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    };

    var series = [{
        type: 'pie',
        name: '销售占比',
        data: data
    }];




    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;
    $('#staff_chart_container_pie').html("");
    $('#staff_chart_container_pie').highcharts(json);
}