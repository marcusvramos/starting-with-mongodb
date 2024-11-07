package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

public class Main {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "fipp";
    private static final String COLLECTION_NAME = "aluno";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                int option = showMenu(scanner);
                if (option == 1) {
                    insertStudent(collection, scanner);
                } else if (option == 2) {
                    listStudents(collection);
                } else if (option == 3) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static int showMenu(Scanner scanner) {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Inserir novo aluno");
        System.out.println("2 - Listar todos os alunos");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    private static void insertStudent(MongoCollection<Document> collection, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Informe o RA do aluno: ");
        String ra = scanner.nextLine();

        if (isRaDuplicate(collection, ra)) {
            System.out.println("Aluno com esse RA já existe.");
            return;
        }

        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o sexo do aluno: ");
        String sexo = scanner.nextLine();
        System.out.print("Informe a naturalidade do aluno: ");
        String naturalidade = scanner.nextLine();

        Document doc = new Document("ra", ra)
                .append("nome", nome)
                .append("sexo", sexo)
                .append("naturalidade", naturalidade);

        collection.insertOne(doc);
        System.out.println("Aluno inserido com sucesso.");
    }

    private static boolean isRaDuplicate(MongoCollection<Document> collection, String ra) {
        Document query = new Document("ra", ra);
        return collection.find(query).first() != null;
    }

    private static void listStudents(MongoCollection<Document> collection) {
        System.out.println("Lista de Alunos:");
        for (Document aluno : collection.find()) {
            System.out.println("RA: " + aluno.getString("ra"));
            System.out.println("Nome: " + aluno.getString("nome"));
            System.out.println("Sexo: " + aluno.getString("sexo"));
            System.out.println("Naturalidade: " + aluno.getString("naturalidade"));
            System.out.println("-------------------------");
        }
    }
}
