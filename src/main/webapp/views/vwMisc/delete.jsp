<c:choose>
    <c:when test="${auth}">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownR" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Hi, <b>${authUser.name}!</b>
            </a>
    </c:when>
</c:choose>