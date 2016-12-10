@tag
Feature: Registrarse
@tag1
Scenario: Registro usuario
Given creamos un usuario
When lo registramos en la bd
Then Comprobar si esta bien

@tag2
Scenario: Registro usuario repetido
Given creamos un usuario que este ya en la bd
When lo registramos en la bd
Then Comprobar que esta repetido
