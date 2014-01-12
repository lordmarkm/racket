<h4>Edit {{commodity.name}}</h4>
<ul>
  <li>Controller: {{name}}
  <li>Name: {{commodity.name}}
  <li>Desc: {{commodity.description}}
  <li>Type: {{commodity.type}}
  <li>Price: {{commodity.price}}
  <li>Unit: {{commodity.unit}}
</ul>

<form ng-submit="submitEditCommodity()">
  <ul>
    <li>Name: <input type="text" data-ng-model="editCommodity.name" />
    <li>Description: <input type="text" data-ng-model="editCommodity.description" />
    <li>Price: <input type="text" data-ng-model="editCommodity.price" />
    <li>Unit: <input type="text" data-ng-model="editCommodity.unit" />
    <li>Type: 
      <select data-ng-model="editCommodity.type" ng-options="type as type for type in commodityTypes">
      </select>
    </li>
    <li><input type="submit" />
  </ul>
</form>