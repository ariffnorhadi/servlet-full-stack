<%-- 
    Document   : login
    Created on : 22 Mar 2025, 8:00:53 am
    Author     : ariffnorhadi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" href="tailwind.min.css"/>-->
  </head>
  <body class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="w-full max-w-md p-6 bg-white rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-center text-gray-700">Login</h2>
      <form class="mt-4">
        <div>
          <label class="block text-sm font-medium text-gray-700">Email Address</label>
          <input type="email" class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="johndoe@example.com">
        </div>
        <div class="mt-4">
          <label class="block text-sm font-medium text-gray-700">Password</label>
          <input type="password" class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="********">
        </div>
        <button type="submit" class="w-full px-4 py-2 mt-4 font-bold text-white bg-blue-500 rounded-lg hover:bg-blue-600">Login</button>
      </form>
    </div>
  </body>
</html>
