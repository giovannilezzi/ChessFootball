package ChessFootball4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Utente
 */
public abstract class Utente {
    protected String nome;
    protected Squadra PropriaSquadra;
    protected int Punteggio;
    protected int CodTurn;
    
    /**
     * Crea un nuovo utente. Ci sono anche i parametri che serviranno al costruttore della Squadra
     * @param nomutente
     * @param nomsq
     * @param c 
     */
    public Utente (String nomutente, String nomsq,int c)
    {
        this.nome=nomutente;
        this.Punteggio=0;
        this.CodTurn=c;
        this.PropriaSquadra=new Squadra(nomsq,c);
        
    }
    /**
     * 
     * @return Restituisce la squadra gestita dall' utente 
     */
    public Squadra getSquadra ()
    {
        return this.PropriaSquadra;
    }
    /**
     * 
     * @return Restituisce i gol segnati dalla propria squadra
     */
    public int getPunteggio ()
    {
        return this.Punteggio;
    }
    /**
     * Incrementa di 1 il punteggio
     */
    public void SetGol ()
    {
        this.Punteggio++;
    }
   /**
    * 
    * @param o è la squadra avversaria
    * @return se è stato segnato un gol 1, altrimenti 0
    */
    public abstract int Mossa (Squadra o);
    /**
     * 
     * @param n Nome del Presidente
     */
    public void setNome (String n)
    {
        this.nome=n;
    }
    /**
     * 
     * @return nome dell' utente
     */
    public String getNome()
    {
        return this.nome;
    }
    /**
     * 
     * @param c è il codice turno dell' utente
     */
    public void setCodTurn(int c)
    {
        this.CodTurn=c;
    }

    }