package Inimigos;

import Hero.Personagem;
import java.util.Random;

public class Zumbi extends Inimigo {

    public Zumbi(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.setTipo("Morto-Vivo");
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("O zumbi se arrasta em sua direção e acerta uma mordida profunda!");

        Random random = new Random();
        int roll = random.nextInt(20) + 1;

        if (roll > personagem.getDefesa()) {
            personagem.receberDano(8);

            System.out.println(personagem.getNome() + " foi envenenado pela mordida contaminada do Zumbi!");
            personagem.setEnvenenado(true);
        } else {
            System.out.println("O ataque especial da criatura falhou!");
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " avança lentamente e ataca!");
        super.atacar(alvo);
    }

    @Override
    public String getTipo(){
        return "Morto-Vivo";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }
}