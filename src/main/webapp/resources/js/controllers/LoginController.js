(function() {
	angular.module('muralApp')
		.controller('LoginController', function($rootScope, $scope, $location, $cookies, $http) {
		
			$scope.login = function() {
				console.log('Logando ' + $scope.usuario.username + '/' + $scope.usuario.password);
				      
				$http.post('/login/', $scope.usuario, {
				    headers : {'Content-Type': 'application/json'}
				}).then(function(usuario) {
				        
				    if(usuario == null) {
				        console.log('Erro de autenticacao!');
				        $location.path('/login');
				    }
				    else {
				        $cookies.putObject('user', usuario.data);
				        $rootScope.isAuthenticated = true;

				        $scope.user = $cookies.getObject('user');

				        console.log('Logou: ' + $scope.user.username);

				        //Definindo se eh aluno ou colaborador
				        if($scope.user.aluno == null) {
				            console.log('Tipo: colaborador');
				            $cookies.put('tipoAluno', false);
				        }
				        else {
				        	console.log('Tipo: aluno');
				        	$cookies.put('tipoAluno', true);
				        }

				        //Definindo se eh user ou admin
				        if($scope.user.privilegio == 'ROLE_USER') {
				        	$rootScope.isAdmin = false;
				        }
				        else {
				        	$rootScope.isAdmin = true;
				        }

				        $location.path('/home');
				    }
				}, function(erro) {
				        
				    console.log('Ocorreu um erro no login!');
				})
			}
		});
})();