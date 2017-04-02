jQuery(function ($) {
    $('#btn-save-product').click(function (event) {
        var brand = {
            id : $('#br-select option:selected').data('brand-id'),
            name : $('#br-select option:selected').data('brand-name'),
            brandImage : $('#br-select option:selected').data('brand-image')
        }
        var category = {
            id : $('#cat-select option:selected').data('category-id'),
            name : $('#cat-select option:selected').data('category-name'),
            categoryImage : $('#cat-select option:selected').data('category-image')
        }
        var image = {
            "name" : $('#form-product input[name=imagename]').val(),
            "image" : $('#form-product input[name=imageurl]').val()
        }
        var parameters = {
            "size" : $('#form-product input[name=size]').val(),
            "weight" : $('#form-product input[name=weight]').val()
        }

        var newProduct = JSON.stringify({
            name: $('#form-product input[name=name]').val(),
            model: $('#form-product input[name=model]').val(),
            color: $('#form-product input[name=color]').val(),
            price: $('#form-product input[name=price]').val(),
            quantity: $('#form-product input[name=quantity]').val(),
            parameters : [parameters],
            changeDate : new Date(),
            images: [image],
            brand: brand,
            categories: category,
            description : $('#description').val()
        })
        $.ajax({
                type: "POST",
                url: "product/create",
                contentType: "application/json",
                data: newProduct,
                success: ()=> {
                $("#form-product input").val("");
                },
                error: ()=> {
                $('#form-product input[name=name]').css("color","red").effect("shake");
                $('#form-product input[name=model]').css("color","red").effect("shake");
                $('#form-product input[name=color]').css("color","red").effect("shake");
        }
    })
    })
})