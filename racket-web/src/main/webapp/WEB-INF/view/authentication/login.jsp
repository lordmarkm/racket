<#import "/spring.ftl" as spring /> 
<#import "../templates/css.ftl" as css />

<!DOCTYPE html>
<html>

<head>
  <title>Login</title>
  <script src="<@spring.url '/javascript/require/r.js' />"></script>
  <script src="<@spring.url '/javascript/authentication/login.js' />"></script>
  <@css.css />
</head>

<body>

<#if error??>
  <div class="alert alert-error">${error }</div>
<#elseif message??>
  <div class="alert alert-info">${message }</div>
</#if>

<#assign action><@spring.url '/login/authenticate' /></#assign>
<form class="form-horizontal" action="${action }" method="post">
  <fieldset>
    <legend>Login</legend>
    <div class="control-group">
      <label class="control-label" for="username">Username</label>
      <div class="controls">
        <input type="text" name="username" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" name="password" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="remember-me">Remember me</label>
      <div class="controls">
        <input type='checkbox' name='remember-me' id="remember-me"/>
      </div>
    </div>
  </fieldset>
  <div class="control-group">
    <div class="controls">
      <input class="btn btn-primary" type="submit" value="Log in" />
    </div>
  </div>    
</form>
<p>No account? <a href="<@spring.url '/auth/register' />">Sign up!</a>

</body>

</html>
