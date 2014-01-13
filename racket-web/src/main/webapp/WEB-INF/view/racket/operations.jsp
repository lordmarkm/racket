controller: {{name}}

<div>
  <div>racket id: {{racket.id}}</div>
  <div>racket name: {{racket.name}}</div>
  <div>description: {{racket.description}}</div>
  
  <a ng-if="racket.canOperate" href="#/racket/operations/{{racket.id}}">Operations</a>
  <a ng-if="racket.canManage" href="#/racket/manage/{{racket.id}}">Manage</a>
  
  <h4>Commodities:</h4>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
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
          <div ng-switch-when="RETAIL">
            <form class="form-inline" role="form" ng-submit="submitSold()">
              <div class="col-lg-3">
                <span class="input-group">
                  <span class="input-group-btn"><button class="btn btn-sm btn-success">Sell</button></span>
                  <input maxlength="4" class="form-control input-sm" type="text" data-ng-model="sellform.sold" style="width: 50px;"/>
                </span>
              </div>
              <div class="col-lg-3">
                <span class="input-group">
                  <span class="input-group-btn"><button class="btn btn-sm btn-primary">Restock</button></span>
                  <input maxlength="4" class="form-control input-sm" type="text" data-ng-model="restockform.restocked" style="width: 50px;" />
                </span>
              </div>
            </form>
          </div>
          <div ng-switch-when="RENTAL">It's rental</div>
        </td>
      </tr>
    </tbody>
  </table>
  
</div>