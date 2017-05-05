jQuery(function ($) {

    $('#btn-add-promo').click(function (event) {
       var productId = $('#form-promo input[name=productId]').val();
       var name = $('#form-promo input[name=name]').val();
       var price = $('#form-promo input[name=price]').val();
       var imageurl = $('#form-promo input[name=imageurl]').val();

       var adProduct = JSON.stringify({
           productId:productId,
           name : name,
           price : price,
           imageUrl : imageurl
       })
        $.ajax({
                type: "POST",
                url: "/productslist/add",
                contentType: "application/json",
                data: adProduct,
                success: ()=> {
                    swal("Product has been created", "success");
                }
        })
    })

    $('#btn-save-product').click(function (event) {
        var brand = $('#br-select option:selected').data('brand-name')
        var category = $('#cat-select option:selected').data('category-name')
        var image = {
            "name": $('#form-product input[name=imagename]').val(),
            "url": $('#form-product input[name=imageurl]').val()
        }
        var parameters = {
            "size": $('#form-product input[name=size]').val(),
            "weight": $('#form-product input[name=weight]').val(),
            "quantity": $('#form-product input[name=quantity]').val()

        }

        var newProduct = JSON.stringify({
            name: $('#form-product input[name=name]').val(),
            model: $('#form-product input[name=model]').val(),
            color: $('#form-product input[name=color]').val(),
            price: $('#form-product input[name=price]').val(),
            parameters: [parameters],
            changeDate: new Date(),
            images: [image],
            brand: brand,
            category: category,
            description: $('#description').val()
        })
        $.ajax({
                type: "POST",
                url: "product/create",
                contentType: "application/json",
                data: newProduct,
                success: ()=> {
                    $("#form-product input").val("");
                    $('#description').val("");
                    swal("Product has been crated", "success");
                },
                error: ()=>{
            swal({
                title: "Error!",
                text: "Product already exist",
                type: "error",
                confirmButtonText: "OK"
            });
                }
        })
    })

    $('#btn-save-category').click(function (event) {
        var newCategory = JSON.stringify({
            "name": $('#form-category input[name=name]').val(),
            "categoryImage": $('#form-category input[name=categoryImage]').val()
        })
        $.ajax({
                type: "POST",
                url: "category/create/",
                contentType: "application/json",
                data: newCategory,
                success: (data)=> {
                $("#form-category input").val("");
        appendCategory(data);
    },
        error: ()=>
        {
            $('#form-category input[name=name]').css("color", "red").effect("shake");
        }
    })
        function appendCategory(data) {
            let dataToAppend = '<option data-category-id=' + data.id + ' data-category-name=' + data.name + ' data-category-products=' + data.products + ' data-category-image=' + data.categoryImage + '>' + data.name + '</option>'
            $('#cat-select').append(dataToAppend);
            $('#cat-edit-select').append(dataToAppend);
        }
    })

    $('#btn-save-brand').click(function (event) {
        var newBrand = JSON.stringify({
            "name": $('#form-brand input[name=name]').val(),
            "brandImage": $('#form-brand input[name=brandImage]').val()
        })
        $.ajax({
                type: "POST",
                url: "brand/create/",
                contentType: "application/json",
                data: newBrand,
                success: (data)=> {
                $("#form-brand input").val("");
        appendBrand(data);
    },
        error: ()=>
        {
            $('#form-brand input[name=name]').css("color", "red").effect("shake");
        }
    })
        function appendBrand(data) {
            let dataToAppend = '<option data-brand-id=' + data.id + ' data-brand-name=' + data.name + ' data-brand-image=' + data.brandImage + '>' + data.name + '</option>'
            $('#br-select').append(dataToAppend);
        }
    })
    $('#btn-edit-category').click(function (event) {
            let category = {
                "id": $('#cat-edit-select option:selected').data('category-id'),
                "name": $('#cat-edit-select option:selected').data('category-name'),
                "categoryImage": $('#cat-edit-select option:selected').data('category-image')
            }
            appendEditCategory(category);
        function appendEditCategory(category){
        let dataToAppend =
            '<div id="app-data"><div class="form-group"><div class="col-sm-10"><input type="hidden" class="form-control" name="id" value='+category.id+' required></div></div>' +
            '<div class="form-group"><label class="col-sm-2 control-label">Name<spanclass="required">*</span></label>' +
            '<div class="col-sm-10"><input type="text" class="form-control" name="name" value='+category.name+' required></div></div>' +
            '<div class="form-group"><label class="col-sm-2 control-label">Image url<spanclass="required">*</span></label>' +
            '<div class="col-sm-10"><input type="text" class="form-control" name="categoryImage" value='+category.categoryImage+' required></div></div></div>'
            $('#btn-edit-category').before(dataToAppend);
            $('#btn-edit-category').prop("disabled", true)
            $('#cat-edit-select').prop("disabled", true)
            $('#btn-update-category').prop("disabled", false)
        }
        })
    $('#btn-update-category').click(function (event) {
        var newCategory = JSON.stringify({
            "id": $('#form-edit-category input[name=id]').val(),
            "name": $('#form-edit-category input[name=name]').val(),
            "categoryImage": $('#form-edit-category input[name=categoryImage]').val()
        })
        $.ajax({
                type: "POST",
                url: "category/update/",
                contentType: "application/json",
                data: newCategory,
                success: (data)=> {
                $("#app-data").remove();
                $("#btn-edit-category").prop("disabled", false)
                $('#cat-edit-select').prop("disabled", false)
                $('#btn-update-category').prop("disabled", true)
    },
        error: ()=>
        {
            $('#form-edit-category input[name=name]').css("color", "red").effect("shake");
        }
    })
    })
})