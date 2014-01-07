<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html ng-app="racketApp">

<head>
  <title>Dashboard</title>
  <!-- 
    <script src="<@spring.url '/javascript/require/r.js' />"></script>
   -->
  <script src="<@spring.url '/libs/backups/angular.min.js'     />"></script>
  <script src="<@spring.url '/javascript/account/dashboard.js' />"></script>
</head>

<body ng-controller="DashboardCtrl">
  Hello, ${racketeer.account.username }!
  
  <section ui-view>
    <i>Some content will load here!</i>
  </section>
  
  <table>
    <tr><th>row number</th></tr>
    <tr ng-repeat="i in [0, 1, 2, 3, 4, 5, 6, 7]"><td>{{i+1}}</td></tr>
  </table>
  
  {{apples}}
  
</body>

</html>