/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ignacio.campinofernandez
 */
public class HiddenWord {

    private char[] characters;
    private boolean[] hits;

    public HiddenWord(String HiddenWord) {
        this.characters = HiddenWord.toCharArray();
        hits = new boolean[characters.length];
        for (int i = 0; i < characters.length; i++) {
            hits[i] = false;
        }

    }

    public char[] getCharacters() {
        return characters;
    }

    public void setCharacters(char[] characters) {
        this.characters = characters;
    }

    public boolean[] getHits() {
        return hits;
    }

    public void setHits(boolean[] hits) {
        this.hits = hits;
    }

    public boolean checkChar(char c) {
        boolean isCharHere = false;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == c) {
                hits[i] = true;
                isCharHere = true;
            }
        }
        return isCharHere;

    }

    public String show() {
        String word = "";
        for (int i = 0; i < characters.length; i++) {
            if (hits[i]) {
                word += characters[i];
            } else {
                word+= "-";
            }
        }
        return word;
    }

    public String showFullWord() {
        String word = "";
        for (int i = 0; i < characters.length; i++) {
            word += characters[i];
        }
        return word;
    }

    public boolean isVisible() {
        int isVisible = 0;
        for (int i = 0; i < characters.length; i++) {
            if (hits[i]) {
                isVisible++;
            }
        }
        if (isVisible == characters.length) {
            return true;
        } else {

            return false;
        }
    }
}
