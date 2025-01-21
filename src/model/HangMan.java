/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.HiddenWord;
import java.util.ArrayList;

/**
 *
 * @author ignacio.campinofernandez
 */
public class HangMan {

    private final int MAX_FAILS = 6;

    private HiddenWord hiddenWord;

    private ArrayList<Character> fails;

    
    public HangMan(String hiddenWord) {
        this.hiddenWord = new HiddenWord(hiddenWord);
        this.fails = new ArrayList();
    }

    public ArrayList<Character> getFails() {
        return fails;
    }

    public String getStringFails() {
        String stringFails = "";
        for (int i = 0; i < fails.size(); i++) {
            stringFails += fails.get(i) + "";
        }
        return stringFails;
    }

    public String showHiddenWord() {
        return hiddenWord.show();
    }

    public String showFullWord() {
        return hiddenWord.showFullWord();
    }

    public void tryChar(char c) {
        if (!hiddenWord.checkChar(c)) {
            fails.add(c);
        }
    }

    public boolean isGameOver() {
        if (fails.size() == MAX_FAILS || hiddenWord.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean maxFailsExceeded() {
        if (fails.size() == MAX_FAILS) {
            return true;
        } else {
            return false;
        }
    }
}
