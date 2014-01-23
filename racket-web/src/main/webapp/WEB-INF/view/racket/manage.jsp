<#import "./racketnav.ftl" as racketnav />

<div>
  <@racketnav.racketnav 'manage' />
  
  <h4>Commodities</h4>
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
        <th>Details</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr data-ng-repeat="commodity in racket.commodities">
        <td>{{commodity.id}}</td>
        <td>{{commodity.name}}</td>
        <td>{{commodity.description}}</td>
        <td>{{commodity.type}}</td>

        <td ng-switch on="commodity.type">
          <span ng-switch-when="RETAIL">
            <span ng-if="commodity.price">{{commodity.price}} <span ng-if="commodity.unit != null && commodity.unit.length > 0">per {{commodity.unit}}</span></span>
            <span ng-if="!commodity.price">Price not specified</span>
          </span>
          <span ng-switch-when="RENTAL">
            <span ng-if="commodity.price && commodity.unit">{{commodity.price}} per {{commodity.unit}}</span>
            <span ng-if="!commodity.price || !commodity.unit">Price or unit not specified</span>
          </span>
        </td>
        <td>
          <a href="#/commodity/edit/{{racket.id}}/{{commodity.id}}">Edit</a>
          <a href="javascript:;" ng-click="deleteCommodity(commodity)">Delete</a>
        </td>
      </tr>
    </tbody>
  </table>
  
  <h4>New commodity</h4>
  <form class="form-horizontal" data-ng-submit="submitNewCommodity()">
    <div class="form-group">
	    <label class="col-sm-2 control-label" for="newCommodity.name">Name</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="newCommodity.name" data-ng-model="newCommodity.name" />
	    </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label" for="newCommodity.description">Description</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="newCommodity.description" data-ng-model="newCommodity.description" />
      </div>
    </div>
    <div class="form-group">
	    <label class="col-sm-2 control-label" for="newCommodity.type">Type</label>
	    <div class="col-sm-10">
	      <select class="form-control" id="newCommodity.type" data-ng-model="newCommodity.type" ng-options="type as type for type in commodityTypes"></select>
	    </div>
    </div>
    <div class="form-group">
	    <div class="col-sm-10 col-sm-push-2">
	      <button type="submit" class="btn btn-primary">Save</button>
	    </div>
    </div>
  </form>
  
  <hr>
  
  <button class="btn-sm btn-danger" data-ng-click="deleteRacket()">Delete this racket</button>
</div>