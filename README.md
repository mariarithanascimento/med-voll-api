# Voll Med API

Med Voll API é uma API REST criada com base na **arquitetura MVC(model, view e controller)**.

Nela o usuário pode monitorar o cadastro de médicos, pacientes e realizar o agendamento de consultas.

O aplicativo possui algumas opções, em que a pessoa que o utiliza pode fazer o CRUD, tanto de médicos quanto de pacientes e realizar o agendamento e cancelamento das consultas.

## **Tecnologias utilizadas**

- Spring Boot 3
- Java 17
- Lombok
- MySQL/Flyway
- JPA/Hibernate
- Maven
- Postman
- JUnit
- Mockito


## Configuração

1. Primeiramente, clone a aplicação em sua máquina

1.1 Abra o Git Bash > Execute o comando:

```bash
git clone https://github.com/mariarithanascimento/med-voll-api.git
```

1.2 No diretório onde realizou a clonagem, abra a aplicação na IDE de sua preferência. No meu caso, usarei o Intellij (Versão 2023.1.4)

![open](https://github.com/mariarithanascimento/med-voll-api/assets/98103720/478cd896-b18c-406b-94e1-92319fd9d902)

1. Lembrando que toda vez que executamos um projeto Maven, é necessário o download das dependências configuradas. 

2.1 Geralmente as IDEAs já realizam o download assim que abre o projeto, porém pode ocorrer de não abrir. Para conferir: (Ícone Maven > api > Dependencies). Os grifados em azul, são as dependências do projeto.

![dependencias](https://github.com/mariarithanascimento/med-voll-api/assets/98103720/9412611e-7883-49ed-ae95-66642174d92e)


3. Execução do projeto e testes

3.1 Download das collections:

[Medicos.postman_collection.json](..%2F..%2FUsers%2Fmaria%2FDownloads%2FMedicos.postman_collection.json)

[Pacientes.postman_collection.json](..%2F..%2FUsers%2Fmaria%2FDownloads%2FPacientes.postman_collection.json)

Após executar o programa, pode realizar os testes / requisições pelo Postman ou pela aplicação que preferir 😊


## Protótipo

![Untitled](https://github.com/mariarithanascimento/med-voll-api/assets/98103720/1d8902b8-f3bf-4602-a435-b2704ead6483)

