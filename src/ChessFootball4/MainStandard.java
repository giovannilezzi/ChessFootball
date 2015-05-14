package ChessFootball4;


import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utente
 */
public class MainStandard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        Utente plA;
        Utente plB;
        System.out.print("INSERIRE NOME GIOCATORE A ");
        String nompla=in.next();
        System.out.print("INSERIRE NOME SQUADRA A ");
        String nomsqa=in.next();
        System.out.print(nompla+ " è automatico? (si/no) ");
        if ("si".equals(in.next()))
            plA=new UtenteAuto (nompla,nomsqa,0);
        else
            plA=new UtenteReale (nompla,nomsqa,0);
        
        System.out.print("INSERIRE NOME GIOCATORE B ");
        String nomplb=in.next();
        System.out.print("INSERIRE NOME SQUADRA B ");
        String nomsqb=in.next();
        System.out.print(nomplb+ " è automatico? (si/no) ");
        if ("si".equals(in.next()))
            plB=new UtenteAuto (nomplb,nomsqb,1);
        else
            plB=new UtenteReale (nomplb,nomsqb,1);
        
                
        Partita p=new Partita(plA,plB);
        boolean faimossa=true;
        
        String inputmossa;
        int golfattobyA;
        int golfattobyB;
        System.out.println(" ");
        System.out.println("Situazione iniziale:");
        p.ToString();//Situazione iniziale
        System.out.println("Eseguo prima mossa");
        while (faimossa)
        {
            golfattobyA=0;
            golfattobyB=0;
            if(p.getTurno()==0)
                golfattobyA=p.getPlayerA().Mossa(p.getPlayerB().getSquadra());
            if(p.getTurno()==1)
                golfattobyB=p.getPlayerB().Mossa(p.getPlayerA().getSquadra());
            p.changeTurno();
            if (golfattobyA==1)
                p.PallaAlCentro(1);
            if (golfattobyB==1)
                p.PallaAlCentro(0);
            
            p.VerificaContrasti();
            p.ToString();
            System.out.println("Prossima mossa? (si/no)");
            inputmossa=in.next();
            if ("no".equals(inputmossa))
                faimossa=false;
            System.out.println(" ");
            
            
         }
        System.out.println("PARTITA FINITA");
        if(p.getPlayerA().getPunteggio()<p.getPlayerB().getPunteggio())
            System.out.println("HA VINTO "+p.getPlayerB().getNome());
        if(p.getPlayerA().getPunteggio()==p.getPlayerB().getPunteggio())
            System.out.println("AVETE PAREGGIATO");
        if(p.getPlayerA().getPunteggio()>p.getPlayerB().getPunteggio())
            System.out.println("HA VINTO "+p.getPlayerA().getNome());
            
       
}
}
