<#import "./racketnav.ftl" as racketnav />

<div>
  <div ng-if="notif != null && notif.message != null"class="alert alert-info">{{notif.message}}</div>
  <@racketnav.racketnav 'notifs' />
  
  <h4>Notifications</h4>
  
  <div class="alert alert-info" ng-repeat="notif in notifs">
    {{notif.message}}
  </div>
  
  <ul>
    <li ng-repeat="notif in notifs">
      {{notif.message}}
    </li>
  </ul>
  
</div>