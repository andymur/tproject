jQuery(function ($) {
    // actionAdminTab();

    // function actionAdminTab () {
    //     if(sessionStorage.getItem("user") !== null && JSON.parse(sessionStorage.getItem("user")).role.name === "user") {
    //         $("#adminService").show()
    //     }else {$("#adminService").hide()}
    // }

    $('#btn-register').click(function (event) {
        event.preventDefault();
        var regData = JSON.stringify({
            name: $('#firstName').val(),
            lastName: $('#lastName').val(),
            email: $('#email').val(),
            password: $('#password').val(),
            ssoId : $('#ssoId').val()
        })
        $.ajax({
                type: "POST",
                url: "newuser",
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
    // $('#btn-login').click(function (event) {
    //     event.preventDefault();
    //     var logData = JSON.stringify({
    //         email: $('#login input[name=email]').val(),
    //         password: $('#login input[name=password]').val()
    //     })
    //     $.ajax({
    //             type: "POST",
    //             url: "login",
    //             contentType: "application/json",
    //             data: logData,
    //             success: (data)=> {
    //                 $("#login input").val("");
    //                 $("#paneltoggle").click();
    //                 sessionStorage.setItem("user", JSON.stringify(data));
    //                 actionAdminTab();
    //             },
    //             error: ()=> {
    //                 $('#login input[name=email]').css("color","red").effect("shake");
    //                 $('#login input[name=password]').val("");
    //     }
    // })
    // })
})