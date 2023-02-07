<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <p>Welcome to login page!</p>
        <pre>
            ${errorMessage}
        </pre>
        <form method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
        <p>Please Login to Continue</p><br>
        <!-- <%= new java.util.Date() %> -->
    </body>
</html>