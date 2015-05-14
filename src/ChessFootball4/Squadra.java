package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import java.util.ArrayList;

/**
 *
 * @author Utente
 */
import java.awt.Color;

public class Squadra {
    private String Nome;
    private int CodiceTurno;
    private Calciatore[] Rosa;
    private Color Divisa;
   
    /**
     * 
     * @param n Nome squadra
     * @param pres L' utente
     * @param cod  Codice che identifica il turno
     */
    public Squadra(String n,int cod){
        this.CodiceTurno=cod;       
        this.Nome=n;
        Rosa = new Calciatore[5];
        if (this.CodiceTurno==0)//Nomi della squadra A
        {
            Rosa[0] = new Calciatore("TOLDO", 1);
            Rosa[1] = new Calciatore("LAVEZZI", 2);
            Rosa[2] = new Calciatore("NEYMAR", 3);
            Rosa[3] = new Calciatore("BAGGIO", 4);
            Rosa[4] = new Calciatore("VIERI", 5);
         }
        if (this.CodiceTurno==1)//Nomi della squadra B
        {
            Rosa[0] = new Calciatore("BUFFON", 1);
            Rosa[1] = new Calciatore("GARRINCHA", 2);
            Rosa[2] = new Calciatore("ROBBEN", 3);
            Rosa[3] = new Calciatore("MARADONA", 4);
            Rosa[4] = new Calciatore("RONALDO", 5);
         }
        
    }
    /**
     * 
     * @param nummaglia serve ad identificare il calciatore
     * @return Calciatore corrispondente al numero
     */
   public Calciatore getCalciatore (int nummaglia)
   {
       Calciatore c=this.Rosa[0];
       if (nummaglia>0 && nummaglia<6)
           c=this.Rosa[nummaglia-1];
       return c;
       
   }
  
   /**
    * 
    * @return Il colore della divisa
    */
   public Color getDivisa ()
   {
       return this.Divisa;
   }
   /**
    * 
    * @param n Imposta il nome della squadra
    */
   public void setNome(String n)
   {
       this.Nome=n;
   }
   /**
    * 
    * @param c Imposta il codice che scandisce i turni
    */
   public void setCodiceTurno(int c)
   {
       this.CodiceTurno=c;
   }
   /**
    * 
    * @param a Imposta il colore della divisa
    */
   public void setDivisa (Color a)
   {
       this.Divisa=a;
   }
   /**
    * 
    * @return Il codice turno della squadra
    */
   public int getCodiceTurno()
   {
       return this.CodiceTurno;
   }
   /**
    * 
    * @return Il nome della squadra
    */
   public String getNome ()
   {
       return this.Nome;
   }

   
    
    
}
