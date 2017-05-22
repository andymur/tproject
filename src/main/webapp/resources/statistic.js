function loadStatistic(event) {
    event.preventDefault();
    $.get("/statistic", (data)=>{
        $('#wrapper').html(data);
        $('.zoomContainer').remove();
    })
}
var loadStatistic_Handler = function (event) {
    loadStatistic(event);
};

$(function () {
    assignClickHandler($("#statistic"), loadStatistic_Handler);
});