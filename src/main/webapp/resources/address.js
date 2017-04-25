/**
 * Created by alexpench on 25.04.17.
 */
$(function () {
    assignClickHandler($("#btn-save-address"), saveAddress_Handler);
})

function saveAddress(event) {
    var addressDto = {
        country: $('#newAddressForm input[name=country]').val(),
        city: $('#newAddressForm input[name=city]').val(),
        street: $('#newAddressForm input[name=street]').val(),
        building: $('#newAddressForm input[name=building]').val(),
        zipCode: $('#newAddressForm input[name=zipCode]').val(),
        appartment: $('#newAddressForm input[name=appartment]').val(),
        email: $('#newAddressForm input[name=email]').val(),
        phoneNumber: $('#newAddressForm input[name=phonenumber]').val()
    }
    addressDto = JSON.stringify(addressDto);

    $.ajax({
            type: "POST",
            url: "/address/create",
            contentType: "application/json",
            data: addressDto,
            success: (data)=>{
                swal({
                    title: "Address has been saved",
                    text: "",
                    type: "success",
                    showCancelButton: false,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true
                }, function () {
                        location.reload();
                    });

            }
    })
}
var saveAddress_Handler = function (event) {
    saveAddress(event);
};