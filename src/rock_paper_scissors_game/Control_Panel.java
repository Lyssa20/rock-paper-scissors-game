/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_paper_scissors_game;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
/**
 *
 * @author lisas
 */
public class Control_Panel extends javax.swing.JFrame {

    // borders for UI
    Border gray_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
    Border blue_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE);

    // image paths (ONLY for display, not logic)
    String rockImg = "/images/Rock.png";
    String paperImg = "/images/Paper.png";
    String scissorsImg = "/images/Scissors.jpg";

    // simple moves (used for logic)
    String ROCK = "ROCK";
    String PAPER = "PAPER";
    String SCISSORS = "SCISSORS";
    
     ArrayList<String> list = new ArrayList<>();
    Random random = new Random();
    ComputerAI ai; 

    int your_wins = 0, computer_wins = 0;
    
    
    /**
     * Creates new form Control_Panel
     */
     public Control_Panel() {
        initComponents();

        // set borders
        Your_Play.setBorder(gray_border);
        Computer_Play.setBorder(gray_border);
        Rock.setBorder(gray_border);
        Paper.setBorder(gray_border);
        Scissors.setBorder(gray_border);

        // display images
        displayImage(rockImg, Rock, 110, 90);
        displayImage(paperImg, Paper, 108, 90);
        displayImage(scissorsImg, Scissors, 110, 90);
        
        // add moves to list
        list.add(ROCK);
        list.add(PAPER);
        list.add(SCISSORS);
        
        // create AI and give it move list
        ai = new ComputerAI(list);
        
    }
      
     //display image in label
      public void displayImage(String imagePath, JLabel label, int width, int height) {
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));
        Image img = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    
       // ONE method for playing a round (removes repeated code)
    public void playRound(String playerMove) {

        // show player image
        if (playerMove.equals(ROCK))
            displayImage(rockImg, Your_Play, 160, 120);
        else if (playerMove.equals(PAPER))
            displayImage(paperImg, Your_Play, 160, 120);
        else
            displayImage(scissorsImg, Your_Play, 160, 120);

       // track player move in AI
       ai.trackPlayerMove(playerMove);

       // get difficulty from dropdown
       String difficulty = DifficultyBox.getSelectedItem().toString();

      // get move from AI
      String computerMove = ai.getMove(difficulty);

        // show computer image
        if (computerMove.equals(ROCK))
            displayImage(rockImg, Computer_Play, 160, 120);
        else if (computerMove.equals(PAPER))
            displayImage(paperImg, Computer_Play, 160, 120);
        else
            displayImage(scissorsImg, Computer_Play, 160, 120);

        // decide winner
        getWinner(playerMove, computerMove);
    }
    
      // simplified winner logic
    public void getWinner(String you, String computer) {

        if (you.equals(computer)) {
            System.out.println("Draw");
            return;
        }

        // player winning conditions
        if (
            (you.equals(ROCK) && computer.equals(SCISSORS)) ||
            (you.equals(PAPER) && computer.equals(ROCK)) ||
            (you.equals(SCISSORS) && computer.equals(PAPER))
        ) {
            your_wins++;
            Your_Wins.setText(String.valueOf(your_wins));
        } else {
            computer_wins++;
            Computer_Wins.setText(String.valueOf(computer_wins));
        }

        // best of 3 (first to 2 wins)
        if (your_wins == 2 || computer_wins == 2) {

            String message;
            if (your_wins == 2)
                message = "You win the match!";
            else
                message = "Computer wins the match!";

            int choice = JOptionPane.showConfirmDialog(null,
        message + "\nPlay Again?",
        "Game Over",
        JOptionPane.YES_NO_OPTION);

       // YES = restart
       if (choice == JOptionPane.YES_OPTION) {
              resetGame();
        }
       // NO = close program
        else {
           System.exit(0); // closes the app
        }
        }
    }

    // reset game
    public void resetGame() {
        your_wins = 0;
        computer_wins = 0;
        ai.reset(); // clear AI memory

        Your_Wins.setText("0");
        Computer_Wins.setText("0");

        Your_Play.setIcon(null);
        Computer_Play.setIcon(null);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Your_Play = new javax.swing.JLabel();
        Computer_Play = new javax.swing.JLabel();
        Your_Wins = new javax.swing.JLabel();
        Computer_Wins = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Rock = new javax.swing.JLabel();
        Scissors = new javax.swing.JLabel();
        Paper = new javax.swing.JLabel();
        jLabel_You = new javax.swing.JLabel();
        jLabel_Computer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DifficultyBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Your_Play.setBackground(new java.awt.Color(204, 255, 255));
        Your_Play.setOpaque(true);

        Computer_Play.setBackground(new java.awt.Color(204, 255, 255));
        Computer_Play.setOpaque(true);

        Your_Wins.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        Your_Wins.setForeground(new java.awt.Color(0, 255, 0));
        Your_Wins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Your_Wins.setText("0");

        Computer_Wins.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        Computer_Wins.setForeground(new java.awt.Color(255, 0, 0));
        Computer_Wins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Computer_Wins.setText("0");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("-");

        Rock.setBackground(new java.awt.Color(204, 255, 255));
        Rock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rock.setOpaque(true);
        Rock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RockMouseExited(evt);
            }
        });

        Scissors.setBackground(new java.awt.Color(204, 255, 255));
        Scissors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Scissors.setOpaque(true);
        Scissors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScissorsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScissorsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScissorsMouseExited(evt);
            }
        });

        Paper.setBackground(new java.awt.Color(204, 255, 255));
        Paper.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Paper.setOpaque(true);
        Paper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaperMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaperMouseExited(evt);
            }
        });

        jLabel_You.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jLabel_You.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_You.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_You.setText("You");

        jLabel_Computer.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jLabel_Computer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Computer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Computer.setText("Computer");

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rock");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Paper");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Scissors");

        DifficultyBox.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        DifficultyBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rock, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Paper, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scissors, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_You, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(Your_Play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Your_Wins, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(Computer_Wins, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Computer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Computer_Play, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(DifficultyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_You)
                            .addComponent(jLabel_Computer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Computer_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Your_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(DifficultyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Computer_Wins, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Your_Wins, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Paper, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scissors, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51))
        );

        Your_Wins.getAccessibleContext().setAccessibleParent(Your_Wins);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RockMouseClicked
         playRound(ROCK);
    }//GEN-LAST:event_RockMouseClicked

    private void PaperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperMouseClicked
        playRound(PAPER); 
    }//GEN-LAST:event_PaperMouseClicked

    private void ScissorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScissorsMouseClicked
        playRound(SCISSORS);
    }//GEN-LAST:event_ScissorsMouseClicked

    private void RockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RockMouseEntered
          Rock.setBorder(blue_border);
    }//GEN-LAST:event_RockMouseEntered

    private void RockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RockMouseExited
        Rock.setBorder(gray_border);
    }//GEN-LAST:event_RockMouseExited

    private void PaperMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperMouseEntered
        Paper.setBorder(blue_border);
    }//GEN-LAST:event_PaperMouseEntered

    private void PaperMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperMouseExited
        Paper.setBorder(gray_border);
    }//GEN-LAST:event_PaperMouseExited

    private void ScissorsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScissorsMouseEntered
        Scissors.setBorder(blue_border);
    }//GEN-LAST:event_ScissorsMouseEntered

    private void ScissorsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScissorsMouseExited
        Scissors.setBorder(gray_border);
    }//GEN-LAST:event_ScissorsMouseExited
   
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Control_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Control_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Control_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Control_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Control_Panel().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Computer_Play;
    private javax.swing.JLabel Computer_Wins;
    private javax.swing.JComboBox<String> DifficultyBox;
    private javax.swing.JLabel Paper;
    private javax.swing.JLabel Rock;
    private javax.swing.JLabel Scissors;
    private javax.swing.JLabel Your_Play;
    private javax.swing.JLabel Your_Wins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Computer;
    private javax.swing.JLabel jLabel_You;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
