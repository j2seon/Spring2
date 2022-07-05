<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="tab">
    <ul class="meumain">
        <li><a href="<c:url value="/show/list?t=1&code=100"/>">샌드위치</a>
            <ul class="sub">
                <li><a href="<c:url value="/show/list?t=1&code=100"/>">전체</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=101"/>">클래식</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=102"/>">프레쉬&라이트</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=103"/>">프리미엄</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=104"/>">신제품</a></li>
            </ul>
        </li>
        <li><a href="<c:url value="/show/list?t=1&code=200"/>">샐러드</a>
            <ul class="sub">
                <li><a href="<c:url value="/show/list?t=1&code=200"/>">전체</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=201"/>">클래식</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=202"/>">프레쉬&라이트</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=203"/>">프리미엄</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=204"/>">신제품</a></li>
            </ul>
        </li>
        <li><a href="<c:url value="/show/list?t=1&code=300"/>">랩&기타</a>
            <ul class="sub">
                <li><a href="<c:url value="/show/list?t=1&code=300"/>">전체</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=301"/>">시그니처 랩</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=302"/>">그릴드 랩</a></li>
                <li><a href="<c:url value="/show/list?t=2&code=303"/>">미니 랩</a></li>
            </ul>
        </li>
    </ul>
</div>

