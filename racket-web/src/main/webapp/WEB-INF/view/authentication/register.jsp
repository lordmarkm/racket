<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html>

<head>
  <title>Register</title>
</head>
<body>

<form id="registration-form" class="form-horizontal" action="<@spring.url '/auth/register' />" method="post">
  <fieldset>
    <legend>Register</legend>
    
    <div class="control-group">
      <label class="control-label" for="username">Username</label>
      <div class="controls">
        <input type="text" name="username" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="email">Email</label>
      <div class="controls">
        <input type="email" name="email" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" name="password" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="password">Confirm Password</label>
      <div class="controls">
        <input type="password" name="confirmpw" />
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