Procedimento para Instalação

Baixar o arquivo da sua API do GitHub1.
Instalar e configurar o pacote JDK (Java Development Kit) no seu sistema operacional2.
Atualizar as dependências do Gradle3.
Executar a API

Procedimento para Testes.

Ter um aplicativo para fazer testes de endpoits, exemplo postman.
Colocar o endpoint que gostaria de ser testado.
E o metodo HTTP.

Endpoints e JSON para testes:

POST http://localhost:8080/api/registrar

{"nome":"Julio","telefone":"11 947100862","dtNascimento":"16012004","email":"rm93285@fiap.com.br","senha":"teste"}

POST http://localhost:8080/api/login/usuario/documento/{id}

{"idEstrangeiro":"00000000000","cpf":"00000000000","rg":"00000000000"}

POST http://localhost:8080/api/login/usuario/endereco/{id}

{"cep":"teste","logradouro":"teste","bairro":"teste","cidade":"teste","estado":"teste","numero":"teste","complemento":"teste"}

POST http://localhost:8080/api/login

{"email":"rm93285@fiap.com.br","senha":"teste"}

POST http://localhost:8080/api/empresa

{"razaoSocial":"teste","cnpj":"teste","telefone":"teste","email":"teste","senha":"teste"}

POST http://localhost:8080/api/empresa/endereco/{id}
--
{"cep":"teste","logradouro":"teste","bairro":"teste","cidade":"teste","estado":"teste","numero":"teste","complemento":"teste"}

POST http://localhost:8080/api/login/usuario/endereco/{id}

{"nome":"teste","regiaoAtuacao":"Alagoas","privacidade":"privado","descricao":"teste"}

POST http://localhost:8080/api/ong"

{"nome":"teste","regiaoAtuacao":"Alagoas","descricao":"teste"}

------------------------------------
Empresa

GET    - http://localhost:8080/api/empresa
POST   - http://localhost:8080/api/empresa
GET    - http://localhost:8080/api/empresa/{id}
PUT    - http://localhost:8080/api/empresa
DELETE - http://localhost:8080/api/empresa/{id}

------------------------------------
EmpresaEndereco

POST   - http://localhost:8080/api/login/empresa/endereco/{id}
GET    - http://localhost:8080/api/login/empresa/endereco/{id}
PUT    - http://localhost:8080/api/login/empresa/endereco
DELETE - http://localhost:8080/api/login/empresa/endereco/{id}

------------------------------------
ONG

GET    - http://localhost:8080/api/login/ong
POST   - http://localhost:8080/api/login/ong
GET    - http://localhost:8080/api/login/ong/{id}
PUT    - http://localhost:8080/api/login/ong
DELETE - http://localhost:8080/api/login/ong/{id}

------------------------------------
Time

GET    - http://localhost:8080/api/time
POST   - http://localhost:8080/api/time
GET    - http://localhost:8080/api/time/{id}
PUT    - http://localhost:8080/api/time
DELETE - http://localhost:8080/api/time/{id}

------------------------------------
TimeIntegrante

POST   - http://localhost:8080/api/time/integrante
GET    - http://localhost:8080/api/time/integrante/{id}
PUT    - http://localhost:8080/api/time/integrante/{id}
DELETE - http://localhost:8080/api/time/integrante/{id}

------------------------------------
Usuario

GET    - http://localhost:8080/api/login
POST   - http://localhost:8080/api/registrar
POST   - http://localhost:8080/api/login
GET    - http://localhost:8080/api/login/{id}
PUT    - http://localhost:8080/api/login
DELETE - http://localhost:8080/api/login/{id}

------------------------------------
UsuarioDocumento

POST   - http://localhost:8080/api/login/usuario/documento
GET    - http://localhost:8080/api/login/usuario/documento/{id}
PUT    - http://localhost:8080/api/login/usuario/documento/{id}
DELETE - http://localhost:8080/api/login/usuario/documento/{id}

------------------------------------
UsuarioEndereco

POST   - http://localhost:8080/api/login/usuario/endereco
GET    - http://localhost:8080/api/login/usuario/endereco/{id}
PUT    - http://localhost:8080/api/login/usuario/endereco/{id}
DELETE - http://localhost:8080/api/login/usuario/endereco/{id}
