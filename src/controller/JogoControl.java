package controller;

import javax.swing.JOptionPane;
import modelo.Jogo;
import modelo.Player;

public class JogoControl {
    
    private Jogo partidaCorrente;
    
    public JogoControl(Jogo partidaCorrente){
        this.partidaCorrente = partidaCorrente;
    }
    
    public boolean sorteio (int numDado){
        
        Player jogadorAtivo = partidaCorrente.getJogadorVez();
        
        jogadorAtivo.addPlcarParc(numDado);
        
        //regras
        if(jogadorAtivo.verificaUltSorteios()){
            //perde tudo
            jogadorAtivo.setPalcarparc(0);
            jogadorAtivo.setPlacartotal(0);
            partidaCorrente.trocaVez();
            return false;
        }
        
        if(numDado == 1){
            partidaCorrente.trocaVez();
            return false;
        }
        
        
        if(numDado == 6){
            jogadorAtivo.setPalcarparc(0);
            partidaCorrente.trocaVez();
            return false;
        }
        
        return true;
    }

    public boolean guardarPlacar() {
        
        Player jogadorAtivo = partidaCorrente.getJogadorVez();
        
        if(jogadorAtivo.getPalcarparc() > 0){
              jogadorAtivo.guardarParcial();
              
            if(jogadorAtivo.getPlacartotal() >= 20){
                return true;//o jogador venc.
            }
              
            partidaCorrente.trocaVez();
        
        }else{
            JOptionPane.showMessageDialog(null, "Você não possui valor para guardar");
        }
        return false;
    }
}
