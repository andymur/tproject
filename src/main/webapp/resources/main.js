/**
 * Created by alexpench on 12.04.17.
 */
//SHOP TAB
$(function () {
    assignClickHandler($("#shop"), shopPageLoad_Handler);
});
var shopPageLoad_Handler = function (event) {
    var url = this.href
    loadShopPage(event,url);
};

function loadShopPage(event, url) {
    event.preventDefault();
    $.ajax({
        type: "GET",
        url: url,
        contentType: "application/json"
    })
    .done((data)=>{
        $("#mainWrapper").empty();
        $("#mainWrapper").append(data)
        assignClickHandler($(".catalogPage"), catalogTabLoad_Handler);//ASSIGN CLICK HANDLER ON CATALOG ELEMENTS
    });
}
//CATALOG TAB
var catalogTabLoad_Handler = function (event) {
    var url = this.href(event);
    loadCatalogPage(event, url);
};
function loadCatalogPage(event, url){
    $.get($(url))
        .done((data)=>{
            $("#mainWrapper").empty();
            $("#mainWrapper").append(data);
        });
}
//HANDLER FUNCTIONS
var assignClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.on("click", handler);
};

var removeClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.off("click", handler);
};