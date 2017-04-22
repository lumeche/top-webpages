(function(angular) {
	var ItemFactory = function($resource) {
		return $resource('/topVisits/:date', {
			date : '@date'
		}); // Note the full endpoint address
	}

	ItemFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("Item", ItemFactory);
}(angular));