# Voll Med API

Med Voll API é uma API REST criada com base na **arquitetura MVC(model, view e controller)**.

Nela o usuário pode monitorar o cadastro de médicos, pacientes e realizar o agendamento de consultas.

O aplicativo possui algumas opções, em que a pessoa que o utiliza pode fazer o CRUD, tanto de médicos quanto de pacientes e realizar o agendamento e cancelamento das consultas.

---

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

---

## Configuração

1. Primeiramente, clone a aplicação em sua máquina

1.1 Abra o Git Bash > Execute o comando:

```bash
git clone https://github.com/mariarithanascimento/med-voll-api.git
```

1.2 No diretório onde realizou a clonagem, abra a aplicação na IDE de sua preferência. No meu caso, usarei o Intellij (Versão 2023.1.4)

![Untitled](Voll%20Med%20API%2060c6dfcc348b420d9a9a02e9530fe0a8/Untitled.png)

1. Lembrando que toda vez que executamos um projeto Maven, é necessário o download das dependências configuradas. 

2.1 Geralmente as IDEAs já realizam o download assim que abre o projeto, porém pode ocorrer de não abrir. Para conferir: (Ícone Maven > api > Dependencies). Os grifados em azul, são as dependências do projeto.

![Untitled](Voll%20Med%20API%2060c6dfcc348b420d9a9a02e9530fe0a8/Untitled%201.png)

1. Execução do projeto e testes

3.1 Download das collections:

[Medicos.postman_collection.json](..%2F..%2FUsers%2Fmaria%2FDownloads%2FMedicos.postman_collection.json)
[Pacientes.postman_collection.json](..%2F..%2FUsers%2Fmaria%2FDownloads%2FPacientes.postman_collection.json)

Após executar o programa, pode realizar os testes / requisições pelo Postman ou pela aplicação que preferir 😊

---

## Protótipo

![Untitled](Voll%20Med%20API%2060c6dfcc348b420d9a9a02e9530fe0a8/Untitled%202.png)