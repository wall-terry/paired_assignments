/*
 * The MIT License
 *
 * Copyright 2014 dccoatney.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package CIT260.PairedProgramming.CrazyConnectFour.Frames;

import CIT260.PairedProgramming.CrazyConnectFour.Controls.GameMenuControl;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.ErrorType;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.GameType;
import CIT260.PairedProgramming.CrazyConnectFour.Enumerations.StatusType;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.GameException;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.LocationException;
import CIT260.PairedProgramming.CrazyConnectFour.Exceptions.MenuException;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Game;
import CIT260.PairedProgramming.CrazyConnectFour.Models.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dccoatney
 */
public class GameFrame extends javax.swing.JFrame {

    private String currentToken = null;
    private Game game = null;
    private GameMenuControl gameCommands = null;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        this.initComponents();

    }

    public GameFrame(Game game) {
        this();
        this.game = game;
        this.gameCommands = new GameMenuControl(game, this);
        this.initializeFrame();
        setLocationRelativeTo(null);
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameMenuControl getGameCommands() {
        return gameCommands;
    }

    public void setGameCommands(GameMenuControl gameCommands) {
        this.gameCommands = gameCommands;
    }

    public JButton getjButtonHelp() {
        return jButtonHelp;
    }

    public void setjButtonHelp(JButton jButtonHelp) {
        this.jButtonHelp = jButtonHelp;
    }

    public JButton getjButtonHighScores() {
        return jButtonHighScores;
    }

    public void setjButtonHighScores(JButton jButtonHighScores) {
        this.jButtonHighScores = jButtonHighScores;
    }

    public JButton getjButtonNewGame() {
        return jButtonNewGame;
    }

    public void setjButtonNewGame(JButton jButtonNewGame) {
        this.jButtonNewGame = jButtonNewGame;
    }

    public JButton getjButtonReturn() {
        return jButtonReturn;
    }

    public void setjButtonReturn(JButton jButtonReturn) {
        this.jButtonReturn = jButtonReturn;
    }

    public JButton getjButtonSettings() {
        return jButtonSettings;
    }

    public void setjButtonSettings(JButton jButtonSettings) {
        this.jButtonSettings = jButtonSettings;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTableCrazyConnectFour() {
        return jTableCrazyConnectFour;
    }

    public void setjTableCrazyConnectFour(JTable jTableCrazyConnectFour) {
        this.jTableCrazyConnectFour = jTableCrazyConnectFour;
    }

    public JTextArea getjTextMessagePanel() {
        return jTextMessagePanel;
    }

    public void setjTextMessagePanel(JTextArea jTextMessagePanel) {
        this.jTextMessagePanel = jTextMessagePanel;
    }

    public void initializeFrame() {

        int rows = this.game.getBoard().getRowCount();
        int columns = this.game.getBoard().getColumnCount();

        jTableCrazyConnectFour.getTableHeader().setVisible(true);
        jTableCrazyConnectFour.getTableHeader().setPreferredSize(new Dimension(rows, columns));
        jTableCrazyConnectFour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Color backgroundColor = jTableCrazyConnectFour.getBackground();
        jTableCrazyConnectFour.setSelectionBackground(backgroundColor);

        CellRenderer cellRenderer = new CellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableColumnModel columnTableModel = jTableCrazyConnectFour.getColumnModel();
        for (int i = 0; i < jTableCrazyConnectFour.getColumnCount(); i++) {
            columnTableModel.getColumn(i).setCellRenderer(cellRenderer);
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonNewGame = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jButtonHighScores = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextMessagePanel = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCrazyConnectFour = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButtonNewGame.setText("Start A New Game");
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);
            }
        });

        jButtonSettings.setText("Game Settings");
        jButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsActionPerformed(evt);
            }
        });

        jButtonHighScores.setText("Display High Scores");
        jButtonHighScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHighScoresActionPerformed(evt);
            }
        });

        jButtonHelp.setText("Help");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        jButtonReturn.setText("Return to Main Menu");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonHelp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNewGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSettings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonHighScores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButtonNewGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHighScores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHelp)
                .addGap(36, 36, 36)
                .addComponent(jButtonReturn)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTextMessagePanel.setColumns(20);
        jTextMessagePanel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextMessagePanel.setLineWrap(true);
        jTextMessagePanel.setRows(5);
        jTextMessagePanel.setText("Click the Start A New Game to begin Play. Click on Game Prefernecs to set new game preferences");
        jTextMessagePanel.setWrapStyleWord(true);
        jTextMessagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(jTextMessagePanel);

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Play The Game");

        jTableCrazyConnectFour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCrazyConnectFour.setToolTipText("");
        jTableCrazyConnectFour.setAlignmentX(1.0F);
        jTableCrazyConnectFour.setAlignmentY(1.0F);
        jTableCrazyConnectFour.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCrazyConnectFour.setColumnSelectionAllowed(true);
        jTableCrazyConnectFour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCrazyConnectFour.setDropMode(javax.swing.DropMode.ON);
        jTableCrazyConnectFour.setGridColor(new java.awt.Color(0, 0, 0));
        jTableCrazyConnectFour.setMaximumSize(new java.awt.Dimension(2147483647, 1000));
        jTableCrazyConnectFour.setRowHeight(50);
        jTableCrazyConnectFour.setRowSelectionAllowed(false);
        jTableCrazyConnectFour.setSelectionBackground(new java.awt.Color(0, 102, 204));
        jTableCrazyConnectFour.setSelectionForeground(new java.awt.Color(102, 153, 255));
        jTableCrazyConnectFour.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCrazyConnectFour.setSurrendersFocusOnKeystroke(true);
        jTableCrazyConnectFour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCrazyConnectFourMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCrazyConnectFour);
        jTableCrazyConnectFour.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1250, 1288);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        initializeFrame();
        this.game.getBoard().makeTheBoard();
        this.gameCommands.startNewGame();
        clearTokens();
        this.game.setStatus(StatusType.PLAYING);
        String nextPlayersMessage = this.game.getCurrentPlayer().getName()
                + " it is your turn. Click on Any Column.";
        this.jTextMessagePanel.setText(nextPlayersMessage);
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
        try {
            if (this.game.getStatus() == StatusType.PLAYING) {
                throw new GameException(ErrorType.ERROR101.getMessage());
            } else {
                GamePreferencesFrame gamepreferencesFrame = new GamePreferencesFrame(game, this);
                gamepreferencesFrame.setVisible(true);
            }
        } catch (GameException ex) {
            this.jTextMessagePanel.setText(ex.getMessage());
        }

    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonHighScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHighScoresActionPerformed
        DisplayHighScoresFrame displayHighScoresFrame = new DisplayHighScoresFrame(this.game);
        displayHighScoresFrame.setVisible(true);
    }//GEN-LAST:event_jButtonHighScoresActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        Help helpFrame = new Help();
        helpFrame.setVisible(true);
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jTableCrazyConnectFourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCrazyConnectFourMouseClicked
        JTable jTable = (JTable) evt.getComponent();
        this.jTextMessagePanel.setForeground(Color.black);
        this.takeTurn(jTable);
    }//GEN-LAST:event_jTableCrazyConnectFourMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonHighScores;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCrazyConnectFour;
    private javax.swing.JTextArea jTextMessagePanel;
    // End of variables declaration//GEN-END:variables
 public void clearTokens() {
        TableModel model = this.jTableCrazyConnectFour.getModel();
        int rowCount = this.jTableCrazyConnectFour.getRowCount();
        int colCount = this.jTableCrazyConnectFour.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                model.setValueAt("", row, col);
            }
        }
    }

    private String getNextPlayerMessage(Player player) {
        if (this.game.getGameType() == GameType.ONE_PLAYER) {
            return "The computer took it's turn. It is now your turn "
                    + player.getName();
        } else {
            return "It is now your turn "
                    + player.getName();
        }
    }

    private class CellRenderer extends DefaultTableCellRenderer {

        public CellRenderer() {
            super();
        }

        public void setValue(Player player) {
            setText((player == null) ? "" : player.getToken());
        }
    }

    private void takeTurn(JTable table) {
        String playersToken;
        int selectedRow;
        int selectedColumn = table.getSelectedColumn();
        Player currentPlayer = this.game.getCurrentPlayer();
        Player otherPlayer = this.game.getOtherPlayer();
        TableModel model = this.jTableCrazyConnectFour.getModel();
        int rowCount = this.game.getBoard().getRowCount();
        int colCount = this.jTableCrazyConnectFour.getColumnCount();
        selectedRow = rowCount - 1;
        while (selectedRow >= 0 && model.getValueAt(selectedRow, selectedColumn) != "") {
            selectedRow -= 1;
        }
        try {
            if (selectedRow >= 0) {
                Point selectedLocation = new Point(selectedRow, selectedColumn);
            } // a valid location was entered
            else {
                throw new LocationException(ErrorType.ERROR201.getMessage());
            }
        } catch (LocationException ex) {
            this.jTextMessagePanel.setText(ex.getMessage());
        }
        if (selectedRow >= 0)
        
        {
            table.setCellSelectionEnabled(false);
            ListSelectionModel selectionModel = table.getSelectionModel();
            selectionModel.clearSelection();
            playersToken = currentPlayer.getToken();
            table.getModel().setValueAt(playersToken, selectedRow, selectedColumn);
            this.gameCommands.alternatePlayers();
            String promptNextPlayer = getNextPlayerMessage(this.game.getCurrentPlayer());
            this.jTextMessagePanel.setText(promptNextPlayer);
        }

    }
}
