package modelo;

import java.util.Collections;
import java.util.Vector;

public class Player {
   
    private String nome;
    private int placartotal;
    private int palcarparc;
    private Vector<Integer> ult3num;
    private boolean humano;

    public Player(String nome, boolean humano) {
        this.nome = nome;
        this.placartotal = 0;
        this.palcarparc = 0;
        this.ult3num = new Vector<>();
        this.humano = humano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPlacartotal() {
        return placartotal;
    }

    public void setPlacartotal(int placartotal) {
        this.placartotal = placartotal;
    }

    public int getPalcarparc() {
        return palcarparc;
    }

    public void setPalcarparc(int palcarparc) {
        this.palcarparc = palcarparc;
    }
    
    public void addPlcarParc(int numDado){
        this.palcarparc += numDado;
        
        addNumeroSorteado(numDado);
    }
    
    public void guardarParcial(){
        this.placartotal += this.getPalcarparc();
        this.placartotal = 0;
    }
   //verificar se usuario tem 3 num repetidos
    //caso true --> 

    private void addNumeroSorteado(int numDado) {
         this.ult3num.add(numDado);
         //somente os últimos três números
         if(this.ult3num.size() > 3){
             this.ult3num.remove(0);
         }
    }
    //acesso aos últimos três usuários como texto
    public String imprimeUltNumeros(){
        String txtResultado = "";
        
        for(int i = 0; i < this.ult3num.size(); i++){
            txtResultado = txtResultado + this.ult3num.get(i);
            txtResultado = txtResultado + ", ";
        }
        return txtResultado;
       
    }
    
    //se ultimos 3 numeros são iguais
    public boolean verificaUltSorteios(){
      
        int quantIguais = Collections.frequency(ult3num, ult3num.get(0));
        
        if(quantIguais == 3){
            return quantIguais == 3;
        }else{
            return false;
        }
    }

    public boolean isHumano() {
        return humano;
    }
}
