    var assignClickHandler = function (selector, handler) {
        // selector is a jquery object
        selector = selector || $(".some-class-which-doesnot-exist");
        handler = handler || function () {
            };
        selector.on("click", handler);
    };

    var restoreCart = function () {
        var cart = getCart();
        var amount = countAmount(cart);
        $('.cart-count').text(amount);
    }

    var checkCartSize = function () {
        var arr = getCart();
        var amount = 0;
        for (var key in arr) {
            amount += arr[key];
        }
        if(amount <= 0 ){
            $("#orderBtn").addClass('disabled');
        }
    }

    var removeClickHandler = function (selector, handler) {
        // selector is a jquery object
        selector = selector || $(".some-class-which-doesnot-exist");
        handler = handler || function () {
            };
        selector.off("click", handler);
    };

    var addToCart_Handler = function (event) {
        var buttonValue = this.value;
        addToCart(buttonValue, event);
    };

    var removeFromCart_Handler = function (event) {
        var buttonValue = this.value;
        removeFromCart(buttonValue, event);
    };
    var loadCardPage_Handler = function (event) {
        loadCardPage(event);
    };

    var loadStatistic_Handler = function (event) {
        loadStatistic(event);
    };

    var loadPromo_Handler = function (event) {
        loadPromo(event);
    };

    var loadAdminProducts_Handler = function (event) {
        loadAdminProducts(event);
    };

    var addPromo_Handler = function (event) {
        addPromo(event);
    };

    var removePromo_Handler = function (event) {
        var buttonValue = this.value;
        removePromo(buttonValue, event);
    };
    var loadOrder_Handler = function (event) {
        loadOrder(event);
    };

    function loadPromo(event) {
        event.preventDefault();
        $.get("/promo", (data)=>{
            $('#wrapper').html(data);
            $('.zoomContainer').remove();
            assignClickHandler($("#btn-add-promo"), addPromo_Handler);
            assignClickHandler($(".removePromoProduct"), removePromo_Handler);
        });
    }

    function loadAdminProducts(event) {
        event.preventDefault();
        $.get("/admin_products", (data)=>{
            $('#wrapper').html(data);
            $('.zoomContainer').remove();
            // assignClickHandler($("#btn-add-promo"), addPromo_Handler);
            // assignClickHandler($(".removePromoProduct"), removePromo_Handler);
        });
    }


    function addPromo(event) {
        var productId = $("#productSelect option:selected").data('id');
        if(productId === undefined){
            swal({
                title: "Error!",
                text: "Please select product",
                type: "error",
                confirmButtonText: "OK"
            });
        } else{
            var adProduct = JSON.stringify({
                productId:productId
            })

            $.ajax({
                    type: "POST",
                    url: "/productslist/add",
                    contentType: "application/json",
                    data: adProduct,
                    success: ()=> {swal({title: 'DONE.',text: '',timer: 500});
                    loadPromo(event);
                    },
                    error:()=> {
                        swal({
                            title: "Error!",
                            text: "Product already in promo list",
                            type: "error",
                            confirmButtonText: "OK"
                        });
                    }
            })
        }
    }

    function removePromo(productId, event) {

        var adProduct = JSON.stringify({
            productId:productId
        })
        $.ajax({
                type: "POST",
                url: "/productslist/remove",
                contentType: "application/json",
                data: adProduct,
                success: ()=> {
                    swal({title: 'DONE.',text: '',timer: 500});
                    $('#'+productId).remove();
                }
        })
    }

    function subtractProduct(event) {
        var productId = event.currentTarget.id;
        var price = event.target.dataset.price;
        var size = event.target.dataset.size;
        removeOne(productId, event);
        var selector = '#qty'+productId+size;
        var count = Number($(selector).val());
        $(selector).val(count - 1);
        var subtotal = price * ($(selector).val())
        $('#subtotal'+productId+size).html('$'+subtotal);
    }
    var subtract_Handler = function (event) {
        subtractProduct(event);
    };
    function addProduct(event) {
        var productId = event.currentTarget.id;
        var price = event.target.dataset.price;
        var size = event.target.dataset.size;
        addToCart(productId, event);
        var selector = '#qty'+productId+size;
        var count = Number($(selector).val());
        $(selector).val(count + 1);
        var subtotal = price * ($(selector).val())
        $('#subtotal'+productId+size).html('$'+subtotal);
    }
    var add_Handler = function (event) {
        addProduct(event);
    };

    $(function () {
        restoreCart();
        assignClickHandler($(".addToCart"), addToCart_Handler);
        assignClickHandler($("#cart"), loadCardPage_Handler);
        assignClickHandler($("#usercart"), loadCardPage_Handler);
        assignClickHandler($("#statistic"), loadStatistic_Handler);
        assignClickHandler($("#promo"), loadPromo_Handler);
        assignClickHandler($("#admin_products"), loadAdminProducts_Handler);
    });



    function loadCardPage(event) {
        event.preventDefault();
        var dataToPush = JSON.stringify(getCart());
        $.ajax({
                type: "POST",
                url: "/basket",
                contentType: "application/json",
                data: dataToPush,
                success:(data)=>{
                    $("#wrapper").html(data);
                    $('.zoomContainer').remove();
                    assignClickHandler($(".removeItem"), removeFromCart_Handler);
                    assignClickHandler($(".sub"), subtract_Handler);
                    assignClickHandler($(".add"), add_Handler);
                    assignClickHandler($("#orderBtn"), loadOrder_Handler);
                    checkCartSize();
                }
        })
    }

    function addToCart(productId, event) {
        var cart = getCart();
        var customSelect  = '#size'+parseInt(productId)+' option:selected';
        var size = $(customSelect).data('size');
        if(size === undefined){
            size = event.target.dataset.size;
        }
        var cartRow = findElement(cart, productId, size);
        if(cartRow === undefined){
            var row = {}
            row.productId = productId;
            row.size = size;
            row.count = 1;
            cart.push(row);
        } else {
            cartRow.count++;
        }
        setCart(cart);
    }

    function findElement(cart, productId, size) {
        for(var i=0; i < (cart.length) && (cart.length > 0);i++){
            if(cart[i].productId === productId && cart[i].size === size){
                return cart[i];
            }
        }
        return undefined;
    }

    function removeFromCart(productId, event) {
        var cart = getCart();
        var size = event.target.dataset.size;
        $.each(cart,(i)=>{
            if(cart[i].productId === productId && cart[i].size === size){
            cart.splice(i,1);
            return false;
            }
        })
        setCart(cart);
        loadCardPage(event);
    }

    function removeOne(productId, event) {
        var cart = getCart();
        var size = event.target.dataset.size;
        var cartRow = findElement(cart, productId, size);
        if(cartRow.count === 1){
            $.each(cart,(i)=>{
                if(cart[i].productId === productId && cart[i].size === size && cart[i].count === 1){
                    cart.splice(i,1);
                    return false;
                }
            })
            setCart(cart);
            loadCardPage(event);
        } else{
            cartRow.count--;
        }
        setCart(cart);
    }

    function getCart(){
        var arr = JSON.parse(localStorage.getItem("arr"));
        return (arr === null) ? [] : arr;
    }

    function setCart(cart){
        var amount = countAmount(cart);
        $('.cart-count').text(amount);
        localStorage.setItem("arr", JSON.stringify(cart))
    }

    function countAmount(cart) {
        var amount = 0;
        for(var i=0; i < (cart.length) && (cart.length > 0);i++){
           amount += cart[i].count;
        }
        return amount;
    }
    
function loadOrder(event) {
      event.preventDefault();
    var dataToPush = JSON.stringify(getCart());
        $.ajax({
                type: "POST",
                url: "/order",
                contentType: "application/json",
                data:dataToPush,
                success:(data)=>{
                    $("#wrapper").html(data);
                    $('.zoomContainer').remove();
                    assignClickHandler($("#submit-order"), submitOrder_Handler);
                }
    })
    }

