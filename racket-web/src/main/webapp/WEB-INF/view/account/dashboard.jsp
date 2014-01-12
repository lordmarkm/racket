<#import "/spring.ftl" as spring /> 

<!DOCTYPE html>
<html>

<head>
  <title>Dashboard</title>
  <script src="<@spring.url '/libs/require/r.js'/>"></script>
  <script src="<@spring.url '/javascript/main.js'/>"></script>
  <link rel="stylesheet" href="<@spring.url '/libs/backups/bootstrap-combined.min.css' />" />
  <link rel="stylesheet" href="<@spring.url '/libs/plugolabs/css/fam-icons.css' />" />
</head>

<body>

  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span12">
        <a href="#/"><i class="fam-house"></i></a> Hello, ${racketeer.account.username }!
      </div>
    </div>
    <div class="row-fluid">
      <div class="span2" data-ng-controller="SidebarCtrl">
        <h3>Your rackets:</h3>
        <ul style="list-style-type: none; margin-left: 0;">
          <li data-ng-repeat="racket in rackets">
            <a href="#/racket/{{racket.id}}">{{racket.name}}</a> - {{racket.description}}
          </li>
        </ul>
        
        <a href="#/newracket">Create new racket</a>
      </div>
      
      <div class="span10" ui-view>
        <i>Some content will load here!</i>
      </div>
    </div>
  
  </div>

</body>

</html>