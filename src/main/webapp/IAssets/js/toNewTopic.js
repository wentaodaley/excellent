/**
 * Created by sky on 15/11/8.
 */



$(function () {
    updatefg();
    var editor;
    $("#stuCount").change(function () {
        updatefg();
    });

    function init() {
        KindEditor.ready(function (K) {
            var options = {
                width: '100%',
                height: '400px'
            };
            editor = K.create('textarea[name="content"]', options);
        });
    }


    function updatefg() {
        var num = $("#stuCount").val();
        var st = "";
        for(var i = 0; i<num;i++) {
            st += "<div class='rwbt'> <div class='form-group'> " +
                "<label class='col-sm-2 control-label'>任务</label> " +
                "<div class='col-sm-7'> " +
                "<input name='ctn' type='text' placeholder='任务标题' id='childName'class='form-control'> " +
                "</div> </div> " +
                "<div class='form-group'> <label class='col-sm-2 control-label'>分工内容</label> " +
                "<div class='col-sm-7'><textarea name='content'></textarea></div> </div> </div>";
        }
        $("#group_rw").html(st);
        init();
    }


});



