/**
 * Created by alexpench on 22.04.17.
 */

$(function () {
    var oddClick = true;
    $(".pic").click(function() {
        $(this).animate({
            width: oddClick ? 360 : 150
        },500);
        oddClick = !oddClick;
    });

})

$(document).on('click', '.removeParameter', function () {
    var buttonValue = this.value;
    $('#par'+buttonValue).remove();
})