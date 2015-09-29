/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author Cristian Michel
 */
public class Rules {
    public static String ruleGlobal;
    
    public Rules() throws IOException{
        ruleGlobal = getText("0.dat");
        makeRules();
        filterRules();
    }
    public Stack<String> rules= new Stack<String>();
    public static Stack<Rule> rulesFilter= new Stack<Rule>();
    
    public String getText(String archivo) throws FileNotFoundException, IOException {
        int counter = 0;
        String cadena="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
      //  System.out.println(b.readLine());
        cadena = b.readLine();
        cadena = b.readLine();

        b.close();
    
    return cadena;
    }
    public void makeRules() throws IOException{
   // String stringfile = getText("0.dat");
         String tmprule= "";
       for(int i =0;i<ruleGlobal.length();i++){
        
       if(ruleGlobal.charAt(i) == ','){rules.add(tmprule); tmprule="";}
       else tmprule+=ruleGlobal.charAt(i);
       
       }
   // rules.add("Batter|Catcher|1|0|");
    
    }
     public void filterRules()
     {
     Object [] info = {null,null,null};
     for(String s: rules)
     {
   String str = s;
String[] part = str.split("(?<=\\D)(?=\\d)");
String p="",b=""; 
/* Iterate the string of numbers for separate the player and the base , afther that I create an object Rule and parse the datas*/
for(int j = 0;j<part[1].length();j++)
{
if(j == part[1].length() - 1)
{
b+=part[1].charAt(j);
}
else
{
p+=part[1].charAt(j);
}
}
rulesFilter.add(new Rule(p,part[0],Integer.parseInt(b)));
     }
     }
    public String getRule()
    {
    if(rules.isEmpty()) return "";
    else return rules.pop();
    
    }
} 