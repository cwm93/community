/**
 * 
 */
function AutomateExcel(tablename) {
	var elTable = document.getElementById(tablename); // 要导出的table id。
	var oRangeRef = document.body.createTextRange();
	oRangeRef.moveToElementText(elTable);
	oRangeRef.execCommand("Copy");
	try {
		var appExcel = new ActiveXObject("Excel.Application");
		var oWB = appExcel.Workbooks.Add();
		// 获取workbook对象
		var oSheet = oWB.ActiveSheet;
		oSheet.Columns("1:5").ColumnWidth = 40
		oWB.Worksheets.Item(1).Paste();
		appExcel.Visible = true;
		// appExcel.ActiveSheet.Columns("1:5").ColumnWidth = 40
	} catch (e) {
		alert("请查看浏览器ActiveX控件和插件是否启用！");
	} finally {
		appExcel = null;
	}
}
