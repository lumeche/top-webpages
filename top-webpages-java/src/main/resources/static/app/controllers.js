(function(angular) {
  var AppController = function($scope, Item) {
	this.date='2016-02-08'
    Item.query({ date: this.date },function(response) {
      $scope.items = response ? response : [];
    });
    
    this.findVisit = function() {
      console.log("adsfasdfadsf"+this.date)
      Item.query({ date: this.date },function(response){
    	  $scope.items = response ? response : [];
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));