/**
 * 实名制 form_1
 */

    /**
     * 志愿者检查 form_3
     **/
    $('#containerZYZJC').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '志愿者检查门店数量'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-4','2016-5','2016-6','2016-7','2016-8', '2016-9', '2016-10','2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '企业门店检查数'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '基础电信企业门店检查数',
            data: [520,568,667,700,655,705,676,727,655,532,687,774,695,783],
            tooltip: {
                valueSuffix: '家'
            }
        }, {
            name: '转售企业门店检查数（合规）',
            data: [0,137,133,162,137,138,154,162,160,143,160,181,134,169],
            tooltip: {
                valueSuffix: '家'
            }
        
        }]
    });

    /**
     * 信息诈骗 form_4
     */
    
    $('#containerXXZP').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: '通讯信息诈骗举报（手机号）'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-3', '2016-4', '2016-5', '2016-6','2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12', '2017-01', '2017-02', '2017-03', '2017-04', '2017-05'],
            crosshair: true
        },
        yAxis: [{ // Primary yAxis
            labels: {
                format: '{value}件次',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            title: {
                text: '被举报件次',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            }
        },{ // Secondary yAxis
            title: {
                text: '举报率（件次/百万用户）',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            gridLineWidth :1,
            tickInterval:1,
            labels: {
                format: '{value} %',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        series: [{
            name: '被举报件次  上海电信',
            type: 'column',
            data: [89,134,213,258,257,342,358,223,287,316,139,70,76,47,0],
            tooltip: {
                valueSuffix: '件次'
            }
        }, {
            name: '被举报件次  上海移动',
            type: 'column',
            data: [148,164,158,151,158,117,0,0,0,118,71,36,62,79,99],
            tooltip: {
                valueSuffix: '件次'
            }
        }, {
            name: '被举报件次  上海联通',
            type: 'column',
            data: [115,117,180,151,236,343,441,192,148,197,160,87,263,169,81],
            tooltip: {
                valueSuffix: '件次'
            }
        }, {
            name: '举报率（件次/百万用户）上海电信',
            type: 'line',
            yAxis: 1,
            data: [13.15,20.23,31.08,37.03,37.87,49.37,51.68,32.19,41.43,45.52,19.52,9.83,11.48,7,0],
            tooltip: {
                valueSuffix: '%'
            }
        }, {
            name: '举报率（件次/百万用户）上海移动',
            type: 'line',
            data: [8.1,8.92,8.66,8.35,8.85,6.23,0,0,0,6.32,3.82,0,0,0,5.36],
            tooltip: {
                valueSuffix: '%'
            }
        }, {
            name: '举报率（件次/百万用户）上海联通',
            type: 'line',
            data: [14.32,14.32,22.13,18.37,30.57,44.23,56.78,24.59,18.81,24.84,20.04,11.48,32.93,20.69,9.78],
            tooltip: {
                valueSuffix: '%'
            }
        }]
    });
    /**
     * 固定电话被举报件次
     **/
    $('#containerGDDHBJB').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '固定电话被举报件次'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-3','2016-4','2016-5','2016-6','2016-7', '2016-8', '2016-9','2016-10', '2016-11', '2016-12','2017-01', '2017-02', '2017-03', '2017-04']
        },
        yAxis: {
        	 title: {
                 text: '件次'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '上海电信',
            data: [45,66,57,58,122,169,215,161,0,0,0,0,0,0,0],
            tooltip: {
                valueSuffix: '件次'
            }
        }, {
            name: '上海移动',
            data: [0,52,0,65,94,59,151,144,0,0,0,0,0,0,0],
            tooltip: {
                valueSuffix: '件次'
            }
        }, {
            name: '上海联通',
            data: [93,126,146,84,74,124,134,147,0,26,15,0,9,0],
            tooltip: {
                valueSuffix: '件次'
            }
        }]
    });
    /**
     * 打击通讯信息诈骗业务 form_6
     **/
    $('#containerDJXXZP').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '虚假主叫拦截和一键退订'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016/11/7','2016/11/14','2016/11/21','2016/11/28','2016/12/5', '2016/12/12', '2016/12/19','2016/12/26', '2017/1/2', '2017/1/9', '2017/1/16', '2017/1/23', '2017/1/30', '2017/2/6', '2017/2/13', '2017/2/20', '2017/2/27', '2017/3/6', '2017/3/13']
        },
        yAxis: {
        	 title: {
                 text: '数量'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '虚假主叫拦截',
            data: [643,695,718,772,772,811,834,839,881,911,927,939,984,134,190,226,257,282,319],
            tooltip: {
                valueSuffix: '个'
            }
        }, {
            name: '一键退订',
            data: [152.07, 158.39, 159.96, 162.40, 162.40, 166.20, 168.61, 170.43, 171.86, 175.55, 174.46, 175.54, 176.71, 5.68, 6.54, 7.69, 8.72, 9.67, 10.32],
            tooltip: {
                valueSuffix: '万起'
            }
        
        }]
    });
    /**
     * 打击通讯信息诈骗业务--每周重点电信业务用户数（到达数）统计 form_6
     **/
    $('#containerZDDXYWYHS').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '上海信息通信行业重点电信业务用户数'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016/11/7','2016/11/14','2016/11/21','2016/11/28','2016/12/5', '2016/12/12', '2016/12/19','2016/12/26', '2017/1/2', '2017/1/9', '2017/1/16', '2017/1/23', '2017/1/30', '2017/2/6', '2017/2/13', '2017/2/20', '2017/2/27', '2017/3/6', '2017/3/13']
        },
        yAxis: {
        	 title: {
                 text: '家'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '语音专线出租业务',
            data: [14495,14470,14473,14457,14457,14414,14434,14434,14370,14398,13999,14010,13998,13998,13999,13996,13965,13964,13956],
            tooltip: {
                valueSuffix: '家'
            }
        }, {
            name: '“400”业务',
            data: [38768,38287,38316,33878,33878,33872,33861,33861,33861,33336,33335,34695,34690,34690,34699,34695,35147,35147,35154],
            tooltip: {
                valueSuffix: '家'
            }
        }, {
            name: '一号通业务',
            data: [16248,15638,15638,15638,15638,15733,15785,15887,15887,15602,15645,15645,15645,15645,15645,15645,15751,15751,15751],
            tooltip: {
                valueSuffix: '家'
            }
        }, {
            name: '商务总机业务',
            data: [11146,11146,5776,5886,5886,5840,5834,5819,5819,5819,5819,5819,5782,5819,5819,5819,5819,5819,5819],
            tooltip: {
                valueSuffix: '家'
            }
        }, {
            name: '语音专线主叫鉴权',
            data: [24650,24932,24932,24931,24931,24917,24915,24916,24911,24443,24442,24453,24472,24472,24469,24469,24469,24469,24469],
            tooltip: {
                valueSuffix: '家'
            }
        }]
    });
    /**
     * 打击通讯信息诈骗业务 上海信息通信行业关停业务数 form_6
     **/
    $('#containerGTYWS').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '上海信息通信行业关停业务数'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016/11/7','2016/11/14','2016/11/21','2016/11/28','2016/12/5', '2016/12/12', '2016/12/19','2016/12/26', '2017/1/2', '2017/1/9', '2017/1/16', '2017/1/23', '2017/1/30', '2017/2/6', '2017/2/13', '2017/2/20', '2017/2/27', '2017/3/6', '2017/3/13']
        },
        yAxis: {
        	 title: {
                 text: '关停业务数'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '语音专线出租业务',
            data: [97316,105365,128992,135862,135862,136862,136944,138695,139695,139695,139700,139720,139724,11029,11041,11047,11365,13356,13758],
            tooltip: {
                valueSuffix: '个'
            }
        }, {
            name: '“400”业务',
            data: [407,1065,2815,2975,2975,3416,3822,3822,3906,3611,3773,3773,3773,3078,3078,3078,3044,3044,3044],
            tooltip: {
                valueSuffix:'个'
            }
        
        }, {
            name: '一号通业务',
            data: [867,1971,2043,2043,2043,17838,16792,16611,14450,14450,14081,14081,14081,11266,11266,11266,11083,11083,10970],
            tooltip: {
                valueSuffix: '个'
            }
        
        }, {
            name: '商务总机业务',
            data: [7805,7805,15455,15455,15455,15595,15615,15615,15615,15615,15619,15619,15619,180,180,180,180,180,180],
            tooltip: {
                valueSuffix: '个'
            }
        
        }]
    });
    
    /**
     * 打击通讯信息诈骗业务  form_7
     **/
    $('#containerWJLJDXJB').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '拦截垃圾短信息总量（万条）'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016/11/7','2016/11/14','2016/11/21','2016/11/28','2016/12/5', '2016/12/12', '2016/12/19','2016/12/26', '2017/1/2', '2017/1/9', '2017/1/16', '2017/1/23', '2017/1/30', '2017/2/6', '2017/2/13', '2017/2/20', '2017/2/27', '2017/3/6', '2017/3/13']
        },
        yAxis: {
        	 title: {
                 text: '拦截垃圾短信息总量（万条）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '电信',
            data: [183,109,147,155,149,187,152,150,147,78,76, 75,74,74],
            tooltip: {
                valueSuffix: '万条'
            }
        }, {
            name: '移动',
            data: [700,817,810,2194,2156,0,0,0,0,731,714, 685,568,875],
            tooltip: {
                valueSuffix: '万条'
            }
        
        },{
            name: '联通',
            data: [915,586,745,783,899,777,788,624,585,643,613,573],
            tooltip: {
                valueSuffix: '万条'
            }
        }, {
            name: '行业',
            data: [1798,1512,1702,3132,2305,1086,929,938,147,1433,1375,1403,1255,1522],
            tooltip: {
                valueSuffix: '万条'
            }
        
        }]
    });

    /**
     *固网号码资源 form_8
     **/
    $('#containerGWHMZY').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: '固网号码资源'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-4','2016-5','2016-6','2016-7','2016-8','2016-9','2016-10','2016-11','2016-12','2017-1','2017-2','2017-3','2017-4','2017-5'],
            crosshair: true
        },
        yAxis: [{ // Primary yAxis
            labels: {
                format: '{value}万',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            title: {
                text: '局号数（万）',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            }
        },{ // Secondary yAxis
            title: {
                text: '号码使用率',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            labels: {
                format: '{value} %',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        series: [{
            name: '电信',
            type: 'column',
            data: [2302,2302,2302,2302,2302,2302,2302,2302,2302,2302,2302,2707,2707,2707],
            tooltip: {
                valueSuffix: '万'
            }
        }, {
            name: '移动（铁通）',
            type: 'column',
            data: [144,144,144,144,144,144,144,144,144,144,144,144,144,144],
            tooltip: {
                valueSuffix: '万'
            }
        }, {
            name: '联通',
            type: 'column',
            data: [230,230,230,230,230,230,230,230,230,230,230,230,230,230],
            tooltip: {
                valueSuffix: '万'
            }
        }, {
            name: '电信',
            type: 'line',
            yAxis: 1,
            data: [49.04,49.13,47.08,48.45,48.35,48.03,48.43,48.38,48.13,47.98,47.69,40.81,40.64,40.76],
            tooltip: {
                valueSuffix: '%'
            }
        }, {
            name: '移动（铁通）',
            type: 'line',
            yAxis: 1,
            data: [84.94,84.94,85.73,90.03,90.05,48.56,48.42,48.89,44.68,42.38,41.47,65.57,65.03,41.22],
            tooltip: {
                valueSuffix: '%'
            }
        }, {
            name: '联通',
            type: 'line',
            yAxis: 1,
            data: [63.68,63.59,63.59,63.50,63.45,63.26,63.71,63.85,63.92,63.88,63.80,41.37,41.35,69.41],
            tooltip: {
                valueSuffix: '%'
            }
        }]
    });
    /**
     * 宽带资费 form_9
     **/
    $('#containerKDZF').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '平均带宽'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-3','2016-4','2016-5','2016-6','2016-7', '2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '平均带宽（M）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '平均带宽-上海电信',
            data: [0.00,43.00,44.80,48.70,48.70,46.80,54.20,57.60,60.90,64.10,71.70,71.7,78,80.6 ],
            tooltip: {
                valueSuffix: 'M'
            }
        }, {
            name: '平均带宽-上海移动',
            data: [19.30,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.01,20.01,20.01,20.01,20.00,20.1],
            tooltip: {
                valueSuffix: 'M'
            }
        }, {
            name: '平均带宽-上海联通',
            data: [31.90,32.00,32.50,32.50,32.30,32.20,32.40,32.60,33.10,33.00,34.60 ,34.6,34.0,33],
            tooltip: {
                valueSuffix: 'M'
            }
        }, {
            name: '平均带宽-长城宽带',
            data: [0,36.15,36.67,40.38,43.49,43.49,44.93,47.79,47.79,49.89,50.23,50.23,52.58,53.24],
            tooltip: {
                valueSuffix: 'M'
            }
        }, {
            name: '平均带宽-东方有线',
            data: [0,18.88,18.88,19.00,18.00,20.00,18.00,20.00,20.00,20.00 ,20.00,20,20,20],
            tooltip: {
                valueSuffix: 'M'
            }
        }]
    });
    /**
     * 降费 form_10
     **/
    $('#containerJF').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '降费'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4']
        },
        yAxis: {
        	 title: {
                 text: '降费'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '固定宽带单位带宽平均资费（元/Mbps）-上海电信',
            data: [1.91,1.783,1.66,1.59,1.52,1.48,1.4,1.519,1.27],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }, {
            name: '固定宽带单位带宽平均资费（元/Mbps）-上海移动',
            data: [1.16,1.16,1.13,1.13,1.12,0.89,0.62,1.13,1.14],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }, {
            name: '固定宽带单位带宽平均资费（元/Mbps）-上海联通',
            data: [1.09,1.05,1.03,1.026,1.016,0.989,0.972,0.96,0.869],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }, {
            name: '手机流量平均资费（元/MB）-上海电信',
            data: [0.078,0.076,0.079,0.077,0.075,0.056,0.07,0.065,0.054],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }, {
            name: '手机流量平均资费（元/MB）-上海移动',
            data: [0.068,0.068,0.066,0.0632,0.061,0.052,0.061,0.064,0.06],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }, {
            name: '手机流量平均资费（元/MB）-上海联通',
            data: [0.071,0.068,0.065,0.063,0.06,0.041,0.04,0.036,0.032],
            tooltip: {
                valueSuffix: '元/MB'
            }
        }]
    });
    
    /**
     * 增值电信业务 form_11
     **/
    $('#containerYYSR').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '增值电信业务收入'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-1','2016-2','2016-3','2016-4','2016-5','2016-6','2016-7','2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4']
        },
        yAxis: {
        	 title: {
                 text: '营业收入（亿）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '营业收入（亿）',
            data: [0,316.53,568.59,608.22,3015.11,1496.79,1186.61,1201.67,1853.35,2153.42,2099.09,3001.4,611.43,3001.4,611.43,973.78],
            tooltip: {
                valueSuffix: '亿元'
            }
        }]
    });
    
    
    $('#containerSRFB').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '增值电信业务收入分布'
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '增值电信业务收入分布',
            data: [
                ['2017-4信息服务',341.06],
                ['2017-4接入服务',4.61],
                ['2017-4呼叫中心',1.76]
            ]
        }]
    });
    
    /**
     * 自贸区增值电信业务 form_12
     **/
    $('#containerZMQDXYW').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '自贸区增值电信业务收入'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-1','2016-2','2016-3','2016-4','2016-5','2016-6','2016-7','2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1','2017-2', '2017-3', '2017-4', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '自贸区增值电信业务收入（亿）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '电信业务收入',
            data: [0.1241,0.1441,0.2059,0.2446,0.2389,0.2718,0.2907,0.3282,0.5983,1.221,1.4312,1.6449,0.1787,0.3874,0.6519,0.8716,1.1362],
            tooltip: {
                valueSuffix: '亿'
            }
        }]
    });
    /**
     * 百万用户申诉率 form_13
     **/
    $('#containerSSL').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '百万用户申诉率'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-1','2016-2','2016-3','2016-4','2016-5','2016-6','2016-7','2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '百万用户申诉率'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '百万用户申诉率--行业',
            data: [3.34,2.47,2.64,3.11,2.81, 2.08,2.47,2.99,3.4, 2.85,3.87,2.37,3.41,2.08,2.32,2.10,1.87],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '百万用户申诉率-电信',
            data: [2.78,1.4,1.75,2.81,3.01, 4.05,2.27,2.76,3.42,2.75,3.92, 2.41,3.29,1.70,1.59,1.43,1.2],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '百万用户申诉率-移动',
            data: [3.46, 2.92, 3.21, 3.05, 4.31,4.31,2.44,2.94,3.02, 2.51, 3.52, 2.63,3.25, 1.93,2.02,1.92,1.72],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '百万用户申诉率-联通',
            data: [ 4.45,4.05, 3.45,4.05, 3.05, 3.05,3.03,3.73, 4.42,4.01,4.72, 1.52,4.19,3.49,3.36,2.94,2.69],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '不明扣费申诉率-行业',
            data: [0,0,0.04,0,0,0.9,0.02,0.02,0,0.04,0.04,0,0.02,0.02,0,0,0],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '不明扣费申诉率-电信',
            data: [0,0,0.05,0,0,0.1,0.05,0.05,0,0.05,0.05,0,0.05,0,0,0,0],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '不明扣费申诉率-移动',
            data: [0,0,0.05,0,0,0.1,0,0,0,0.05,0.1,0,0,0.05,0,0,0],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        },{
            name: '不明扣费申诉率-联通',
            data: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
            tooltip: {
                valueSuffix: '人次/百万用户'
            }
        }]
    });
    /**
     * 宽带资费 form_14
     **/
    $('#containerXNYYSZS').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '移动转售业务用户总数'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-1', '2016-2','2016-3','2016-4','2016-5','2016-6','2016-7', '2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '用户总数（万）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '全国',
            data: [2257.63,2464.6,2741.12,2974.56,3136.64,3136.71,3436.95,3584.27,3549.93,3912.14,4077.42,4375.76,4479.22,4424.37,4589.44,4752.98,4890.44],
            tooltip: {
                valueSuffix: '万'
            }
        }, {
            name: '本地',
            data: [130.45,139.78,146.38,154.7,159.3,170.7,183.78,190.48,178.08,210.01,163.8255,237.71,247.78,242.14,244.77,253.33,254.42],
            tooltip: {
                valueSuffix: '万'
            }
        }]
    });
    
    $('#containerXNYYSXZ').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '移动转售业务每月新增用户数'
        },
        subtitle: {
            text: '数据来源: 上海市通信管理局'
        },
        xAxis: {
            categories: ['2016-1', '2016-2','2016-3','2016-4','2016-5','2016-6','2016-7', '2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4', '2017-5']
        },
        yAxis: {
        	 title: {
                 text: '本月新增数（万）'
             },
             plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
             }]
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        series: [{
            name: '全国',
            data: [198.91,206.97,276.45,233.44,124.37,124.39,150.31,201.84,157.32,159.25,165.28,298.34,103.46,130.24,171.45,163.55,137.46],
            tooltip: {
                valueSuffix: '万'
            }
        }, {
            name: '本地',
            data: [3.62,9.33,6.58,8.32,12.37,12.24,12.58,7.6,4.04,4.29,8.74,18.96,10.07,3.14,5.46,8.56,1.09],
            tooltip: {
                valueSuffix: '万'
            }
        }]
    });
    
    
    /**
     * 行业卡管理 form_15
     */
        $('#containerHYK').highcharts({
            chart: {
                zoomType: 'xy'
            },
            title: {
                text: '行业卡管理'
            },
            subtitle: {
                text: '数据来源: 上海市通信管理局'
            },
            xAxis: {
                categories: ['2016-12','2017-1','2017-2','2017-3','2017-4','2017-5'],
                crosshair: true
            },
            yAxis: [{ // Primary yAxis
                labels: {
                    format: '{value}个',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                },
                title: {
                    text: '数量（个）',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                }
            },{ // Secondary yAxis
                title: {
                    text: '技术限定百分率',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                },
                labels: {
                    format: '{value} %',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                },
                opposite: true
            }],
            tooltip: {
                shared: true
            },
            series: [{
                name: '存量物联网卡用户数（个）--行业',
                type: 'column',
                data: [11993867,11223391,11201086,15245287,16221544,17610126],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '存量物联网卡用户数（个）--上海电信',
                type: 'column',
                data: [3279997,2698852,2691017,4372449,4349649,4339000],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '存量物联网卡用户数（个）--上海移动',
                type: 'column',
                data: [5288343,5097736,5075499,7346827,8239767,9429890],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '存量物联网卡用户数（个）--上海联通',
                type: 'column',
                data: [3425527,3426803,3434570,3526011,3632128,3841236],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '累计采取技术限定号码数--行业',
                type: 'column',
                data: [11378320,10740185,10729863,14172600,15353174],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '累计采取技术限定号码数--上海电信',
                type: 'column',
                data: [3032351,2496375,2502515,3540000,3498649,3489000],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '累计采取技术限定号码数--上海移动',
                type: 'column',
                data: [5288343,5097736,5073507,7346827,8239767,9429890],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '累计采取技术限定号码数--上海联通',
                type: 'column',
                data: [3057626,3146074,3153841,3526011,2434184,2434284],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '技术限定百分率--行业',
                type: 'line',
                yAxis: 1,
                data: [93.90,94.77,94.93,93.67,93.47,93.47],
                tooltip: {
                    valueSuffix: '%'
                }
            }, {
                name: '技术限定百分率--上海电信',
                type: 'line',
                yAxis: 1,
                data: [92.45	,92.5,93,81,80.4,80.4],
                tooltip: {
                    valueSuffix: '%'
                }
            }, {
                name: '技术限定百分率--上海移动',
                type: 'line',
                yAxis: 1,
                data: [100,100,99.96,100,100,100],
                tooltip: {
                    valueSuffix: '%'
                }
            }, {
                name: '技术限定百分率--上海联通',
                type: 'line',
                yAxis: 1,
                data: [89.26,91.81,91.83,100,100,100],
                tooltip: {
                    valueSuffix: '%'
                }
            }]
        });
        /**
         * 码号分类 form_16
         */
        $('#containerMHFL').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '码号分类'
	        },
	        tooltip: {
	            headerFormat: '{series.name}<br>',
	            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                },
	                showInLegend: true
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '码号类型占比',
	            data: [	
	                ['10630', 0],
	                ['10639', 1],
	                ['1062XXXX',7],
	                ['10635-10638', 64],
	                ['962XXX', 14],
	                ['96XXX', 105]
	            ]
	        }]
	    });
        /**
         * 码号分类 form_17
         */
        $('#container_1').highcharts({
            chart: {
                zoomType: 'xy'
            },
            title: {
                text: '批准日期'
            },
            subtitle: {
                text: '数据来源: 上海市通信管理局'
            },
            xAxis: [{
                categories: [{
                    name: "2015",
                    categories: ["企业数", "前置审批数"]
                }, {
                    name: "2016",
                    categories: ["企业数", "前置审批数"]
                }, {
                    name: "2017",
                    categories: ["企业数", "前置审批数"]
                }],
                crosshair: true
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    format: '{value}个',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                },
                title: {
                    text: '数量（个）',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                }
            }],
            tooltip: {
                shared: true
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true,
                        allowOverlap: true
                    }
                }
            },
            series: [{
                name: '存储转发类业务',
                type: 'column',
                data: [1,0,2,0,1,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '国内多方通信服务业务',
                type: 'column',
                data: [3,0,2,0,0,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '国内呼叫中心业务',
                type: 'column',
                data: [19,0,21,0,5,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '国内互联网虚拟专用网业务',
                type: 'column',
                data: [2,0,4,0,1,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '互联网接入服务业务',
                type: 'column',
                data: [29,0,45,0,36,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '互联网数据中心业务',
                type: 'column',
                data: [3,0,5,0,8,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '信息服务业务（不含互联网信息服务）',
                type: 'column',
                data: [17,0,10,6,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '信息服务业务（仅限固定网电话信息服务）',
                type: 'column',
                data: [0,0,1,0,0,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '信息服务业务（仅限互联网信息服务）',
                type: 'column',
                data: [191,0,304,66,182,71],
                tooltip: {
                    valueSuffix: '个'
                }
            }, {
                name: '在线数据处理与交易处理业务',
                type: 'column',
                data: [5,0,27,0,14,0],
                tooltip: {
                    valueSuffix: '个'
                }
            }]
        });
        /**
         * 企业性质
         */
        $('#container_4').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '企业性质'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '{point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: '企业性质',
                data: [	
                    ['历史', 186],
                    ['国有控股', 230],
                    ['民营控股', 1352],
                    ['中外合资', 34]
                ]
            }]
        });
        /**
         * 上市情况
         */
        $('#container_5').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '上市情况'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '{point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: '上市占比',
                data: [	
                    ['未上市', 1393],
                    ['已上市', 8],
                    ['空白', 401]
                ]
            }]
        });
        /**
         * 自贸区业务占比
         */
        $('#container_6').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '自贸区业务占比'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '{point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: '自贸区业务占比',
                data: [	
                    ['国内多方通信服务业务', 1],
                    ['国内呼叫中心业务', 4],
                    ['国内互联网虚拟专用网业务', 1],
                    ['互联网接入服务业务', 1],
                    ['信息服务业务（不含互联网信息服务）', 1],
                    ['信息服务业务（仅限互联网信息服务）', 10],
                    ['在线数据处理与交易处理业务',16]
                ]
            }]
        });

        /**
         * 注册资本与许可证
         */
        $('#container_7').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '注册资本与许可证'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '{point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: '注册资本与许可证',
                data: [	
                    ['<100万元', 6],
                    ['<300万元，〉=100万元', 452],
                    ['<500万元，〉=300万元', 44],
                    ['〉=500万元', 1300]
                ]
            }]
        });

        /**
         * form18_1
         **/
        $('#form18_1').highcharts({
            chart: {
                zoomType: 'xy'
            },
            title: {
                text: '上海地区移动转售企业用户数和网点数'
            },
            subtitle: {
                text: '数据来源: 上海市通信管理局'
            },
            xAxis: {
                categories: ['2016-3', '2016-4', '2016-5', '2016-6','2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12', '2017-01', '2017-02', '2017-03', '2017-04'],
                crosshair: true
            },
            yAxis: [{ // Primary yAxis
                labels: {
                    format: '{value}',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                },
                title: {
                    text: '移动电话用户数量（户）',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                }
            },{ // Secondary yAxis
                title: {
                    text: '实体代理店数、网络代理店数',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                },
                min :0,
                max:550,
                labels: {
                    format: '{value} ',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                },
                opposite: true
            }],
            tooltip: {
                shared: true
            },
            series: [{
                name: '移动电话用户数量（户）',
                type: 'column',
                data: [1098956,911465,926225,1101199,1208851,1303028,1297975,1455542,1491444,1262500,1302627,1275593,1572314,1456040]
            }, {
                name: '实体代理店数',
                type: 'column',
                yAxis: 1,
                data: [371,445,447,496,327,358,260,244,232,198,241,197,193,210]
            }, {
                name: '网络代理店数',
                type: 'column',
                yAxis: 1,
                data: [15,15,15,15,15,16,0,16,16,1,16,0,14,1]
            }]
        });
            
        $('#form18_2').highcharts({
            chart: {
                type: 'line'
            },
            title: {
                text: '上海地区移动转售企业转售业务收入（万元）'
            },
            subtitle: {
                text: '数据来源: 上海市通信管理局'
            },
            xAxis: {
                categories: ['2016-3','2016-4','2016-5','2016-6','2016-7','2016-8', '2016-9','2016-10', '2016-11', '2016-12', '2017-1', '2017-2', '2017-3', '2017-4']
            },
            yAxis: {
            	 title: {
                     text: '（万元）'
                 },
                 plotLines: [{
                     value: 0,
                     width: 1,
                     color: '#808080'
                 }]
            },
            tooltip: {
                crosshairs: true,
                shared: true
            },
            series: [{
                name: '上海地区移动转售企业转售业务收入（万元）',
                data: [1802.4882,2557.0211,2972.1645,3776.6807,4293.7907,4959.7617,5283.3203,6255.6208,7177.8742,6596.8644,2018.5062,1661.3575,1852.7045,2483.9617]
            }]
        });
