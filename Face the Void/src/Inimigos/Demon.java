package Inimigos;

import Hero.Personagem;

import java.util.Random;

public class Demon extends Inimigo {

    public Demon(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("O demônio voa em sua direção!! com o impacto ele lhe perfura com as garras!");
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > personagem.getDefesa()) {
            personagem.setAtordoado(true);
            System.out.println("A dor é tão grande que você não consegue se mover!");
            personagem.receberDano(12*2);
        } else {
            System.out.println("O ataque especial da criatura falhou! você tem mais uma chance de vencer!");
        }
    }


    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " o Demônio sorri enquanto rasga sua pele com as garras!");
        super.atacar(alvo);
    }

    @Override
    public String getTipo(){
        return "Corruptor";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }
}
