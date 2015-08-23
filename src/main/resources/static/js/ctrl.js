(function () {
	angular
		.module('ctrl', ['ngMaterial', 'ngRoute', 'ngCookies'])
		.controller('AppCtrl', AppCtrl)
		.controller('ProductCtrl', ProductCtrl)
		.controller('EventCtrl', EventCtrl)
		;
	
	function AppCtrl(
			$scope, $mdSidenav, $log, $location, $cookies) {
		this.name ="AppCtrl";
		
		$scope.toggleSidenav = function(menuId) {
			$mdSidenav(menuId).toggle();
		}
		
		$scope.clearProducts = function() {
			$cookies.remove("products");
			$scope.applyCookies();
		}
		
		$scope.applyCookies = function() {
			if ( !$cookies.get("products") ) {
				$cookies.putObject("products", []);
			}
			$scope.myProducts = $cookies.getObject("products");
		}
		
		$scope.$on("applyCookies", function (event, args) {
			$scope.applyCookies();
		});
		
		$scope.$on("putProduct", function(event, args){
			// TODO put product needs to filter same product
			var contain = $scope.putProduct(args.product);
			
			// We don't need to refresh from cookies if it already exist,
			// and refresh will cancel the ripple animation.
			if (!contain) {
				$scope.applyCookies();
			}
		});
		
		$scope.putProduct = function(product) {
			var products = $cookies.getObject("products");
			
			var contain = false;
			for (var key in products) {
				if (product.id == products[key].id) {
					contain = true;
				}
			}
			
			if (!contain) {
				var clone = {
						id: product.id,
						name: product.name,
						checked: true
				};
				products.push(clone);
				$cookies.putObject("products", products);
			}
			
			return contain;
		}
		
		$scope.gotoUri = function($event, uri) {
			$location.path("/group/" + uri);
		}
		
		$scope.showProduct = function(id) {
			$location.path("/product/" + id);
		}
		
		$scope.analysisDanger = function() {
			$location.path("/event");
		}
		$scope.applyCookies();
	}
	
	function ProductCtrl($rootScope, $scope, $http, $routeParams, $cookies, $log) {
		this.name  = "ProductCtrl";
		var id = $routeParams.id;
		
		$http
			.get("/product/" + id)
			.success(function(data) {
				$scope.product = data;
				$scope.$emit("putProduct", {
					product: data
				});
			})
			.error(function(){
				$scope.error = "Oops";
			})
			;
	}
	
	function EventCtrl($scope, $log, $http) {
		this.name = "AnalysisCtrl";
		
		$http
			.post("/event/analysis", [])
			.success(function(data){
				$scope.events = data;
			})
			;
	}
})();