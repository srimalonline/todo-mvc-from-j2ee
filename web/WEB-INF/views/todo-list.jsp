<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Todos</title>
    <!-- Tailwind CSS CDN link -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!-- Font Awesome CDN link for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
    <div class="container mx-auto py-8 flex flex-col items-center">
        <div class="text-center mb-8">
            <h1 class="text-3xl font-bold">My Todos</h1>
            <div class="mt-4">
                <a href="new" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
                    <i class="fas fa-plus-circle mr-2"></i> Add New Todo
                </a>
            </div>
        </div>
        <div class="mt-8 container">
            <div class="grid grid-cols-1 gap-4">
                <c:forEach var="todo" items="${listTodo}">
                    <div class="bg-white rounded-lg shadow-lg p-6 flex flex-col justify-between">
                        <div>
                            <h2 class="text-lg font-semibold mb-2"><c:out value="${todo.name}" /></h2>
                            <p class="text-sm text-gray-600 mb-4"><c:out value="${todo.description}" /></p>
                        </div>
                        <div class="flex justify-between">
                            
                            <form action="update" method="POST" class="flex items-center">
                                <input type="hidden" name="id" value="<c:out value='${todo.id}' />">
                                <input type="hidden" name="name" value="<c:out value='${todo.name}' />">
                                <input type="hidden" name="description" value="<c:out value='${todo.description}' />">


                                <c:choose>
                                    <c:when test="${todo.state}">
                                        <!-- If todo is completed, display button to mark as not completed -->
                                        <input type="hidden" name="state" value="false">
                                        <button type="submit" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
                                            <i class="far fa-times-circle"></i> Mark as Not Completed
                                        </button>
                                    </c:when>
                                    <c:otherwise>
                                        <!-- If todo is not completed, display button to mark as completed -->
                                        <input type="hidden" name="state" value="true">
                                        <button type="submit" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
                                            <i class="far fa-check-circle"></i> Mark as Completed
                                        </button>
                                    </c:otherwise>
                                        
                                </c:choose>
                            </form>
                                <div class="flex">
                                <a href="edit?id=<c:out value='${todo.id}' />" class="text-blue-500 hover:text-blue-700">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="delete?id=<c:out value='${todo.id}' />" class="text-red-500 hover:text-red-700 ml-2">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
