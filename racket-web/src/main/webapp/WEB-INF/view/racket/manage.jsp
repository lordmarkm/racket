controller: {{name}}

<div>
  <div>racket id: {{racket.id}}</div>
  <div>racket name: {{racket.name}}</div>
  <div>description: {{racket.description}}</div>
  
  <button data-ng-click="deleteRacket()">Delete this racket</button>
  
  <h4>Commodities:</h4>
  <table>
    <thead>
    </thead>
    <tbody>
      <tr data-ng-repeat="commodity in racket.commodities">
        <td>{{commodity.name}}</td>
        <td>{{commodity.description}}</td>
      </tr>
    </tbody>
  </table>
  
  <h4>New commodity:</h4>
  <form data-ng-submit="newCommodity()">
    <ul>
      <li>Name: <input data-ng-model="newCommodity.name" /></li>
      <li>Description: <input data-ng-model="newCommodity.description" /></li>
    </ul>
  </form>
</div>