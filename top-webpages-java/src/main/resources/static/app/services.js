(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/topVisits/2016-02-08', {
      
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);
}(angular));