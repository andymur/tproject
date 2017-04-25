var deliveryType;
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


// var loadCardPage_Handler = function (event) {
//     loadCardPage(event);
// };

var submitOrder_Handler = function (event) {
    submitOrder(event);
};

var submitPayment_Handler = function (event) {
    var orderId = this.value;
    submitPayment(orderId);
};

function submitOrder(event) {
    deliveryType = $('#deliveryTypeSelect option:selected').val();
    var paymentType = $('input[name=payment]:checked').val();
    if(deliveryType === 'DELIVERY'){
        var deliveryAddressDto = {
            country: $('#checkout-order-form input[name=country]').val(),
            city: $('#checkout-order-form input[name=city]').val(),
            street: $('#checkout-order-form input[name=street]').val(),
            building: $('#checkout-order-form input[name=building]').val(),
            zipCode: $('#checkout-order-form input[name=zipCode]').val(),
            appartment: $('#checkout-order-form input[name=appartment]').val(),
            email: $('#checkout-order-form input[name=email]').val(),
            phoneNumber: $('#checkout-order-form input[name=phonenumber]').val()
        }
    }
    var orderDto = JSON.stringify({
        productAndAmounts: getCart(),
        deliveryAddressDto: deliveryAddressDto,
        paymentType: paymentType,
        deliveryType: deliveryType
    })
    $.ajax({
            type: "POST",
            url: "/order/create",
            contentType: "application/json",
            data: orderDto,
            success: (data)=> {
            $('.cart-count').text("0");
    if(paymentType === 'CARD'){
        $("#wrapper").html(data);
        assignClickHandler($("#submitPayment"), submitPayment_Handler);
    } else {
        $("#wrapper").html(
            '</br></br></br></br></br>' +
            'Order successfully paid. Email confirmation has been sent to your box.' +
            'Continue <a href="shop">shopping</a>' +
            '</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>'
        );
    }
    localStorage.removeItem("arr")

},
            error:(data)=>{alert();
        swal({
            title: "Error!",
            text: data.responseText,
            type: "error",
            confirmButtonText: "OK"
        });
            }
})
}

function submitPayment(orderId) {

    var orderStatusData = JSON.stringify({
        orderId: orderId,
        orderStatusCode: "AWAIT_SHIPMENT",
        paymentStatusCode : "PAID"
    })
    $.ajax({
        type: "PUT",
        url: "/order",
        contentType: "application/json",
        data: orderStatusData,
        success:()=>{
            $('#payment-form').remove();
            $('#countdown').remove();
            $('#payment').append(
                'Order successfully paid. Email confirmation has been sent to your box.' +
                'Continue <a href="shop">shopping</a>'
            )
        }
    })
}

function getArr(){
    var arr = JSON.parse(localStorage.getItem("arr"));
    return (arr === null) ? {} : arr;
}

$(document).on('change', '#form-deliveryTypes select', function () {
    deliveryType = $('#deliveryTypeSelect option:selected').val();
    if(deliveryType === 'DELIVERY'){
        $('#deliveryForm').html(
            '<div class="col-md-6">'+
            '<div class="heading">Billing Details</div>'+
            '<div id="checkout-order-form">'+
            '<label>Country</label>'+
            '<input type="text" class="form-control" name="country" placeholder="Enter your country">'+
            '<label>Street</label>'+
            '<input type="text" class="form-control" name="street" placeholder="Enter your street">'+
            '<label>Building</label>'+
            '<input type="text" class="form-control" name="building" placeholder="Enter your building">'+
            '<label>Appartment</label>'+
            '<input type="text" class="form-control" name="appartment" placeholder="Enter your appartment">'+
            '<label>Town/City</label>'+
            '<input type="text" class="form-control" name="city" placeholder="Enter your town/city name">'+
            '<label>Zip Code</label>'+
            '<input type="text" class="form-control" name="zipCode" placeholder="Enter your zipcode">'+
            '<label>Email Address</label>'+
            '<input type="text" class="form-control" name="email" placeholder="Enter your  email address">'+
            '<label>Phone Nmber</label>'+
            '<input type="text" class="form-control" name="phonenumber" placeholder="Enter your phone number">'+
            '</div>'+
            '</div>'
        )
    } else {
        $('#deliveryForm').html('');
    }
})
