@tag
	
	Feature: Registrarse
	@tag1
	Scenario: Registro usuario
	Given creamos un usuario
	When Comprobar que no existia
	Then lo registramos en la bd
	
	@tag2
	Scenario: Registro usuario repetido
	Given creamos un usuario que este ya en la bd
	When Comprobar que existe
	Then lo registramos en la bd
	
