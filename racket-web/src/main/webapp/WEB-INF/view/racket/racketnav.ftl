<#macro racketnav activeId>

<h3>{{racket.id}} {{racket.name}}</h3>
<i>{{racket.description}}</i>

<div class="clear" style="margin-top: 20px;"></div>

<ul class="nav nav-tabs">
	<li <#if activeId == 'operations'>class="active"</#if>><a ng-if="racket.canOperate" href="#/racket/operations/{{racket.id}}">Operations</a>
	<li <#if activeId == 'manage'>class="active"</#if>><a ng-if="racket.canManage" href="#/racket/manage/{{racket.id}}">Manage</a>
  <li <#if activeId == 'notifs'>class="active"</#if>><a href="#racket/notifs/{{racket.id}}">Notifs</a>
</ul>

</#macro>