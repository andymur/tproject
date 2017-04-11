
    // $('#btnAddToCart').click(()=>{
    //
    //     var product = $(this).val()
    //     if(sessionStorage.getItem(product.productid) === null){
    //         sessionStorage.setItem(product.productid, 1)
    //     } else {
    //     var total = parseInt( sessionStorage.getItem(product.productid) );
    //     total++;
    //     sessionStorage.setItem( product.productid, total );
    //         $('.cart-count').text(total);
    // }
    // })

    var assignClickHandler = function (selector, handler) {
        // selector is a jquery object
        selector = selector || $(".some-class-which-doesnot-exist");
        handler = handler || function () {
            };
        selector.on("click", handler);
    };

    var restoreCart = function () {
        // var cart = getCart();
        // $('.cart-count').text(cart.amount);
        var arr = getArr();
        var amount = 0;
        for (var key in arr) {
            amount += arr[key];
        }
        $('.cart-count').text(amount);
    }

    var removeClickHandler = function (selector, handler) {
        // selector is a jquery object
        selector = selector || $(".some-class-which-doesnot-exist");
        handler = handler || function () {
            };
        selector.off("click", handler);
    };

    var addToCart_Handler = function () {
        var buttonValue = this.value;
        addToCart(buttonValue);
    };

    var removeFromCart_Handler = function () {
        var buttonValue = this.value;
        removeFromCart(buttonValue);
    };
    var loadCardPage_Handler = function (event) {
        loadCardPage(event);
    };

    $(function () {
        restoreCart();
        assignClickHandler($(".addToCart"), addToCart_Handler);
        assignClickHandler($("#cart"), loadCardPage_Handler);
    });

    function loadCardPage(event) {
        event.preventDefault();
        // var cart = JSON.stringify(getCart());
        var cart = getArr();
        var rows = [];

        for(var key in cart){
            var row = {}
            row.productId = parseInt(key);
            row.count = cart[key];
            rows.push(row);
        }
           var dataToPush = JSON.stringify({rows : rows});
        $.ajax({
                type: "POST",
                url: "basket",
                contentType: "application/json",
                data: dataToPush,
                success:(data)=>{
                    $("#wrapper").remove();
                    $("#body").append(data);
                    assignClickHandler($(".removeItem"), removeFromCart_Handler);
                }
        })
    }

    function addToCart(productId) {
        var assoArray = getArr();

        if(assoArray[productId] == undefined)
        {
            assoArray[productId] = 1;
        }
        else {
            assoArray[productId] =assoArray[productId]+1
        };
        setArr(assoArray);
    }

    function removeFromCart(productId) {
        var assoArray = getArr();
        delete assoArray[productId];
        setArr(assoArray);
        loadCardPage(event);
    }

    function getArr(){
        var arr = JSON.parse(sessionStorage.getItem("arr"));
        return (arr === null) ? {} : arr;
    }

    function setArr(arr){
        var amount = 0;
        for (var key in arr) {
            amount += arr[key];
        }
        $('.cart-count').text(amount);
        sessionStorage.setItem("arr", JSON.stringify(arr))
    }
