// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('singlestock'));

var data0={};
var option={};
$(document).ready(function () {

    Init();

})

function Init() {
    InitMarketSelector();
    InitStockNameSelector();
    InitCategorySelector();
    InitCandleStick();
    InitSearchButton();
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

function InitMarketSelector() {
    $("#market").select2();
    $("#market").ready(function () {
        $.ajax({
            url: "market/listAll",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            complete: function (data,textStatus,jqXHR) {
                $("#market").empty();
                $.each(data.responseJSON,function (index, value) {
                    if(index == 0) {
                        $("#market").append("<option value='" + value.marketId + "'"+ " selected='selected'>" + value.marketName + "</option>");
                    }
                    else {
                        $("#market").append("<option value='" + value.marketId + "'>" + value.marketName + "</option>");
                    }
                })
            }
        });
    })
}

function InitStockNameSelector() {

    $("#stockName").select2({
        ajax: {
            url: "stock/search",
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    q: params.term, // search term
                    page: params.page,
                    market: $("#market").val()
                };
            },
            processResults: function (data, params) {
                // parse the results into the format expected by Select2
                // since we are using custom formatting functions we do not need to
                // alter the remote JSON data, except to indicate that infinite
                // scrolling can be used
                params.page = params.page || 1;
                return {
                    results: data.items,
                    pagination: {
                        more: (params.page * 30) < data.total_count
                    }
                };
            },
            cache: true
        },
        minimumInputLength: 1,
        escapeMarkup: function (markup) { return markup; },
        templateResult: formatRepo, // omitted for brevity, see the source of this page
        templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
    });
}

function formatRepo (repo) {
    /*if (repo.loading) return repo.text;
    var markup = "<div class='select2-result-repository clearfix'>" +
        "<div class='select2-result-repository__meta'>" +
        "<div class='select2-result-repository__title'>" + repo + "</div>";

    if (repo.description) {
        markup += "<div class='select2-result-repository__description'>" + repo.description + "</div>";
    }

    return markup;*/
    return repo.text;
}

function formatRepoSelection (repo) {
    return repo.text;
}

function InitCategorySelector() {
    $("#category").select2();
}

function InitSearchButton() {
    $("#search").click(function () {
        var market = $("#market").find("option:selected").text();
        var stockName = $("#stockName").val();
        var category = $("#category").find("option:selected").text();
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

        $.ajax({
            url: "stockRela/" + stockName,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            complete: function (data) {
                $("#relateTable tr:gt(0)").remove();
                $.each(data.responseJSON,function (index, value) {
                    var sub1 = 1;
                    if(data.responseJSON.length > 1) {
                        var test = data.responseJSON[data.responseJSON.length - 1].ccvalue;
                        sub1 = data.responseJSON[0].ccvalue - test;
                    }
                    var sub2 = data.responseJSON[0].ccvalue - value.ccvalue;
                    if(sub1 == 0)
                        sub1 = 1;
                    var res = 1 - sub2 / sub1;
                    var newRow = "<tr><td>" + (index + 1) +
                        "</td><td>" + value.stock2 +
                        "</td><td><div class='progress progress-xs'> <div class='progress-bar progress-bar-yellow' style='width: " + res *100 +
                        "%'></div></div>" +
                        "</td><td><span class='label label-danger'>Unavailable</span></td></tr>";
                    $("#relateTable tr:last").after(newRow);
                })
            }
        });
    })
}

function setCustomOption() {
    if(data0.values.length == 0) {
        alert("No data of such stock!");
        return;
    }
    var category = $("#category").find("option:selected").text() + "_K";
    option.legend.data[0] = category;
    option.xAxis.data = data0.categoryData;
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
        },
        {
            name: 'MA20',
            type: 'line',
            data: calculateMA(20),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA30',
            type: 'line',
            data: calculateMA(30),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },

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
            data: ['minute_K', 'MA5', 'MA10', 'MA20', 'MA30']
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
            },
            {
                name: 'MA20',
                type: 'line',
                data: calculateMA(20),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA30',
                type: 'line',
                data: calculateMA(30),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },

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
