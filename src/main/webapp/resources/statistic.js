function loadStatistic(event) {
    event.preventDefault();
    $.get("/statistic", (data)=>{$('#wrapper').html(data);})
    //     , function (data) {
    //
    //     $('#wrapper').html('' +
    //         '<div id="wrapper">' +
    //         '<div class="container">' +
    //         '<div class="numbers">' +
    //         '<div class="container">' +
    //         '<div class="row">' +
    //         '<div class="col-md-12">' +
    //         '<h2><span class="color">STATISTIC</span></h2>' +
    //         '</div>' +
    //         '</div>' +
    //         '<div class="row number-row">' +
    //         '<div class="col-md-6">' +
    //         '<div class="number-box">' +
    //         '<h3><span class="counter">$'+data["monthRevenue"]+'</span></h3>' +
    //         '</div>' +
    //         '<div class="heading">MONTH REVENUE</div>' +
    //         '<p>Current month revenue.</p>' +
    //         '</div>' +
    //         '<div class="col-md-6">' +
    //         '<div class="number-box">' +
    //         '<h3><span class="counter">$'+data["weekRevenue"]+'</span></h3>' +
    //         '</div>' +
    //         '<div class="heading">WEEK REVENUE</div>' +
    //         '<p>Current week revenue.</p>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '<div class="container">' +
    //         '<div class="chartss">' +
    //         '<div class="container">' +
    //         '<div class="row number-row">' +
    //         '<div class="col-md-6">' +
    //         '<canvas id="topProducts"></canvas>' +
    //         '<div class="heading">TOP 10 PRODUCTS</div>' +
    //         '</div>' +
    //         '<div class="col-md-6">' +
    //         '<canvas id="topUsers"></canvas>' +
    //         '<div class="heading">TOP 10 USERS</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>' +
    //         '</div>');
    //
    //     var products = data["topProducts"];
    //     var users = data["topUsers"];
    //
    //     var option = {
    //         responsive: true,
    //     };
    //     var topProductsData = [
    //         {
    //             value: products[0].count,
    //             color:"#F7464A",
    //             highlight: "#FF5A5E",
    //             label: products[0].name
    //         },
    //         {
    //             value: products[1].count,
    //             color: "#46BFBD",
    //             highlight: "#5AD3D1",
    //             label: products[1].name
    //         },
    //         {
    //             value: products[2].count,
    //             color: "#FDB45C",
    //             highlight: "#FFC870",
    //             label: products[2].name
    //         },
    //         {
    //             value: products[3].count,
    //             color: "#fdfa3f",
    //             highlight: "#fffeb2",
    //             label: products[3].name
    //         },
    //         {
    //             value: products[4].count,
    //             color: "#0dfd24",
    //             highlight: "#91ff87",
    //             label: products[4].name
    //         },
    //         {
    //             value: products[5].count,
    //             color: "#10c5fd",
    //             highlight: "#aadaff",
    //             label: products[5].name
    //         },
    //         {
    //             value: products[6].count,
    //             color: "#2818fd",
    //             highlight: "#7374ff",
    //             label: products[6].name
    //         },
    //         {
    //             value: products[7].count,
    //             color: "#bb16fd",
    //             highlight: "#d6b3ff",
    //             label: products[7].name
    //         },
    //         {
    //             value: products[8].count,
    //             color: "#fd1edf",
    //             highlight: "#ffc3ef",
    //             label: products[8].name
    //         },
    //         {
    //             value: products[9].count,
    //             color: "#8d336a",
    //             highlight: "#bc84a5",
    //             label: products[9].name
    //         }
    //     ];
    //
    //     var topUsersData = [
    //         {
    //             value: users[0].countOfOrders,
    //             color:"#F7464A",
    //             highlight: "#FF5A5E",
    //             label: users[0].name
    //         },
    //         {
    //             value: users[1].countOfOrders,
    //             color: "#46BFBD",
    //             highlight: "#5AD3D1",
    //             label: users[1].name
    //         }
    //         // ,
    //         // {
    //         //     value: users[2].countOfOrders,
    //         //     color: "#FDB45C",
    //         //     highlight: "#FFC870",
    //         //     label: users[2].name
    //         // },
    //         // {
    //         //     value: users[3].countOfOrders,
    //         //     color: "#fdfa3f",
    //         //     highlight: "#fffeb2",
    //         //     label: users[3].name
    //         // },
    //         // {
    //         //     value: users[4].countOfOrders,
    //         //     color: "#0dfd24",
    //         //     highlight: "#91ff87",
    //         //     label: users[4].name
    //         // },
    //         // {
    //         //     value: users[5].countOfOrders,
    //         //     color: "#10c5fd",
    //         //     highlight: "#aadaff",
    //         //     label: users[5].name
    //         // },
    //         // {
    //         //     value: users[6].countOfOrders,
    //         //     color: "#2818fd",
    //         //     highlight: "#7374ff",
    //         //     label: users[6].name
    //         // },
    //         // {
    //         //     value: users[7].countOfOrders,
    //         //     color: "#bb16fd",
    //         //     highlight: "#d6b3ff",
    //         //     label: users[7].name
    //         // },
    //         // {
    //         //     value: users[8].countOfOrders,
    //         //     color: "#fd1edf",
    //         //     highlight: "#ffc3ef",
    //         //     label: users[8].name
    //         // },
    //         // {
    //         //     value: users[9].countOfOrders,
    //         //     color: "#8d336a",
    //         //     highlight: "#bc84a5",
    //         //     label: users[9].name
    //         // }
    //     ];
    //     var ctxProd = document.getElementById("topProducts").getContext('2d');
    //     var myPieChartProducts = new Chart(ctxProd).Pie(topProductsData,option);
    //     var ctxUser = document.getElementById("topUsers").getContext('2d');
    //     var myPieChartUsers = new Chart(ctxUser).Pie(topUsersData,option);
    // })
}
var loadStatistic_Handler = function (event) {
    loadStatistic(event);
};

$(function () {
    assignClickHandler($("#statistic"), loadStatistic_Handler);
});