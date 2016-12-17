
	@tag
Feature: a_login
	@tag1
	Scenario: Test para loging
	Given Definimos el nombre y password
	When Comprobamos login en la bd
	Then Logearse bien
	
	@tag2
	Scenario: Test para loging no existente
	Given Definimos el nombre y password que no existen
	When Comprobamos login en la bd mal
	Then Login repetido