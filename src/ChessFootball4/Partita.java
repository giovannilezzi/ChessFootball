package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Utente
 */
public class Partita {
    private Utente PlayerA;
    private Utente PlayerB;
    private int Mosse;
    
   
    /**
     * Vengono aggregati i due utenti, inoltre si impostano in codice turno e il colore delle divise
     * @param plA Giocatore
     * @param plB Giocatore (può anche essere automatico)
     */
    public Partita (Utente plA, Utente plB)
    {
        
        this.PlayerA=plA;
        //this.PlayerA.setCodTurn(0);
        this.PlayerB=plB;
        //this.PlayerB.setCodTurn(1);
        this.Mosse=0;
        
        //this.PlayerA.getSquadra().setCodiceTurno(0);
        this.PlayerA.getSquadra().setDivisa(Color.RED);//SquadraA divisa rossa
        //this.PlayerB.getSquadra().setCodiceTurno(1);
        this.PlayerB.getSquadra().setDivisa(Color.BLUE);//SquadraB divisa blu
        //piazzo i giocatori
        this.PlayerA.getSquadra().getCalciatore(1).setPosizione(new Casella(3,4));
        this.PlayerA.getSquadra().getCalciatore(2).setPosizione(new Casella(5,8));
        this.PlayerA.getSquadra().getCalciatore(3).setPosizione(new Casella(5,1));
        this.PlayerA.getSquadra().getCalciatore(4).setPosizione(new Casella(4,5));
        this.PlayerA.getSquadra().getCalciatore(5).setPosizione(new Casella(6,4));
        
        this.PlayerB.getSquadra().getCalciatore(1).setPosizione(new Casella(12,5));
        this.PlayerB.getSquadra().getCalciatore(2).setPosizione(new Casella(10,1));
        this.PlayerB.getSquadra().getCalciatore(3).setPosizione(new Casella(10,8));
        this.PlayerB.getSquadra().getCalciatore(4).setPosizione(new Casella(11,4));
        this.PlayerB.getSquadra().getCalciatore(5).setPosizione(new Casella(9,5));
        
        this.PlayerA.getSquadra().getCalciatore(1).setPalla(true);
            
    }
   
    /**
     * viene icrementato il numero totali di mosse
     */
    public void changeTurno()
    {
        this.Mosse++;
    }
    /**
     * Il turno è dato dal resto della divisione del numero delle mosse totali per due. O=turno di A  1=turno di B
     * @return restituisce un int tra 0 e 1; 
     */
    public int getTurno ()
    {
        int turn=this.Mosse%2;
        return turn;
       
    }
    /**
     * 
     * @return Il numero delle mosse totali
     */
    public int getNumMosse ()
    {
        return this.Mosse;
    }
    /**
     * 
     * @return Il giocatore A
     */
    public Utente getPlayerA()
    {
        return this.PlayerA;
    }
    /**
     * 
     * @return Il giocatoreB
     */
    public Utente getPlayerB()
    {
        return this.PlayerB;
    }
    /**
     * Scorre la griglia/campo, ritorna true se in una casella sono presenti due giocatori di squadre diverse e uno dei due ha la palla
     * @return Ci sono contrasti?
     */
     
    public void VerificaContrasti()
    {
        boolean contrasti=false;
        Calciatore scontratoA=this.PlayerA.getSquadra().getCalciatore(1);
        Calciatore scontratoB=this.PlayerB.getSquadra().getCalciatore(1);//In caso andranno modificati
        for (int a=1; (a<6)&&(!contrasti); a++)
            for (int b=1; (b<6)&&(!contrasti); b++)
            {//Se due giocatori di squadre diverse hanno le stesse coordinate
                if ((this.PlayerA.getSquadra().getCalciatore(a).getPosizione().GetX()==this.PlayerB.getSquadra().getCalciatore(b).getPosizione().GetX())&&(this.PlayerA.getSquadra().getCalciatore(a).getPosizione().GetY()==this.PlayerB.getSquadra().getCalciatore(b).getPosizione().GetY()))
                    if(this.PlayerA.getSquadra().getCalciatore(a).HasPalla()||this.PlayerB.getSquadra().getCalciatore(b).HasPalla())
                {
                    contrasti=true;
                    scontratoA=this.PlayerA.getSquadra().getCalciatore(a);
                    scontratoB=this.PlayerB.getSquadra().getCalciatore(b);
                }
                    
            }
        if(contrasti)
        {
            Random generatore= new Random();
            boolean cambio=generatore.nextBoolean();
            if(cambio)
            {
                this.changeTurno();
            }
            int turno=this.getTurno();
            if(turno==0)
            {
                scontratoA.setPalla(true);
                scontratoB.setPalla(false);
            }
            if(turno==1)
            {
                scontratoA.setPalla(false);
                scontratoB.setPalla(true);
            }
                
        }
        
            
    }
    /**
     * 
     * @param c ==0 se devo dare la palla alla squadra A, ==1 se devo dare la palla alla squadra B
     */
    public void PallaAlCentro (int c)
    {
        this.PlayerA.getSquadra().getCalciatore(1).Muovi(3,4);
        this.PlayerA.getSquadra().getCalciatore(2).Muovi(5,8);
        this.PlayerA.getSquadra().getCalciatore(3).Muovi(5,1);
        this.PlayerA.getSquadra().getCalciatore(4).Muovi(4,5);
        this.PlayerA.getSquadra().getCalciatore(5).Muovi(6,4);
        
        this.PlayerB.getSquadra().getCalciatore(1).Muovi(12,5);
        this.PlayerB.getSquadra().getCalciatore(2).Muovi(10,1);
        this.PlayerB.getSquadra().getCalciatore(3).Muovi(10,8);
        this.PlayerB.getSquadra().getCalciatore(4).Muovi(11,4);
        this.PlayerB.getSquadra().getCalciatore(5).Muovi(9,5);
        if(c==0)
        {
            this.PlayerA.getSquadra().getCalciatore(5).setPalla(true);
        }
        if(c==1)
        {
            this.PlayerB.getSquadra().getCalciatore(5).setPalla(true);
        }
        
        
    }
    /**
     * Stampa lo stato della partita
     */
    public void ToString ()
    {
        System.out.println(this.PlayerA.getNome()+" VS "+this.PlayerB.getNome());
        System.out.println("RISULTATO:");
        Integer pa=this.PlayerA.getPunteggio();
        Integer pb=this.PlayerB.getPunteggio();
        System.out.println(this.PlayerA.getSquadra().getNome()+" "+pa.toString()+" : "+pb.toString()+" "+this.PlayerB.getSquadra().getNome());
        Integer nm=this.getNumMosse();
        System.out.println("Sono state compiute "+nm.toString()+" mosse in totale.");
        if (this.getTurno()==0)
            System.out.println("Ora è il turno di: "+this.PlayerA.getNome());
        if (this.getTurno()==1)
            System.out.println("Ora è il turno di: "+this.PlayerB.getNome());
        
        System.out.println("QUESTO E' LO STATO DELLA PARTITA:");
        System.out.println("-GIOCATORI DI "+this.PlayerA.getSquadra().getNome()+":");
        for (int i=1; i<6; i++)
        {
            Integer x=this.PlayerA.getSquadra().getCalciatore(i).getPosizione().GetX();
            Integer y=this.PlayerA.getSquadra().getCalciatore(i).getPosizione().GetY();
            Integer n=this.PlayerA.getSquadra().getCalciatore(i).getNumMaglia();
            System.out.println(n.toString()+" "+this.PlayerA.getSquadra().getCalciatore(i).getNome()+" si trova in ("+x.toString()+";"+y.toString()+")");
            if(this.PlayerA.getSquadra().getCalciatore(i).HasPalla())
                System.out.println(this.PlayerA.getSquadra().getCalciatore(i).getNome()+" HA LA PALLA");
            if(x>12 && (y>1 && y<8))
                System.out.println(this.PlayerA.getSquadra().getCalciatore(i).getNome()+"E' NELL' AREA AVVERSARIA!!!");
        }
         System.out.println("-GIOCATORI DI "+this.PlayerB.getSquadra().getNome()+":");
        for (int i=1; i<6; i++)
        {
            Integer x=this.PlayerB.getSquadra().getCalciatore(i).getPosizione().GetX();
            Integer y=this.PlayerB.getSquadra().getCalciatore(i).getPosizione().GetY();
            Integer n=this.PlayerB.getSquadra().getCalciatore(i).getNumMaglia();
            System.out.println(n.toString()+" "+this.PlayerB.getSquadra().getCalciatore(i).getNome()+" si trova in ("+x.toString()+";"+y.toString()+")");
            if(this.PlayerB.getSquadra().getCalciatore(i).HasPalla())
                System.out.println(this.PlayerB.getSquadra().getCalciatore(i).getNome()+" HA LA PALLA");
            if(x<3 && (y>1 && y<8))
                System.out.println(this.PlayerB.getSquadra().getCalciatore(i).getNome()+"E' NELL' AREA AVVERSARIA!!!");
        }
        System.out.println("------------------------------");
        System.out.println(" ");
    }
    
 
   
}
