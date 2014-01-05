<#import "/spring.ftl" as spring /> 
<#import "../templates/css.ftl" as css />

<!DOCTYPE html>
<html>

<head>
  <title>Register</title>
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

<form id="login-form" class="form-horizontal" action="<@spring.url '/auth/register' />" method="post">
  <fieldset>
    <legend>Register</legend>
    
    <div class="control-group">
      <label class="control-label" for="username">Username</label>
      <div class="controls">
        <input type="text" name="username" <#if form?? && form.username??>value="${form.username }"</#if> />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" name="password" <#if form?? && form.password??>value="${form.password }"</#if> />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Confirm Password</label>
      <div class="controls">
        <input type="password" name="confirmpw" <#if form?? && form.confirmpw??>value="${form.confirmpw }"</#if> />
      </div>
    </div>
  </fieldset>
  <div class="control-group">
    <div class="controls">
      <input class="btn btn-success btn-large" type="submit" value="Sign Up" />
    </div>
  </div>
</form>
<p>Already have an account? <a href="<@spring.url '/auth/login' />">Log in</a>

</body>

</html>