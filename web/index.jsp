<%-- 
    Document   : index
    Created on : 21 Mar 2025, 10:38:57 pm
    Author     : ariffnorhadi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <!--        <link rel="stylesheet" href="tailwind.min.css"/>-->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  </head>
  <body class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="w-full max-w-md p-6 bg-white rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-center text-gray-700">Register</h2>

      <!-- Step 1: Create form, action is to go to which servlet. can check servlet-full-stack\web\WEB-INF\web.xml for correct URL-->
      <form class="mt-4" action="UserController">
        <div>
          <label class="block text-sm font-medium text-gray-700">Full Name</label>
          <!-- 
            Step 2: 
            In a form, define what is the name of the parameter that we want to send to controller so that controller know what param to retrieve.
            This name is defined in the `name` attribute of each input field

            for example below, the param name for input name is `full_name`. Later on, servlet need to retrieve the param name `full_name`.
            if we retrieve wrong/incorrect param name, then we'll retrieve nothing , in other words, it'll become null. 
            When values are null, we cannot save/ update anything in database.
          -->
          <input type="text" class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Ahmad Jacob" name="full_name">
        </div>
        <div class="mt-4">
          <label class="block text-sm font-medium text-gray-700">Email Address</label>
          <input type="email" class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="ahmadjacob@example.com" name="email">
        </div>
        <div class="mt-4">
          <label class="block text-sm font-medium text-gray-700">Password</label>
          <input type="password" class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="********" name="password">
        </div>

        <!-- Step 3: Add an action param, to tell servlet what to do with all the params above. Assign the value too so that servelet can identify what process to be done -->
        <button type="submit" name="action" value="create_new_user" class="w-full px-4 py-2 mt-4 font-bold text-white bg-blue-500 rounded-lg hover:bg-blue-600">Register</button>

        <!-- 
          Step 4: Now that we're submitting the form, let's go to the controller where we send this data to (UserController) 
          Let's go to servlet-full-stack\src\java\controller\UserController.java
         -->
      </form>
    </div>
  </body>
</html>
