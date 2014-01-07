<#import "/spring.ftl" as spring />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html>
<html>

<head>
  <title>Hello world</title>
  <script data-main="modules/main" src="<@spring.url '/libs/require/r.js' />"></script>
</head>

<body>
  Hello world
</body>

</html>
