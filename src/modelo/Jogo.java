package modelo;

import java.util.Random;
import javax.swing.JOptionPane;

public class Jogo {
   
    private int vezPlayer; //0,1
    private Player jogadores[];

    public Jogo(Player[] jogadores){
        this.jogadores = jogadores;
        //sorteia jogador
        Random gerador = new Random();
        this.vezPlayer = gerador.nextInt(2);
        
    }
    //void - não retorna nada
    
    //sem set do vezPlayer
    public void trocaVez(){
        
        //this.vezPlayer = (vezPlayer == 0) ? 1:0;
        
        if(this.vezPlayer == 0){
            this.vezPlayer = 1;
        }else{
            this.vezPlayer = 0;
        }
    }
    
    public int getVez(){
        return this.vezPlayer;
    }
    
    //quem joga agora
    public Player getJogadorVez(){
        return jogadores[this.vezPlayer];
    }
    
}
