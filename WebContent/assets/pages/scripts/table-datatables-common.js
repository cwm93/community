var TableDatatablesButtons = function () {

    var initTable1 = function () {
        var table = $('#tablesList');
        
        var oTable = table.dataTable({

            // Internationalisation. For more info refer to http://datatables.net/manual/i18n
            "language": {
                "aria": {
                    "sortAscending": ": activate to sort column ascending",
                    "sortDescending": ": activate to sort column descending"
                },
                "emptyTable": "暂无数据",
                "info": "显示 _START_ 到 _END_ 条  共 _TOTAL_ 条",
                "infoEmpty": "没有发现可加载的数据",
                "infoFiltered": "(filtered1 from _MAX_ total entries)",
                "lengthMenu": "_MENU_ 条",
                "search": "全局检索:",
                "zeroRecords": "没有发现匹配项目"
            },

            "order": [
                [0, 'desc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 20, -1],
                [5, 10, 15, 20, "全部"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,

        });
    }
    return {

        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

            initTable1();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesButtons.init();
});