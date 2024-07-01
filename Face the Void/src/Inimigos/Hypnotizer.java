package Inimigos;

import Hero.Personagem;
import java.util.Random;

public class Hypnotizer extends Inimigo {

    public Hypnotizer(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.setTipo("Mágico");
    }

    @Override
    public void usarHabilidadeEspecial(Personagem personagem) {
        System.out.println("O hipnotizador lhe mostra um colar balançando de um lado para o outro... seus sentidos adormecem...");

        Random random = new Random();
        int roll = random.nextInt(20) + 1;

        if (roll > personagem.getDefesa()) {
            personagem.receberDano(1);
            personagem.setAdormecido(true);
            System.out.println(personagem.getNome() + " está adormecido! Não pode realizar nenhuma ação por 2 turnos.");
        } else {
            System.out.println("O ataque especial do hipnotizador falhou!");
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " o Hipnotizador lhe pega desprevenido e ataca sem remorso!");
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