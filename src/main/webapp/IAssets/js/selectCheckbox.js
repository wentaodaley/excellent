
$(function () {
    var $select = $("#selectAll");
    $select.change(function(){
        if ($select.is(":checked")){
            $("input[name = 'teaId']").attr("checked", true);
        }else {
            $("input[name = 'teaId']").attr("checked", false);
        }
    });
});
