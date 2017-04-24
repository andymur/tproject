/**
 * Created by alexpench on 22.04.17.
 */

$(function () {
    var oddClick = true;
    $(".pic").click(function() {
        $(this).animate({
            width: oddClick ? 360 : 150
        },500);
        oddClick = !oddClick;
    });

    $('#saveProduct').click(function(event){
        event.preventDefault();
        var productId = event.target.dataset.productId;

        var data = JSON.stringify({
            productId : productId,
            name: $('input[name=name]').val(),
            model: $('input[name=model]').val(),
            color: $('input[name=color]').val(),
            description: $('#description').val(),
            quantity: $('input[name=quantity]').val(),
            price: $('input[name=price]').val(),
            changeDate: new Date()
        })
        $.ajax({
                type: "POST",
                url: "product/update",
                contentType: "application/json",
                data: data,
                success: ()=> {
                    alert("Product updated");
                },
                error: ()=>{

                }
        })

    })
})

$(document).on('click', '.removeParameter', function () {
    var buttonValue = this.value;
    $('#par'+buttonValue).remove();
})