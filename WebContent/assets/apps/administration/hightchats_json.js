
	/**
	 * 实名制
	 **/
	var formSMZ = function(year){
		var options = {
		        chart: {
		            zoomType: 'xy'
		        },
		        title: {
		            text: '实名制'
		        },
		        subtitle: {
		            text: '数据来源: 上海市通信管理局'
		        },
		        xAxis: {
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
		                text: '数量（万）',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            }
		        },{ // Secondary yAxis
		            title: {
		                text: '实名率',
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
		            name: '电信总量（万）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '电信已登记用户数（万）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '移动总量（万）',
		            type: 'column',	            
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '移动已登记用户数（万）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '联通总量（万）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '联通已登记用户数（万）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '电信实名率',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '移动实名率',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '联通实名率',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }]
		    }
		var url = "/gj/smz/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.realNameRegistrationList!=null){
				var i,len=data.realNameRegistrationList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.series[6].data = new Array();
				options.series[7].data = new Array();
				options.series[8].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.realNameRegistrationList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11+entity.field_12);
					options.series[1].data[index] = getNumber((entity.field_13+entity.field_14).toFixed(2));
					options.series[2].data[index] = getNumber(entity.field_21+entity.field_22);
					options.series[3].data[index] = getNumber((entity.field_23+entity.field_24).toFixed(2));
					options.series[4].data[index] = getNumber(entity.field_31+entity.field_32);
					options.series[5].data[index] = getNumber((entity.field_33+entity.field_34).toFixed(2));
					options.series[6].data[index] = getNumber(((entity.field_13+entity.field_14)*100/(entity.field_11+entity.field_12)).toFixed(2));
					options.series[7].data[index] = getNumber(((entity.field_23+entity.field_24)*100/(entity.field_21+entity.field_22)).toFixed(2));
					options.series[8].data[index] = getNumber(((entity.field_33+entity.field_34)*100/(entity.field_31+entity.field_32)).toFixed(2));
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerSMZ',options);
		        $("#containerSMZ").show();
			}else{
				//$("#containerSMZ").hide();
			}
		})
	} 
	/**
	 * 实名制渠道
	 **/
	var formSMZQD = function(year){
		var options = {
				chart: {
		            type: 'column'
		        },
		        title: {
		            text: '实名制渠道'
		        },
		        subtitle: {
		            text: '数据来源: 上海市通信管理局'
		        },
		        xAxis: {
		        		crosshair: true
		        },
		        yAxis: {
		        	 title: {
		                 text: '数量（个）'
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
		            name: '自营厅总数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }, {
		            name: '代理点总数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }, {
		            name: '电商平台授权数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }, {
		            name: '二代身份证识别设备网点数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }, {
		            name: '社会渠道授权牌数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }, {
		            name: '本月终止违规代理商数',
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }]
		    }
		var url = "/gj/smzqd/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.realNameRegistrationChannelList!=null){
				var i,len=data.realNameRegistrationChannelList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.realNameRegistrationChannelList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.filed_01);
					options.series[1].data[index] = getNumber(entity.filed_02);
					options.series[2].data[index] = getNumber(entity.filed_03);
					options.series[3].data[index] = getNumber(entity.filed_04);
					options.series[4].data[index] = getNumber(entity.filed_05);
					options.series[5].data[index] = getNumber(entity.filed_06);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerSMZQD',options);
		        $("#containerSMZQD").show();
			}else{
				//$("#containerSMZQD").hide();
			}
		})
	} 
	/**
	 * 实名志愿者监督检查
	 **/
	var formZYZJC = function(year){
		var options = {
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
		        		crosshair: true
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
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }, {
		            name: '转售企业门店检查数（合规）',
		            tooltip: {
		                valueSuffix: '家'
		            }
		        
		        }]
		}
		
		var url = "/gj/zyzjcmdsl/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.checkedStoreList!=null){
				var i,len=data.checkedStoreList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.checkedStoreList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_01);
					options.series[1].data[index] = getNumber(entity.field_02);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerZYZJC',options);
		        $("#containerZYZJC").show();
			}else{
				//$("#containerZYZJC").hide();
			}
		})
	}
	
	/**
	 *通讯信息诈骗举报（手机号）form_4 
	 **/
	var formXXZP = function(year){
		var options = {
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
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }, {
		            name: '被举报件次  上海移动',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }, {
		            name: '被举报件次  上海联通',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }, {
		            name: '举报率（件次/百万用户）上海电信',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '举报率（件次/百万用户）上海移动',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '举报率（件次/百万用户）上海联通',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }]
		}
		
		var url = "/gj/m_txxxzpjb/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.mobileFraudReportList!=null){
				var i,len=data.mobileFraudReportList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.mobileFraudReportList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_12);
					options.series[1].data[index] = getNumber(entity.field_22);
					options.series[2].data[index] = getNumber(entity.field_32);
					options.series[3].data[index] = getNumber(entity.field_13);
					options.series[4].data[index] = getNumber(entity.field_23);
					options.series[5].data[index] = getNumber(entity.field_33);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerXXZP',options);
		        $("#containerXXZP").show();
			}else{
				//$("#containerXXZP").hide();
			}
		})
	}
	
	var formGDDHBJB = function(year){
		var options = {
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
		        		crosshair: true
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
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }, {
		            name: '上海移动',
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }, {
		            name: '上海联通',
		            tooltip: {
		                valueSuffix: '件次'
		            }
		        }]
		}
		
		var url = "/gj/f_txxxzpjb/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.landlineFraudReportList!=null){
				var i,len=data.landlineFraudReportList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.landlineFraudReportList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_12);
					options.series[1].data[index] = getNumber(entity.field_22);
					options.series[2].data[index] = getNumber(entity.field_32);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerGDDHBJB',options);
		        $("#containerGDDHBJB").show();
			}else{
				//$("#containerGDDHBJB").hide();
			}
		})
	}
	//form6
	var formDJXXZP = function(year){
		var options = {
				chart: {
					zoomType: 'xy'
		        },
		        title: {
		            text: '虚假主叫拦截和一键退订'
		        },
		        subtitle: {
		            text: '数据来源: 上海市通信管理局'
		        },
		        xAxis: {
		        		crosshair: true
		        	},
		        yAxis: [{ // Primary yAxis
		            labels: {
		                format: '{value}万起',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            },
		            title: {
		                text: '一键退订（万）',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            }
		        },{ // Secondary yAxis
		            title: {
		                text: '虚假主叫拦截',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            labels: {
		                format: '{value} 个',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            opposite: true
		        }],
		        tooltip: {
		            crosshairs: true,
		            shared: true
		        },
		        series: [{
		            name: '一键退订',
		            tooltip: {
		                valueSuffix: '万起'
		            }
		        }, {
		            name: '虚假主叫拦截',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '个'
		            }
		        }]	
		}
		var options2 = {
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
		        		crosshair: true
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
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }, {
		            name: '“400”业务',
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }, {
		            name: '一号通业务',
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }, {
		            name: '商务总机业务',
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }, {
		            name: '语音专线主叫鉴权',
		            tooltip: {
		                valueSuffix: '家'
		            }
		        }]	
		}
		var options3 = {
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
			        		crosshair: true
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
			            tooltip: {
			                valueSuffix: '个'
			            }
			        }, {
			            name: '“400”业务',
			            tooltip: {
			                valueSuffix:'个'
			            }
			        
			        }, {
			            name: '一号通业务',
			            tooltip: {
			                valueSuffix: '个'
			            }
			        
			        }, {
			            name: '商务总机业务',
			            tooltip: {
			                valueSuffix: '个'
			            }
			        
			        }]	
		}
		var url = "/gj/djxxzpsjzb/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.combatFraudBusinessList!=null){
				var i,len=data.combatFraudBusinessList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options2.series[0].data = new Array();
				options2.series[1].data = new Array();
				options2.series[2].data = new Array();
				options2.series[3].data = new Array();
				options2.series[4].data = new Array();
				options3.series[0].data = new Array();
				options3.series[1].data = new Array();
				options3.series[2].data = new Array();
				options3.series[3].data = new Array();
				options.xAxis.categories = new Array();
				options2.xAxis.categories = new Array();
				options3.xAxis.categories = new Array();
				$.each(data.combatFraudBusinessList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_81);
					options.series[1].data[index] = getNumber(entity.field_71);
					options2.series[0].data[index] = getNumber(entity.field_11);
					options2.series[1].data[index] = getNumber(entity.field_21);
					options2.series[2].data[index] = getNumber(entity.field_31);
					options2.series[3].data[index] = getNumber(entity.field_41);
					options2.series[4].data[index] = getNumber(entity.field_61);
					options3.series[0].data[index] = getNumber(entity.field_13);
					options3.series[1].data[index] = getNumber(entity.field_23);
					options3.series[2].data[index] = getNumber(entity.field_33);
					options3.series[3].data[index] = getNumber(entity.field_43);
					var showDate = '';
					if(entity.day!=null){
						showDate = entity.year+'-'+entity.month+'-'+entity.day;
					}else{
						showDate = entity.year+'-'+entity.month;
					}
					options.xAxis.categories[index] = showDate;
					options2.xAxis.categories[index] = showDate;
					options3.xAxis.categories[index] = showDate;
				}) 
		        var chart = new Highcharts.Chart('containerDJXXZP',options);
				var chart2 = new Highcharts.Chart('containerZDDXYWYHS',options2);
				var chart3 = new Highcharts.Chart('containerGTYWS',options3);
		        $("#containerDJXXZP").show();
		        $("#containerZDDXYWYHS").show();
		        $("#containerGTYWS").show();
			}else{
				//$("#containerDJXXZP").hide();
				//$("#containerZDDXYWYHS").hide();
				//$("#containerGTYWS").hide();
			}
		})
	}
	//网间平台垃圾短信举报 form7
	var formWJLJDXJB = function(year){
		var options = {
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
		        		crosshair: true
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
		            tooltip: {
		                valueSuffix: '万条'
		            }
		        }, {
		            name: '移动',
		            tooltip: {
		                valueSuffix: '万条'
		            }
		        
		        },{
		            name: '联通',
		            tooltip: {
		                valueSuffix: '万条'
		            }
		        }, {
		            name: '行业',
		            tooltip: {
		                valueSuffix: '万条'
		            }
		        
		        }]	
		}
		
		var url = "/gj/ljdxjb/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.internetPlatformSpamMessageList!=null){
				var i,len=data.internetPlatformSpamMessageList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.internetPlatformSpamMessageList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_17);
					options.series[1].data[index] = getNumber(entity.field_27);
					options.series[2].data[index] = getNumber(entity.field_37);
					options.series[3].data[index] = getNumber(entity.field_17+entity.field_27+entity.field_37);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerWJLJDXJB',options);
		        $("#containerWJLJDXJB").show();
			}else{
				//$("#containerWJLJDXJB").hide();
			}
		})
	}
	
	var formGWHMZY = function(year){
		var options = {
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
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '移动（铁通）',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '联通',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '电信',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '移动（铁通）',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '联通',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }]
		}
		
		var url = "/gj/gdhmzy/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.fixedNumberResourceList!=null){
				var i,len=data.fixedNumberResourceList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.fixedNumberResourceList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11);
					options.series[1].data[index] = getNumber(entity.field_21);
					options.series[2].data[index] = getNumber(entity.field_31);
					options.series[3].data[index] = getNumber(entity.field_12);
					options.series[4].data[index] = getNumber(entity.field_22);
					options.series[5].data[index] = getNumber(entity.field_32);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerGWHMZY',options);
		        $("#containerGWHMZY").show();
			}else{
				//$("#containerGWHMZY").hide();
			}
		})
	}
	/**
	 * 宽带资费 
	 **/
	var formKDZF = function(year){
		var options = {
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
			        		crosshair: true
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
			            tooltip: {
			                valueSuffix: 'M'
			            }
			        }, {
			            name: '平均带宽-上海移动',
			            tooltip: {
			                valueSuffix: 'M'
			            }
			        }, {
			            name: '平均带宽-上海联通',
			            tooltip: {
			                valueSuffix: 'M'
			            }
			        }, {
			            name: '平均带宽-长城宽带',
			            tooltip: {
			                valueSuffix: 'M'
			            }
			        }, {
			            name: '平均带宽-东方有线',
			            tooltip: {
			                valueSuffix: 'M'
			            }
			        }]
		}
		
		var url = "/gj/kdzf/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.broadbandTariffList!=null){
				var i,len=data.broadbandTariffList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.broadbandTariffList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_13);
					options.series[1].data[index] = getNumber(entity.field_23);
					options.series[2].data[index] = getNumber(entity.field_33);
					options.series[3].data[index] = getNumber(entity.field_43);
					options.series[4].data[index] = getNumber(entity.field_53);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerKDZF',options);
		        $("#containerKDZF").show();
			}else{
				//$("#containerKDZF").hide();
			}
		})
	}
	//降费
	var formJF = function(year){
		var options = {
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
		        		crosshair: true
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
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }, {
		            name: '固定宽带单位带宽平均资费（元/Mbps）-上海移动',
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }, {
		            name: '固定宽带单位带宽平均资费（元/Mbps）-上海联通',
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }, {
		            name: '手机流量平均资费（元/MB）-上海电信',
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }, {
		            name: '手机流量平均资费（元/MB）-上海移动',
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }, {
		            name: '手机流量平均资费（元/MB）-上海联通',
		            tooltip: {
		                valueSuffix: '元/MB'
		            }
		        }]
		}
		
		var url = "/gj/kdjf/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.cutFeesList!=null){
				var i,len=data.cutFeesList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.cutFeesList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11);
					options.series[1].data[index] = getNumber(entity.field_21);
					options.series[2].data[index] = getNumber(entity.field_31);
					options.series[3].data[index] = getNumber(entity.field_12);
					options.series[4].data[index] = getNumber(entity.field_22);
					options.series[5].data[index] = getNumber(entity.field_23);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerJF',options);
		        $("#containerJF").show();
			}else{
				//$("#containerJF").hide();
			}
		})
	}
	/**
	 * 增值电信业务 form11
	 **/
	var formYYSR = function(year){
		var options_yy = {
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
			        		crosshair: true
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
			            tooltip: {
			                valueSuffix: '亿元'
			            }
			        }]	
		}
		
		var options_sr = {
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
		            name: '增值电信业务收入分布'
		        }]
		}
		
		var url = "/gj/zzdxyw/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.valueAddedTelecomBussinessList!=null){
				var i,len=data.valueAddedTelecomBussinessList.length; 
				options_yy.series[0].data = new Array();
				options_sr.series[0].data = new Array();
				options_yy.xAxis.categories = new Array();
				$.each(data.valueAddedTelecomBussinessList,function(index,entity){
					options_yy.series[0].data[index] = getNumber(entity.field_11);
					options_yy.xAxis.categories[index] = entity.year+'-'+entity.month;
					if(index==(len-1)){
						options_sr.series[0].data[0] = [entity.year+'-'+entity.month+'信息服务',getNumber(entity.field_24)];
						options_sr.series[0].data[1] = [entity.year+'-'+entity.month+'接入服务',getNumber(entity.field_34)];
						options_sr.series[0].data[2] = [entity.year+'-'+entity.month+'呼叫中心',getNumber(entity.field_44)];	
					}
				}) 
				
		        var chartYY = new Highcharts.Chart('containerYYSR',options_yy);
				var chartSR = new Highcharts.Chart('containerSRFB',options_sr);
		        $("#containerYYSR").show();
		        $("#containerSRFB").show();
			}else{
				//$("#containerYYSR").hide();
				//$("#containerSRFB").hide();
			}
		})
	}
	//自贸区增值电信业务收入
	var formZMQDXYW = function (year){
		var options = {
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
		        		crosshair: true		        
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
		            tooltip: {
		                valueSuffix: '亿'
		            }
		        }]	
		}
		var url = "/gj/zmqdxywsr/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.zoonValueAddedTelecomBussinessList!=null){
				var i,len=data.zoonValueAddedTelecomBussinessList.length; 
				options.series[0].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.zoonValueAddedTelecomBussinessList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
				console.log(options);
		        var chart = new Highcharts.Chart('containerZMQDXYW',options);
		        $("#containerZMQDXYW").show();
			}else{
				//$("#containerZMQDXYW").hide();
			}
		})
	}
	//form13
	var formSSL = function(year){
		var options = {
				 chart: {
			            zoomType: 'xy'
			        },
			        title: {
			            text: '百万用户申诉率'
			        },
			        subtitle: {
			            text: '数据来源: 上海市通信管理局'
			        },
			        xAxis: {
			        		crosshair: true	
			        	},
			        	 yAxis: [{ // Primary yAxis
					            labels: {
					                format: '{value} %',
					                style: {
					                    color: Highcharts.getOptions().colors[1]
					                }
					            },
					            title: {
					                text: '百万用户申诉率',
					                style: {
					                    color: Highcharts.getOptions().colors[1]
					                }
					            }
					        },{ // Secondary yAxis
					            title: {
					                text: '不明扣费申诉率',
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
			            crosshairs: true,
			            shared: true
			        },
			        series: [{
			            name: '百万用户申诉率--行业',
			            type:'line',
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '百万用户申诉率-电信',
			            type:'line',
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '百万用户申诉率-移动',
			            type:'line',
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '百万用户申诉率-联通',
			            type:'line',
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '不明扣费申诉率-行业',
			            type:'line',
			            yAxis: 1,
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '不明扣费申诉率-电信',
			            type:'line',
			            yAxis: 1,
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '不明扣费申诉率-移动',
			            type:'line',
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        },{
			            name: '不明扣费申诉率-联通',
			            type:'line',
			            yAxis: 1,
			            tooltip: {
			                valueSuffix: '人次/百万用户'
			            }
			        }]	
		}
		
		var url = "/gj/bwyhss/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.millionUserComplaintRateList!=null){
				var i,len=data.millionUserComplaintRateList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.series[6].data = new Array();
				options.series[7].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.millionUserComplaintRateList,function(index,entity){
					options.series[0].data[index] = getNumber(((entity.field_13+entity.field_23+entity.field_33)/3).toFixed(2));
					options.series[1].data[index] = getNumber(entity.field_13);
					options.series[2].data[index] = getNumber(entity.field_23);
					options.series[3].data[index] = getNumber(entity.field_33);
					options.series[4].data[index] = getNumber(((entity.field_16+entity.field_26+entity.field_36)/3).toFixed(2));
					options.series[5].data[index] = getNumber(entity.field_16);
					options.series[6].data[index] = getNumber(entity.field_26);
					options.series[7].data[index] = getNumber(entity.field_36);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerSSL',options);
		        $("#containerSSL").show();
			}else{
				//$("#containerSSl").hide();
			}
		})
	}
	//form14
	var formXNYYSZS = function(year){
		var options = {
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
			        		crosshair: true	
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
			            tooltip: {
			                valueSuffix: '万'
			            }
			        }, {
			            name: '本地',
			            tooltip: {
			                valueSuffix: '万'
			            }
			        }]
		}
		
		var options2 = {
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
		        		crosshair: true	
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
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }, {
		            name: '本地',
		            tooltip: {
		                valueSuffix: '万'
		            }
		        }]
		}
		
		var url = "/gj/xnyys/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.virtualOperatorList!=null){
				var i,len=data.virtualOperatorList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options2.series[0].data = new Array();
				options2.series[1].data = new Array();
				options.xAxis.categories = new Array();
				options2.xAxis.categories = new Array();
				$.each(data.virtualOperatorList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11);
					options.series[1].data[index] = getNumber(entity.field_21);
					options2.series[0].data[index] = getNumber(entity.field_12);
					options2.series[1].data[index] = getNumber(entity.field_22);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
					options2.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerXNYYSZS',options);
				var chart2 = new Highcharts.Chart('containerXNYYSXZ',options2);
		        $("#containerXNYYSZS").show();
		        $("#containerXNYYSXZ").show();
			}else{
				//$("#containerXNYYSZS").hide();
				//$("#containerXNYYSXZ").hide();
			}
		})
	}
	//form15
	var formHYK = function(year){
		var options = {
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
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '存量物联网卡用户数（个）--上海电信',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '存量物联网卡用户数（个）--上海移动',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '存量物联网卡用户数（个）--上海联通',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '累计采取技术限定号码数--行业',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '累计采取技术限定号码数--上海电信',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '累计采取技术限定号码数--上海移动',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '累计采取技术限定号码数--上海联通',
	                type: 'column',
	                tooltip: {
	                    valueSuffix: '个'
	                }
	            }, {
	                name: '技术限定百分率--行业',
	                type: 'line',
	                yAxis: 1,
	                tooltip: {
	                    valueSuffix: '%'
	                }
	            }, {
	                name: '技术限定百分率--上海电信',
	                type: 'line',
	                yAxis: 1,
	                tooltip: {
	                    valueSuffix: '%'
	                }
	            }, {
	                name: '技术限定百分率--上海移动',
	                type: 'line',
	                yAxis: 1,
	                tooltip: {
	                    valueSuffix: '%'
	                }
	            }, {
	                name: '技术限定百分率--上海联通',
	                type: 'line',
	                yAxis: 1,
	                tooltip: {
	                    valueSuffix: '%'
	                }
	            }]	
		}
		
		var url = "/gj/hykgl/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.businessCardManagementList!=null){
				var i,len=data.businessCardManagementList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.series[6].data = new Array();
				options.series[7].data = new Array();
				options.series[8].data = new Array();
				options.series[9].data = new Array();
				options.series[10].data = new Array();
				options.series[11].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.businessCardManagementList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11+entity.field_21+entity.field_31);
					options.series[1].data[index] = getNumber(entity.field_11);
					options.series[2].data[index] = getNumber(entity.field_21);
					options.series[3].data[index] = getNumber(entity.field_31);
					options.series[4].data[index] = getNumber(entity.field_12+entity.field_22+entity.field_32);
					options.series[5].data[index] = getNumber(entity.field_12);
					options.series[6].data[index] = getNumber(entity.field_22);
					options.series[7].data[index] = getNumber(entity.field_32);
					options.series[8].data[index] = getNumber(((entity.field_13+entity.field_23+entity.field_33)/3).toFixed(2));
					options.series[9].data[index] = getNumber(entity.field_13);
					options.series[10].data[index] = getNumber(entity.field_23);
					options.series[11].data[index] = getNumber(entity.field_33);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerHYK',options);
		        $("#containerHYK").show();
			}else{
				//$("#containerHYK").hide();
			}
		})
	}
	
	var formMHFL = function(year){
		var options = {
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
			        }]
		}
		
		var url = "/codeclass/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.batch!=null){
				options.series[0].data = new Array();
				options.title.text = data.batch.year+'年'+data.batch.month+'月码号分类统计图';
				options.series[0].data = [
					['10630',data.counter[0]],
	                ['10639',data.counter[1]],
	                ['1062XXXX',data.counter[2]],
	                ['10635-10638', data.counter[3]],
	                ['962XXX',data.counter[4]],
	                ['96XXX',data.counter[5]]
				];
		        var chart = new Highcharts.Chart('containerMHFL',options);
		        $("#containerMHFL").show();
			}else{
				//$("#containerMHFL").hide();
			}
		})
	}
	//form18本地移动通信转售企业业务统计表
	var formBDTXZSYW = function(year){
		var options = {
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
	            }, {
	                name: '实体代理店数',
	                type: 'column',
	                yAxis: 1,
	            }, {
	                name: '网络代理店数',
	                type: 'column',
	                yAxis: 1,
	            }]
		}
		
		var options2 = {
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
            		crosshair: true
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
            }]
		}
		
		var url = "/gj/ydzsyw/data_to_charts";
		$.getJSON(url,{year:year},function(data){
			if(data.mobileResaleEnterpriseList!=null){
				var i,len=data.mobileResaleEnterpriseList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options2.series[0].data = new Array();
				options.xAxis.categories = new Array();
				options2.xAxis.categories = new Array();
				$.each(data.mobileResaleEnterpriseList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_11);
					options.series[1].data[index] = getNumber(entity.field_17);
					options.series[2].data[index] = getNumber(entity.field_23);
					options2.series[0].data[index] = getNumber(entity.field_16);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
					options2.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('form18_1',options);
				var chart2 = new Highcharts.Chart('form18_2',options2);
		        $("#form18_1").show();
		        $("#form18_2").show();
			}else{
				//$("#form18_1").hide();
				//$("#form18_2").hide();
			}
		})
	}
	var formCheckJobList = function(year){
		var options = {
				chart: {
		            zoomType: 'xy'
		        },
		        title: {
		            text: '全国核查工单及时率及准确率情况'
		        },
		        subtitle: {
		            text: '数据来源: 上海市通信管理局'
		        },
		        xAxis: {
		        		crosshair: true
		        },
		        yAxis: [{ // Primary yAxis
		            labels: {
		                format: '{value}%',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            },
		            title: {
		                text: '及时率',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            }
		        },{ // Secondary yAxis
		            title: {
		                text: '准确率',
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
		            name: '全国核查工单及时率 上海电信',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '全国核查工单及时率 上海移动',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '全国核查工单及时率 上海联通',
		            type: 'column',
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '全国核查工单准确率 上海电信',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '全国核查工单准确率 上海移动',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }, {
		            name: '全国核查工单准确率 上海联通',
		            type: 'line',
		            yAxis: 1,
		            tooltip: {
		                valueSuffix: '%'
		            }
		        }]
		}
		
		var url = "/gj/checkjob/list";
		$.getJSON(url,{year:year},function(data){
			if(data.checkJobList!=null){
				var i,len=data.checkJobList.length; 
				options.series[0].data = new Array();
				options.series[1].data = new Array();
				options.series[2].data = new Array();
				options.series[3].data = new Array();
				options.series[4].data = new Array();
				options.series[5].data = new Array();
				options.xAxis.categories = new Array();
				$.each(data.checkJobList,function(index,entity){
					options.series[0].data[index] = getNumber(entity.field_12);
					options.series[1].data[index] = getNumber(entity.field_22);
					options.series[2].data[index] = getNumber(entity.field_32);
					options.series[3].data[index] = getNumber(entity.field_14);
					options.series[4].data[index] = getNumber(entity.field_24);
					options.series[5].data[index] = getNumber(entity.field_34);
					options.xAxis.categories[index] = entity.year+'-'+entity.month;
				}) 
		        var chart = new Highcharts.Chart('containerCheckJobList',options);
		        $("#containerCheckJobList").show();
			}else{
				//$("#containerCheckJobList").hide();
			}
		})
	}
	var initFunction = function(){
		var date=new Date();
		var year = date.getFullYear();  
		if($("#containerSMZ").length>0){
			formSMZ(year);
		}
		if($("#containerSMZQD").length>0){
			formSMZQD(year);
		}
		if($("#containerZYZJC").length>0){
			formZYZJC(year);
		}
		if($("#containerXXZP").length>0){
			formXXZP();
		}
		if($("#containerGDDHBJB").length>0){
			formGDDHBJB(year);
		}
		if($("#containerDJXXZP").length>0){
			formDJXXZP(year);
		}
		if($("#containerWJLJDXJB").length>0){
			formWJLJDXJB(year);
		}
		if($("#containerGWHMZY").length>0){
			formGWHMZY(year);
		}
		if($("#containerKDZF").length>0){
			formKDZF(year);
		}
		if($("#containerJF").length>0){
			formJF(year);
		}
		if($("#containerYYSR").length>0){
			formYYSR(year);
		}
		if($("#containerZMQDXYW").length>0){
			formZMQDXYW(year);
		}
		if($("#containerSSL").length>0){
			formSSL(year);
		}
		if($("#containerXNYYSZS").length>0){
			formXNYYSZS(year);
		}
		if($("#containerMHFL").length>0){
			formMHFL(year);
		}
		if($("#containerHYK").length>0){
			formHYK(year);
		}
		if($("#form18_1").length>0){
			formBDTXZSYW(year);
		}
		
		if($("#containerCheckJobList").length>0){
			formCheckJobList(year);
		}
	}();
	
var getNumber = function(param){
	if(param==null){
		return 0;
	}
	return Number(param);
}
