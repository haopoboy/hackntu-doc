(function () {
	angular
		.module('ctrl', ['ngMaterial', 'ngRoute'])
		.controller('AppController', function(
				$scope, $mdSidenav, $routeParams, $http, $timeout, $q, $sce, $log, $compile){
			$scope.toggleSidenav = function(menuId) {
				$mdSidenav(menuId).toggle();
			};
		});
})();