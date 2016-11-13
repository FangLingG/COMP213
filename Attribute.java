/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * An attribute with some
 * operation
 * @author Ling
 */
public class Attribute {
 
    private String name;
    private int value;

    public Attribute(String name, int value) {
        this.name = name;
        this.value = value;
    }

  

	/**
     *
     * @return name of attribute
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return value of attribute
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String res;
        res = name + ": ";
        res += value;
        return res;
    }

}
