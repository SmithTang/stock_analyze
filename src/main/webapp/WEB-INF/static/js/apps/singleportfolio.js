$(document).ready(function () {
    $("#news").click(function () {
        var s = $("#news").attr("name");
        $.ajax({
            url: "http://localhost:5000/demo/"+s,
            type: "get",
            ContentType: "text/html;charset=utf-8",
            dataType:'json',
            success: function (data) {
                $("#div_list").append(data)

            }
        });
    })
})