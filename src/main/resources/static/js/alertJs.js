
$.extend( {
    notifationTime : undefined,
    longpresstm : undefined,
    pageRecordEventArg : undefined,
    pageObject : undefined,
    /*获取顶层页面*/
    win : function() {
        var w = window;
        while (true) {
            if (w.top == w.self)
                break;
            else
                w = w.top;
        }
        return w;
    },
    /*遮罩阴影层*/
    jq_MaskDiv : function(e) {
        var str = "<div aria-hidden='false' class='theme-popover-mask "
            + e.cn
            + "' style=\"z-index:2;height:"
            + $($.win()).height()
            + "px;position:fixed;left:0;top:0;left:0;right:0;background:#000;opacity:0.1;filter:alpha(opacity=10);-moz-opacity:0.1;display:none;\"></div>";
        $.win().$("body").append(str);
        $.win().$('.theme-popover-mask').show();
    },
    jq_MaskDiv_close : function(e) {
        $.win().$('.' + e.cn).hide();
        $.win().$('.' + e.cn).remove();
    },
    /*确定取消对话框*/
    jq_Confirm : function(e) {
        if (!e)
            return;
        e.btnOktext = !e.btnOktext ? "确定" : e.btnOktext;
        e.btnCanceltext = !e.btnCanceltext ? "取消" : e.btnCanceltext;
        e.dialogModal = e.dialogModal == undefined ? true
            : e.dialogModal;
        if (!e.message) {
            e.message = "请输入对应的提示信息";
        }
        //set it's modal
        if (e.dialogModal) {
            $.jq_MaskDiv( {
                cn : "confirmMask"
            });
        }
        var str = "<div class='jq_dvconfirm' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;min-height:144px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
            + "<div style='min-height:54px;line-height:54px;padding:20px;'>"
            + "<button title='关闭' class='btncloseconfirm' style='outline:0px;float:right;margin-top:-10px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
            + "<div style='font-size:16px;color: rgb(57, 57, 57);'>"
            + e.message
            + "</div>"
            + "</div>"
            + "<div style='overflow:auto;padding:12px 14px;background-color: rgb(239, 243, 248);'>"
            + "<input class='confirmbtncancel' type='button' value=' ✓ "
            + e.btnCanceltext
            + "' style='float:right;margin:0px 10px;' />"
            + "<input class='confirmbtnok' type='button' value=' ✓ "
            + e.btnOktext
            + "' style='float:right;' />"
            + "</div>"
            + "</div>";
        $.win().$("body").append(str);
        $.win().$(".btncloseconfirm").hover(function() {
            $(this).css("opacity", 1);
        }, function() {
            $(this).css("opacity", 0.2);
        });

        $('.jq_dvconfirm').css(
            "left",
            ($($.win()).width() - $.win().$('.jq_dvconfirm')
                .width())
            / 2 + "px");
        $('.jq_dvconfirm').css("top",
            0 - $.win().$('.jq_dvconfirm').height());
        $('.jq_dvconfirm').stop().animate( {
            "top" : 200 + $($.win()).scrollTop(),
            "opacity" : 1
        }, 350);

        $('.confirmbtnok').bind("click", function() {
            if (e.btnOkClick)
                e.btnOkClick();
            $.jq_Confirm_close();
        });
        $('.confirmbtncancel').bind("click", function() {
            if (e.btnCancelClick)
                e.btnCancelClick();
            $.jq_Confirm_close();
        });
        $('.btncloseconfirm').bind("click", function() {
            $.jq_Confirm_close();
        });
    },
    /*确定取消对话框关闭*/
    jq_Confirm_close : function() {
        $.win().$('.jq_dvconfirm').stop().animate( {
            "top" : 0 - $.win().$('.jq_dvconfirm').height(),
            "opacity" : 0
        }, 150, function() {
            $.jq_MaskDiv_close( {
                cn : "confirmMask"
            });
            $.win().$(".jq_dvconfirm").remove();
        });
    },
    /*确定对话框*/
    jq_Alert : function(e) {
        if (!e)
            return;
        e.btnOktext = !e.btnOktext ? "确定" : e.btnOktext;
        e.dialogModal = e.dialogModal == undefined ? true
            : e.dialogModal;

        if (!e.message) {
            e.message = "请输入对应的提示信息";
        }
        //set it's modal
        if (e.dialogModal) {
            $.jq_MaskDiv( {
                cn : "okMask"
            });
        }
        var str = "<div class='jq_dvalert' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;min-height:144px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
            + "<div style='min-height:54px;line-height:54px;padding:20px;'>"
            + "<button title='关闭' class='btnclosealert' style='outline:0px;float:right;margin-top:-10px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
            + "<div style='font-size:16px;color: rgb(57, 57, 57);'>"
            + e.message
            + "</div>"
            + "</div>"
            + "<div style='overflow:auto;padding:12px 14px;background-color:rgb(239, 243, 248);'>"
            + "<input class='alertbtnok' type='button' value=' ✓ "
            + e.btnOktext
            + "' style='float:right;' />"
            + "</div>"
            + "</div>";
        $.win().$("body").append(str);
        $.win().$(".btnclosealert").hover(function() {
            $(this).css("opacity", 1);
        }, function() {
            $(this).css("opacity", 0.2);
        });
        $.win().$('.jq_dvalert').css(
            "left",
            ($($.win()).width() - $.win().$('.jq_dvalert').width())
            / 2 + "px");
        $.win().$('.jq_dvalert').css("top",
            0 - $.win().$('.jq_dvalert').height());
        $.win().$('.jq_dvalert').stop().animate( {
            "top" : 200 + $($.win()).scrollTop(),
            "opacity" : 1
        }, 350);
        $.win().$('.alertbtnok').bind("click", function() {
            $.jq_Alert_close();
            if (e.btnOkClick) {
                e.btnOkClick();
            }
        });
        $.win().$('.btnclosealert').bind("click", function() {
            $.jq_Alert_close();
        });
    },
    /*确定对话框关闭*/
    jq_Alert_close : function() {
        $.win().$('.jq_dvalert').stop().animate( {
            "top" : 0 - $.win().$('.jq_dvalert').height(),
            "opacity" : 0
        }, 150, function() {
            $.jq_MaskDiv_close( {
                cn : "okMask"
            });
            $.win().$(".jq_dvalert").remove();
        });
    },
    /*加载对话框*//* DaTouWang URL: www.datouwang.com */
    jq_Loading : function() {
        //set it's modal
        $.jq_MaskDiv( {
            cn : "loadMask"
        });
        var str = "<div class='jq_dvloading' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
            + "<div style='height:100px;padding:30px 30px;'>"
            + "<div style='font-weight:bold;height:100px;line-height:100px;text-indent:160px;font-size:16px;color: rgb(57, 57, 57);background-Image:url(css/images/loading.gif);background-repeat:no-repeat;background-position:40px 0px;'>正在加载，请稍后……</div>"
            + "</div>" + "</div>";
        $.win().$("body").append(str);

        $.win().$('.jq_dvloading').css(
            "left",
            ($($.win()).width() - $.win().$('.jq_dvloading')
                .width())
            / 2 + "px");
        $.win().$('.jq_dvloading').css("top",
            0 - $('.jq_dvloading').height());
        $.win().$('.jq_dvloading').stop().animate( {
            "top" : 200 + $($.win()).scrollTop(),
            "opacity" : 1
        }, 350);
    },
    /*加载对话框     关闭*/
    jq_Loading_close : function() {
        $.win().$('.jq_dvloading').stop().animate( {
            "top" : 0 - $.win().$('.jq_dvloading').height(),
            "opacity" : 0
        }, 150, function() {
            $.jq_MaskDiv_close( {
                cn : "loadMask"
            });
            $.win().$(".jq_dvloading").remove();
        });
    },

    /*消息提示  对话框*/
    jq_Notifation : function(e) {
        if (!e)
            return;
        e.message = !e.message ? "请填写消息内容" : e.message;
        var str = "<div class='jq_dvnotifation' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;right:5px;bottom:3px;background-Color:#fff;min-width:328px;width:328px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
            + "<div class='jq_dvnotifation_title' style='background-color:#ECF2F7 !important;border-bottom: 1px solid #BCD4E5 !important;font-weight:600;padding:10px 10px;'>"
            + "提示消息"
            + "<button title='关闭' class='btnclosenotifation' style='outline:0px;float:right;margin-top:-5px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
            + "</div>"
            + "<div class='jq_dvnotifation_content' style='padding:20px 10px;min-height:100px;'>"
            + e.message + "</div>" + "</div>";

        $.win().$("body").append(str);
        $.win().$(".btnclosenotifation").hover(function() {
            $(this).css("opacity", 1);
        }, function() {
            $(this).css("opacity", 0.2);
        });

        $.win().$('.jq_dvnotifation').stop().animate( {
            "opacity" : 1
        }, 350);

        $('.btnclosenotifation').bind("click", function() {
            $.jq_Notifation_close();
        });
        var tm = window.setTimeout(function() {
            $.jq_Notifation_close();
        }, 4000);
        $.win().$('.jq_dvnotifation_title,.jq_dvnotifation_content')
            .hover(function(event) {
                window.clearTimeout(tm);
                $.win().$('.jq_dvnotifation').css("opacity", 1);
            }, function() {
                tm = window.setTimeout(function() {
                    $.jq_Notifation_close();
                }, 4000);
            });
    },
    /*消息提示  对话框     关闭*/
    jq_Notifation_close : function() {
        $.win().$('.jq_dvnotifation').stop().animate( {
            "opacity" : 0
        }, 1050, function() {
            window.clearTimeout($.notifationTime);
            $.win().$('.jq_dvnotifation').remove();
        });
    }
});
