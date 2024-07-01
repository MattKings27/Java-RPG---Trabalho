package Hero.Classes;

import Hero.Personagem;

public class Mago extends Personagem {
    private int fireBolt = 1;
    private int mana;

    public Mago(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String classe) {
        super(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma, classe);


        this.setInteligencia(getInteligencia()+1);
        this.setDestreza(getDestreza()+1);

        this.mana = 1 + ((getInteligencia()/10));

    }

    public void usarFireBolt(){
        this.mana = -1;
        this.fireBolt =-1;
    }

    public int getFireBolt() {
        return fireBolt;
    }

    public void setFireBolt(int fireBolt) {
        this.fireBolt = fireBolt;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
