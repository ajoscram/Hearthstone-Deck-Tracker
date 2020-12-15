package ui;

import logic.decks.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import logic.*;

public class DeckEditWindow extends javax.swing.JFrame implements WindowListener{
    private Deck deck;
    private MainWindow parent;
    private DefaultTableModel matchesModel;
    
    public DeckEditWindow(Deck deck, MainWindow parent) {
        this.deck = deck;
        this.parent = parent;
        initComponents();
        this.addWindowListener(this);
        if(deck instanceof ArenaDeck)
            this.setTitle("Hearthstone Stats Tracker: Arena Run");
        else
            this.setTitle("Hearthstone Stats Tracker: Constructed Deck");
        classLabel.setIcon(UI.getClassBanner(deck.getHeroClass()));
        setIconImage((new ImageIcon(getClass().getResource("/resources/hs_icon.png"))).getImage());
        String data[][] ={};
        String col [] = {"Result", "Had Coin?", "Enemy Class", "Date"};
        matchesModel = new DefaultTableModel(data,col);
        matchesTable.setModel(matchesModel);
        update();
        moveWindowToLeft();
    }
    private DeckEditWindow(Frame parent) {
        initComponents();
    }
    
    private void moveWindowToLeft(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width-this.getSize().width,0);
    }
    
    //updates a semantic group of labels, the key parameter is available as a
    //constant in the deck class
    private void updateLabelGroup(JLabel winrateLabel, JLabel winsLabel, JLabel lossesLabel, String key){
        try{
            winrateLabel.setText(Integer.toString(Math.round(deck.getWLPercent(key)))+"%");
            winsLabel.setText(Integer.toString(deck.getWins(key))+" W");
            lossesLabel.setText(Integer.toString(deck.getLosses(key))+" L");
        }catch(Exception e){
            UI.getInstance().displayError(e.getMessage());
        }
    }
    
    private void insertMatchInTable(Match match){
        matchesModel.insertRow(0, new Object[]{});
        if(match.wasWON())
            matchesModel.setValueAt("Won", 0, 0);
        else
            matchesModel.setValueAt("Lost", 0, 0);
        if(match.hasCOIN())
            matchesModel.setValueAt("Yes", 0, 1);
        else
            matchesModel.setValueAt("No", 0, 1);
        matchesModel.setValueAt(match.getENEMY_HERO_CLASS(), 0, 2);
        matchesModel.setValueAt(new SimpleDateFormat(Match.DATE_FORMAT).format(match.getDATE()), 0, 3);
    }
    
    public final void update(){
        //updates labels for general data and matchups for the deck
        nameLabel.setText(deck.getName());
        curveAverageLabel.setText(Double.toString(deck.getCurveAverage()));       
        updateLabelGroup(totalWinrateLabel, totalWinsLabel, totalLossesLabel, Deck.TOTAL);
        updateLabelGroup(coinWinrateLabel, coinWinsLabel, coinLossesLabel, Deck.COIN);
        updateLabelGroup(noCoinWinrateLabel, noCoinWinsLabel, noCoinLossesLabel, Deck.NO_COIN);
        updateLabelGroup(druidWinrateLabel, druidWinsLabel, druidLossesLabel, Deck.DRUID);
        updateLabelGroup(hunterWinrateLabel, hunterWinsLabel, hunterLossesLabel, Deck.HUNTER);
        updateLabelGroup(mageWinrateLabel, mageWinsLabel, mageLossesLabel, Deck.MAGE);
        updateLabelGroup(paladinWinrateLabel, paladinWinsLabel, paladinLossesLabel, Deck.PALADIN);
        updateLabelGroup(priestWinrateLabel, priestWinsLabel, priestLossesLabel, Deck.PRIEST);
        updateLabelGroup(rogueWinrateLabel, rogueWinsLabel, rogueLossesLabel, Deck.ROGUE);
        updateLabelGroup(shamanWinrateLabel, shamanWinsLabel, shamanLossesLabel, Deck.SHAMAN);
        updateLabelGroup(warlockWinrateLabel, warlockWinsLabel, warlockLossesLabel, Deck.WARLOCK);
        updateLabelGroup(warriorWinrateLabel, warriorWinsLabel, warriorLossesLabel, Deck.WARRIOR);
        
        while(matchesModel.getRowCount() != 0){
            matchesModel.removeRow(0);
        }
        for(Match match : deck.getMatches())
            insertMatchInTable(match);
        parent.update();
    }

    @Override
    public void windowOpened(WindowEvent we) {
        parent.setVisible(false);
        this.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent we) {
        parent.setVisible(true);
        this.dispose();
    }

    //These had to be implemented because of the WindowListener interface,
    //but are not required.
    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePopupMenu = new javax.swing.JPopupMenu();
        changeNameMenuItem = new javax.swing.JMenuItem();
        invertTitleColorMenuItem = new javax.swing.JMenuItem();
        decklistPopupMenu = new javax.swing.JPopupMenu();
        editDeckMenuItem = new javax.swing.JMenuItem();
        matchesPopupMenu = new javax.swing.JPopupMenu();
        addMatchMenuItem = new javax.swing.JMenuItem();
        deleteMatchMenuItem = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        nameClassPane = new javax.swing.JLayeredPane();
        nameLabel = new javax.swing.JLabel();
        curveAverageLabel = new javax.swing.JLabel();
        manaCrystalLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        generalLabel = new javax.swing.JLabel();
        generalPane = new javax.swing.JLayeredPane();
        totalWinrateLabel = new javax.swing.JLabel();
        totalWinsLabel = new javax.swing.JLabel();
        totalLossesLabel = new javax.swing.JLabel();
        totalWinPercentageLabel = new javax.swing.JLabel();
        coinButton = new javax.swing.JButton();
        coinWinsLabel = new javax.swing.JLabel();
        coinLossesLabel = new javax.swing.JLabel();
        coinWinrateLabel = new javax.swing.JLabel();
        noCoinButton = new javax.swing.JButton();
        noCoinWinsLabel = new javax.swing.JLabel();
        noCoinLossesLabel = new javax.swing.JLabel();
        noCoinWinrateLabel = new javax.swing.JLabel();
        matchupsLabel = new javax.swing.JLabel();
        matchupsPane = new javax.swing.JLayeredPane();
        druidButton = new javax.swing.JButton();
        druidWinsLabel = new javax.swing.JLabel();
        druidLossesLabel = new javax.swing.JLabel();
        druidWinrateLabel = new javax.swing.JLabel();
        hunterButton = new javax.swing.JButton();
        hunterWinsLabel = new javax.swing.JLabel();
        hunterLossesLabel = new javax.swing.JLabel();
        hunterWinrateLabel = new javax.swing.JLabel();
        mageButton = new javax.swing.JButton();
        mageWinsLabel = new javax.swing.JLabel();
        mageLossesLabel = new javax.swing.JLabel();
        mageWinrateLabel = new javax.swing.JLabel();
        paladinButton = new javax.swing.JButton();
        paladinWinsLabel = new javax.swing.JLabel();
        paladinLossesLabel = new javax.swing.JLabel();
        paladinWinrateLabel = new javax.swing.JLabel();
        priestButton = new javax.swing.JButton();
        priestWinsLabel = new javax.swing.JLabel();
        priestLossesLabel = new javax.swing.JLabel();
        priestWinrateLabel = new javax.swing.JLabel();
        rogueButton = new javax.swing.JButton();
        rogueWinsLabel = new javax.swing.JLabel();
        rogueLossesLabel = new javax.swing.JLabel();
        rogueWinrateLabel = new javax.swing.JLabel();
        shamanButton = new javax.swing.JButton();
        shamanWinsLabel = new javax.swing.JLabel();
        shamanLossesLabel = new javax.swing.JLabel();
        shamanWinrateLabel = new javax.swing.JLabel();
        warlockButton = new javax.swing.JButton();
        warlockWinsLabel = new javax.swing.JLabel();
        warlockLossesLabel = new javax.swing.JLabel();
        warlockWinrateLabel = new javax.swing.JLabel();
        warriorButton = new javax.swing.JButton();
        warriorWinsLabel = new javax.swing.JLabel();
        warriorLossesLabel = new javax.swing.JLabel();
        warriorWinrateLabel = new javax.swing.JLabel();
        matchesLabel = new javax.swing.JLabel();
        decklistButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        matchesTable = new javax.swing.JTable();
        decklistButton1 = new javax.swing.JButton();

        titlePopupMenu.setInvoker(nameClassPane);

        changeNameMenuItem.setText("Change Name");
        changeNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameMenuItemActionPerformed(evt);
            }
        });
        titlePopupMenu.add(changeNameMenuItem);

        invertTitleColorMenuItem.setText("Invert Colors");
        invertTitleColorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertTitleColorMenuItemActionPerformed(evt);
            }
        });
        titlePopupMenu.add(invertTitleColorMenuItem);

        editDeckMenuItem.setText("Edit Deck");
        decklistPopupMenu.add(editDeckMenuItem);

        addMatchMenuItem.setText("Add Match");
        addMatchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMatchMenuItemActionPerformed(evt);
            }
        });
        matchesPopupMenu.add(addMatchMenuItem);

        deleteMatchMenuItem.setText("Delete Selected Match");
        deleteMatchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMatchMenuItemActionPerformed(evt);
            }
        });
        matchesPopupMenu.add(deleteMatchMenuItem);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hearthstone Stat Tracker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(560, 900));
        setResizable(false);

        nameClassPane.setComponentPopupMenu(titlePopupMenu);

        nameLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLabel.setText("Deck Name");

        curveAverageLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        curveAverageLabel.setForeground(new java.awt.Color(255, 255, 255));
        curveAverageLabel.setText("14.20");
        curveAverageLabel.setToolTipText("Mana average for the deck's curve.");

        manaCrystalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mana_crystal.png"))); // NOI18N
        manaCrystalLabel.setText("jLabel1");
        manaCrystalLabel.setToolTipText("Mana average for the deck's curve.");

        classLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shaman_title.png"))); // NOI18N

        javax.swing.GroupLayout nameClassPaneLayout = new javax.swing.GroupLayout(nameClassPane);
        nameClassPane.setLayout(nameClassPaneLayout);
        nameClassPaneLayout.setHorizontalGroup(
            nameClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameClassPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addComponent(manaCrystalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(curveAverageLabel)
                .addContainerGap())
            .addGroup(nameClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nameClassPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(classLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        nameClassPaneLayout.setVerticalGroup(
            nameClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameClassPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nameClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(curveAverageLabel)
                    .addComponent(manaCrystalLabel))
                .addContainerGap())
            .addGroup(nameClassPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(nameClassPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(classLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        nameClassPane.setLayer(nameLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        nameClassPane.setLayer(curveAverageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        nameClassPane.setLayer(manaCrystalLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        nameClassPane.setLayer(classLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        generalLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        generalLabel.setText("General:");

        generalPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        totalWinrateLabel.setForeground(new java.awt.Color(0, 153, 51));
        totalWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalWinrateLabel.setText("54%");

        totalWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        totalWinsLabel.setText("12 W");

        totalLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        totalLossesLabel.setText("11 L");

        totalWinPercentageLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        totalWinPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalWinPercentageLabel.setText("Win %");

        coinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/coin.png"))); // NOI18N
        coinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        coinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        coinWinsLabel.setText("12 W");

        coinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        coinLossesLabel.setText("11 L");

        coinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        coinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coinWinrateLabel.setText("54%");

        noCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/no_coin.png"))); // NOI18N
        noCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        noCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        noCoinWinsLabel.setText("12 W");

        noCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        noCoinLossesLabel.setText("11 L");

        noCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        noCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCoinWinrateLabel.setText("54%");

        javax.swing.GroupLayout generalPaneLayout = new javax.swing.GroupLayout(generalPane);
        generalPane.setLayout(generalPaneLayout);
        generalPaneLayout.setHorizontalGroup(
            generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPaneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addComponent(totalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLossesLabel)
                            .addComponent(totalWinsLabel)))
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(totalWinPercentageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(coinWinrateLabel))
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addComponent(coinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coinWinsLabel)
                            .addComponent(coinLossesLabel))))
                .addGap(119, 119, 119)
                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addComponent(noCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noCoinWinsLabel)
                            .addComponent(noCoinLossesLabel)))
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(noCoinWinrateLabel)))
                .addContainerGap())
        );
        generalPaneLayout.setVerticalGroup(
            generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPaneLayout.createSequentialGroup()
                        .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPaneLayout.createSequentialGroup()
                                .addComponent(totalWinsLabel)
                                .addGap(19, 19, 19)
                                .addComponent(totalLossesLabel))
                            .addComponent(totalWinrateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalWinPercentageLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPaneLayout.createSequentialGroup()
                                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(generalPaneLayout.createSequentialGroup()
                                        .addComponent(noCoinWinsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(noCoinLossesLabel))
                                    .addComponent(noCoinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noCoinWinrateLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPaneLayout.createSequentialGroup()
                                .addGroup(generalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(generalPaneLayout.createSequentialGroup()
                                        .addComponent(coinWinsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(coinLossesLabel))
                                    .addComponent(coinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coinWinrateLabel)))))
                .addContainerGap())
        );
        generalPane.setLayer(totalWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(totalWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(totalLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(totalWinPercentageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(coinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(coinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(coinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(coinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(noCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(noCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(noCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        generalPane.setLayer(noCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        matchupsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        matchupsLabel.setText("Match-ups:");

        matchupsPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        druidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/druid_icon.png"))); // NOI18N
        druidButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        druidWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        druidWinsLabel.setText("12 W");

        druidLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        druidLossesLabel.setText("11 L");

        druidWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        druidWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        druidWinrateLabel.setText("54%");

        hunterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        hunterButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        hunterWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        hunterWinsLabel.setText("12 W");

        hunterLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        hunterLossesLabel.setText("11 L");

        hunterWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        hunterWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hunterWinrateLabel.setText("54%");

        mageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mage_icon.png"))); // NOI18N
        mageButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        mageWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        mageWinsLabel.setText("12 W");

        mageLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        mageLossesLabel.setText("11 L");

        mageWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        mageWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mageWinrateLabel.setText("54%");

        paladinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/paladin_icon.png"))); // NOI18N
        paladinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        paladinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        paladinWinsLabel.setText("12 W");

        paladinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        paladinLossesLabel.setText("11 L");

        paladinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        paladinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paladinWinrateLabel.setText("54%");

        priestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/priest_icon.png"))); // NOI18N
        priestButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        priestWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        priestWinsLabel.setText("12 W");

        priestLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        priestLossesLabel.setText("11 L");

        priestWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        priestWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priestWinrateLabel.setText("54%");

        rogueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rogue_icon.png"))); // NOI18N
        rogueButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        rogueWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        rogueWinsLabel.setText("12 W");

        rogueLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        rogueLossesLabel.setText("11 L");

        rogueWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        rogueWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rogueWinrateLabel.setText("54%");

        shamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shaman_icon.png"))); // NOI18N
        shamanButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        shamanWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        shamanWinsLabel.setText("12 W");

        shamanLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        shamanLossesLabel.setText("11 L");

        shamanWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        shamanWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shamanWinrateLabel.setText("54%");

        warlockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warlock_icon.png"))); // NOI18N
        warlockButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        warlockWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        warlockWinsLabel.setText("12 W");

        warlockLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        warlockLossesLabel.setText("11 L");

        warlockWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        warlockWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warlockWinrateLabel.setText("54%");

        warriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warrior_icon.png"))); // NOI18N
        warriorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        warriorWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        warriorWinsLabel.setText("12 W");

        warriorLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        warriorLossesLabel.setText("11 L");

        warriorWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        warriorWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warriorWinrateLabel.setText("54%");

        javax.swing.GroupLayout matchupsPaneLayout = new javax.swing.GroupLayout(matchupsPane);
        matchupsPane.setLayout(matchupsPaneLayout);
        matchupsPaneLayout.setHorizontalGroup(
            matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchupsPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(druidButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(druidLossesLabel)
                            .addComponent(druidWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(paladinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paladinLossesLabel)
                            .addComponent(paladinWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(shamanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shamanLossesLabel)
                            .addComponent(shamanWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paladinWinrateLabel)
                            .addComponent(druidWinrateLabel)
                            .addComponent(shamanWinrateLabel))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(priestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priestLossesLabel)
                            .addComponent(priestWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(hunterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hunterLossesLabel)
                            .addComponent(hunterWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(warlockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warlockWinsLabel)
                            .addComponent(warlockLossesLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warlockWinrateLabel)
                            .addComponent(hunterWinrateLabel)
                            .addComponent(priestWinrateLabel))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(rogueButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rogueLossesLabel)
                            .addComponent(rogueWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(warriorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warriorLossesLabel)
                            .addComponent(warriorWinsLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mageWinrateLabel)
                            .addComponent(rogueWinrateLabel)
                            .addComponent(warriorWinrateLabel)))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addComponent(mageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mageLossesLabel)
                            .addComponent(mageWinsLabel))))
                .addContainerGap())
        );
        matchupsPaneLayout.setVerticalGroup(
            matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchupsPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(druidWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(druidLossesLabel))
                            .addComponent(druidButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(druidWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(hunterWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hunterLossesLabel))
                            .addComponent(hunterButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hunterWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(mageWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mageLossesLabel))
                            .addComponent(mageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mageWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(paladinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paladinLossesLabel))
                            .addComponent(paladinButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paladinWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(priestWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priestLossesLabel))
                            .addComponent(priestButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priestWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(rogueWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rogueLossesLabel))
                            .addComponent(rogueButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rogueWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(shamanWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shamanLossesLabel))
                            .addComponent(shamanButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shamanWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(warlockWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(warlockLossesLabel))
                            .addComponent(warlockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warlockWinrateLabel))
                    .addGroup(matchupsPaneLayout.createSequentialGroup()
                        .addGroup(matchupsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matchupsPaneLayout.createSequentialGroup()
                                .addComponent(warriorWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(warriorLossesLabel))
                            .addComponent(warriorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warriorWinrateLabel)))
                .addContainerGap())
        );
        matchupsPane.setLayer(druidButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(druidWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(druidLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(druidWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(hunterButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(hunterWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(hunterLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(hunterWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(mageButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(mageWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(mageLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(mageWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(paladinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(paladinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(paladinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(paladinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(priestButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(priestWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(priestLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(priestWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(rogueButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(rogueWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(rogueLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(rogueWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(shamanButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(shamanWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(shamanLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(shamanWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warlockButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warlockWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warlockLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warlockWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warriorButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warriorWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warriorLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        matchupsPane.setLayer(warriorWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        matchesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        matchesLabel.setText("Match History:");

        decklistButton.setFont(new java.awt.Font("Belwe Bd BT", 0, 12)); // NOI18N
        decklistButton.setText("Manage Decklist");
        decklistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decklistButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setComponentPopupMenu(matchesPopupMenu);

        matchesTable.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        matchesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        matchesTable.setComponentPopupMenu(matchesPopupMenu);
        jScrollPane1.setViewportView(matchesTable);

        decklistButton1.setFont(new java.awt.Font("Belwe Bd BT", 0, 12)); // NOI18N
        decklistButton1.setText("Filter Data");
        decklistButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decklistButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generalPane)
                    .addComponent(nameClassPane)
                    .addComponent(matchupsPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(decklistButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decklistButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matchupsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matchesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameClassPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(generalLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(decklistButton)
                            .addComponent(decklistButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(matchupsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchupsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(matchesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invertTitleColorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertTitleColorMenuItemActionPerformed
        if(nameLabel.getForeground() == Color.black){
            nameLabel.setForeground(Color.white);
            curveAverageLabel.setForeground(Color.white);
        }
        else{
            nameLabel.setForeground(Color.black);
            curveAverageLabel.setForeground(Color.black);
        }
    }//GEN-LAST:event_invertTitleColorMenuItemActionPerformed

    private void changeNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameMenuItemActionPerformed
        ChangeNameDialog changeNameDialog = new ChangeNameDialog(deck, this, true);
        changeNameDialog.setVisible(true);
    }//GEN-LAST:event_changeNameMenuItemActionPerformed

    private void addMatchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMatchMenuItemActionPerformed
        AddMatchWindow addMatchWindow = new AddMatchWindow(deck, this, true);
        addMatchWindow.setVisible(true);
    }//GEN-LAST:event_addMatchMenuItemActionPerformed

    private void deleteMatchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMatchMenuItemActionPerformed
        try {
            if(matchesTable.getSelectedRow() == -1)
                throw new Exception("No match was selected.");
            deck.removeMatch(deck.getMatch(((String)matchesTable.getValueAt(matchesTable.getSelectedRow(), 0)).equals("Won"),
                                           ((String)matchesTable.getValueAt(matchesTable.getSelectedRow(), 1)).equals("Yes"),
                                           (String)matchesTable.getValueAt(matchesTable.getSelectedRow(), 2),
                                           new SimpleDateFormat(Match.DATE_FORMAT).parse((String)matchesTable.getValueAt(matchesTable.getSelectedRow(), 3))));
            Logic.getInstance().saveDeck(deck);
        } catch (Exception ex) {
            UI.getInstance().displayError(ex.getMessage());
            return;
        }
        UI.getInstance().displayInfo("Match deleted.");
        update();
    }//GEN-LAST:event_deleteMatchMenuItemActionPerformed

    private void decklistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decklistButtonActionPerformed
        DecklistWindow decklistWindow = new DecklistWindow(deck, this, true);
        decklistWindow.setVisible(true);
    }//GEN-LAST:event_decklistButtonActionPerformed

    private void decklistButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decklistButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decklistButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DeckEditWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeckEditWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeckEditWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeckEditWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeckEditWindow dialog = new DeckEditWindow(new javax.swing.JFrame());
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
    private javax.swing.JMenuItem addMatchMenuItem;
    private javax.swing.JMenuItem changeNameMenuItem;
    private javax.swing.JLabel classLabel;
    private javax.swing.JButton coinButton;
    private javax.swing.JLabel coinLossesLabel;
    private javax.swing.JLabel coinWinrateLabel;
    private javax.swing.JLabel coinWinsLabel;
    private javax.swing.JLabel curveAverageLabel;
    private javax.swing.JButton decklistButton;
    private javax.swing.JButton decklistButton1;
    private javax.swing.JPopupMenu decklistPopupMenu;
    private javax.swing.JMenuItem deleteMatchMenuItem;
    private javax.swing.JButton druidButton;
    private javax.swing.JLabel druidLossesLabel;
    private javax.swing.JLabel druidWinrateLabel;
    private javax.swing.JLabel druidWinsLabel;
    private javax.swing.JMenuItem editDeckMenuItem;
    private javax.swing.JLabel generalLabel;
    private javax.swing.JLayeredPane generalPane;
    private javax.swing.JButton hunterButton;
    private javax.swing.JLabel hunterLossesLabel;
    private javax.swing.JLabel hunterWinrateLabel;
    private javax.swing.JLabel hunterWinsLabel;
    private javax.swing.JMenuItem invertTitleColorMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mageButton;
    private javax.swing.JLabel mageLossesLabel;
    private javax.swing.JLabel mageWinrateLabel;
    private javax.swing.JLabel mageWinsLabel;
    private javax.swing.JLabel manaCrystalLabel;
    private javax.swing.JLabel matchesLabel;
    private javax.swing.JPopupMenu matchesPopupMenu;
    private javax.swing.JTable matchesTable;
    private javax.swing.JLabel matchupsLabel;
    private javax.swing.JLayeredPane matchupsPane;
    private javax.swing.JLayeredPane nameClassPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton noCoinButton;
    private javax.swing.JLabel noCoinLossesLabel;
    private javax.swing.JLabel noCoinWinrateLabel;
    private javax.swing.JLabel noCoinWinsLabel;
    private javax.swing.JButton paladinButton;
    private javax.swing.JLabel paladinLossesLabel;
    private javax.swing.JLabel paladinWinrateLabel;
    private javax.swing.JLabel paladinWinsLabel;
    private javax.swing.JButton priestButton;
    private javax.swing.JLabel priestLossesLabel;
    private javax.swing.JLabel priestWinrateLabel;
    private javax.swing.JLabel priestWinsLabel;
    private javax.swing.JButton rogueButton;
    private javax.swing.JLabel rogueLossesLabel;
    private javax.swing.JLabel rogueWinrateLabel;
    private javax.swing.JLabel rogueWinsLabel;
    private javax.swing.JButton shamanButton;
    private javax.swing.JLabel shamanLossesLabel;
    private javax.swing.JLabel shamanWinrateLabel;
    private javax.swing.JLabel shamanWinsLabel;
    private javax.swing.JPopupMenu titlePopupMenu;
    private javax.swing.JLabel totalLossesLabel;
    private javax.swing.JLabel totalWinPercentageLabel;
    private javax.swing.JLabel totalWinrateLabel;
    private javax.swing.JLabel totalWinsLabel;
    private javax.swing.JButton warlockButton;
    private javax.swing.JLabel warlockLossesLabel;
    private javax.swing.JLabel warlockWinrateLabel;
    private javax.swing.JLabel warlockWinsLabel;
    private javax.swing.JButton warriorButton;
    private javax.swing.JLabel warriorLossesLabel;
    private javax.swing.JLabel warriorWinrateLabel;
    private javax.swing.JLabel warriorWinsLabel;
    // End of variables declaration//GEN-END:variables
}
