package Enemies;

import Hero.Personagem;

    public class Inimigo extends Personagem {

        private String nome;
        private String tipo;
        private int recompensaXP;
        private int ataque;

        public Inimigo(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String classe, String tipo, int recompensaXP) {
            super(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma, classe);
            this.tipo = tipo;
            this.recompensaXP = recompensaXP;

        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public int getRecompensaXP() {
            return recompensaXP;
        }

        public void setRecompensaXP(int recompensaXP) {
            this.recompensaXP = recompensaXP;
        }
    }
