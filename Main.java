/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.UnknownHostException;

/**
 * 
 * @author Ling
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     */
   public static void main(String[] args) throws UnknownHostException {
        Game game = new Game();
        game.running();
    }
}
