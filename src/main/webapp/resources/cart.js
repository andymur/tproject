    var assignClickHandler = function (selector, handler) {
        // selector is a jquery object
        selector = selector || $(".some-class-which-doesnot-exist");
        handler = handler || function () {
            };
        selector.on("click", handler);
    };

    var restoreCart = function () {
        var arr = getCart();
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
        assignClickHandler($("#usercart"), loadCardPage_Handler);
    });

    function loadCardPage(event) {
        event.preventDefault();
        // var cart = JSON.stringify(getCart());
        var cart = getCart();
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
                    $("#mainWrapper").empty();
                    $("#mainWrapper").append(data);
                    assignClickHandler($(".removeItem"), removeFromCart_Handler);
                }
        })
    }

    function addToCart(productId) {
        var assoArray = getCart();

        if(assoArray[productId] == undefined)
        {
            assoArray[productId] = 1;
        }
        else {
            assoArray[productId] =assoArray[productId]+1
        };
        setCart(assoArray);
    }

    function removeFromCart(productId) {
        var assoArray = getCart();
        delete assoArray[productId];
        setCart(assoArray);
        loadCardPage(event);
    }

    function getCart(){
        var arr = JSON.parse(localStorage.getItem("arr"));
        return (arr === null) ? {} : arr;
    }

    function setCart(arr){
        var amount = 0;
        for (var key in arr) {
            amount += arr[key];
        }
        $('.cart-count').text(amount);
        localStorage.setItem("arr", JSON.stringify(arr))
    }
