<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="resources/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/adminLTE/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resources/adminLTE/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="resources/css/singlestock.css">

    <!-- Select2 -->
    <link rel="stylesheet" href="resources/bower_components/select2/dist/css/select2.min.css">
    <!-- jQuery 3 -->
    <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="resources/bower_components/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);

    </script>
    <!-- Bootstrap 3.3.7 -->
    <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Slimscroll -->
    <script src="resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="resources/adminLTE/dist/js/adminlte.min.js"></script>
    <!-- ChartJS -->
    <script src="resources/bower_components/chart.js/Chart.js"></script>
    <script src="js/echarts/echarts.js"></script>

    <!-- Select2 -->
    <script src="resources/bower_components/select2/dist/js/select2.full.min.js"></script>

</head>
<body>
    <h2>Hello !</h2>

        <label>Stock Name</label>
        <select class="select2" id="stockName">
            <option>feafafaf</option>
        </select>
    <script>



            $("#stockName").select2();

            $("#stockName").select2({
                ajax: {
                    url: "stock/search",
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        return {
                            q: params.term, // search term
                            page: params.page,
                            market: 1
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


        function formatRepo (repo) {
            /*if (repo.loading) return repo.text;
             var markup = "<div class='select2-result-repository clearfix'>" +
             "<div class='select2-result-repository__meta'>" +
             "<div class='select2-result-repository__title'>" + repo + "</div>";

             if (repo.description) {
             markup += "<div class='select2-result-repository__description'>" + repo.description + "</div>";
             }

             return markup;*/
            return repo;
        }

        function formatRepoSelection (repo) {
            return repo;
        }
    </script>
</body>
</html>
