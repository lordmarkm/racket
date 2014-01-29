<h4>Edit {{commodity.name}}</h4>
<ul>
  <li>Controller: {{name}}
  <li>Name: {{commodity.name}}
  <li>Desc: {{commodity.description}}
  <li>Type: {{commodity.type}}
  <li>Price: {{commodity.price}}
  <li>Unit: {{commodity.unit}}
  <li ng-if="commodity.type == 'RENTAL'">
    Rental Details
    <ul>
	    <li>Charging method: {{commodity.chargingMethod}}
	    <li ng-if="commodity.chargingMethod == 'PER_MINUTE'">
	      Price per minute: {{commodity.pricePerMinute}}
	    </li>
      <li ng-if="commodity.chargingMethod == 'PER_MINUTE'">
        Roundup: {{commodity.roundUp}}
      </li>
    </ul>
  </li>
</ul>

<form class="form-horizontal" ng-submit="submitEditCommodity()">
  <div class="form-group">
    <label class="col-sm-2 control-label" for="editCommodity.name">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="editCommodity.name" data-ng-model="editCommodity.name" />
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label" for="editCommodity.description">Description</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="editCommodity.description" data-ng-model="editCommodity.description" />
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label" for="editCommodity.description">Price</label>
    <div class="col-sm-10">
      <div class="input-group">
	      <span class="input-group-addon">Php</span>
	      <input type="text" class="form-control" id="editCommodity.price" data-ng-model="editCommodity.price" />
      </div>
      <p class="help-block">
        This price is used to compute for retail, per-rental charged rentals, or services. For per-minute charged rentals,
        it will be displayed but the actual price is computed using the Price per Minute field
      </p>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label" for="editCommodity.description">Unit</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="editCommodity.unit" data-ng-model="editCommodity.unit" />
      <p class="help-block">
	      For display only
	    </p>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label" for="editCommodity.type">Type</label>
    <div class="col-sm-10">
      <select class="form-control" id="editCommodity.type" data-ng-model="editCommodity.type" ng-options="type as type for type in commodityTypes"></select>
    </div>
  </div>
  <div ng-switch on="editCommodity.type">
    <div ng-switch-when="RENTAL">
      <h3>Rental details</h3>
      <div class="form-group">
		    <label class="col-sm-2 control-label" for="editCommodity.chargingMethod">Charging Method</label>
		    <div class="col-sm-10">
		      <select class="form-control" id="editCommodity.chargingMethod" data-ng-model="editCommodity.chargingMethod">
		        <option value="PER_RENTAL">Per Rental</option>
		        <option value="PER_MINUTE">Per Minute</option>
		      </select>
		    </div>
      </div>
      <div ng-if="editCommodity.chargingMethod == 'PER_MINUTE'">
	      <div class="form-group">
	        <label class="col-sm-2 control-label" for="editCommodity.pricePerMinute">Price per minute</label>
	        <div class="col-sm-10">
	          <input type="text" class="form-control" id="editCommodity.pricePerMinute" data-ng-model="editCommodity.pricePerMinute" />
	        </div>
	      </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="editCommodity.roundUp">Round up</label>
          <div class="col-sm-10">
            <select class="form-control" id="editCommodity.roundUp" data-ng-model="editCommodity.roundUp" ng-options="roundUp as roundUp for roundUp in roundUpTypes"></select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="editCommodity.minimumCharge">Minimum charge</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="editCommodity.minimumCharge" data-ng-model="editCommodity.minimumCharge" />
          </div>
        </div>
      </div>
    </div>
    <div ng-switch-when="RETAIL">
    </div>
    <div ng-switch-default>
      Unhandled commodity type: {{editCommodity.type}}
    </div>
  </div>
</form>
<div class="col-sm-10 col-sm-push-2">
  <button ng-click="submitEditCommodity()" class="btn btn-primary">Save</button>
  <button ng-click="done()" class="btn btn-success">Done</button>
</div>

<h1>Images</h1>
{{commodity.images}}

<div ng-repeat="image in commodity.images">
  Yolo<img src="{{image.url}}s.jpg" />
</div>

<form ng-submit="addImage()">
  Url: <input type="text" ng-model="newImage.url"/><br/>
  Desc: <input type="text" ng-model="newImage.description"/>
  <input type="submit" />
</form>