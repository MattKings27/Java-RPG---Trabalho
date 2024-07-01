package Inimigos;
import Hero.Personagem;

import java.util.Random;

public class Orc extends Inimigo {
    private String tipo;

    public Orc(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.tipo = "Humanoide";
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("O orc grita furiosamente!! Sacudindo seu machado em todas as direções!");
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > personagem.getDefesa()) {
        personagem.receberDano(8*2);
    } else {
            System.out.println("O ataque especial da criatura falhou! você tem mais uma chance de vencer!");
        }
}

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " o Orc ataca com ferocidade!");
        super.atacar(alvo);
    }

    @Override
    public String getTipo(){
        return "Humanoide";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }

}