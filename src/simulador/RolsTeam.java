/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.Stack;

/**
 *
 * @author Cristian Michel
 */
public class RolsTeam {
    
    Stack<Agents> in,out;

    public RolsTeam(){
    in = new Stack<Agents>();
    out = new Stack<Agents>();
    }
    
    public void addIn(Agents rol){
    in.add(rol);
    }
    public Agents removeIn(Agents rol){
  
       return in.pop();
      
    }
    
    public void addOut(Agents rol){
    
        out.add(rol);
    
    }

    public Agents removeOut(Agents rol){
    return out.pop();
    }
    
    
    
    
}
