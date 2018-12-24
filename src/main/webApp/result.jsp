<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Uimaker-专注UI设计</title>
<link href="/tss/css/style.css" rel="stylesheet" type="text/css" />
<link href="/tss/css/result.css" rel="stylesheet" type="text/css" />
    <script src="/tss/js/jquery.js"></script>
    <script type="text/javascript">
           function aa() {
               var ss=$("#ss").val();
               window.location='/tss/poetry/queryVerse?nowPage=${param.nowPage-1}&pageSize=${param.pageSize}&verse='+ss;
           };
           function bb() {
               var ss=$("#ss").val();
               window.location='/tss/poetry/queryVerse?nowPage=${param.nowPage+1}&pageSize=${param.pageSize}&verse='+ss;
           };
    </script>
</head>
<body>
<div id="container">
	<div id="hd" class="ue-clear">
    	<div class="logo"></div>
        <div class="inputArea">
        	<input id="ss" type="text" class="searchInput"  value="${requestScope.verse}"/>
            <input type="button" class="searchButton" />
        </div>
    </div>
                <div class="sideBarShowHide">
                	<a href="javascript:;" class="icon"></a>
                </div>
            <div class="resultArea">
                <div class="resultList">
                    <c:forEach items="${requestScope.list}" var="poetry">
                	<div class="resultItem">
                    	<div class="itemHead">
                        	${poetry.title}--作者${poetry.poets.name}
                        </div>
                        <div class="itemBody">
                        	${poetry.content}
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
    <p>
        <c:if test="${param.nowPage!=1}">
            <input type="button" class="button" value="上一页" onclick="aa()"/>
        </c:if>
        &nbsp;${param.nowPage}/${requestScope.page.pageCount}&nbsp;
        <c:if test="${requestScope.page.pageLast(param.nowPage)}">
            <input type="button" class="button" value="下一页" onclick="bb()"/>
        </c:if>
    </p>
</div>
<div id="foot">Copyright &copy;uimaker.com 版权所有  E-mail:admin@uimaker.com</div>
</body>
</html>