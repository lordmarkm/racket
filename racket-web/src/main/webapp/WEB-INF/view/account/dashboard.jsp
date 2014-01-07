<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html ng-app="racketApp">

<head>
  <title>Dashboard</title>
  <script src="<@spring.url '/libs/backups/jquery.min.js'      />"></script>
  <script src="<@spring.url '/libs/angular/angular.min.js'     />"></script>
  <script src="<@spring.url '/libs/angular/angular-ui-router.min.js' />"></script>
  <script src="<@spring.url '/javascript/services.js' />"></script>
  <script src="<@spring.url '/javascript/app.js' />"></script>
</head>

<body ng-controller="MainCtrl">
  Hello, ${racketeer.account.username }!
  
  <ul>
    <li><a href="#/newracket">Create new</a>
    <li><a href="#/racket/5">racket 5</a></li>
  </ul>

  <section ui-view>
    <i>Some content will load here!</i>
  </section>
  
  <section ng-controller="SidebarCtrl">
    <ul>
      <li ng-repeat="racket in rackets">
        {{racket.id}}: {{racket.name}} - {{racket.description}}
      </li>
    </ul>
  </section>
</body>

</html>