package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Utente
 */
public class UtenteAuto extends Utente {
    
    /**
     * Viene richiamato il costruttore di Utente
     * @param nomutente
     * @param nomsq 
     */
    public UtenteAuto (String nomutente, String nomsq, int c)
    {
        super(nomutente, nomsq, c);
        
        
    }
    /**
     * 
     * @param o
     * @return se ritorna 1 la squadra ha segnato
     */
   
    public int Mossa (Squadra o)
    {
        int golfatto=0;
        boolean possessopalla=false;
        Calciatore tienepalla=null;
        for(int i=1; i<6;i++)
        { //Controllo se un mio giocatore ha la palla e qual' è
            if(this.PropriaSquadra.getCalciatore(i).HasPalla())
            {
                possessopalla=true;
                tienepalla=this.PropriaSquadra.getCalciatore(i);
            }
        }
        if(this.CodTurn==0)
        {  // sono casi diversi a seconda che questa mossa la compia il giocatore A o il giocatore B
            boolean inareaB=false;
            if(possessopalla)
            {//Situazioni con possesso palla
               if((tienepalla.getPosizione().GetX()>12) && ((tienepalla.getPosizione().GetY()>1)&&(tienepalla.getPosizione().GetY()<8)))
               {
                   inareaB=true;//Sarà true quando il giocatore si trova dentro l' area avversaria                   
               }
             if(inareaB)
             {
                 if(tienepalla.Tira())
                 {
                   this.SetGol();
                   golfatto=1;
                 }
                 else
                 {
                     o.getCalciatore(1).setPalla(true);//Se tiro fuori do la palla agli avversari
                 }
             }
             else
             {
                 int icsnow=tienepalla.getPosizione().GetX();//Mi salvo le coordinate del possessore palla
                 int ypsilonnow=tienepalla.getPosizione().GetY();
                 boolean trovatocom=false;//Cerco compagno di squadra abbastanza vicino
                 boolean passaggiofatto=false;
                 
                     for(int i=5;(i>0 && !trovatocom) ; i--) //I miei compagni di squadra         
                     {
                         if (tienepalla!=this.PropriaSquadra.getCalciatore(i))//Non mi passo la palla da solo
                         {
                         if(tienepalla.getPosizione().VicinaPerPassare(this.getSquadra().getCalciatore(i).getPosizione()))
                         {
                             if (tienepalla.getPosizione().GetX()<this.PropriaSquadra.getCalciatore(i).getPosizione().GetX())//Passo la palla solo in avanti
                         {
                             trovatocom=true;
                             tienepalla.Passa(this.PropriaSquadra.getCalciatore(i));
                             passaggiofatto=true;
                         }
                         }
                         }
                     }
                     
                         if(!passaggiofatto)
                         {
                             if (ypsilonnow<2||ypsilonnow>7)//Lo voglio accentrare
                             {
                                 if (ypsilonnow<2)
                                     tienepalla.Muovi(icsnow+1, ypsilonnow+1);
                                 if (ypsilonnow>7)
                                     tienepalla.Muovi(icsnow+1, ypsilonnow-1);
                             }
                             else // si muove solo in avanti
                             tienepalla.Muovi(icsnow+1,ypsilonnow);
                         
                         }
                 }
                 }
            
            if(!possessopalla)
            {//Voglio prima vedere se un mio giocatore si trova vicino ad un avversario con la palla e , in caso, contrstarlo
                Calciatore avv=null;//L' avversario che ha la palla
                int Xavv=0;
                int Yavv=0;
                for (int k=1; k<6; k++)
                {
                    if(o.getCalciatore(k).HasPalla())
                    {
                        avv=o.getCalciatore(k);
                        Xavv=avv.getPosizione().GetX();
                        Yavv=avv.getPosizione().GetY();
                    }
                    
                }
                //Ho salvato l' avversario che ha la palla
                
                Calciatore mio=null;
                boolean trovatoMio = false;
                for (int w=1; w<6&&(!trovatoMio); w++)//Scorro i miei
                {
                    mio=this.getSquadra().getCalciatore(w);
                    if(mio.getPosizione().VicinaPerMuoversi(avv.getPosizione()))//Lo posso contrastare solo se sono vicino
                        trovatoMio=true;
                }
                if(trovatoMio)
                {
                    mio.Muovi(Xavv, Yavv);//Al combio turno scatterà il contrasto
                }
                if(!trovatoMio)
                {
                    //L' unica cosa che mi rimane da fare è far avanzare il mio giocatore più arretrato
                    Calciatore mioDietro=null;
                    int xDietro=16;
                    int yDietro=0;
                    for (int w=1; w<6; w++ )
                    {//2 CAMBIAMENTI DA FARE PER LA SQUADRA B
                        if(this.getSquadra().getCalciatore(w).getPosizione().GetX()<xDietro)//Se sta più dietro di quelli controllati fin ora
                        {
                            mioDietro=this.getSquadra().getCalciatore(w);
                            xDietro=mioDietro.getPosizione().GetX();
                            yDietro=mioDietro.getPosizione().GetY();
                        }
                    }
                    mioDietro.Muovi(xDietro+1, yDietro);
                         
                    
                    
                }
            }
                
        }
        if(this.CodTurn==1)
        {
            // sono casi diversi a seconda che questa mossa la compia il giocatore A o il giocatore B
            boolean inareaA=false;
            if(possessopalla)
            {//Situazioni con possesso palla
               if((tienepalla.getPosizione().GetX()<3) && ((tienepalla.getPosizione().GetY()>1)&&(tienepalla.getPosizione().GetY()<8)))
               {
                   inareaA=true;//Sarà true quando il giocatore si trova dentro l' area avversaria                   
               }
             if(inareaA)
             {
                 if(tienepalla.Tira())
                 {
                   this.SetGol();
                   golfatto=1;
                 }
                 else
                 {
                     o.getCalciatore(1).setPalla(true);//Se tiro fuori do la palla agli avversari
                 }
             }
             else
             {
                 int icsnow=tienepalla.getPosizione().GetX();//Mi salvo le coordinate del possessore palla
                 int ypsilonnow=tienepalla.getPosizione().GetY();
                 boolean trovatocom=false;//Cerco compagno di squadra abbastanza vicino
                 boolean passaggiofatto=false;
                 
                     for(int i=5;(i>0 && !trovatocom) ; i--) //I miei compagni di squadra         
                     {
                         if (tienepalla!=this.PropriaSquadra.getCalciatore(i))//Non mi passo la palla da solo
                         {
                         if(tienepalla.getPosizione().VicinaPerPassare(this.getSquadra().getCalciatore(i).getPosizione()))
                         {
                             if (tienepalla.getPosizione().GetX()>this.PropriaSquadra.getCalciatore(i).getPosizione().GetX())//Passo la palla solo in avanti
                         {
                             trovatocom=true;
                             tienepalla.Passa(this.PropriaSquadra.getCalciatore(i));
                             passaggiofatto=true;
                         }
                         }
                         }
                     }
                     
                         if(!passaggiofatto)
                         {
                             if (ypsilonnow<2||ypsilonnow>7)//Lo voglio accentrare
                             {
                                 if (ypsilonnow<2)
                                     tienepalla.Muovi(icsnow-1, ypsilonnow+1);
                                 if (ypsilonnow>7)
                                     tienepalla.Muovi(icsnow-1, ypsilonnow-1);
                             }
                             else // si muove solo in avanti
                             tienepalla.Muovi(icsnow-1,ypsilonnow);
                         
                         }
                 }
                 }
            
            if(!possessopalla)
            {//Voglio prima vedere se un mio giocatore si trova vicino ad un avversario con la palla e , in caso, contrstarlo
                Calciatore avv=null;//L' avversario che ha la palla
                int Xavv=0;
                int Yavv=0;
                for (int k=1; k<6; k++)
                {
                    if(o.getCalciatore(k).HasPalla())
                    {
                        avv=o.getCalciatore(k);
                        Xavv=avv.getPosizione().GetX();
                        Yavv=avv.getPosizione().GetY();
                    }
                    
                }
                //Ho salvato l' avversario che ha la palla
                
                Calciatore mio=null;
                boolean trovatoMio = false;
                for (int w=1; w<6&&(!trovatoMio); w++)//Scorro i miei
                {
                    mio=this.getSquadra().getCalciatore(w);
                    if(mio.getPosizione().VicinaPerMuoversi(avv.getPosizione()))//Lo posso contrastare solo se sono vicino
                        trovatoMio=true;
                }
                if(trovatoMio)
                {
                    mio.Muovi(Xavv, Yavv);//Al combio turno scatterà il contrasto
                }
                if(!trovatoMio)
                {
                    //L' unica cosa che mi rimane da fare è far avanzare il mio giocatore più arretrato
                    Calciatore mioDietro=null;
                    int xDietro=-1;
                    int yDietro=0;
                    for (int w=1; w<6; w++ )
                    {//2 CAMBIAMENTI DA FARE PER LA SQUADRA B
                        if(this.getSquadra().getCalciatore(w).getPosizione().GetX()>xDietro)//Se sta più dietro di quelli controllati fin ora
                        {
                            mioDietro=this.getSquadra().getCalciatore(w);
                            xDietro=mioDietro.getPosizione().GetX();
                            yDietro=mioDietro.getPosizione().GetY();
                        }
                    }
                    mioDietro.Muovi(xDietro-1, yDietro);
                         
                    
                    
                }
            }
            
               
                      
         
        }
                
          return golfatto;
        
    }
}

