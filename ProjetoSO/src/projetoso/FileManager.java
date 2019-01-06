/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import static java.lang.Math.toIntExact;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */

public class FileManager {
    private int pisos;
    private int carga;
    
    
    public void writeToFile(int piso, int carga){
        
        
    }
    
   public void readFile(String path) {
       JSONParser parser = new JSONParser();
       
       try{
           JSONObject teste = (JSONObject) parser.parse(new FileReader(path));
           
           this.pisos = toIntExact((Long) teste.get("pisos"));
           this.carga = toIntExact((Long) teste.get("carga"));
           
           
       }catch(FileNotFoundException ex){  
           System.out.println("FileNotFound");
       }catch(IOException | ParseException e){
           System.out.println("Exception");
       }
       
       
   }

    public int getPisos() {
        return pisos;
    }

    public int getCarga() {
        return carga;
    }
   
   
    
}
