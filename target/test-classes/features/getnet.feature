@execucao
Feature: Criar POST Professional
	Eu como usuario quero validar os dados obrigatorios enviados na criação do usuário

	@cenarioDadosValidos
	Scenario Outline: Validar criacao de usuario com todos os dados validos
		Given enviar os dados obrigatorio "<nome>" e "<job>"
		Then valido o status code <status>
		Then valido o primeiro nome "<nome>" e "<job>"

		Examples:
			| nome       | job        | status |
			| Rafa Quea  | Testando   | 201    |

	@cenarioDadosInvalidos
	Scenario Outline: Validar tentativa de criação de usuário enviando o campo nome em branco
		Given enviar os dados obrigatorio "<nome>" e "<job>"
		Then valido o status code <status>
		Then valido o primeiro nome "<nome>" e "<job>"

		Examples:
			| nome | job       | status |
			|      | Testando  | 400    |

	@cenarioDadosInvalidos
	Scenario Outline: Validar tentativa de criação de usuário enviando o campo nome em invalido
		Given enviar os dados obrigatorio "<nome>" e "<job>"
		Then valido o status code <status>
		Then valido o primeiro nome "<nome>" e "<job>"

		Examples:
			| nome 	| job       | status |
			| R@$@  | Testando  | 400    |

	@cenarioDadosInvalidos
	Scenario Outline: Validar tentativa de criação de usuário enviando o campo job em branco
		Given enviar os dados obrigatorio "<nome>" e "<job>"
		Then valido o status code <status>
		Then valido o primeiro nome "<nome>" e "<job>"

		Examples:
			| nome 			 | job        | status |
			| Rafa Teste     | 			  | 400    |

	@cenarioDadosInvalidos
	Scenario Outline: Validar tentativa de criação de usuário enviando o campo job invalido
		Given enviar os dados obrigatorio "<nome>" e "<job>"
		Then valido o status code <status>
		Then valido o primeiro nome "<nome>" e "<job>"

		Examples:
			| nome 			 | job      		  | status |
			| Rafa Teste     | 15@!Rafa			  | 400    |
