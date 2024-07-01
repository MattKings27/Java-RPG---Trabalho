package Hero.Classes;

import Hero.Personagem;

public class Arqueiro extends Personagem {
    private int disparoRapido = 1;

    public Arqueiro(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String classe) {
        super(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma, classe);

        this.setDestreza(getDestreza()+1);
        this.setForca(getForca()+1);

    }

    public int getDisparoRapido() {
        return disparoRapido;
    }

    public void setDisparoRapido(int disparoRapido) {
        this.disparoRapido = disparoRapido;
    }

    public void usarDisparoRapido() {
        this.disparoRapido--;
    }

}
