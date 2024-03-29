$(function () {
    assignClickHandler($(".productButton"), goToProduct_Handler);
    assignClickHandler($(".editProduct"), editProduct_Handler);
})

var editProduct_Handler = function (event) {
    editProduct(event);
};

var updateProduct_Handler = function (event) {
    updateProduct(event);
};

function updateProduct(event){
    event.preventDefault();
    var productId = event.target.dataset.id;

    var parameters = [];
    var ids = $('.paramId');
    $.each(ids,(i)=>{
        var paramId = ids[i].value;
    var quantity = ids[i].parentElement.parentElement.getElementsByTagName('input')[name='quantity'].value;
    var weight = ids[i].parentElement.parentElement.getElementsByTagName('input')[name='weight'].value;
    var param = {
        id : paramId,
        quantity : quantity,
        weight : weight
    };
    parameters.push(param);
    })

    var images = [];
    var ids = $('.imageurl');
    $.each(ids,(i)=>{
        var id = ids[i].value;
    var name = $('#pic'+id+' input[name=name]').val();
    var url = $('#pic'+id+' input[name=url]').val();
    var img = {
        id : id,
        name : name,
        url : url
    };
    images.push(img);
    })

    var data = JSON.stringify({
        id : productId,
        parameters : parameters,
        images: images,
        name: $('input[name=name]').val(),
        model: $('input[name=model]').val(),
        color: $('input[name=color]').val(),
        description: $('#description').val(),
        price: $('input[name=price]').val(),
        changeDate: new Date()
    })
    $.ajax({
            type: "POST",
            url: "product/update",
            contentType: "application/json",
            data: data,
            success: ()=> {swal({title: 'DONE.',text: '',timer: 500});},
            error: (data)=>{
                swal({
                    title: "Error!",
                    text: data.responseText,
                    type: "error",
                    confirmButtonText: "OK"
                });
            }
    })

}

function editProduct(event) {
    var productId = event.currentTarget.dataset.id;
    $.ajax({
            type: "GET",
            url: "product/edit/"+productId,
            contentType: "application/json",
            success:(data)=>{
            $("#wrapper").html(data);
            $('.zoomContainer').remove();
            assignClickHandler($("#updateProduct"), updateProduct_Handler)
            }
    })
}

$(document).on('change', '#cat-filter select', function () {
    var categoryId = $('#cat-filter').data('category-id')
    if ($('#color-select option:selected').is(':disabled') == false) {
        var color = $('#color-select option:selected').val()
    }
    if ($('#size-select option:selected').is(':disabled') == false) {
        var size = $('#size-select option:selected').val()
    }
    if ($('#br-select option:selected').is(':disabled') == false) {
        var brand = $('#br-select option:selected').val()
    }
    var filterParams = 'catalog/filter?categoryId=' + categoryId + '&size=' + size + '&brand=' + brand + '&color=' + color
    var dataFilter = JSON.stringify({
        categoryId: categoryId,
        color: color,
        brand: brand,
        size: size
    })
    $.ajax({
            type: "GET",
            url: filterParams,
            success: (data)=> {
            $("#wrapper").html(data);
    $('.zoomContainer').remove();
    assignClickHandler($(".addToCart"), addToCart_Handler);
    assignClickHandler($(".productButton"), goToProduct_Handler);
    assignClickHandler($(".editProduct"), editProduct_Handler);
}
})
})


var goToProduct_Handler = function () {
    var buttonValue = this.value;
    goToProduct(buttonValue);
};

function goToProduct(productId) {
    location.href = "product/" + productId;
}

