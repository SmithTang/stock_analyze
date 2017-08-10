// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('singlestock'));

var data0={};
var option={};
var fakeTime = 201307010930;

$(document).ready(function () {

    Init();

});

function Init() {
    InitTable();
    InitSearchButton();
    InitPlayButton();
    InitPauseButton();
    InitResetButton();
    InitCandleStick();
}

function InitTable() {
    $.ajax({
        url: "stockprice/fakeTime/" + fakeTime,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        complete: function (data) {
            $("#stockTable tr:gt(0)").remove();
            $.each(data.responseJSON,function (index, value) {
                var newRow = "<tr><td>" + value[0] +
                    "</td><td>" + value[2];
                if(value[3] >= 0.000000)
                    newRow += "</td><td><span class='label label-danger'>" + (value[3]).toFixed(2) + "%" + "</span></td></tr>";
                else
                    newRow += "</td><td><span class='label label-success'>" + (value[3]).toFixed(2) + "%" + "</span></td></tr>";
                $("#stockTable tr:last").after(newRow);
            })
        }
    });
}

function InitSearchButton() {
    $("#searchButton").click(function () {
        var stockName = $("#stockName").val();
        $.ajax({
            url: "stockprice/singleStock",
            type: "get",
            data: {
                "singleStock": stockName,
                "fakeTime": fakeTime
            },
            contentType: "application/json; charset=utf-8",
            complete: function (data) {
                if(data.responseJSON.length == 0) {
                    alert("No data for such stock!");
                    return ;
                }
                $("#stockTable tr:gt(0)").remove();
                $.each(data.responseJSON,function (index, value) {

                    var newRow = "<tr><td>" + value[0] +
                        "</td><td>" + value[2];
                    if(value[3] >= 0.000000)
                        newRow += "</td><td><span class='label label-danger'>" + (value[3]).toFixed(2) + "%" + "</span></td></tr>";
                    else
                        newRow += "</td><td><span class='label label-success'>" + (value[3]).toFixed(2) + "%" + "</span></td></tr>";
                    $("#stockTable tr:last").after(newRow);
                })
            }
        });

        var market = "Unknown Market";
        var category = "5min";
        option.title.text = market + "-" + stockName;
        $.ajax({
            url: "stockprice/" + category + "/" + stockName,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            complete: function (data) {
                date2 = data.responseJSON;
                var split =splitData(date2);
                data0 = split;
                if (option && typeof option === "object") {
                    setCustomOption();
                    myChart.setOption(option, true);
                }
                else {
                }
            }
        });
    });
}
var task = {};
function InitPlayButton() {
    $("#play").click(function () {
        var stockName = $("#stockName").val();
        if(stockName != null && stockName.trim() != "") {
            task = setInterval(refreshSingle, 2000);
        }
        else {
            task = setInterval(refreshTables ,5000);
        }
        $("#pause").attr("disabled",false);
        $("#reset").attr("disabled",false);
        $("#play").attr("disabled",true);
    })
}

function InitPauseButton() {
    $("#pause").click(function () {
        clearInterval(task);
        $("#pause").attr("disabled",true);
        $("#play").attr("disabled",false);
    })
}

function InitResetButton() {
    $("#reset").click(function () {
        clearInterval(task);
        fakeTime = 201307010930;
        InitTable();
        $("#reset").attr("disabled",true);
        $("#pause").attr("disabled",true);
        $("#play").attr("disabled",false);
    })
}

function refreshTables() {
    fakeTime +=5;
    InitTable();
}

function refreshSingle() {
    fakeTime +=5;
    var market = "Unknown Market";
    var category = "5min";
    var stockName = $("#stockName").val();
    option.title.text = market + "-" + stockName;
    $.ajax({
        url: "stockprice/" + category + "/" + stockName + "/" + fakeTime,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        complete: function (data) {
            date2 = data.responseJSON;
            var split =splitData(date2);
            data0 = split;
            if (option && typeof option === "object") {
                setCustomOption();
                myChart.setOption(option, true);
            }
            else {
            }
        }
    });
}

function InitCandleStick() {
    $.ajax({
        url: "stockprice/1min/C",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        complete: function (data) {
            date2 = data.responseJSON;
            var fafaef =splitData(date2);
            data0 = fafaef;
            if (option && typeof option === "object") {
                setOption();
                myChart.setOption(option, true);
            }
        }
    });
}

function setCustomOption() {
    if(data0.values.length == 0) {
        alert("No data of such stock!");
        return;
    }
    var category =  "5min_K";
    option.legend.data[0] = category;
    option.xAxis.data = data0.categoryData;
    option.dataZoom = [
        {
            type: 'inside',
            start: 0,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 0,
            end: 100
        }
    ];
    option.series = [
        {
            name: category,
            type: 'candlestick',
            data: data0.values,
            markPoint: {
                label: {
                    normal: {
                        formatter: function (param) {
                            return param != null ? param.value : '';
                        }
                    }
                },
                data: [
                    {
                        name: 'highest value',
                        type: 'max',
                        valueDim: 'highest'
                    },
                    {
                        name: 'lowest value',
                        type: 'min',
                        valueDim: 'lowest'
                    },
                    {
                        name: 'average value on close',
                        type: 'average',
                        valueDim: 'close'
                    }
                ],
                tooltip: {
                    formatter: function (param) {
                        return param.name + '<br>' + (param.data.coord || '');
                    }
                }
            },
            markLine: {
                symbol: ['none', 'none'],
                data: [
                    [
                        {
                            name: 'from lowest to highest',
                            type: 'min',
                            valueDim: 'lowest',
                            symbol: 'circle',
                            symbolSize: 10,
                            label: {
                                normal: {show: false},
                                emphasis: {show: false}
                            }
                        },
                        {
                            type: 'max',
                            valueDim: 'highest',
                            symbol: 'circle',
                            symbolSize: 10,
                            label: {
                                normal: {show: false},
                                emphasis: {show: false}
                            }
                        }
                    ],
                    {
                        name: 'min line on close',
                        type: 'min',
                        valueDim: 'close'
                    },
                    {
                        name: 'max line on close',
                        type: 'max',
                        valueDim: 'close'
                    }
                ]
            }
        },
        {
            name: 'MA5',
            type: 'line',
            data: calculateMA(5),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA10',
            type: 'line',
            data: calculateMA(10),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        }

    ];
}

function setOption() {

    option = {
        title: {
            text: 'NYSE',
            left: 0
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['minute_K', 'MA5', 'MA10']
        },
        grid: {
            left: '10%',
            right: '10%',
            bottom: '15%'
        },
        xAxis: {
            type: 'category',
            data: data0.categoryData,
            scale: true,
            boundaryGap : false,
            axisLine: {onZero: false},
            splitLine: {show: false},
            splitNumber: 20,
            min: 'dataMin',
            max: 'dataMax'
        },
        yAxis: {
            scale: true,
            splitArea: {
                show: true
            }
        },
        dataZoom: [
            {
                type: 'inside',
                start: 50,
                end: 100
            },
            {
                show: true,
                type: 'slider',
                y: '90%',
                start: 50,
                end: 100
            }
        ],
        series: [
            {
                name: 'minute_K',
                type: 'candlestick',
                data: data0.values,
                markPoint: {
                    label: {
                        normal: {
                            formatter: function (param) {
                                return param != null ? param.value : '';
                            }
                        }
                    },
                    data: [
                        {
                            name: 'highest value',
                            type: 'max',
                            valueDim: 'highest'
                        },
                        {
                            name: 'lowest value',
                            type: 'min',
                            valueDim: 'lowest'
                        },
                        {
                            name: 'average value on close',
                            type: 'average',
                            valueDim: 'close'
                        }
                    ],
                    tooltip: {
                        formatter: function (param) {
                            return param.name + '<br>' + (param.data.coord || '');
                        }
                    }
                },
                markLine: {
                    symbol: ['none', 'none'],
                    data: [
                        [
                            {
                                name: 'from lowest to highest',
                                type: 'min',
                                valueDim: 'lowest',
                                symbol: 'circle',
                                symbolSize: 10,
                                label: {
                                    normal: {show: false},
                                    emphasis: {show: false}
                                }
                            },
                            {
                                type: 'max',
                                valueDim: 'highest',
                                symbol: 'circle',
                                symbolSize: 10,
                                label: {
                                    normal: {show: false},
                                    emphasis: {show: false}
                                }
                            }
                        ],
                        {
                            name: 'min line on close',
                            type: 'min',
                            valueDim: 'close'
                        },
                        {
                            name: 'max line on close',
                            type: 'max',
                            valueDim: 'close'
                        }
                    ]
                }
            },
            {
                name: 'MA5',
                type: 'line',
                data: calculateMA(5),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: calculateMA(10),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            }

        ]
    };
}

function splitData(rawData) {
    var categoryData = [];
    var values = []
    if( rawData != null) {
        for (var i = 0; i < rawData.length; i++) {
            categoryData.push(rawData[i].splice(0, 1)[0]);
            values.push(rawData[i])
        }
    }
    return {
        categoryData: categoryData,
        values: values
    };
}

function calculateMA(dayCount) {
    var result = [];
    for (var i = 0, len = data0.values.length; i < len; i++) {
        if (i < dayCount) {
            result.push('-');
            continue;
        }
        var sum = 0;
        for (var j = 0; j < dayCount; j++) {
            sum += data0.values[i - j][1];
        }
        result.push(sum / dayCount);
    }
    return result;
}