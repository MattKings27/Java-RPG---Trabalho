package Hero;

import Inimigos.Inimigo;
import Hero.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected List<Habilidade> habilidades;
    protected boolean envenenado;
    protected boolean sangrando;
    protected boolean adormecido;
    protected boolean atordoado;
    protected boolean queimando;
    protected int turnosDormindo;
    protected int pontosExperiencia;
    protected int nivel;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.habilidades = new ArrayList<>();
        this.envenenado = false;
        this.sangrando = false;
        this.adormecido = false;
        this.atordoado = false;
        this.queimando = false;
        this.turnosDormindo = 0;
        this.pontosExperiencia = 0;
        this.nivel = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public boolean isVivo() {
        return vida > 0;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public boolean isSangrando() {
        return sangrando;
    }

    public void setSangrando(boolean sangrando) {
        this.sangrando = sangrando;
    }

    public boolean isAdormecido() {
        return adormecido;
    }

    public void setAdormecido(boolean dormindo) {
        this.adormecido = dormindo;
        if (dormindo) {
            this.turnosDormindo = 2;
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

    public void atacar(Personagem alvo) {
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        if (roll > alvo.getDefesa()) {
            int dano = calcularDanoBasico(alvo);
            alvo.receberDano(dano);
            System.out.println(nome + " atacou " + alvo.getNome() + " e causou " + dano + " de dano.");
        } else {
            System.out.println(nome + " tentou atacar, mas parou na defesa de " + alvo.getNome());
        }
        System.out.println("Vida restante: " + alvo.getVida());
    }

    protected int calcularDanoBasico(Personagem alvo) {
        return Math.max(0, ataque - alvo.getDefesa());
    }

    public void atacarComHabilidade(Habilidade habilidade, Personagem alvo) {
        int dano = calcularDano(habilidade, alvo);
        alvo.receberDano(dano);
        System.out.println(nome + " usou " + habilidade.getNome() + " em " + alvo.getNome() + " e causou " + dano + " de dano.");
    }

    protected int calcularDano(Habilidade habilidade, Personagem alvo) {
        int dano = habilidade.getDanoBase();
        String tipoHabilidade = habilidade.getTipo();
        String tipoAlvo = alvo.getTipo();

        if ((tipoHabilidade.equals("Fogo") && tipoAlvo.equals("Morto-Vivo")) ||
                (tipoHabilidade.equals("Gelo") && tipoAlvo.equals("Fogo")) ||
                (tipoHabilidade.equals("Elétrico") && tipoAlvo.equals("Água"))) {
            dano *= 2;
        } else if ((tipoHabilidade.equals("Fogo") && tipoAlvo.equals("Fogo")) ||
                (tipoHabilidade.equals("Gelo") && tipoAlvo.equals("Gelo")) ||
                (tipoHabilidade.equals("Elétrico") && tipoAlvo.equals("Elétrico"))) {
            dano /= 2;
        }

        return dano;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nome + " recebeu " + dano + " de dano!");
    }

    public void defender() {
        System.out.println(nome + " está se defendendo.");
        defesa += 5;
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidades.add(habilidade);
    }

    public void usarHabilidadeEspecial(Inimigo inimigo) {
        System.out.println(nome + " se prepara com concentração!");
    }

    public void tratarEfeitos() {
        tratarEnvenenamento();
        tratarSangramento();
        tratarAtordoamento();
        tratarAdormecimento();
    }

    public void tratarEnvenenamento() {
        if (envenenado) {
            Random random = new Random();
            int danoEnvenenamento = random.nextInt(4) + 1;
            vida -= danoEnvenenamento;
            System.out.println(nome + " está envenenado e perde " + danoEnvenenamento + " pontos de vida!");

            if (vida <= 0) {
                vida = 0;
                System.out.println(nome + " foi derrotado pelo envenenamento!");
            }
        }
    }

    public void tratarSangramento() {
        if (sangrando) {
            vida -= 3;
            System.out.println(nome + " está sangrando e perde 3 pontos de vida!");

            if (vida <= 0) {
                vida = 0;
                System.out.println(nome + " foi derrotado pelo sangramento!");
            }
        }
    }

    public void tratarAtordoamento() {
        if (atordoado) {
            System.out.println(nome + " está atordoado e perdeu seu turno!");
            atordoado = false; // Reseta o estado de atordoamento após um turno
        }
    }

    public void tratarAdormecimento() {
        if (adormecido) {
            System.out.println(nome + " está adormecido e não pode realizar nenhuma ação!");
            turnosDormindo--;

            if (turnosDormindo <= 0) {
                adormecido = false;
                System.out.println(nome + " acordou do estado de adormecimento!");
            }
        }
    }

    public void passarTurno() {
    }

    public abstract String getTipo();

    public void recuperar() {

        vida += 5;
        ataque += 1;
        habilidades.clear();
        envenenado = false;
        sangrando = false;
        adormecido = false;
        atordoado = false;
        queimando = false;
        turnosDormindo = 0;


        recuperarHabilidadeEspecial();
    }


    protected abstract void recuperarHabilidadeEspecial();


    public void ganharExperiencia(int pontos) {
        pontosExperiencia += pontos;
        System.out.println(nome + " ganhou " + pontos + " pontos de experiência!");


        verificarAumentoNivel();
    }


    protected void verificarAumentoNivel() {
        int experienciaParaProximoNivel = nivel * 10;

        if (pontosExperiencia >= experienciaParaProximoNivel) {
            nivel++;
            pontosExperiencia -= experienciaParaProximoNivel;
            System.out.println(nome + " subiu para o nível " + nivel + "!");


            vida += 5;
            ataque += 2;
            defesa += 2;
        }
    }
}