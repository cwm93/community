/**
 * 
 */

Highcharts.chart('containerSMZ', {
	chart: {
        type: 'line'
    },
    title: {
        text: '实名制'
    },
    subtitle: {
        text: '来源: 上海市通信管理局'
    },
    xAxis: {
        categories: [
            '2016-01',
            '2016-02',
            '2016-03',
            '2016-04',
            '2016-05',
            '2016-06',
            '2016-07',
            '2016-08',
            '2016-09',
            '2016-10',
            '2016-11',
            '2016-12'
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: '总量（万）'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 万</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
    	line: {
            dataLabels: {
                enabled: true          // 开启数据标签
            }
        }
    },
    series: [{
        name: '行业',
        data: [4372.48, 4217.6, 4262.18, 4184.01, 4171.76, 4171.38, 4167.54, 4171.13, 4172.23, 4180.28,4191.07, 4305.79]

    }, {
        name: '移动',
        data: [2158.87, 2134.11, 2170.15, 2100.35, 2092.61, 2089.96, 2090.33, 2094.18, 2099.19, 2107.99, 2124.81, 2152.77]

    }, {
        name: '联通',
        data: [810.4, 680.3, 687.5, 679.6, 681.8, 685.4, 685.4, 687.3, 686.41, 689.07, 686.3, 799.34]

    }, {
        name: '电信',
        data: [1356.55, 1356.4, 1357.59, 1357.3, 1350.56, 1349.26, 1345.24, 1343.06,1340.43, 1337.48, 1334.41, 1322.34]

    }]
});


Highcharts.chart('containerSMZQD', {
	chart: {
        type: 'line'
    },
    title: {
        text: '实名制渠道'
    },
    subtitle: {
        text: '来源: 上海市通信管理局'
    },
    xAxis: {
        categories: [
            '2016-04',
            '2016-05',
            '2016-06',
            '2016-07',
            '2016-08',
            '2016-09',
            '2016-10',
            '2016-11',
            '2016-12',
            '2017-01'
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: '数量(个)'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
    	line: {
            dataLabels: {
                enabled: true          // 开启数据标签
            }
        }
    },
    series: [{
        name: '自营厅总数',
        data: [446, 448, 444, 440, 443, 444, 445, 445, 443, 444]

    }, {
        name: '代理点总数',
        data: [13780, 13832, 13676,	13705,14280, 14255, 14243, 14256, 13900, 13835]
    }, {
        name: '电商平台授权数',
        data: [48, 49, 52, 54, 50, 51, 52, 60, 26, 26]

    }, {
        name: '二代身份证识别设备网点数',
        data: [15153, 15226, 15080, 15099, 15697, 15685, 15687, 15685, 15261, 15211]

    }, {
        name: '社会渠道授权牌数',
        data: [14794, 14867, 14727, 14751, 15344, 15331, 15333, 14875, 14883, 14832]

    }, /*{
        name: '代理渠道售卡数',
        data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    }, {
        name: '代理渠道售卡拍照核验不合规数',
        data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    },*/ {
        name: '本月终止违规代理商数',
        data: [ 40, 65, 133, 58, 10, 114, 46, 57, 76, 223]

    }]
});