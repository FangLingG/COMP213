/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Random;

/**
 * A card cosists of serveral attributs and values.
 * @author Ling
 */
public class Card {

    private String nameOfAttribute[] = {"Hearts", "Spades", "Diamonds", "Clubs"};
    private Attribute[] attributes = new Attribute[nameOfAttribute.length];
    private Random random = new Random();

    /**
     * constructor
     */
    public Card() {
        for (int i = 0; i < nameOfAttribute.length; i++) {
            attributes[i] = new Attribute(nameOfAttribute[i], random.nextInt(10));
        }
    }

    /**
     *
     * @return attributes of a card
     */
    public String getAttributes() {
        return Arrays.toString(attributes);
    }

    /**
     *
     * @param i
     * @return value of attribute
     */
    public int getAttValue(int i) {
        return attributes[i].getValue();
    }

    /**
     *
     * @param i
     * @return name of attribute
     */
    public String getAttName(int i) {
        return attributes[i].getName();
    }

}
