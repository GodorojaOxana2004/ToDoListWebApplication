<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo List</title>
    <link href="${pageContext.request.contextPath}/resources/css/main-page.css" rel="stylesheet">
</head>
<body>
<div class="main-wrapper">
    <header class="header"><h1>ToDo List</h1> <span
            class="count-info">${numberActiveRecords} more to do ${numberDoneRecords} done</span></header>


    <section class="filters">
        <form id="filter-form">
            <label>
                <input type="radio" name="filter" value="all" checked> All
            </label>
            <label>
                <input type="radio" name="filter" value="active"> Active
            </label>
            <label>
                <input type="radio" name="filter" value="done"> Done
            </label>
            <button type="submit">Apply Filter</button>
        </form>
    </section>


    <main class="items">


        <div class="items">
            <c:choose>
                <c:when test="${not empty records }">
                    <c:forEach items="${records}" var="record">
                        <div class="item">
                            <div class="item-text">
                                <h3 class="${record.status == 'DONE' ? 'btn-done-done' : ''}">${record.title}</h3>
                            </div>

                            <div class="controls">
                                <c:if test="${record.status== 'ACTIVE'}">
                                    <form action="/markDone" method="post">
                                        <input type="hidden" name="id" value="${record.id}" />
                                        <button type="submit" class="btn-done" name="MarksDone" title="MarksDone"
                                                value="${record.id}">✓
                                        </button>
                                    </form>
                                </c:if>
                                <form action="/delete" method="post">
                                    <input type="hidden" name="id" value="${record.id}" />
                                    <button type="submit" class="btn-delete" name="DeleteTask" title="Delete Task"
                                            value="${record.id}">✕
                                    </button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div>
                        <span>There are not task!</span>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>

    </main>


    <section class="input-form">
        <form id="add-form" action="/addTask" method="POST">
            <input type="text" name="taskDescription" placeholder="What needs to be done?" required>
            <button type="submit">Add Task</button>
        </form>
    </section>

</div>
</body>
</html>