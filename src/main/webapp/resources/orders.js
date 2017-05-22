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


var saveOrderStatus_Handler = function (event) {
    var orderId = this.value;
    saveOrderStatus(orderId);
};
var repeatOrder_Handler = function (event) {
    var orderId = this.value;
    repeatOrder(orderId);
};

$(function () {
    assignClickHandler($(".saveOrderStatus"), saveOrderStatus_Handler);
    assignClickHandler($(".repeatOrder"), repeatOrder_Handler);

});

function saveOrderStatus(orderId) {
    var orderStatusCode = $('#orderStatusSelect option:selected').data('order-status');


    var orderStatusData = JSON.stringify({
        orderId: orderId,
        orderStatusCode: orderStatusCode
    })
    $.ajax({
        type: "PUT",
        url: "order",
        contentType: "application/json",
        data: orderStatusData,
            success: ()=> {swal({title: 'DONE.',text: '',timer: 500});}
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
            $('.zoomContainer').remove();
            assignClickHandler($("#submit-order"), submitOrder_Handler);
            assignChangeHandler($("#deliveryAddressSelect"), changeAddress_Handler)
        }
    })
}
