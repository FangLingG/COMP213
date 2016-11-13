/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * a smart computer always pick 
 * the biggest attribute value
 * @author Ling
 */
public class Computer extends Player {

    private List<Integer> value;
    static int position;

    /**
     *
     * @param name
     */
    public Computer(String name) {
        super(name);
    }

    /**
     *
     * @return
     */
    public int smartComp() {
        value = new ArrayList<Integer>();
        int max = 0;
        for (int count = 0; count < 4; count++) {
            value.add(this.Deck.peek().getAttValue(count));
            max = Collections.max(value);
        }
        position = value.indexOf(max);
        return max;
    }

    /**
     *
     * @param player
     * @return
     * @throws java.io.IOException
     */
    @Override
	public boolean Compare(Player player, int i) throws IOException {
        return smartComp() >= player.getAttributeValue(position);
    }

}

/**
 * a predictable computer always pick 
 * the 1st attribute from a card
 * @author Ling
 */    

class PredictableComputer extends Computer {

    
    public PredictableComputer(String name) {
        super(name);
    }

    @Override
    public boolean Compare(Player player, int i) throws IOException{
        position = 0;
        return getAttributeValue(0) >= player.getAttributeValue(0);
    }

}

/**
 * a random computer pick attribute
 * from a card, randomly
 * @author Ling
 */


 class RandomComputer extends Computer {

    public RandomComputer(String name) {
        super(name);
    }

    /* （not Javadoc）
     * @see Computer#Compare(Player, int)
     */
    @Override
    public boolean Compare(Player player, int i) {
        
        int randomSelect = random.nextInt(4);
        position = randomSelect;
        return this.Deck.peek().getAttValue(randomSelect)
                >= player.Deck.peek().getAttValue(randomSelect);
    }

}