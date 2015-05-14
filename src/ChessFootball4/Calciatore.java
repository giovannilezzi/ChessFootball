package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author Utente
 */
public class Calciatore {
   
    private String nome;
    private Casella Posizione;
    private boolean Palla;//Il giocatore tiene la palla?
    private int NumMaglia;
    
    /**
     * 
     * 
     * 
     * @param name
     * @param num Numero di maglia
     */
    public Calciatore (String name, int num)
    {
        
        this.nome=name;
        this.NumMaglia=num;
        this.Posizione=null;
        this.Palla=false;
    }
    /**
     * 
     * @return Il nome del Calciatore
     */
    public String getNome()
    {
        return this.nome;
    }
    /**
     * 
     * @return La posizione nel campo è un tipo casella
     */
    public Casella getPosizione ()
    {
        return this.Posizione;
    }
  
    /**
     * 
     * @return  il numero di maglia
     */
    public int getNumMaglia()
    {
        return this.NumMaglia;
    }
  
    /**
     * 
     * @return Controlla se il giocatore ha la palla
     */
    public boolean HasPalla()
    {
        return this.Palla;
    }
    /**
     * 
     * @param c casella
     */
    public void setPosizione (Casella c)
    {
        this.Posizione=c;
    }
   /**
    * 
    * @param x nuova coordinata x
    * @param y nuova coordinata y
    */
    public void Muovi (int x,int y) 
    {
        this.getPosizione().setX(x);
        this.getPosizione().setY(y);
    }
    /**
     * Passa la palla a un compagno che si trovi a non più di 3 caselle di distanza
     * @param c casella in cui si trova il compagno
     */
    public void Passa(Calciatore c)
    {
        this.setPalla(false);
        c.setPalla(true);
    }
    /**
     * 
     * @param bool Imposta il possesso della palla da parte di un calciatore
     */
    public void setPalla(boolean bool)
    {
        this.Palla=bool;
    }
    /**
     * Se un calciatore si trova nell' area avversaria può effettuare il tiro. C'è un Random che stabilisce se
     * si è segnato un gol. Il giocatore in ogni caso perde il possesso del pallone
     * @return esito del tiro
     */
    public boolean Tira ()
    {
        boolean gol=false;
        Random generatore=new Random();
        if(this.HasPalla())
            gol=generatore.nextBoolean();
        this.setPalla(false);
        return gol;
        
    }
                
                
        
                
        
        
        
            
        
                }

                    
       
                
                   
           
    
            

