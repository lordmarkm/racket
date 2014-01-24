<#import "./racketnav.ftl" as racketnav />

<div>
  <div ng-if="notif != null && notif.message != null"class="alert alert-info">{{notif.message}}</div>
  <@racketnav.racketnav 'notifs' />
  
  <h4>Notifications</h4>
  
  <ul>
    <li ng-repeat
  </ul>
  
</div>