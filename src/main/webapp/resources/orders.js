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


var submitOrder_Handler = function (event) {
    var orderId = this.value;
    submitOrder(orderId);
};
var repeatOrder_Handler = function (event) {
    var orderId = this.value;
    repeatOrder(orderId);
};

$(function () {
    assignClickHandler($(".saveOrderStatus"), submitOrder_Handler);
    assignClickHandler($(".repeatOrder"), repeatOrder_Handler);

});

function submitOrder(orderId) {
    var orderStatusCode = $('#orderStatusSelect option:selected').data('order-status');


    var orderStatusData = JSON.stringify({
        orderId: orderId,
        orderStatusCode: orderStatusCode
    })
    $.ajax({
        type: "PUT",
        url: "order",
        contentType: "application/json",
        data: orderStatusData
    })
}

function repeatOrder(orderId) {
    var orderStatusCode = $('#orderStatusSelect option:selected').data('order-status');
    var orderStatusData = JSON.stringify({
        orderId: orderId,
        orderStatusCode: orderStatusCode
    })
    $.ajax({
        type: "POST",
        url: "order/repeat",
        contentType: "application/json",
        data: orderStatusData,
        success: (data)=>{
            $("#wrapper").html(data);
            assignClickHandler($("#submit-order"), submitOrder_Handler);
            assignChangeHandler($("#deliveryAddressSelect"), changeAddress_Handler)
        }
    })
}
