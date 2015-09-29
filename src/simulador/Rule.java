/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

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
    this.player = p;
    this.escenario = es; 
    this.base = base;
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
