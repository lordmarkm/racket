<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html>

<head>
  <title>Dashboard</title>
  <script src="<@spring.url '/libs/require/r.js'/>"></script>
  <script src="<@spring.url '/javascript/main.js'/>"></script>
  <link rel="stylesheet" href="<@spring.url '/libs/bootstrap-3.0.3/css/bootstrap.min.css' />" />
  <link rel="stylesheet" href="<@spring.url '/libs/bootstrap-3.0.3/css/bootstrap-theme.min.css' />" />
  <link rel="stylesheet" href="<@spring.url '/libs/plugolabs/css/fam-icons.css' />" />
</head>

<body>

  <div class="container-fluid">
    <div class="row-fluid">
      <div class="col-md-12">
        <a href="#/"><i class="fam-house"></i></a> Hello, ${racketeer.account.username }!
      </div>
    </div>
    <div class="row-fluid">
      <div class="col-md-2" data-ng-controller="SidebarCtrl">
        <ul class="nav nav-pills nav-stacked">
          <li class="list-group">Your rackets</li>
          <li data-ng-repeat="racket in rackets">
            <a href="#/racket/operations/{{racket.id}}" title="{{racket.description}}">{{racket.name}}</a>
          </li>
        </ul>
        
        <a href="#/newracket">Create new racket</a>
      </div>
      
      <div class="col-md-10" ui-view>
        <i>Some content will load here!</i>
      </div>
    </div>
  
  </div>

</body>

</html>