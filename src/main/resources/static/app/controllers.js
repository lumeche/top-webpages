(function(angular) {
	var AppController = function($scope, TopVisitsByDate, TopVisitsByUrl) {
		this.date = '2016-02-08';
		this.page = 'www.google.com.au';
		this.shown = 'date';

		TopVisitsByDate.query({
			date : this.date
		}, function(response) {
			console.log('xxxxxxxxxxxx' + this.date)
			$scope.items = response ? response : [];
			this.shown = 'date';
		});

		this.findVisitByDate = function() {
			console.log('yyyyy' + this.date)
			TopVisitsByDate.query({
				date : this.date
			}, function(response) {
				$scope.items = response ? response : [];
			});
			this.shown = 'date';
		};

		this.findVisitByURL = function() {
			console.log('zzzzz' + this.page)
			TopVisitsByUrl.query({
				url : this.page
			}, function(response) {
				$scope.items = response ? response : [];
			});
			this.shown='url';
		};
	};

	AppController.$inject = [ '$scope', 'TopVisitsByDate', 'TopVisitsByUrl' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);
}(angular));