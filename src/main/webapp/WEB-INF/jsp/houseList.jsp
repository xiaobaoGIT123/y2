<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:forEach items="${houseList}" var="li">
<div class="showhome">
    <c:if test="${li.housePicture==''}">
        <img src="/statics/img/l_img/moren.png"/>
    </c:if>
    <c:if test="${li.housePicture!=''}">
        <img src="/statics/uploadfiles/${li.housePicture}"/>
    </c:if>
    <table >
        <tr>
            <td>发布时间：${li.houseTime}&nbsp;&nbsp;&nbsp;</td>
            <td>房源类型：${li.type}&nbsp;&nbsp;&nbsp;</td>
            <td>房源价格：${li.housePrice}</td>
        </tr>
        <tr>
            <td colspan="2">房源地址：${li.houseAddress}&nbsp;&nbsp;&nbsp;</td>
            <td><a href="#">房源详细信息</a></td>
        </tr>
    </table>
</div>
</c:forEach>