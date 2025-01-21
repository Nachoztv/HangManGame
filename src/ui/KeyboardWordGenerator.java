/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author ignacio.campinofernandez
 */
public class KeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException{
        String word;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la palabra a adivinar: ");
        if (System.console() == null) {
                 word = scan.nextLine();
        }else{
            word = String.valueOf(System.console().readPassword());
        }
    
        return word;
    }

}
