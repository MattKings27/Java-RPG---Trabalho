package Hero.Classes;

import Hero.Personagem;
import Hero.LevelUp;

public class Guerreiro extends Personagem {
    private int gritoDeGuerra = 1;
    private int segundoVento;
    private int doubleStrike;
    private int aimWeakness;

    public Guerreiro(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String classe) {
        super(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma, classe);

        this.setForca(getForca()+1);
        this.setConstituicao(getConstituicao()+1);

    }

    public int getGritoDeGuerra() {
        return gritoDeGuerra;
    }

    public void setGritoDeGuerra(int gritoDeGuerra) {
        this.gritoDeGuerra = gritoDeGuerra;
    }

    public int getSegundoVento() {
        return segundoVento;
    }

    public void setSegundoVento(int segundoVento) {
        this.segundoVento = segundoVento;
    }

    public int getDoubleStrike() {
        return doubleStrike;
    }

    public void setDoubleStrike(int doubleStrike) {
        this.doubleStrike = doubleStrike;
    }

    public int getAimWeakness() {
        return aimWeakness;
    }

    public void setAimWeakness(int aimWeakness) {
        this.aimWeakness = aimWeakness;
    }

    public void usarGritoDeGuerra() {
        if(gritoDeGuerra > 0) {
            System.out.println("Por honra e glória!\n" + this.getNome() + " usou Grito de Guerra!");
            setForca(getForca() + 1);
            setVida(getVida() + 2);
            gritoDeGuerra--;
        } else {
            System.out.println("Habilidade indisponível.. Descanse entre combates para usar novamente");
        }

    }
}
