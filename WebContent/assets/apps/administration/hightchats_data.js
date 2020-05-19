
        /**
         * form_17
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