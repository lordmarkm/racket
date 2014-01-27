<#import "./racketnav.ftl" as racketnav />

<div>
  <div ng-if="notif != null && notif.message != null"class="alert alert-info">{{notif.message}}</div>
  <@racketnav.racketnav 'transactions' />

  <h4>Transactions</h4>

  <div class="alert alert-info" ng-repeat="transaction in transactions">
    {{transaction.message}} ({{transaction.value}}) <span title="Show transaction details" class="pointer glyphicon glyphicon-collapse-down"></span>
    <div class="hide">
      <ul>
        <li ng-repeat="detail in transaction.details">
          {{detail.label}} - {{detail.message}}
        </li>
      </ul>
    </div>
    <div class="clear"></div>
    <div class="label label-default">{{fromNow(transaction.date)}}</div>
  </div>

</div>