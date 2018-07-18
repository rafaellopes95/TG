(function() {
  var app = angular.module('muralApp', ['ngRoute', 'ngCookies']);

  app.config(function($routeProvider, $locationProvider) {

    $routeProvider
      .when('/home', {
        templateUrl: './templates/home.html',
        controller: 'autenticacao'
      })
    	.when('/login', {
    		templateUrl: './templates/login.html',
        controller: 'LoginController'
    	})
    	.otherwise({ redirectTo: '/home' });

  })
  .controller('autenticacao', function($rootScope, $scope, $cookies, $location) {

    $rootScope.user = $cookies.getObject('user');
    $rootScope.tipoAluno = $cookies.get('tipoAluno');

    if($rootScope.user == null) {
        console.log('Você não está logado!');
        $location.path('/login');
    }
    else {
        console.log($rootScope.user.username + ' está logado');
    }

    $scope.logout = function() {
      $cookies.remove('user');
      $cookies.remove('tipoAluno');      
      $rootScope.isAuthenticated = false;

      console.log('Usuário fez logout');

      $location.path('/login');
    };
  })
})();
