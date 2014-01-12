<h4>Edit {{commodity.name}}</h4>
<ul>
  <li>Controller: {{name}}
  <li>Name: {{commodity.name}}
  <li>Desc: {{commodity.description}}
  <li>Type: {{commodity.type}}
</ul>

<form ng-submit="submitEditCommodity()">
  <ul>
    <li>Name: <input type="text" value="{{commodity.name}}" ng-data-model="editCommodity.name" />
    <li>Description: <input type="text" value="{{commodity.description}}" ng-data-model="editCommodity.description" />
    <li>Price: <input type="text" value="{{commodity.price}}" ng-data-model="editCommodity.price" />
    <li>Unit: <input type="text" value="{{commodity.unit}}" ng-data-model="editCommodity.unit" />
    <li><input type="submit" />
  </ul>
</form>