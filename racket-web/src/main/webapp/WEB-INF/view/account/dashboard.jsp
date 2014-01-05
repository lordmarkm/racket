<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html>

<head>
  <title>Dashboard</title>
  <script src="<@spring.url '/javascript/require/r.js' />"></script>
  <script src="<@spring.url '/javascript/account/dashboard.js' />"></script>
</head>
<body>
  Hello, ${racketeer.account.username }!
</body>

</html>