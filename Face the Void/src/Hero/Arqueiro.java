package Hero;

import Inimigos.Inimigo;
import java.util.Random;

public class Arqueiro extends Personagem {
    private boolean habilidadeUsada = false;

    public Arqueiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    public void tiroRapido(Inimigo inimigo) {
        if (!habilidadeUsada) {
            System.out.println(nome + " utiliza Tiro Rápido e ataca 2 vezes em um segundo!");
            inimigo.receberDano(8 * 2);
            habilidadeUsada = true;
        } else {
            System.out.println("O arqueiro parece não conseguir disparar com a mesma velocidade de antes.. Tiro Rápido já foi usada. Disparando flecha!");
            atacar(inimigo);
        }
    }

    public void flechaNoCalcanhar(Inimigo inimigo) {
        if (!habilidadeUsada) {
            Random random = new Random();
            int roll = random.nextInt(20) + 1;
            if (roll > inimigo.getDefesa()) {
                System.out.println(nome + " atira uma Flecha no Calcanhar do inimigo!");
                inimigo.setAtordoado(true);
                System.out.println("O inimigo foi atingido no calcanhar e está atordoado!");

            } else {
                System.out.println("Arqueiro tentou atirar a Flecha no Calcanhar do inimigo, mas falhou.");
            }
            habilidadeUsada = true;
        } else {
            System.out.println("A habilidade Flecha no Calcanhar já foi usada. Disparando flecha!");
            atacar(inimigo);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println();
        System.out.println(nome + " atira uma flecha precisa!");
        super.atacar(alvo);
    }

    @Override
    public void defender() {
        System.out.println(nome + " se movimenta para evitar ataques!");
        defesa = 13;
    }

    @Override
    public String getTipo() {
        return "Humanoide";
    }

    @Override
    protected void recuperarHabilidadeEspecial() {

    }

    public boolean isHabilidadeUsada() {
        return habilidadeUsada;
    }

    public void setHabilidadeUsada(boolean habilidadeUsada) {
        this.habilidadeUsada = habilidadeUsada;
    }
}