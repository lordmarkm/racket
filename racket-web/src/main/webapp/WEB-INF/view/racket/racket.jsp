controller: {{name}}

<div>
  <div>racket id: {{racket.id}}</div>
  <div>racket name: {{racket.name}}</div>
  <div>description: {{racket.description}}</div>
  
  <a ng-if="racket.canOperate" href="#/racket/operations/{{racket.id}}">Operations</a>
  <a ng-if="racket.canManage" href="#/racket/manage/{{racket.id}}">Manage</a>
</div>