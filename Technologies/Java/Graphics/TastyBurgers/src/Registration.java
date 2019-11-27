/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oluwa
 */
public class Registration extends javax.swing.JFrame {

    /**
     * Creates new form Registration
     */
    public Registration() {
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

        header = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        form = new javax.swing.JPanel();
        usernameField = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        passwordField = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        phoneField = new javax.swing.JPanel();
        phoneLabel = new javax.swing.JLabel();
        phoneInput = new javax.swing.JTextField();
        sexField = new javax.swing.JPanel();
        sexLabel = new javax.swing.JLabel();
        sexInput = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        masthead = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setMaximumSize(new java.awt.Dimension(768, 500));
        setMinimumSize(new java.awt.Dimension(768, 500));
        setPreferredSize(new java.awt.Dimension(768, 500));
        setSize(new java.awt.Dimension(768, 500));

        header.setBackground(new java.awt.Color(255, 0, 0));
        header.setFont(new java.awt.Font("Tekton Pro", 0, 25)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Registration");
        header.setFocusable(false);
        header.setMaximumSize(new java.awt.Dimension(130, 30));
        header.setMinimumSize(new java.awt.Dimension(130, 30));
        header.setPreferredSize(new java.awt.Dimension(130, 30));
        header.setRequestFocusEnabled(false);
        header.setVerifyInputWhenFocusTarget(false);

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

        form.setPreferredSize(new java.awt.Dimension(384, 210));

        usernameField.setMaximumSize(new java.awt.Dimension(384, 40));
        usernameField.setMinimumSize(new java.awt.Dimension(384, 40));
        usernameField.setPreferredSize(new java.awt.Dimension(384, 40));

        usernameLabel.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setLabelFor(usernameInput);
        usernameLabel.setText("Username");
        usernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usernameLabel.setMaximumSize(new java.awt.Dimension(90, 20));
        usernameLabel.setMinimumSize(new java.awt.Dimension(90, 20));
        usernameLabel.setPreferredSize(new java.awt.Dimension(90, 20));
        usernameLabel.setRequestFocusEnabled(false);
        usernameLabel.setVerifyInputWhenFocusTarget(false);

        usernameInput.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        usernameInput.setForeground(new java.awt.Color(102, 102, 102));
        usernameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        usernameInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        usernameInput.setMaximumSize(new java.awt.Dimension(190, 20));
        usernameInput.setMinimumSize(new java.awt.Dimension(190, 20));
        usernameInput.setPreferredSize(new java.awt.Dimension(190, 20));

        javax.swing.GroupLayout usernameFieldLayout = new javax.swing.GroupLayout(usernameField);
        usernameField.setLayout(usernameFieldLayout);
        usernameFieldLayout.setHorizontalGroup(
            usernameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameFieldLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usernameFieldLayout.setVerticalGroup(
            usernameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usernameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        passwordField.setMaximumSize(new java.awt.Dimension(384, 40));
        passwordField.setMinimumSize(new java.awt.Dimension(384, 40));
        passwordField.setPreferredSize(new java.awt.Dimension(384, 40));

        passwordLabel.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setLabelFor(usernameInput);
        passwordLabel.setText("Password");
        passwordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        passwordLabel.setMaximumSize(new java.awt.Dimension(90, 20));
        passwordLabel.setMinimumSize(new java.awt.Dimension(90, 20));
        passwordLabel.setPreferredSize(new java.awt.Dimension(90, 20));
        passwordLabel.setRequestFocusEnabled(false);
        passwordLabel.setVerifyInputWhenFocusTarget(false);

        passwordInput.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        passwordInput.setForeground(new java.awt.Color(102, 102, 102));
        passwordInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        passwordInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        passwordInput.setMaximumSize(new java.awt.Dimension(190, 20));
        passwordInput.setMinimumSize(new java.awt.Dimension(190, 20));
        passwordInput.setPreferredSize(new java.awt.Dimension(190, 20));

        javax.swing.GroupLayout passwordFieldLayout = new javax.swing.GroupLayout(passwordField);
        passwordField.setLayout(passwordFieldLayout);
        passwordFieldLayout.setHorizontalGroup(
            passwordFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordFieldLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        passwordFieldLayout.setVerticalGroup(
            passwordFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passwordFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        phoneField.setMaximumSize(new java.awt.Dimension(384, 40));
        phoneField.setMinimumSize(new java.awt.Dimension(384, 40));
        phoneField.setPreferredSize(new java.awt.Dimension(384, 40));

        phoneLabel.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setLabelFor(usernameInput);
        phoneLabel.setText("Phone");
        phoneLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        phoneLabel.setMaximumSize(new java.awt.Dimension(90, 20));
        phoneLabel.setMinimumSize(new java.awt.Dimension(90, 20));
        phoneLabel.setPreferredSize(new java.awt.Dimension(90, 20));
        phoneLabel.setRequestFocusEnabled(false);
        phoneLabel.setVerifyInputWhenFocusTarget(false);

        phoneInput.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        phoneInput.setForeground(new java.awt.Color(102, 102, 102));
        phoneInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        phoneInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        phoneInput.setMaximumSize(new java.awt.Dimension(190, 20));
        phoneInput.setMinimumSize(new java.awt.Dimension(190, 20));
        phoneInput.setPreferredSize(new java.awt.Dimension(190, 20));

        javax.swing.GroupLayout phoneFieldLayout = new javax.swing.GroupLayout(phoneField);
        phoneField.setLayout(phoneFieldLayout);
        phoneFieldLayout.setHorizontalGroup(
            phoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phoneFieldLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        phoneFieldLayout.setVerticalGroup(
            phoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phoneFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phoneFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        sexField.setMaximumSize(new java.awt.Dimension(384, 40));
        sexField.setMinimumSize(new java.awt.Dimension(384, 40));

        sexLabel.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        sexLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sexLabel.setLabelFor(usernameInput);
        sexLabel.setText("Sex");
        sexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sexLabel.setMaximumSize(new java.awt.Dimension(90, 20));
        sexLabel.setMinimumSize(new java.awt.Dimension(90, 20));
        sexLabel.setPreferredSize(new java.awt.Dimension(90, 20));
        sexLabel.setRequestFocusEnabled(false);
        sexLabel.setVerifyInputWhenFocusTarget(false);

        sexInput.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        sexInput.setForeground(new java.awt.Color(102, 102, 102));
        sexInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sexInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sexInput.setMaximumSize(new java.awt.Dimension(190, 20));
        sexInput.setMinimumSize(new java.awt.Dimension(190, 20));
        sexInput.setPreferredSize(new java.awt.Dimension(190, 20));

        javax.swing.GroupLayout sexFieldLayout = new javax.swing.GroupLayout(sexField);
        sexField.setLayout(sexFieldLayout);
        sexFieldLayout.setHorizontalGroup(
            sexFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sexFieldLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(sexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(sexInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sexFieldLayout.setVerticalGroup(
            sexFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sexFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sexFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sexField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        registerButton.setBackground(new java.awt.Color(255, 255, 255));
        registerButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 0, 0));
        registerButton.setText("Register");
        registerButton.setBorder(null);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        registerButton.setMaximumSize(new java.awt.Dimension(100, 35));
        registerButton.setMinimumSize(new java.awt.Dimension(100, 35));
        registerButton.setName(""); // NOI18N
        registerButton.setOpaque(true);
        registerButton.setPreferredSize(new java.awt.Dimension(100, 35));

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Google Sans", 1, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 0, 0));
        loginButton.setText("Back <<");
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

        masthead.setMaximumSize(new java.awt.Dimension(280, 135));
        masthead.setMinimumSize(new java.awt.Dimension(280, 135));
        masthead.setPreferredSize(new java.awt.Dimension(280, 135));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(masthead, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masthead, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
        );

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel form;
    private javax.swing.JLabel header;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel masthead;
    private javax.swing.JPanel passwordField;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel phoneField;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel sexField;
    private javax.swing.JTextField sexInput;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel usernameField;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
