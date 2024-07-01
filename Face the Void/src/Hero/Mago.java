package Hero;

import Inimigos.Inimigo;
import java.util.Random;

public class Mago extends Personagem {

    private boolean habilidadeUsada = false;

    public Mago(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println();
        System.out.println(nome + " lança Mísseis Mágicos!");
        super.atacar(inimigo);
    }

    public void fireBolt(Inimigo inimigo) {
        if (!habilidadeUsada) {
            System.out.println(nome + " conjura um FIRE BOLT! o mago estende suas mãos e lança uma pérola vermelha que se transforma em uma linha de fogo vivo!");

            int danoBase = 15;
            Random random = new Random();
            int roll = random.nextInt(20) + 1;

            if (roll > inimigo.getDefesa()) {
                System.out.println("O raio de fogo acertou o inimigo! e causou " + danoBase + " de dano!");

                if (inimigo.getTipo().equalsIgnoreCase("Morto-Vivo")) {
                    danoBase *= 2;
                    System.out.println("O FireBolt causa dano dobrado a um Morto-Vivo!");
                } else if (inimigo.getTipo().equalsIgnoreCase("Corruptor")) {
                    danoBase /= 2;
                    System.out.println("O FireBolt causa apenas metade do dano a um Corruptor!");
                }

                inimigo.receberDano(danoBase);

                if (random.nextDouble() <= 0.25) {
                    System.out.println("O inimigo está queimando!");
                    int danoQueimadura = random.nextInt(6) + 1;
                    inimigo.receberDano(danoQueimadura);
                }
            } else {
                System.out.println("O FireBolt falhou em acertar o inimigo.");
            }

            habilidadeUsada = true;
        } else {
            System.out.println("A habilidade FireBolt já foi utilizada neste turno!");
        }
    }

    public void imobilizarComMagia(Inimigo inimigo) {
        if (!habilidadeUsada) {
            System.out.println(nome + " conjura uma magia de Imobilização!");

            Random random = new Random();
            int roll = random.nextInt(20) + 1;

            if (roll > inimigo.getDefesa()) {
                inimigo.setAtordoado(true);
                System.out.println("O inimigo foi imobilizado!");
            } else {
                System.out.println("A magia de Imobilização falhou!");
            }

            habilidadeUsada = true;
        } else {
            System.out.println("A habilidade de Imobilização já foi utilizada neste turno!");
        }
    }

    @Override
    public void defender() {
        System.out.println(nome + " conjura um escudo mágico para se defender!");
        defesa = 18;
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