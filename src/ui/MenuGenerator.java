/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import model.HangMan;
import java.util.Scanner;

/**
 *
 * @author ignacio.campinofernandez
 */
public class MenuGenerator {

    Scanner scan = new Scanner(System.in);
    private HangMan hangMan;

    private String showInitMenu() throws GenerateWordException{
        Scanner scan = new Scanner(System.in);
        WordGenerator generator = null;
        int number;
        
        System.out.println("1-Generar palabra aleatoriamente");
        number = scan.nextInt();
       
        switch (number) {
            case 1:
                generator = new ArrayWordGenerator();
                break;
            default:
                generator = new KeyboardWordGenerator();
        }
        
        String word = generator.generateWord();
        return word;
    }

    private void showGameMenu() {
        while (!hangMan.isGameOver()) {
            if (!hangMan.getFails().isEmpty()) {
                System.out.println("Fallos: " + hangMan.getStringFails());
            }
            System.out.println("Introduzca un caracter para adiviñar da seguinte palabra: " + hangMan.showHiddenWord());
            hangMan.tryChar(scan.nextLine().charAt(0));
        }
        if (hangMan.maxFailsExceeded()) {
            System.out.println("GAME OVER!!!");
            System.out.println("A palabra era... " + hangMan.showFullWord());

        } else {
            System.out.println("Acertaste a palabra era..." + hangMan.showFullWord());
        }
    }

    private boolean showExitMenu() {
        System.out.println("Quere xogar outra partida...(s/n): ");
        if (scan.nextLine().charAt(0) == 's') {
            return false;
        }
        return true;
    }

   /* public static void main(String[] args) {
        MenuGenerator menuGenerator = new MenuGenerator();
        GenerateWordException gn = new GenerateWordException(true, "");
        do {
            try {
                 menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            } catch (Exception GenerateWordException) {
                if (gn.isVisible()) {
                    System.err.println(GenerateWordException.getMessage());
                    
                }
            }
           
            menuGenerator.showGameMenu();
        } while (!menuGenerator.showExitMenu());

    }*/

}
