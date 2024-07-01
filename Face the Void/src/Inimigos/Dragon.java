package Inimigos;

import Hero.Personagem;

import java.util.Random;

public class Dragon extends Inimigo {
    public Dragon(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("Cryovain ruge para os céus!! Tudo estremesse, você sente seus ossos trincarem e de repente um Iceberg cai do céu sobre você!");
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > personagem.getDefesa()) {
            personagem.receberDano(20 * 2);
            personagem.setAtordoado(true);
        } else {
            System.out.println("O ataque especial da criatura falhou! você tem mais uma chance de vencer!");
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " o Dragão ergue suas garras e ataca! Causando um forte tremor de terra!");
        super.atacar(alvo);
    }

    @Override
    public String getTipo(){
        return "Gelo";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }
}