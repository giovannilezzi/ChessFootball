package ChessFootball4;

import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Utente
 */
public class UtenteReale extends Utente {
    /**
     * Viene richiamato il costruttore della classe astratta Utente
     * @param nomutente
     * @param nomsq 
     */
    public UtenteReale (String nomutente, String nomsq, int c)
    {
        super(nomutente, nomsq, c);
    }
    /**
     * 
     * @param o avversaria
     * @return 1== ha segnato
     */
    public int Mossa(Squadra o) 
    {
        int golfatto=0;
        Calciatore selezionato=null;
        int NumSel;
        Scanner in= new Scanner(System.in);
        System.out.println("Tocca a: "+this.nome);
        System.out.println(" ");
        System.out.println("Scegli un tuo calciatore (1/2/3/4/5) ");
        NumSel=in.nextInt();
        selezionato=this.getSquadra().getCalciatore(NumSel);
        System.out.println("Hai selezionato "+selezionato.getNome());
        Integer xattuale=selezionato.getPosizione().GetX();
        Integer yattuale=selezionato.getPosizione().GetY();
        System.out.println("Cosa gli vuoi far fare? ");
        System.out.println("Muovi= m, Tira= t, Passa= p ");
        System.out.println("Ricorda:Puoi tirare solo se sei in area, puoi muoverti di una casella");
        System.out.println("puoi passare a un compagno distante non più di tre caselle");
        String mossa;
        mossa=in.next();
        
        if("m".equals(mossa))
        {
            int newXmove;
            int newYmove;
            System.out.println("Inserire coordinate nuova casella, N.B: deve essere confinante ");
            System.out.print("X= ");
            newXmove=in.nextInt();
            System.out.print("Y= ");
            newYmove=in.nextInt();
            Casella newmove= new Casella(newXmove,newYmove);
            if(selezionato.getPosizione().VicinaPerMuoversi(newmove))
            {
                selezionato.setPosizione(newmove);
                System.out.println("Muovi eseguito");
            }
            else 
                System.out.println("Nuova casella troppo lontana");
                
        }
        
        if("t".equals(mossa))
        {
            boolean inarea=false;
            if(selezionato.HasPalla())
            {
                if(this.CodTurn==0)
                {
                    if((selezionato.getPosizione().GetX()>12) && ((selezionato.getPosizione().GetY()>1)&&(selezionato.getPosizione().GetY()<8)))
                    {
                        inarea=true;
                    }
                }
                if(this.CodTurn==1)
                {
                    if((selezionato.getPosizione().GetX()<3) && ((selezionato.getPosizione().GetY()>1)&&(selezionato.getPosizione().GetY()<8)))
                    {
                        inarea=true;
                    }
                }
                if(inarea)
                {
                
                        if(selezionato.Tira())
                        {
                            System.out.println("GOALLLLLLLLL!!!!!");
                            this.SetGol();
                            golfatto=1;
                        }
                        else
                        {
                            System.out.println("Hai sbagliato il tiro :'(");
                        }
                }
                else
                    {
                        System.out.println("Non sei in area non puoi tirare");
                    }
                        
             }
            else 
            {
                System.out.println("il calciatore selezionato non ha la palla");
            }
                
                
                
            }
        if("p".equals(mossa))
        {
            if(selezionato.HasPalla())
            {
                System.out.print("A quele compagno passare? (1/2/3/4/5) ");
                Calciatore toPass;
                toPass=this.getSquadra().getCalciatore(in.nextInt());
                if(selezionato.getPosizione().VicinaPerPassare(toPass.getPosizione()))
                {
                    selezionato.Passa(toPass);
                    System.out.println("Passaggio eseguito");
                }
                else
                {
                    System.out.println("Compagno troppo lontano ");
                }
            }
            else
            {
                System.out.println("Non può passare se non ha la palla");
            }
        }
        System.out.println(" ");
        return golfatto;
        
              
            
        }
        
        
        
        
    }
    
    

