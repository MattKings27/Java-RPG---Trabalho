package Inimigos;
import Hero.Personagem;

import java.util.Random;


public class Goblin extends Inimigo {

    public Goblin(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("O goblin rosna e espuma pela boca!! Em um golpe frenético o goblin tenta lhe morder com violência!");
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > personagem.getDefesa()) {
            System.out.println("a mordida passa sua defesa! Você sente os dentes como agulhas do goblin perfurar sua pele!");
            personagem.receberDano(8*2);
        } else {
            System.out.println("O ataque especial da criatura falhou! você tem mais uma chance de vencer!");
        }
    }


    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " o Goblin se esgueira e ataca covardemente!");
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