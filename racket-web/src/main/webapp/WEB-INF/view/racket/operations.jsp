<#import "./racketnav.ftl" as racketnav />

<div>
  <@racketnav.racketnav 'operations' />
  
  <h4>Commodities</h4>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
        <th>Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr data-ng-repeat="commodity in racket.commodities | orderBy:'name'">
        <td>{{commodity.id}}</td>
        <td>{{commodity.name}}</td>
        <td>{{commodity.description}}</td>
        <td>{{commodity.type}}</td>
        <td ng-switch on="commodity.type">
          <div ng-switch-when="RETAIL">
            In stock: {{commodity.stock}}
          </div>
          <div ng-switch-when="RENTAL">
            <div ng-if="commodity.rentalStart != 0">In use - started: {{formatTime(commodity.rentalStart)}}</div>
            <div ng-if="commodity.rentalStart == 0">Available</div>
          </div>
        </td>
        <td ng-switch on="commodity.type">
          <div ng-switch-when="RETAIL">
            <form class="form-inline" role="form" ng-submit="submitSold()">
              <div class="col-lg-3">
                <span class="input-group">
                  <span class="input-group-btn"><button ng-click="submitSellForm(commodity.id)" class="btn btn-sm btn-success">Sell</button></span>
                  <input maxlength="4" class="form-control input-sm" type="text" data-ng-model="sellforms[commodity.id].sold" style="width: 50px;"/>
                </span>
              </div>
              <div class="col-lg-3">
                <span class="input-group">
                  <span class="input-group-btn"><button ng-click="submitRestockForm(commodity.id)" class="btn btn-sm btn-primary">Restock</button></span>
                  <input maxlength="4" class="form-control input-sm" type="text" data-ng-model="restockforms[commodity.id].restocked" style="width: 50px;" />
                </span>
              </div>
            </form>
          </div>
          <div ng-switch-when="RENTAL">
            <div ng-if="commodity.rentalStart != 0">
              <button ng-click="endRental(commodity.id)" class="btn btn-sm btn-primary">End Rental</button>
            </div>
            <div ng-if="commodity.rentalStart == 0">
              <button ng-click="startRental(commodity.id)" class="btn btn-sm btn-success">Start Rental</button>
            </div>
          </div>
        </td>
      </tr>
    </tbody>
  </table>
  
</div>