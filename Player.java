/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * A player with a deck, there are operations
 * to shift, remove card from the deck. as well
 * as get other infomation about the deck.
 * @author Ling
 */
public class Player {

    /**
     * necessary variables  
     */
    protected Queue<Card> Deck;
    private final int size = 10;
    private String nameOfPlayer;
    Random random = new Random();

    /**
     * @param name
     */
    Player(String name) {
        Card card;
        Deck = new LinkedList<>();
        for (int i = 0; i < size;) {
            card = new Card();
            Deck.offer(card);
            i++;
        }
        this.nameOfPlayer = name;
    }

    /**
     * shift a card to bottom from top
     */
    public void shiftCard() {
        Deck.offer(Deck.poll());
    }

    /**
     *
     * @return attributes of a card from the top of Deck 
     */
    public String removeCard() {
        return Deck.poll().getAttributes();
    }

    //method for a predictable computer, i.e., one that always chooses the same
    //attribute in every round in which they play first

    /**
     *
     * @param player
     * @param i
     * @return
     * @throws java.io.IOException
     */
    public boolean Compare(Player player, int i)throws IOException {
            return this.Deck.peek().getAttValue(i) >= 
            		player.Deck.peek().getAttValue(i);        
    }

    /**
     *
     * @return size of Deck
     */
    public int getSize() {
        return Deck.size();
    }


    /**
     *
     * @return name of player
     */
    public String getName() {
        return nameOfPlayer;
    }

    /**
     *
     * @return attributes of top card
     */
    public String getAttributes() {
        return this.Deck.peek().getAttributes();
    }

    /**
     *
     * @param i
     * @return
     * @throws java.io.IOException
     */
    public int getAttributeValue(int i) throws IOException{
        return this.Deck.peek().getAttValue(i);
    }
}
