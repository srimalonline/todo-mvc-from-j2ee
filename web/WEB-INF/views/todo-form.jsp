<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Todos - New Todo</title>
    <!-- Tailwind CSS CDN link -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

</head>
<body class="bg-gray-100">
    <div class="container mx-auto py-8">
        <div class="text-center">
            <h1 class="text-3xl font-bold mb-4">My Todos - New Todo</h1>
            <a href="list" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-full">
                    <i class="fas fa-list mr-2"></i> List All Todos
                </a>
        </div>
        <div class="mt-8 mx-auto w-full bg-white p-8 rounded-lg shadow-lg">
            <c:choose>
                <c:when test="${empty todo.id}">
                    <form action="insert" method="post">
                </c:when>
                <c:otherwise>
                    <form action="update" method="post">
                        <input type="hidden" name="id" value="${todo.id}" />
                </c:otherwise>
            </c:choose>

                <div class="mb-4">
                    <label for="name" class="block text-gray-700 text-sm font-bold mb-2">Name</label>
                    <input type="text" id="name" name="name" value="${todo.name}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>
                <div class="mb-4">
                    <label for="description" class="block text-gray-700 text-sm font-bold mb-2">Description</label>
                    <textarea id="description" name="description" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">${todo.description}</textarea>
                </div>
                <div class="mb-4">
                    <label for="state" class="block text-gray-700 text-sm font-bold mb-2">State</label>
                    <select id="state" name="state" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                        <option value="true" ${todo.state ? 'selected' : ''}>Completed</option>
                        <option value="false" ${!todo.state ? 'selected' : ''}>Not Completed</option>
                    </select>
                </div>
                <div class="flex items-center justify-between">
                    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Save</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
