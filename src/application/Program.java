package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = tec.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            // HashSet por ser mais rápido e neste problema específico a ordem dos elementos não importa
            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                // Qualquer LogEntry que for inserido com nome repetido, a própria estrutura do set vai barrar
                set.add(new LogEntry(username, moment));

                line = br.readLine();           
            }
            System.out.println("Total user: " + set.size());


        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        tec.close();
    }
}
