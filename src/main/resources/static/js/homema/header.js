$(document).ready(function () {
    $(".left-navigation li").click(function (event) {
        let type = $(event.target).attr("id")
        window.location.href = type + ".html?type=" + type
    })

    let url = window.location.href;
    let params = url.split("?")[1].split("&")
    let paramList = {}
    for (let index = 0; index < params.length; index++) {
        param = params[index].split("=")
        paramList[param[0]] = param[1]
    }

    $("#" + paramList["type"]).addClass("select-nav")

    console.log("引入了js")
});