import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");



    public static void main(String[] args) {

        new Game();
    }

    public Game(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("CHILD OF ERU");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("texto de teste");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }
    public void playerSetup(){

        playerHP = 15;
        monsterHP = 20;
        weapon = "Faca";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("Você se depara com os grandes muros e o imponente portão da citadela principal. \n -Alto lá! afirma um guarda. \n\n O que você faz?");
        choice1.setText("Falar com o Guarda");
        choice2.setText("Atacar o Guarda!");
        choice3.setText("Voltar");
        choice4.setText("");
    }
    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guarda: Olá estranho aventureiro. Nunca vi seu rosto por essas bandas. \nMe desculpe mas não posso deixar forasteiros passarem, estamos em alerta!.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guarda: Ei! não seja idiota!\n\nO guarda contra-ataca e você percebe o preparo dos combatentes da citadela.\n(Você recebeu 3 de dano)");
        playerHP -=3;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("Você agora se vê em uma encruzilhada.\nSe você pegar a direção Sul, Retornará à Citadela de Osgiliath.");
        choice1.setText("Norte");
        choice2.setText("Leste");
        choice3.setText("Sul");
        choice4.setText("Oeste");
    }
    public void north(){
        position = "Norte";
        mainTextArea.setText("Você se aproxima do Bruinem, o rio sagrado. \nVocê bebe de sua água e descansa sobre sua margem. \n\n(2 de HP Recuperados)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("Sul");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void east(){
        position = "Leste";
        mainTextArea.setText("Andando por uma floresta você encontra uma espada fincada em uma arvore morta!\n\n(Espada Longa Obtida!)");
        weapon = "Espada Longa";
        weaponLabelName.setText(weapon);
        choice1.setText("Oeste");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void west(){
        position = "Oeste";
        mainTextArea.setText("Você encontra um Goblin! Talvez ele seja o culpado pela cidade em alerta!");
        choice1.setText("Atacar");
        choice2.setText("Fugir");
        choice3.setText("");
        choice4.setText("");
    }
    public void fight(){
        position = "Atacar";
        mainTextArea.setText("Goblin HP: " + monsterHP + "\n\nO que você faz?");
        choice1.setText("Atacar");
        choice2.setText("Fugir");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if(weapon.equals("Faca")){
            playerDamage = new java.util.Random().nextInt(3);
        }
        else if(weapon.equals("Espada Longa")){
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("Você ataca a criatura, que recebe " + playerDamage + " de dano!");

        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("O Goblin se esgueira em sua direção e lhe corta com sua Espada Curta, você recebe " + monsterDamage + " de dano!");

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";

        mainTextArea.setText("Você derrota a criatura!\nO monstro deixa cair algo brilhante!!\n\n(Silver Ring obtido!)");

        silverRing = 1;

        choice1.setText("Leste");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void lose(){
        position = "lose";

        mainTextArea.setText("VOCÊ MORREU !\n\nGAME OVER");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void ending(){
        position = "ending";

        mainTextArea.setText("Guarda: Hã Você conseguiu matar aquele Goblin!?\nMuito obrigado. Você é um verdadeiro herói!\nBem vindo à Osgiliath, talvez você seja de grande ajuda, fale com nosso Governante!\n\nTHE END");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }




    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }


    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "townGate":
                    switch(yourChoice){
                        case "c1":
                            if(silverRing==1){
                                ending();
                            }
                            else{
                                talkGuard();
                            }
                            break;
                        case "c2": attackGuard();break;
                        case "c3": crossRoad();break;
                    }
                    break;
                case "talkGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "crossRoad":
                    switch(yourChoice){
                        case "c1": north(); break;
                        case "c2": east();break;
                        case "c3": townGate(); break;
                        case "c4": west();break;
                    }
                    break;
                case "Norte":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "Leste":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "Oeste":
                    switch(yourChoice){
                        case "c1": fight(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "Atacar":
                    switch(yourChoice){
                        case "c1": playerAttack();break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice){
                        case "c1":
                            if(monsterHP <1 ){
                                win();
                            }
                            else{
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch(yourChoice){
                        case "c1":
                            if(playerHP <1 ){
                                lose();
                            }
                            else{
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch(yourChoice){
                        case "c1": crossRoad();
                    }
                    break;

            }


        }
    }

}