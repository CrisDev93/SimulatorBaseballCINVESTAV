/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cristian Michel
 */
public class Rule {
    
    public String player; 
    public String escenario;
    public int base;
    
    public Rule(String p,String es,int base)
    {
    
    this.player = Integer.toString(base);
    this.escenario = es;  
    try{
    this.base = Integer.parseInt(p);
    }
    catch(NumberFormatException e)
    {
    this.base = 0;
    }
    }
    
    public String getPlayer()
    {
    return this.player;
    }
    public String getScenario()
    {
    return this.escenario;
    }
    public int getBase()
    {
    return this.base;
    }
    
    
}
