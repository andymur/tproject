var assignClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.on("click", handler);
};

var removeClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.off("click", handler);
};


var loadCardPage_Handler = function (event) {
    loadCardPage(event);
};

var submitOrder_Handler = function (event) {
    submitOrder(event);
};

$(function () {
    assignClickHandler($("#cart1"), loadCardPage_Handler);
    assignClickHandler($("#submit-order"), submitOrder_Handler);

});

function submitOrder(event) {
    var cart = getArr();
    var rows = [];

    for (var key in cart) {
        var row = {}
        row.productId = parseInt(key);
        row.count = cart[key];
        rows.push(row);
    }

    var paymentType = $('#paymentTypeSelect option:selected').data('payment-type');
    var deliveryType = $('#deliveryTypeSelect option:selected').data('delivery-type');

    var deliveryAddressDto = {
        country: $('#checkout-order-form input[name=country]').val(),
        city: $('#checkout-order-form input[name=city]').val(),
        street: $('#checkout-order-form input[name=street]').val(),
        building: $('#checkout-order-form input[name=building]').val(),
        zipCode: $('#checkout-order-form input[name=zipCode]').val(),
        apartment: $('#checkout-order-form input[name=apartment]').val()
    }
    var basketDto = {rows: rows};

    var orderDto = JSON.stringify({
        basketDto: basketDto,
        deliveryAddressDto: deliveryAddressDto,
        paymentType: paymentType,
        deliveryType: deliveryType
    })
    $.ajax({
            type: "POST",
            url: "order/create",
            contentType: "application/json",
            data: orderDto,
            success: (data)=> {
            $('.cart-count').text("0");
    localStorage.removeItem("arr")
    $("#wrapper").remove();
    $("#body").append(data);
    // assignClickHandler($(".removeItem"), removeFromCart_Handler);
}
})
}


function loadCardPage(event) {
    event.preventDefault();
    // var cart = JSON.stringify(getCart());
    var cart = getArr();
    var rows = [];

    for(var key in cart){
        var row = {}
        row.productId = parseInt(key);
        row.count = cart[key];
        rows.push(row);
    }
    var dataToPush = JSON.stringify({rows : rows});
    $.ajax({
            type: "POST",
            url: "basket",
            contentType: "application/json",
            data: dataToPush,
            success:(data)=>{
            $("#wrapper").remove();
    $("#body").append(data);
    assignClickHandler($(".removeItem"), removeFromCart_Handler);
}
})
}

function getArr(){
    var arr = JSON.parse(localStorage.getItem("arr"));
    return (arr === null) ? {} : arr;
}
