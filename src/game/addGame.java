package game;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mfkaf
 */
public class addGame extends javax.swing.JFrame {
    private int flag = 1;
    private int id_game;
    private String nama;
    private String deskripsi;
    private int developer;
    private String img;
    private File fileimg;
    private String path;
    private game.JPanelCard MainFrame;
    static dbConnection db = new dbConnection();
    private Map<String, Integer> columnDataMap = new HashMap<>();
    /**
     * Creates new form addGame
     */
    public addGame() {}
    public addGame(game.JPanelCard MainFrame) throws SQLException {
        initComponents();
        this.MainFrame = MainFrame;
        combobox();
        flag = 1;
        ButtonAdd.setText("Add");
    }
    public addGame(int id_game, game.JPanelCard MainFrame) throws SQLException {
        initComponents();
        this.id_game = id_game;
        this.MainFrame = MainFrame;
        flag = 0;
        
        ButtonAdd.setText("Edit");
        
        combobox();
      
        
        try{
            String sql = "SELECT * FROM game WHERE id_game = '"+this.id_game+"'";
            ResultSet res = db.selectQuery(sql);
            while (res.next()) {
                this.id_game = res.getInt("id_game");
                this.nama = res.getString("nama");
                this.deskripsi = res.getString("deskripsi");
                this.developer = res.getInt("dev");
                this.img = res.getString("foto");
            }
            for (Map.Entry<String, Integer> entry : columnDataMap.entrySet()) {
                if (entry.getValue() == this.developer) {
                    jComboBox1.setSelectedItem(entry.getKey());
                    break;
                }
            }
                   
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        this.fileimg = new File("src/image/"+ img);
        jnama.setText(this.nama);
        jdeskripsi.setText(this.deskripsi);
        labelpath.setText(this.img);
        
    }
    
    public void upload(String img){
        try {
            Path copy = Paths.get("src/image/"+img);
            Path originalPath = Paths.get(this.fileimg.getAbsolutePath());
            Files.copy(originalPath, copy, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void combobox() throws SQLException
    {
        
        try {
            String query = "SELECT id_dev, nama FROM developer";
            ResultSet res = db.selectQuery(query);
            while (res.next()) {
            int id = res.getInt("id_dev");
            String name = res.getString("nama");
            columnDataMap.put(name, id);
            jComboBox1.addItem(name);
        }
        
        } catch (SQLException ex) {
            System.out.println(ex);
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

        jnama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdeskripsi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonImage = new javax.swing.JButton();
        labelpath = new javax.swing.JLabel();
        ButtonAdd = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnamaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama");

        jLabel2.setText("Deskripsi");

        jLabel3.setText("Developer");

        buttonImage.setText("Upload Image");
        buttonImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageActionPerformed(evt);
            }
        });

        ButtonAdd.setText("Add");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonImage)
                        .addGap(3, 3, 3)
                        .addComponent(labelpath, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAdd)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jnama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jdeskripsi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonImage)
                    .addComponent(labelpath, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(ButtonAdd)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnamaActionPerformed

    private void buttonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageActionPerformed
        // TODO add your handling code here:
         JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg","bmp","webp");
        file.addChoosableFileFilter(filter);
        file.setAcceptAllFileFilterUsed(false);
        int res = file.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
          this.fileimg = file.getSelectedFile();
          this.path =  fileimg.getName();
        }
        labelpath.setText(this.path);
        
//        JFileChooser filechooser = new JFileChooser();
//        
//        int result = filechooser.showOpenDialog(null);
//        if(result == JFileChooser.APPROVE_OPTION)
//        {
//            File selectedFile = filechooser.getSelectedFile();
//            try{
//                Path projectDir = Paths.get(System.getProperty("user.dir"));
//                String pathstring = projectDir + File.separator + "src";
//                Path pathfinal = Paths.get(pathstring);
//                Path destDir = pathfinal.resolve("image");
//                Files.createDirectories(destDir);
//                Path destFile = destDir.resolve(selectedFile.getName());
//                Files.copy(selectedFile.toPath(),destFile,StandardCopyOption.REPLACE_EXISTING);
//                String filename = selectedFile.getName();
//                String nama = jTextField1.getText();
//                String deskripsi = jTextField2.getText();
//                String developer = jTextField3.getText();
//                card = new Card(nama, deskripsi, developer, filename);
//                System.out.println(filename);
//                JPanelCard.getInstance().addPanel(card);
//                JPanelCard.getInstance().setPanel();
//                JOptionPane.showMessageDialog(null, "Berhasil");
//            } catch(IOException e){
//                JOptionPane.showMessageDialog(null, "error");
//            }
//            setVisible(false);
//        }
    }//GEN-LAST:event_buttonImageActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        // TODO add your handling code here:
        nama = jnama.getText();
        deskripsi = jdeskripsi.getText();
        String selectedName = (String) jComboBox1.getSelectedItem();
        developer = columnDataMap.get(selectedName);
        this.img = this.path;
        upload(this.img);
        if(flag == 1)
        {
            
            try{
                String sql = "INSERT INTO `game` (`id_game`, `foto`, `nama`, `deskripsi`, `dev`) VALUES (null,'"+img+"','"+nama+"','"+deskripsi+"','"+developer+"')";
                db.stmt.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                this.dispose();
                this.MainFrame.setPanel();
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else
        {
            try{
                String sql = "UPDATE `game` SET nama = '"+nama+"', deskripsi= '"+deskripsi+"', dev = '"+developer+"', foto = '"+img+"' WHERE id_game = '"+id_game+"'";
                db.stmt.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                this.dispose();
                this.MainFrame.setPanel();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//            developer = res.getInt("id_dev");
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(addGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton buttonImage;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jdeskripsi;
    private javax.swing.JTextField jnama;
    private javax.swing.JLabel labelpath;
    // End of variables declaration//GEN-END:variables
}
