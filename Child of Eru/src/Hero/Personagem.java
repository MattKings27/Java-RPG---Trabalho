package Hero;

public class Personagem {
    private String nome;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    private int vida;
    private String classe;
    private int nivel;
    private int experiencia;
    private int armaduraNatural;
    private static final int[] experienciaParaLevelUp = {0, 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000};

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, String classe) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.classe = classe;
        this.nivel = 1;
        this.experiencia = 0;
        this.armaduraNatural = ((destreza + constituicao)/10) + 10;

        applyClassBonus();
        calcularVida();
    }

    private void applyClassBonus() {
        switch (this.classe.toLowerCase()){
            case "guerreiro":
                this.forca += 1;
                this.constituicao += 1;
                break;
            case "mago":
                this.inteligencia += 1;
                this.destreza += 1;
                break;
            case "arqueiro":
                this.destreza += 1;
                this.forca += 1;
                break;
            default:
                String prisioneiro = "prisioneiro";
        }
    }

    void calcularVida() {
        switch(this.classe.toLowerCase()){
            case "guerreiro":
                this.vida = Math.max(1, 10 + ((constituicao - 10) / 2));
                break;
            case "mago":
                this.vida = Math.max(1, 6 + ((constituicao - 10) / 2));
                break;
            case "arqueiro":
                this.vida = Math.max(1, 8 + ((constituicao - 10) / 2));
                break;
        }
    }

    public void ganharExperiencia(int xp) {
        this.experiencia += xp;
        while (this.nivel < experienciaParaLevelUp.length &&
                this.experiencia >= experienciaParaLevelUp[this.nivel]) {
            this.nivel++;
            System.out.println("Você sente sua alma alterar o corpo, uma energia invade seu espírito, suas feridas se fecham, seu coração bate ferozmente");
            System.out.println("Parabéns, você atingiu o nível " + this.nivel);
            LevelUp.aplicarBonusPorNivel(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getVida() {
        return vida;
    }

    public int setVida(int vida) {
        this.vida = vida;
        return vida;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getarmaduraNatural(){
        return armaduraNatural;
    }

    public void setarmaduraNatural(int armaduraNatural) {
        this.armaduraNatural = armaduraNatural;
    }
}