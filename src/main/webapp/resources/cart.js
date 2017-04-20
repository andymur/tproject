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
    var loadOrder_Handler = function (event) {
        loadOrder(event);
    };

    function subtractProduct(event) {
        var productId = event.currentTarget.id;
        var price = event.target.dataset.price;
        removeOne(productId);
        var count = $('#qty'+productId).val();
        $('#qty'+productId).val(count - 1);
        var subtotal = price * ($('#qty'+productId).val())
        $('#subtotal'+productId).html('$'+subtotal);
    }
    var subtract_Handler = function (event) {
        subtractProduct(event);
    };
    function addProduct(event) {
        var productId = event.currentTarget.id;
        var price = event.target.dataset.price;
        addToCart(productId);
        var count = Number($('#qty'+productId).val());
        $('#qty'+productId).val(count + 1);
        var subtotal = price * ($('#qty'+productId).val())
        $('#subtotal'+productId).html('$'+subtotal);
    }
    var add_Handler = function (event) {
        addProduct(event);
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
                    $("#wrapper").empty();
                    $("#wrapper").append(data);
                    assignClickHandler($(".removeItem"), removeFromCart_Handler);
                    assignClickHandler($(".sub"), subtract_Handler);
                    assignClickHandler($(".add"), add_Handler);
                    assignClickHandler($("#orderBtn"), loadOrder_Handler);
                    checkCartSize();
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

    function removeOne(productId) {
        var assoArray = getCart();

        if(assoArray[productId] === 1)
        {
            delete assoArray[productId];
            setCart(assoArray);
            loadCardPage(event);
        }
        else {
            assoArray[productId] =assoArray[productId]-1
        };
        setCart(assoArray);
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
    
function loadOrder(event) {
      event.preventDefault();
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
                url: "order",
                contentType: "application/json",
                data:dataToPush,
                success:(data)=>{
                    $("#wrapper").html(data);
                    assignClickHandler($("#submit-order"), submitOrder_Handler);
                }
    })
    }

