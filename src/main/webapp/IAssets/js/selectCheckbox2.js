
$(function () {
    var $select = $("#selectAll");
    $select.change(function(){
        if ($select.is(":checked")){
            $("input[name = 'stuIds']").attr("checked", true);
        }else {
            $("input[name = 'stuIds']").attr("checked", false);
        }
    });
});
