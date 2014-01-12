<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html>

<head>
  <title>Dashboard</title>
  <script src="<@spring.url '/libs/require/r.js'/>"></script>
  <script src="<@spring.url '/javascript/main.js'/>"></script>
  <link rel="stylesheet" href="<@spring.url '/libs/backups/bootstrap-combined.min.css' />" />
</head>

<body>
  Hello, ${racketeer.account.username }!
  
  <ul>
    <li><a href="#/newracket">Create new racket</a>
  </ul>

  <section ui-view>
    <i>Some content will load here!</i>
  </section>
  
  <section ng-controller="SidebarCtrl">
    <h3>Your rackets:</h3>
    <ul>
      <li ng-repeat="racket in rackets">
        {{racket.id}}: <a href="#/racket/{{racket.id}}">{{racket.name}}</a> - {{racket.description}}
      </li>
    </ul>
  </section>
  
</body>

</html>