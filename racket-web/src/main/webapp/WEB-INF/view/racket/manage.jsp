controller: {{name}}

<div>
  <div>racket id: {{racket.id}}</div>
  <div>racket name: {{racket.name}}</div>
  <div>description: {{racket.description}}</div>
  
  <a ng-if="racket.canOperate" href="#/racket/operations/{{racket.id}}">Operations</a>
  <a ng-if="racket.canManage" href="#/racket/manage/{{racket.id}}">Manage</a>
  
  <button data-ng-click="deleteRacket()">Delete this racket</button>
  
  <h4>Commodities:</h4>
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
            <span ng-if="commodity.price">{{commodity.price}}</span>
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
  
  <h4>New commodity:</h4>
  <form data-ng-submit="submitNewCommodity()">
    <ul>
      <li>Name: <input data-ng-model="newCommodity.name" /></li>
      <li>Description: <input data-ng-model="newCommodity.description" /></li>
      <li>Type:
        <select data-ng-model="newCommodity.type">
          <option data-ng-repeat="type in commodityTypes">{{type}}</option>
        </select>
      </li>
      <li><input type="submit" /></li>
    </ul>
  </form>
  
</div>