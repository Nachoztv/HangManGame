/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import  java.util.Random;
/**
 *
 * @author ignacio.campinofernandez
 */
public class ArrayWordGenerator implements WordGenerator{
    private static String[] WORDLIST = new String[]{
         "cohete",
        "coche",
        "politico",
        "patatas",
        "obrero",
        "cerveza",
        "eucaristia",
        "delegado",
        "abecedario",
        "canciller",
        "gastrointeritis",
        "gol",
        "hacienda",
        "beligol"
    };

    public static String[] getWORDLIST() {
        return WORDLIST;
    }

    public static void setWORDLIST(String[] WORDLIST) {
        ArrayWordGenerator.WORDLIST = WORDLIST;
    }
    
    @Override
    public String generateWord() throws GenerateWordException{
        Random rand = new Random();
        int longitudMenorArray = rand.nextInt(WORDLIST.length);
        return WORDLIST[longitudMenorArray];
        
    }
    
    
    
    
}
