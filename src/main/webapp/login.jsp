<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Login Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form method="post" action="user">
            <div style="padding: 100px 0 0 250px;">
                <div id="login-box">
                    <h2>Login Page</h2>
                    Please provide your credential to use this website
                    <br/>
                    <br/>
                    <div id="login-box-name" style="margin-top:20px;">User Id:</div>
                    <div id="login-box-field" style="margin-top:20px;">
                        <input type='text' name="username" class="form-login" title="Username" value="" size="30" maxlength="50" />
                    </div>
                    <div id="login-box-name">Password:</div>
                    <div id="login-box-field">
                        <input type="password" name="password" class="form-login" title="Password" value="" size="30" maxlength="48" />
                    </div>
                    <br />
                    <span class="login-box-options">
                        New User?� <a href="register.jsp" style="margin-left:30px;">Register Here</a>
                    </span>
                    <br />
                    <br />
                    <input type="hidden" name="action" value="doLogin"/>
                    <input style="margin-left:100px;" type="submit" value="Login" />
                </div>
            </div>
        </form>
    </body>
</html>