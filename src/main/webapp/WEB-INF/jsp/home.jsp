<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
</head>
<h1>This is customer home page</h1>
<body>
<script>
    jQuery(function ($) {

        var customerName = "${Customer.name}"
        var customerId = ${Customer.id}
        var customerEmail = "${Customer.email}"


        $('#saveAddress').click(function () {

            var addressData = JSON.stringify({
                country: $('#address input[name=country]').val(),
                city: $('#address input[name=city]').val(),
                street: $('#address input[name=street]').val(),
                building: $('#address input[name=building]').val(),
                apartment: $('#address input[name=apartment]').val(),
                zipCode: $('#address input[name=zipCode]').val(),
                customer: {
                    id: customerId,
                    name: customerName,
                    email: customerEmail
                }
            })
            $.ajax({
                    type: "POST",
                    url: "address",
                    contentType: "application/json",
                    data: addressData,
                    success: () => {
                    $("#address input").val("");
        }
        })
        })
    })
</script>


Hello ${Customer.name} !<br/><br/>

<h2>Add new address here:</h2>
<div id="address">
    COUNTRY:<input type="text" name="country"/><br/><br/>
    city:<input type="text" name="city"/><br/><br/>
    street:<input type="text" name="street"/><br/><br/>
    building:<input type="text" name="building"/><br/><br/>
    apartment:<input type="text" name="apartment"/><br/><br/>
    zipCode:<input type="text" name="zipCode"/><br/><br/>
    <button id="saveAddress">Save</button>
</div>

</body>

</html>