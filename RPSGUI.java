/**
   RPSGUI.java
   
   This program plays the game Rock Paper Scissors
   and creates the GUI for the game 
   
   @Author: Thomas Rivera
   
   @Version: 10/19/2021
**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class RPSGUI extends JFrame {
   
   //Buttons
   private ImageIcon iRock;
   private ImageIcon iPaper;
   private ImageIcon iScissors;
   private JButton buttonR = new JButton(iRock);
   private JButton buttonP = new JButton(iPaper);
   private JButton buttonS = new JButton(iScissors);
   private JButton buttonI = new JButton("Instructions");
   private JButton buttonE = new JButton("End Game");
   
   //Lables
   private JLabel title = new JLabel("Rock Paper Scissors");//Title of game
   private JLabel playerUiChoice = new JLabel("");//Displays choice of player
   private JLabel compUiChoice = new JLabel("");//Displays chice of computer
   private JLabel pickUi = new JLabel("Pick One:");
   private JLabel space = new JLabel("");//Creates empty space for GUI
   private JLabel space2 = new JLabel("");
   
   //Counts
   private int playerCount = 0;//Player win count
   private int compCount = 0;//Computer win count
   private int tieCount = 0;//Ties count
   private int roundCount = 0;//Count of rounds
   
   //Lables
   private JLabel winner = new JLabel(" ");//Tells who the winner is
   private JLabel score = new JLabel("Score | You: " + playerCount + " | The Computer: " + compCount + " | Ties: " + tieCount);//Formats score
   private JLabel comp = new JLabel("Computer Choice: ");//Tells what the computer chose
   private JLabel player = new JLabel ("Player Chioce: ");//Tells what the player chose
   private JLabel roundUi = new JLabel("Round " + roundCount);//Rounds played UI
   
   //Choices for Rock Paper Scissors
   private int playerChoice = 0;
   private int compChoice = 0;
   
   //Frame size
   private final int WIDTH = 1280;
   private final int HEIGHT = 720;
   
   //Creates files to print scores to.
   File scores = new File ("scores.txt");
   
   //---------------------------------------------------------
   //Instructions to initialize frame.
   //---------------------------------------------------------   
   public RPSGUI() {
      //Instructions to initialize frame
      this.setSize(WIDTH, HEIGHT);
      this.setTitle("Rock Paper Scissors");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setResizable(false);
      this.setBackground(Color.orange);
   }
   
   //---------------------------------------------------------
   //Puts the elements in the GUI where they belong.
   //Adds listeners to elements that monitor events.
   //--------------------------------------------------------- 
   public void initializeGUI( ) {
      //add action listeners to graphic elements
      ActionListener ears = new MyListener( );
      buttonR.addActionListener(ears);
      buttonP.addActionListener(ears);
      buttonS.addActionListener(ears);
      buttonI.addActionListener(ears);
      buttonE.addActionListener(ears);
      
      //Create panels
      JPanel mPanel = new JPanel(); 
      JPanel nPanel = new JPanel();
      JPanel cPanel = new JPanel();
      JPanel wPanel = new JPanel();
      JPanel ePanel = new JPanel(); 
      JPanel bPanel = new JPanel();
      
      //Panel colors
      nPanel.setBackground(Color.RED);
      wPanel.setBackground(Color.YELLOW);
      ePanel.setBackground(Color.YELLOW);
      bPanel.setBackground(Color.RED);
      
      //Images (Place images in folder named "images")
      iRock = new ImageIcon(getClass().getResource("/images/rock.png"));
      iPaper = new ImageIcon(getClass().getResource("/images/paper.png"));
      iScissors = new ImageIcon(getClass().getResource("/images/scissors.png"));
      Image rockImg = iRock.getImage();
      Image paperImg = iPaper.getImage();
      Image scissorsImg = iScissors.getImage();
      Image nRockImg = rockImg.getScaledInstance(130,130, java.awt.Image.SCALE_SMOOTH);
      Image nPaperImg = paperImg.getScaledInstance(130,130, java.awt.Image.SCALE_SMOOTH);
      Image nScissorsImg = scissorsImg.getScaledInstance(130,130, java.awt.Image.SCALE_SMOOTH);
      iRock = new ImageIcon(nRockImg);
      iPaper = new ImageIcon(nPaperImg);
      iScissors = new ImageIcon(nScissorsImg);
      buttonR.setIcon(iRock);
      buttonP.setIcon(iPaper);
      buttonS.setIcon(iScissors);
      
      //border (top,left,botton,right)
      //Top / North panel borders
      nPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      title.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
      
      //Left / West panel borders
      wPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      pickUi.setBorder(BorderFactory.createEmptyBorder(5,10,10,10)); 
      
      //Center panel borders
      cPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      player.setBorder(BorderFactory.createEmptyBorder(40,110,10,80));
      comp.setBorder(BorderFactory.createEmptyBorder(40,110,10,90));
      playerUiChoice.setBorder(BorderFactory.createEmptyBorder(40,125,10,140));
      compUiChoice.setBorder(BorderFactory.createEmptyBorder(40,140,10,125));
      winner.setBorder(BorderFactory.createEmptyBorder(60,10,10,10));
      
      //Right / East panel borders
      ePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      roundUi.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      space.setBorder(BorderFactory.createEmptyBorder(40,50,50,50));
      buttonI.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      space2.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
      buttonE.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      
      //Bottom / Sount panel borders      
      bPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); 
      score.setBorder(BorderFactory.createEmptyBorder(5,20,15,20));    
      
      //Fonts and size
      title.setFont(new Font("Helvetica",Font.BOLD,58));
      pickUi.setFont(new Font("Helvetica",Font.BOLD,24));
      player.setFont(new Font("Helvetica",Font.BOLD,24));
      comp.setFont(new Font("Helvetica",Font.BOLD,24));
      winner.setFont(new Font("Helvetica",Font.BOLD,26));
      score.setFont(new Font("Helvetica",Font.BOLD,24));
      roundUi.setFont(new Font("Helvetica",Font.BOLD,24));
      
      buttonI.setFont(new Font("Helvetica",Font.BOLD,20));
      buttonE.setFont(new Font("Helvetica",Font.BOLD,20));
      
      //Panels
      //main
      mPanel.setLayout(new BorderLayout());
      
      //Top / North
      nPanel.setPreferredSize(new Dimension(1280,120));
      nPanel.add(title);
      
      //Center
      cPanel.setPreferredSize(new Dimension(500,480));
      cPanel.add(player);
      cPanel.add(comp);
      cPanel.add(playerUiChoice);
      cPanel.add(compUiChoice);
      cPanel.add(winner);
      
      //Left / West
      wPanel.setPreferredSize(new Dimension(200,120));
      wPanel.add(pickUi);
      wPanel.add(buttonR);
      wPanel.add(buttonP);
      wPanel.add(buttonS);
      
      //Right / East
      ePanel.setPreferredSize(new Dimension(200,120));
      ePanel.add(roundUi);
      ePanel.add(space);
      ePanel.add(buttonI);
      ePanel.add(space2);
      ePanel.add(buttonE);
      
      //Bottom / South
      bPanel.setPreferredSize(new Dimension(1280, 60));
      bPanel.add(score);
      
      //Add panels to mPanel
      mPanel.add(nPanel,BorderLayout.NORTH);
      mPanel.add(cPanel,BorderLayout.CENTER);
      mPanel.add(wPanel,BorderLayout.WEST);
      mPanel.add(ePanel,BorderLayout.EAST);
      mPanel.add(bPanel,BorderLayout.PAGE_END);
      
      this.add(mPanel);    
   } 
   
   //---------------------------------------------------------
   //Takes in user input through event listeners and
   //calculates the winner, shows instructions, ends the game
   //and program, and prints the score to scores.txt.
   //--------------------------------------------------------- 
   private class MyListener implements ActionListener{      
      public void actionPerformed(ActionEvent event) {
         
         try{
         
            //printWriter
            FileWriter fW = new FileWriter(scores,true);
            PrintWriter pW = new PrintWriter(fW);
            
            //Instructions button
            if (event.getSource() == buttonI) {
               JOptionPane.showMessageDialog(new JFrame(),
                  "It's You vs the Computer!"
                  +"\nTo play, the Player and the Computer will select between three objects; Rock, Paper, or Scissors."
                  +"\nAfter choosing, the winner is determined by observing which object beats the other. For instance,"
                  +"\nRock beats Scissors, Paper beats Rock, and Scissors beats Paper. If both player choose the same"
                  +"\nobject, it ends in a tie.",
                  "How To Play",
                  JOptionPane.PLAIN_MESSAGE);
            }
            
            //End game button
            if (event.getSource() == buttonE) {
               int n = JOptionPane.showConfirmDialog(new JFrame(),//Asks if user wants to quit
                  "Are you sure you want to end the game?",
                  "End Game",
                  JOptionPane.YES_NO_OPTION);
               
               //If yes, the game closes and save game scores to "scores.txt"
               if (n == 0) {
                  JOptionPane.showMessageDialog(new JFrame(),
                     "Your game score has been saved to the file 'scores.txt'"
                     +"\nThank You For Playing!",
                     "End Game",
                     JOptionPane.PLAIN_MESSAGE);
                  pW.close();
                  System.exit(0);
               }
            }
            
            //Rock Paper Scissors game.
            //0 = rock, 1 = paper, 2 = scissors.
            if (event.getSource() == buttonR || event.getSource() == buttonP || event.getSource() == buttonS) {
            
               Random randChoice = new Random();
            
            //Sets the player's choice when button is pressed
               if(event.getSource( ) == buttonR) {
                  playerChoice = 0;//Player chose rock
                  playerUiChoice.setIcon(iRock);
               } else if (event.getSource( ) == buttonP) {
                  playerChoice = 1;//Player chose paper
                  playerUiChoice.setIcon(iPaper);
               } else if (event.getSource( ) == buttonS) {
                  playerChoice = 2;//Player chose scissors
                  playerUiChoice.setIcon(iScissors);
               }
            
               compChoice = randChoice.nextInt(3);//Chooses random number between 0-2
            
            //Randomly sets the computer's choice
               if (compChoice == 0) { 
                  compUiChoice.setIcon(iRock);//Comp chose rock
               } else if (compChoice == 1) {
                  compUiChoice.setIcon(iPaper);//Comp chose paper
               } else if (compChoice == 2){
                  compUiChoice.setIcon(iScissors);//Comp chose scissors
               }
            
            //Calculates the winner
               //Tie
               if (playerChoice == compChoice) {
                  winner.setText("Tie!");
                  tieCount++;
                  roundCount++;
                  
                  //prints score to scores.txt
                  pW.write("Round " + roundCount + ": The Player Wins!"
                           +"\nYou: " + playerCount + " The Computer: " + compCount + " Ties: " + tieCount + "\n\n");
                  pW.close();
               } 
            
               //Computer wins
               if (playerChoice == 0 && compChoice == 1 || playerChoice == 1 && compChoice == 2 || playerChoice == 2 && compChoice == 0) {
                  winner.setText("The Computer Wins!");
                  compCount++;
                  roundCount++;
                  
                  //prints score to scores.txt
                  pW.write("Round " + roundCount + ": The Computer Wins!"
                           +"\nScore | You: " + playerCount + " | The Computer: " + compCount + " | Ties: " + tieCount + "\n\n");
                  pW.close();
               }
               
               //Player wins
               if(compChoice == 0 && playerChoice == 1 || compChoice == 1 && playerChoice == 2 || compChoice == 2 && playerChoice == 0) {
                  winner.setText("The Player Wins!");
                  playerCount++;
                  roundCount++;
                  
                  //Prints score to scores.txt
                  pW.write("Round " + roundCount + ": The Player Wins!"
                           +"\nScore | You: " + playerCount + " | The Computer: " + compCount + " | Ties: " + tieCount + "\n\n");
                  pW.close();
               }
               
               //Updates score on GUI   
               score.setText("Score | You: " + playerCount + " | The Computer: " + compCount + " | Ties: " + tieCount);
               roundUi.setText("Round " + roundCount);
            }
         } catch (IOException ioe) {
            System.out.println("Oops, something went wrong.");
         }  
      }
   } 
}