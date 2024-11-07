# 📚 Gerenciamento de Alunos com MongoDB

Este projeto é uma aplicação Java que interage com uma instância MongoDB para gerenciar dados de alunos. A aplicação permite a inserção de novos alunos, evitando duplicações de RA, e oferece uma listagem completa dos alunos cadastrados. O projeto é ideal para quem deseja aprender como manipular um banco de dados NoSQL com Java e MongoDB.

## ⚙️ Funcionalidades

- **➕ Inserir Novo Aluno**: Permite adicionar um novo aluno ao banco de dados, com informações como RA, nome, sexo e naturalidade.
- **🔍 Verificação de Duplicidade de RA**: Antes de inserir, o sistema verifica se o RA já existe para evitar duplicações.
- **📋 Listagem de Alunos**: Exibe todos os alunos cadastrados com suas informações detalhadas.

## 🛠️ Tecnologias Utilizadas

- **☕ Java**: Linguagem principal do projeto.
- **🍃 MongoDB**: Banco de dados NoSQL usado para armazenar as informações dos alunos.
- **📦 MongoDB Driver for Java**: Biblioteca que permite a interação entre Java e MongoDB.

## 📋 Pré-requisitos

1. **Java 17** ou superior.
2. **MongoDB** instalado e rodando localmente na porta padrão (27017).
