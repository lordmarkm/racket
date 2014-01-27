<#import "./racketnav.ftl" as racketnav />

<div>
  <div ng-if="notif != null && notif.message != null"class="alert alert-info">{{notif.message}}</div>
  <@racketnav.racketnav 'transactions' />

  <h4>Transactions</h4>

  <div class="alert alert-info" ng-repeat="transaction in orderedTransactions()">
    {{transaction.message}} <span class="bold">(Php {{transaction.value}})</span> 

    <span title="Show transaction details" class="pointer glyphicon"
      ng-click="showDetails[transaction.id] = !showDetails[transaction.id]" 
      ng-class="{'glyphicon-collapse-down': !showDetails[transaction.id], 'glyphicon-collapse-up': showDetails[transaction.id]}">
    </span>
    
    <span title="Add annotation" class="pointer glyphicon glyphicon-pencil"
      ng-click="showAnnotationForm[transaction.id] = !showAnnotationForm[transaction.id]">
    </span>

    <div class="bs-callout" ng-show="showDetails[transaction.id]">
      <small class="light-grey bold">TRANSACTION DETAILS</small>
      <div ng-repeat="detail in transaction.details">
        {{detail.label}} - {{detail.message}}
      </div>
    </div>
    
    <div class="bs-callout" ng-show="showAnnotationForm[transaction.id]">
      <small class="light-grey bold">ADD ANNOTATION</small>
      <form class="form form-inline">
		    <div class="form-group">
		      <label class="sr-only" for="annotationform-{{transaction.id}}-description">Description</label>
	        <input type="text" class="form-control input-sm" id="annotationform-{{transaction.id}}-description" 
	         placeholder="Description"
	         ng-model="annotationforms[transaction.id].description" />
		    </div>
        <div class="form-group">
          <label class="sr-only" for="annotationform-{{transaction.id}}-value">Value</label>
          <input type="text" class="form-control input-sm" id="annotationform-{{transaction.id}}-value" 
            placeholder="Value"
            ng-model="annotationforms[transaction.id].value" />
        </div>	
        <button type="submit" class="btn btn-sm btn-primary" ng-click="addAnnotation(transaction.id)">Save</button>
        <button class="btn btn-sm btn-danger" ng-click="showAnnotationForm[transaction.id] = false">Cancel</button>
      </form>
    </div>
    
    <div class="bs-callout" ng-show="transaction.annotations.length > 0">
      <small class="light-grey bold">ANNOTATIONS</small>
      <div class="bs-callout bs-callout-info" ng-repeat="annotation in transaction.annotations">
        <span class="bold">{{annotation.author}}</span> {{annotation.title}}<span ng-if="annotation.value">: {{annotation.value}}</span>
        <div><small>{{fromNow(annotation.date)}}</small></div>
      </div>
    </div>

    <div class="clear"></div>
    <div class="label label-default">{{fromNow(transaction.date)}}</div>
  </div>

</div>