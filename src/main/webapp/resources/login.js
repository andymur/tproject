jQuery(function ($) {

    $("#adminService").hide()

    $('#btn-register').click(function (event) {
        event.preventDefault();
        var regData = JSON.stringify({
            name: $('#register input[name=name]').val(),
            secondName: $('#register input[name=secondName]').val(),
            email: $('#register input[name=email]').val(),
            password: $('#register input[name=password]').val()
        })
        $.ajax({
                type: "POST",
                url: "register",
                contentType: "application/json",
                data: regData,
                success: ()=> {
                    $("#register input").val("");
                    $("#paneltoggle").click();
                },
                error: ()=> {
                    $('#register input[name=email]').css("color","red").effect("shake");
                    $('#register input[name=password]').val("");
                }
    })
    })
    $('#btn-login').click(function (event) {
        event.preventDefault();
        var logData = JSON.stringify({
            email: $('#login input[name=email]').val(),
            password: $('#login input[name=password]').val()
        })
        $.ajax({
                type: "POST",
                url: "login",
                contentType: "application/json",
                data: logData,
                success: (data)=> {
                    $("#login input").val("");
                    $("#paneltoggle").click();
                    if(data.role.name) {$("#adminService").show()}
                    sessionStorage.setItem("user", data)
                },
                error: ()=> {
                    $('#login input[name=email]').css("color","red").effect("shake");
                    $('#login input[name=password]').val("");
        }
    })
    })
})