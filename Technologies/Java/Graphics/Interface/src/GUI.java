/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oluwa
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        toolbarMenuButton = new javax.swing.JToggleButton();
        header = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        poster = new java.awt.Canvas();
        musicTitle = new javax.swing.JLabel();
        musicArtiste = new javax.swing.JLabel();
        musicTimestamp = new javax.swing.JLabel();
        musicDuration = new javax.swing.JLabel();
        musicSeeker = new javax.swing.JSlider();
        loopButton = new javax.swing.JButton();
        previousSongButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        nextSongButton = new javax.swing.JButton();
        shuffleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Graphical User Interface");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        setForeground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(400, 550));
        setMinimumSize(new java.awt.Dimension(400, 550));
        setName("Java Graphical User Interface"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 550));

        toolbar.setBackground(new java.awt.Color(0, 102, 255));
        toolbar.setFloatable(false);
        toolbar.setForeground(new java.awt.Color(51, 51, 51));
        toolbar.setRollover(true);
        toolbar.setAlignmentX(0.0F);
        toolbar.setBorderPainted(false);
        toolbar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        toolbar.setMaximumSize(new java.awt.Dimension(400, 50));
        toolbar.setMinimumSize(new java.awt.Dimension(400, 50));
        toolbar.setName("Toolbar"); // NOI18N

        toolbarMenuButton.setBackground(new java.awt.Color(0, 102, 255));
        toolbarMenuButton.setFont(new java.awt.Font("Google Sans", 1, 30)); // NOI18N
        toolbarMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        toolbarMenuButton.setText("=");
        toolbarMenuButton.setToolTipText("Check the playlist");
        toolbarMenuButton.setBorderPainted(false);
        toolbarMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toolbarMenuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbarMenuButton.setMargin(new java.awt.Insets(0, 30, 0, 30));
        toolbarMenuButton.setMaximumSize(new java.awt.Dimension(50, 25));
        toolbarMenuButton.setMinimumSize(new java.awt.Dimension(50, 25));
        toolbarMenuButton.setName("Menu Button"); // NOI18N
        toolbarMenuButton.setPreferredSize(new java.awt.Dimension(50, 25));
        toolbar.add(toolbarMenuButton);
        toolbarMenuButton.getAccessibleContext().setAccessibleName("Menu Button");

        header.setBackground(new java.awt.Color(0, 102, 255));
        header.setFont(new java.awt.Font("Google Sans", 1, 25)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Now Playing");
        header.setAlignmentX(0.5F);
        header.setMaximumSize(new java.awt.Dimension(300, 40));
        header.setMinimumSize(new java.awt.Dimension(300, 40));
        header.setOpaque(true);
        header.setPreferredSize(new java.awt.Dimension(300, 40));
        toolbar.add(header);

        main.setBackground(new java.awt.Color(255, 0, 0));
        main.setForeground(new java.awt.Color(51, 51, 51));
        main.setAlignmentX(0.0F);
        main.setAlignmentY(0.0F);
        main.setFocusable(false);
        main.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        main.setMaximumSize(new java.awt.Dimension(400, 500));
        main.setMinimumSize(new java.awt.Dimension(400, 500));
        main.setPreferredSize(new java.awt.Dimension(400, 500));
        main.setRequestFocusEnabled(false);
        main.setVerifyInputWhenFocusTarget(false);

        poster.setBackground(new java.awt.Color(0, 0, 0));
        poster.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        poster.setEnabled(false);
        poster.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        poster.setMaximumSize(new java.awt.Dimension(200, 200));
        poster.setMinimumSize(new java.awt.Dimension(200, 200));
        poster.setName("Poster"); // NOI18N

        musicTitle.setBackground(new java.awt.Color(255, 255, 255));
        musicTitle.setFont(new java.awt.Font("Google Sans", 1, 30)); // NOI18N
        musicTitle.setForeground(new java.awt.Color(255, 255, 255));
        musicTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicTitle.setText("...");
        musicTitle.setAlignmentX(0.5F);
        musicTitle.setEnabled(false);
        musicTitle.setFocusable(false);
        musicTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        musicTitle.setMaximumSize(new java.awt.Dimension(400, 40));
        musicTitle.setMinimumSize(new java.awt.Dimension(400, 40));
        musicTitle.setName("Title"); // NOI18N
        musicTitle.setPreferredSize(new java.awt.Dimension(400, 40));
        musicTitle.setRequestFocusEnabled(false);
        musicTitle.setVerifyInputWhenFocusTarget(false);

        musicArtiste.setBackground(new java.awt.Color(255, 255, 255));
        musicArtiste.setFont(new java.awt.Font("Google Sans", 0, 24)); // NOI18N
        musicArtiste.setForeground(new java.awt.Color(102, 102, 102));
        musicArtiste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicArtiste.setText("...");
        musicArtiste.setAlignmentX(0.5F);
        musicArtiste.setEnabled(false);
        musicArtiste.setFocusable(false);
        musicArtiste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        musicArtiste.setMaximumSize(new java.awt.Dimension(400, 30));
        musicArtiste.setMinimumSize(new java.awt.Dimension(400, 30));
        musicArtiste.setPreferredSize(new java.awt.Dimension(400, 30));
        musicArtiste.setRequestFocusEnabled(false);
        musicArtiste.setVerifyInputWhenFocusTarget(false);

        musicTimestamp.setBackground(new java.awt.Color(255, 255, 255));
        musicTimestamp.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        musicTimestamp.setForeground(new java.awt.Color(33, 33, 33));
        musicTimestamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicTimestamp.setText("-:--");
        musicTimestamp.setEnabled(false);
        musicTimestamp.setFocusable(false);
        musicTimestamp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        musicTimestamp.setMaximumSize(new java.awt.Dimension(75, 40));
        musicTimestamp.setMinimumSize(new java.awt.Dimension(75, 40));
        musicTimestamp.setPreferredSize(new java.awt.Dimension(75, 40));
        musicTimestamp.setRequestFocusEnabled(false);
        musicTimestamp.setVerifyInputWhenFocusTarget(false);

        musicDuration.setBackground(new java.awt.Color(255, 255, 255));
        musicDuration.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        musicDuration.setForeground(new java.awt.Color(33, 33, 33));
        musicDuration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicDuration.setText("-:--");
        musicDuration.setAlignmentX(1.0F);
        musicDuration.setEnabled(false);
        musicDuration.setFocusable(false);
        musicDuration.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        musicDuration.setMaximumSize(new java.awt.Dimension(75, 40));
        musicDuration.setMinimumSize(new java.awt.Dimension(75, 40));
        musicDuration.setPreferredSize(new java.awt.Dimension(75, 40));
        musicDuration.setRequestFocusEnabled(false);
        musicDuration.setVerifyInputWhenFocusTarget(false);

        musicSeeker.setBackground(new java.awt.Color(255, 255, 255));
        musicSeeker.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        musicSeeker.setForeground(new java.awt.Color(102, 102, 102));
        musicSeeker.setPaintLabels(true);
        musicSeeker.setValue(0);
        musicSeeker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        musicSeeker.setMaximumSize(new java.awt.Dimension(355, 30));
        musicSeeker.setMinimumSize(new java.awt.Dimension(355, 30));
        musicSeeker.setPreferredSize(new java.awt.Dimension(355, 30));

        loopButton.setBackground(new java.awt.Color(255, 255, 255));
        loopButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        loopButton.setForeground(new java.awt.Color(33, 33, 33));
        loopButton.setToolTipText("Loop");
        loopButton.setBorder(null);
        loopButton.setBorderPainted(false);
        loopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loopButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loopButton.setMaximumSize(new java.awt.Dimension(40, 40));
        loopButton.setMinimumSize(new java.awt.Dimension(40, 40));
        loopButton.setPreferredSize(new java.awt.Dimension(40, 40));

        previousSongButton.setBackground(new java.awt.Color(255, 255, 255));
        previousSongButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        previousSongButton.setForeground(new java.awt.Color(33, 33, 33));
        previousSongButton.setToolTipText("Loop");
        previousSongButton.setBorder(null);
        previousSongButton.setBorderPainted(false);
        previousSongButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previousSongButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        previousSongButton.setMaximumSize(new java.awt.Dimension(40, 40));
        previousSongButton.setMinimumSize(new java.awt.Dimension(40, 40));
        previousSongButton.setPreferredSize(new java.awt.Dimension(40, 40));

        playButton.setBackground(new java.awt.Color(255, 255, 255));
        playButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        playButton.setForeground(new java.awt.Color(33, 33, 33));
        playButton.setToolTipText("Loop");
        playButton.setBorder(null);
        playButton.setBorderPainted(false);
        playButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        playButton.setMaximumSize(new java.awt.Dimension(40, 40));
        playButton.setMinimumSize(new java.awt.Dimension(40, 40));
        playButton.setPreferredSize(new java.awt.Dimension(40, 40));

        nextSongButton.setBackground(new java.awt.Color(255, 255, 255));
        nextSongButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        nextSongButton.setForeground(new java.awt.Color(33, 33, 33));
        nextSongButton.setToolTipText("Loop");
        nextSongButton.setBorder(null);
        nextSongButton.setBorderPainted(false);
        nextSongButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextSongButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nextSongButton.setMaximumSize(new java.awt.Dimension(40, 40));
        nextSongButton.setMinimumSize(new java.awt.Dimension(40, 40));
        nextSongButton.setPreferredSize(new java.awt.Dimension(40, 40));

        shuffleButton.setBackground(new java.awt.Color(255, 255, 255));
        shuffleButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        shuffleButton.setForeground(new java.awt.Color(33, 33, 33));
        shuffleButton.setToolTipText("Loop");
        shuffleButton.setBorder(null);
        shuffleButton.setBorderPainted(false);
        shuffleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shuffleButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        shuffleButton.setMaximumSize(new java.awt.Dimension(40, 40));
        shuffleButton.setMinimumSize(new java.awt.Dimension(40, 40));
        shuffleButton.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(musicTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicArtiste, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musicTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(musicDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(loopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(previousSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(nextSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(musicSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(musicTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicArtiste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musicTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musicDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicSeeker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        poster.getAccessibleContext().setAccessibleName("Poster");
        poster.getAccessibleContext().setAccessibleDescription("Poster");
        musicTitle.getAccessibleContext().setAccessibleName("Title");
        musicTitle.getAccessibleContext().setAccessibleDescription("The title of the current media/ song");
        musicArtiste.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        toolbar.getAccessibleContext().setAccessibleName("Toolbar");

        getAccessibleContext().setAccessibleDescription("Practical demonstration of a functional graphical user-interface (GUI) made with the Java programming language");
        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel header;
    private javax.swing.JButton loopButton;
    private javax.swing.JPanel main;
    private javax.swing.JLabel musicArtiste;
    private javax.swing.JLabel musicDuration;
    private javax.swing.JSlider musicSeeker;
    private javax.swing.JLabel musicTimestamp;
    private javax.swing.JLabel musicTitle;
    private javax.swing.JButton nextSongButton;
    private javax.swing.JButton playButton;
    private java.awt.Canvas poster;
    private javax.swing.JButton previousSongButton;
    private javax.swing.JButton shuffleButton;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JToggleButton toolbarMenuButton;
    // End of variables declaration//GEN-END:variables
}
