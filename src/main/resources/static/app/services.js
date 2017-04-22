(function(angular) {
	var TopVisitsByDateFactory = function($resource) {
		return $resource('/topVisits/:date', {
			date : '@date'
		}); 
	};
	
	var TopVisitsByUrlFactory = function($resource) {
		return $resource('/visitByURL?url=:url', {
			url : '@url'
		}); 
	}
	
	TopVisitsByDateFactory.$inject = [ '$resource' ];
	TopVisitsByUrlFactory.$inject = [ '$resource' ];
	angular.module("myApp.services").factory("TopVisitsByDate", TopVisitsByDateFactory);
	angular.module("myApp.services").factory("TopVisitsByUrl", TopVisitsByUrlFactory);
}(angular));