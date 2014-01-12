controller: {{name}}

<div>
  <div>racket id: {{racket.id}}</div>
  <div>racket name: {{racket.name}}</div>
  <div>description: {{racket.description}}</div>
  
  <h4>Commodities:</h4>
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
        <th>Details</th>
      </tr>
    </thead>
    <tbody>
      <tr data-ng-repeat="commodity in racket.commodities">
        <td>{{commodity.id}}</td>
        <td>{{commodity.name}}</td>
        <td>{{commodity.description}}</td>
        <td>{{commodity.type}}</td>
        <td ng-switch on="commodity.type">
          <span ng-switch-when="RETAIL">It's retail</span>
          <span ng-switch-when="RENTAL">It's rental</span>
        </td>
      </tr>
    </tbody>
  </table>
  
</div>