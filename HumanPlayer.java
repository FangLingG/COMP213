/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 * A human player extends the Player clss
 * @author Ling
 */
public class HumanPlayer extends Computer {
    
    public HumanPlayer(String name) {
        super(name);
    }
        
    
    /* （not Javadoc）
     * @see Computer#Compare(Player, int)
     */
    @Override
	public boolean Compare(Player player, int i) throws IOException {
            return this.Deck.peek().getAttValue(i) >= 
            		player.Deck.peek().getAttValue(i);        
    }
}
