package ui;

import java.awt.Color;
import java.awt.Component;
import logic.decks.Deck;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import logic.*;

public class DecklistWindow extends javax.swing.JDialog {
    private static int KEYBOARD_KEYCODE = 32; 
    
    private Deck deck;
    private DeckEditWindow parent;
    private DefaultListModel decklistModel;
    private DefaultListModel cardpoolModel;
    
    public DecklistWindow(Deck deck, DeckEditWindow parent, boolean modal){
        super(parent, modal);
        this.deck = deck;
        this.parent = parent;
        decklistModel = new DefaultListModel();
        cardpoolModel = new DefaultListModel();
        initComponents();
        setIconImage((new ImageIcon(getClass().getResource("/resources/hs_icon.png"))).getImage());
        setTitle(deck.getName()+" Decklist Editor");
        deckListbox.setModel(decklistModel);
        cardpoolListbox.setModel(cardpoolModel);
        deckListbox.setCellRenderer(new CardListRenderer());
        cardpoolListbox.setCellRenderer(new CardListRenderer());
        update();
        moveWindowToLeft();
    }
    
    private DecklistWindow(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void update(){
        filterCardpool("");
        for(Card card : deck.getCards()){
            decklistModel.addElement(card);
        }
    }
    
    //Filters the cards in the cardpool so that only class cards and
    //neutral cards are displayed.
    
    private void filterCardpool(String cardPoolFilter){
        cardpoolModel.clear();
        for(Card card : Logic.getInstance().getCards()){
            if((card.getCLASS().equals(deck.getHeroClass()) || 
                card.getCLASS().equals("Neutral"))&&
               (card.getNAME().toLowerCase().contains(cardPoolFilter)||
                cardPoolFilter.equals("")))
                    cardpoolModel.addElement(card);
        }
    }
    
    private void moveWindowToLeft(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width-(this.getSize().width+100),20);
    }
    
    private void addCardToDecklist(){
        if(decklistModel.getSize() == 30){
            UI.getInstance().displayError("Deck size is already at 30 cards.");
        }
        else if(cardpoolListbox.getSelectedValue() == null){
            UI.getInstance().displayError("There is no card selected in the cardpool.");
        }
        else{
            decklistModel.addElement((Card)cardpoolListbox.getSelectedValue());
            ArrayList<Card> cardAL;
            try{
                cardAL = Logic.getInstance().sortCards(new ArrayList(Arrays.asList(decklistModel.toArray())));
                decklistModel.clear();
                for(Card card : cardAL)
                    decklistModel.addElement(card);
            }catch(Exception ex){
                UI.getInstance().displayError(ex.getMessage());
            }
        }
    }
    
    private void removeCardFromDecklist(){
        if(deckListbox.getSelectedValue() == null){
            UI.getInstance().displayError("There is no card selected in the deck.");
        }else{
            decklistModel.removeElement(deckListbox.getSelectedValue());
        }
    }
    
    private class CardListRenderer extends DefaultListCellRenderer
    {
        @Override
        public Component getListCellRendererComponent( JList list,
                Object value, int index, boolean isSelected,
                boolean cellHasFocus ){
            super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            switch (((Card)value).getRARITY()) {
                case Card.LEGENDARY:
                    setForeground(Color.orange);
                    break;
                case Card.EPIC:
                    setForeground(Color.MAGENTA);
                    break;
                case Card.RARE:
                    setForeground(Color.BLUE);
                    break;
                default:
                    setForeground(Color.BLACK);
            }
            return this;
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

        cardpoolPopupMenu = new javax.swing.JPopupMenu();
        addCardMenuItem = new javax.swing.JMenuItem();
        deckPopupMenu = new javax.swing.JPopupMenu();
        removeCardMenuItem = new javax.swing.JMenuItem();
        deckScrollPane = new javax.swing.JScrollPane();
        deckListbox = new javax.swing.JList();
        cardpoolScrollPane = new javax.swing.JScrollPane();
        cardpoolListbox = new javax.swing.JList();
        deckLabel = new javax.swing.JLabel();
        cardpoolLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        addCardMenuItem.setText("Add Selected Card");
        addCardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardMenuItemActionPerformed(evt);
            }
        });
        cardpoolPopupMenu.add(addCardMenuItem);

        removeCardMenuItem.setText("Remove Selected Card");
        removeCardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCardMenuItemActionPerformed(evt);
            }
        });
        deckPopupMenu.add(removeCardMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        deckScrollPane.setComponentPopupMenu(deckPopupMenu);

        deckListbox.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        deckListbox.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        deckListbox.setInheritsPopupMenu(true);
        deckListbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deckListboxKeyPressed(evt);
            }
        });
        deckScrollPane.setViewportView(deckListbox);

        cardpoolScrollPane.setComponentPopupMenu(cardpoolPopupMenu);

        cardpoolListbox.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        cardpoolListbox.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cardpoolListbox.setInheritsPopupMenu(true);
        cardpoolListbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardpoolListboxKeyPressed(evt);
            }
        });
        cardpoolScrollPane.setViewportView(cardpoolListbox);

        deckLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        deckLabel.setText("Deck:");

        cardpoolLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cardpoolLabel.setText("Card Pool:");

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        searchLabel.setText("Search Card Pool:");

        acceptButton.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        acceptButton.setText("Accept Changes and Save");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N
        cancelButton.setText("Cancel Changes");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchLabel)
                    .addComponent(cardpoolLabel)
                    .addComponent(cardpoolScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(searchTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deckScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deckLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cardpoolLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deckLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardpoolScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deckScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        deck.getCards().clear();
        for(Object card : decklistModel.toArray()){
            try {
                deck.addCard((Card)card);
            } catch (Exception ex) {
                UI.getInstance().displayError(ex.getMessage());
                return;
            }
        }
        
        try {
            Logic.getInstance().saveDeck(deck);
        } catch (Exception ex) {
            UI.getInstance().displayError(ex.getMessage());
            return;
        }
        parent.update();
        this.dispose();
        UI.getInstance().displayInfo("Decklist updated successfully.");
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        filterCardpool(searchTextField.getText().toLowerCase());
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void addCardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCardMenuItemActionPerformed
        addCardToDecklist();
    }//GEN-LAST:event_addCardMenuItemActionPerformed

    private void removeCardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCardMenuItemActionPerformed
        removeCardFromDecklist();
    }//GEN-LAST:event_removeCardMenuItemActionPerformed

    private void cardpoolListboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardpoolListboxKeyPressed
        if(evt.getKeyCode() == KEYBOARD_KEYCODE && cardpoolListbox.getSelectedValue() != null){
            addCardToDecklist();
        }
    }//GEN-LAST:event_cardpoolListboxKeyPressed

    private void deckListboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deckListboxKeyPressed
        if(evt.getKeyCode() == KEYBOARD_KEYCODE && deckListbox.getSelectedValue() != null){
            removeCardFromDecklist();
        }
    }//GEN-LAST:event_deckListboxKeyPressed

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
            java.util.logging.Logger.getLogger(DecklistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DecklistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DecklistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DecklistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DecklistWindow dialog = new DecklistWindow(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JMenuItem addCardMenuItem;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cardpoolLabel;
    private javax.swing.JList cardpoolListbox;
    private javax.swing.JPopupMenu cardpoolPopupMenu;
    private javax.swing.JScrollPane cardpoolScrollPane;
    private javax.swing.JLabel deckLabel;
    private javax.swing.JList deckListbox;
    private javax.swing.JPopupMenu deckPopupMenu;
    private javax.swing.JScrollPane deckScrollPane;
    private javax.swing.JMenuItem removeCardMenuItem;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
