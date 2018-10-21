# C标签换行

    <tr>
      <c:forEach var="storeEntity" items="${displayList}" varStatus="status">
        <td> 
          <c:out value="${storeEntity.getS_name()}"/>
        </td>
        <c:if test="${status.count%4==0}">
          <tr>
          </tr>
        </c:if>
      </c:forEach>
    </tr> 
