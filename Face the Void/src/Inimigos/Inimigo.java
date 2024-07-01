package Inimigos;

import Hero.Habilidade;
import Hero.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Inimigo extends Personagem {
    protected List<Habilidade> habilidades;
    private String tipo;
    private int vidaMaxima;

    public Inimigo(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.habilidades = new ArrayList<>();
        this.tipo = "Comum";
        this.vidaMaxima = vida;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipo() {
        this.tipo = "Comum";
    }

    @Override
    public void atacar(Personagem alvo) {
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > alvo.getDefesa()) {
            int dano = calcularDanoBasico(alvo);
            alvo.receberDano(dano);
            System.out.println(nome + " atacou " + alvo.getNome() + " e causou " + dano + " de dano.");
        } else {
            System.out.println(nome + " tentou atacar " + alvo.getNome() + ", mas foi defendido.");
        }
        System.out.println("Vida restante de " + alvo.getNome() + ": " + alvo.getVida());
    }

    @Override
    public void receberDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano!");
        }
    }

    @Override
    public void defender() {
        System.out.println(nome + " está se preparando para o próximo ataque!");
        defesa += 2;
    }

    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println(nome + " se prepara para algo terrível!");
    }

    @Override
    public void tratarEfeitos() {
        super.tratarEfeitos();
        if (isEnvenenado()) {
            Random random = new Random();
            int danoEnvenenamento = random.nextInt(4) + 1;
            vida -= danoEnvenenamento;
            System.out.println(nome + " está envenenado e perde " + danoEnvenenamento + " pontos de vida!");
        }
        if (isSangrando()) {
            vida -= 3;
            System.out.println(nome + " está sangrando e perde 3 pontos de vida!");
        }
        if (isAtordoado()) {
            System.out.println(nome + " está atordoado e perdeu seu turno!");
            setAtordoado(false);
        }
        if (isQueimando()) {
            Random random = new Random();
            int danoQueimadura = random.nextInt(6) + 1;
            vida -= danoQueimadura;
            System.out.println(nome + " está queimando e perde " + danoQueimadura + " pontos de vida!");
        }
    }

    public boolean isAtordoado() {
        return atordoado;
    }

    public void setAtordoado(boolean atordoado) {
        this.atordoado = atordoado;
    }

    public boolean isQueimando() {
        return queimando;
    }

    public void setQueimando(boolean queimando) {
        this.queimando = queimando;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
}
