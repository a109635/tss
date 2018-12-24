<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Uimaker-专注UI设计</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
    <script type="text/javascript">
        $(function () {

        });
        function aa() {
            var ss=$("#ss").val();
            console.log(ss);
            window.location="/tss/poetry/queryVerse?verse="+ss+"&nowPage=1&pageSize=10";
        }
    </script>
</head>
<body>
<div id="container">
	<div id="bd">
        <div id="main">
        	<h1 class="title">
            	<div class="logo large"></div>
            </h1>
            <div class="nav ue-clear">
            </div>
            <div class="inputArea">
            	<input type="text" id="ss" class="searchInput" />
                <input type="button" class="searchButton" onclick="aa()" />
            </div>
        </div><!-- End of main -->
    </div><!--End of bd-->
    
    <div class="foot">
    	<div class="wrap">
            <div class="copyright">Copyright &copy;uimaker.com 版权所有  E-mail:admin@uimaker.com</div>
        </div>
    </div>
</div>
</body>
</html>