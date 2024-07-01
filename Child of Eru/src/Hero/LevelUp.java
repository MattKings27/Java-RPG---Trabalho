package Hero;

public class LevelUp {

    public static void aplicarBonusPorNivel(Personagem personagem) {
        switch (personagem.getClasse().toLowerCase()) {
            case "guerreiro":
                personagem.setForca(personagem.getForca() + 1);
                personagem.setConstituicao(personagem.getConstituicao() + 1);
                System.out.println(personagem.getNome() + " ganhou +1 Força e +1 Constituição!");
                break;
            case "mago":
                personagem.setInteligencia(personagem.getInteligencia() + 1);
                personagem.setDestreza(personagem.getDestreza() + 1);
                System.out.println(personagem.getNome() + " ganhou +1 Inteligência e +1 Destreza!");
                break;
            case "arqueiro":
                personagem.setDestreza(personagem.getDestreza() + 1);
                personagem.setForca(personagem.getForca() + 1);
                System.out.println(personagem.getNome() + " ganhou +1 Destreza e +1 Força!");
                break;
            default:
                throw new IllegalArgumentException("Classe desconhecida: " + personagem.getClasse());
        }

        personagem.calcularVida();
        System.out.println("Nova vida: " + personagem.getVida());
    }
}