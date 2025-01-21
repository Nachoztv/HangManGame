/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nacho
 */
public class FileWordGenerator implements WordGenerator {
//O metodo lee todas as liñas do ficheiro engadindo as palabras a un ArrayList. Unha vez teñamos o array con todas as palabras, xeraremos un número aleatorio menor que a lonxitude do mesmo e devolveremos a palabra correspondente.
    @Override
    public String generateWord() throws GenerateWordException {
        String word = "";
        BufferedReader in = null;
        BufferedWriter out = null;
        String filePath = "F:\\1CSDAW\\PROGRAMACION\\ProyectoAhorcado-nacho\\FileWordGenerator.txt";
        ArrayList<String> wordStorage = new ArrayList<>();
        try {
            // Abrimos o reader e o writer
            in = new BufferedReader(new FileReader(filePath));
            // Usamos os métodos readLine, write e writeLine para ler e escribir
            // liña a liña
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    wordStorage.add(line);

                }
                Random rand = new Random();
                int number = rand.nextInt(wordStorage.size());
                word = wordStorage.get(number);
            } finally {
                // En calquera caso, producirase ou non unha excepción, pechamos o
                // reader e o writer se están abertos
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }

        } catch (IOException ex) {
            System.out.println("Erro ao xenerar a FileWordGenerator");
        }
        return word;

    }
}
