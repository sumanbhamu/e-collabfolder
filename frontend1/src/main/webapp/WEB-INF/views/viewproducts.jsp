<%@include file="header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);

	function MyController($scope, $http) {
		$scope.sortType = 'name'; // set the default sort type
		$scope.sortReverse = false; // set the default sort order
		$scope.searchPTitle = '';

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'GsonCon'
			}).success(function(data, status, headers, config) {
				$scope.prod = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		};
	};
</script>
<style>
/*  Add a gray background color and some padding to the footer 
  */
footer {
	background-color: #f2f2f2;
	padding: 20px;
}

img {
	width: 200px;
	height: 100px;
}

.panel-footer {
	background-color: #111;
	color: white;
	font-size: 10px;
}
</style>

</head>
<body background="resources/images/blue.jpg">

	<div class="container" ng-app="myApp" ng-controller="MyController"
		ng-init="getDataFromServer()">

		<form>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-search"></i>
					</div>
					<input type="text" class="form-control"
						placeholder="Search Product Name" ng-model="searchPTitle">
				</div>
			</div>
			<!-- table heading -->
		</form>
		<table class="table table-hover" style="min-width: 1200px">
			<thead>
				<tr>
					<td><a href="#"
						ng-click="sortType = 'prod_id'; sortReverse = !sortReverse">
							Product Id <span ng-show="sortType == 'prod_id' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'prod_id' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'prod_name'; sortReverse = !sortReverse">
							Product Name <span
							ng-show="sortType == 'prod_name' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'prod_name' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'quantity'; sortReverse = !sortReverse">
							Quantity <span ng-show="sortType == 'quantity' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'quantity' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'prod_price'; sortReverse = !sortReverse">
							Price <span ng-show="sortType == 'prod_price' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'prod_price' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'more'; sortReverse = !sortReverse">
							Image <span ng-show="sortType == 'more' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'more' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
				</tr>
			</thead>
			<!-- table body showing product list -->
			<tbody>
				<tr
					ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
					<td>{{p1.prod_id}}</td>
					<td>{{p1.prod_name}}</td>
					<td>{{p1.quantity}}</td>
					<td>{{p1.prod_price}}</td>
					<td><img src="resources/images/{{p1.prod_name}}.jpg"
						style="height: 100px; width: 100px"></td>


					<td><a href="viewdetails?id={{p1.prod_id}}">View</a>
				</tr>
			</tbody>

		</table>


	</div>


	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">NEW YEAR DEAL</div>
					<div class="panel-body">
						<img src="resources/images/Accessories.jpg" class="img-rounded"
							alt="Image">
					</div>
					<div class="panel-footer">Buy accessories and get a gift card</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">NEW YEAR DEAL</div>
					<div class="panel-body">
						<img src="resources/images/pic14.jpg" class="img-rounded"
							alt="Image">
					</div>
					<div class="panel-footer">Buy accessories and get a gift card</div>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">NEW YEAR DEAL</div>
					<div class="panel-body">
						<img src="resources/images/pic15.jpg" class="img-rounded"
							alt="Image">
					</div>
					<div class="panel-footer">Buy accessories and get a gift card</div>
				</div>
			</div>
		</div>
	</div>
	<br>

	<footer class="container-fluid text-center">
		<p>Fashion Store Copyright</p>

	</footer>