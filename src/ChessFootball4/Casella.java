package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Utente
 */
public class Casella {
    private int X;
    private int Y;
    
    /**
     * 
     * @param ics Coordinata x della casella nella griglia/campo
     * @param ipsilon  Coordinata y della casella nella giglia/campo
     */
    public Casella (int ics, int ipsilon)
    {
        this.X=ics;
        this.Y=ipsilon;
        
    }
    /**
     * 
     * @return coordinata x
     */
    public int GetX ()
    {
        return this.X;
    }
    /**
     * 
     * @return coordinata y
     */
    public int GetY ()
    {
        return this.Y;
    }
    /**
     * 
     * @param c casella su cui ci si vuole spostare
     * @return controlla se le due caselle non sono troppo lontane.applico il Teorema di Pitagora per calcolare la distanza tra due caselle Esito positivo è dato se le due caselle sono adiacenti (anche in diagonale)
     *
     */
    public boolean VicinaPerMuoversi(Casella c)
    {
        int Xattuale=this.X;
        int Yattuale=this.Y;
        int XToMove=c.X;
        int YToMove=c.Y;
        boolean nextTo=true;
        //Ora applico il Teorema di Pitagora per calcolare la distanza tra due caselle
        //Esito positivo è dato se le due caselle sono adiacenti (anche in diagonale)
        if (((Xattuale-XToMove)*(Xattuale-XToMove))+((Yattuale-YToMove)*(Yattuale-YToMove))>2)
            nextTo=false;
        return nextTo;
    }
    /**
     * 
     * @param c Casella su cui si trova il compagno
     * @return applico il Teorema di Pitagora per calcolare la distanza tra due caselle. Esito positivo è dato se le due caselle hanno al massimo distanza = 3 caselle
     */
    public boolean VicinaPerPassare(Casella c)
    {
        int Xattuale=this.X;
        int Yattuale=this.Y;
        int XToPass=c.X;
        int YToPass=c.Y;
        boolean nextTo=true;
        //Ora applico il Teorema di Pitagora per calcolare la distanza tra due caselle
        //Esito positivo è dato se le due caselle hanno al massimo distanza = 3 caselle
        if (((Xattuale-XToPass)*(Xattuale-XToPass))+((Yattuale-YToPass)*(Yattuale-YToPass))>18)
            nextTo=false;
        return nextTo;
    }
    /**
     * 
     * @param x imposta la x
     */
    public void setX(int x)
    {
        this.X=x;
    }
    /**
     * 
     * @param y imposta la y
     */
    public void setY(int y)
    {
        this.Y=y;
    }
  
   
 

   
   
        
    }
    
    

