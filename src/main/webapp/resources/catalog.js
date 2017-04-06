jQuery(function ($) {
    $('#cat-filter select').change(function () {
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
        var filterParams = 'catalog/filter?categoryId=' + categoryId + '&size=' + size + '&brand=' + brand + '$color=' + color
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
                $("#grid-container-10").remove()
                $('#pr-div').append(data)
    }
    })
    })
})