/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oluwa
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Home() {
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

        title = new javax.swing.JLabel();
        masthead = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tasty Burgers Delivery System");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 0, 0));
        setFont(new java.awt.Font("Tekton Pro", 0, 16)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(768, 500));
        setMinimumSize(new java.awt.Dimension(768, 500));
        setName("Home Window"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(768, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(768, 500));

        title.setBackground(new java.awt.Color(255, 255, 0));
        title.setFont(new java.awt.Font("Tekton Pro", 0, 30)); // NOI18N
        title.setForeground(new java.awt.Color(255, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Tasty Burgers Delivery System");
        title.setEnabled(false);
        title.setFocusable(false);
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setInheritsPopupMenu(false);
        title.setMaximumSize(new java.awt.Dimension(680, 40));
        title.setMinimumSize(new java.awt.Dimension(680, 40));
        title.setPreferredSize(new java.awt.Dimension(680, 40));

        masthead.setBackground(new java.awt.Color(255, 0, 0));
        masthead.setForeground(new java.awt.Color(255, 255, 255));
        masthead.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        masthead.setAlignmentX(0.5F);
        masthead.setEnabled(false);
        masthead.setFocusable(false);
        masthead.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        masthead.setMaximumSize(new java.awt.Dimension(500, 200));
        masthead.setMinimumSize(new java.awt.Dimension(500, 200));
        masthead.setPreferredSize(new java.awt.Dimension(500, 200));
        masthead.setRequestFocusEnabled(false);
        masthead.setVerifyInputWhenFocusTarget(false);

        header.setBackground(new java.awt.Color(255, 0, 0));
        header.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Welcome and have a wonderful burger experience");
        header.setAlignmentX(1.0F);
        header.setEnabled(false);
        header.setFocusable(false);
        header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        header.setInheritsPopupMenu(false);
        header.setMaximumSize(new java.awt.Dimension(500, 20));
        header.setMinimumSize(new java.awt.Dimension(500, 20));
        header.setPreferredSize(new java.awt.Dimension(500, 20));
        header.setRequestFocusEnabled(false);
        header.setVerifyInputWhenFocusTarget(false);

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 0, 0));
        loginButton.setText("Proceed");
        loginButton.setAlignmentX(1.0F);
        loginButton.setBorder(null);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loginButton.setMaximumSize(new java.awt.Dimension(100, 35));
        loginButton.setMinimumSize(new java.awt.Dimension(100, 35));
        loginButton.setName(""); // NOI18N
        loginButton.setOpaque(true);
        loginButton.setPreferredSize(new java.awt.Dimension(100, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(masthead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masthead, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("The digital delivery platform for the foodsnacks service: Tasty Burgers");

        pack();
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel header;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel masthead;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
