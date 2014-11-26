/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Auxiliares.Conexion;
import Colecciones.*;
import Objetos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Rodrigo
 */
public class GUI_Usuario extends javax.swing.JInternalFrame {   
    private ArrayList<String> items = new ArrayList<String>();        
    private Conexion r_con;
    private Usuarios usuarios;
    private Perfiles perfiles;
    private int id_perfil;
    private String modo;// si es ventana alta,baja o modificacion
    private DefaultTableModel modelo = new DefaultTableModel();
    private String usuarioLogueado;
    
    public GUI_Usuario(String modo,Usuario usr,Conexion con) {
        initComponents();        
        r_con=con;
        perfiles = new Perfiles(r_con);
        usuarios = new Usuarios(r_con);        
        usuarioLogueado=r_con.getUsuario();
        cargarComboBox();
        //cargarTabla(1);
        jTable1.setEnabled(false);        
        jTextField4.setEnabled(false);
        this.modo=modo;
        tipoVentana(); 
        jTextField1.requestFocusInWindow();
    }
       
    private void completarCampos(String usr){        
        Usuarios usuarios = new Usuarios(r_con);
        Usuario u = usuarios.getUsuario(usr);
        
        jTextField1.setText(u.getNombre());
        jTextField2.setText(u.getApellido());             
        jPasswordField1.setText(u.getContraseña());
        jPasswordField2.setText(u.getContraseña());
        jLabel9.setIcon(null);
        jLabel10.setIcon(null);      
 
        Vector<Vector<String>>vv=perfiles.getTablaPerfiles();                        
        int pos=0;int cont=0;
        for(Vector<String>aux:vv){
            if(aux.elementAt(1).equals(u.getIdPerfil().getDescripcion()))
                pos=cont;
            cont++;
        }
        jComboBox1.setSelectedIndex(pos);        
    }
    
    private void tipoVentana(){        
        if(modo.equals("Baja")){
            habilitarCampos(false);                                    
            jButton2.setText("Eliminar");
            jLabel7.setText("Baja de Usuario");
        }
        if(modo.equals("Modificar")){
            habilitarCampos(false);                                    
            jButton2.setText("Modificar");
            jLabel7.setText("Modificar Usuario");
        }
    }
    
    public void cargarComboBox(){
        
        jComboBox1.removeAllItems();        
        Vector<Vector<String>>v = perfiles.getTablaPerfiles();
        
        for(Vector<String>a:v){
            jComboBox1.addItem(a.elementAt(0)+" - "+a.elementAt(1));
            
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios.");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        jTextField1.setToolTipText("");

        jTextField2.setToolTipText("");

        jTextField3.setToolTipText("");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });

        jPasswordField2.setText("jPasswordField1");
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });

        jTextField4.setToolTipText("");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setToolTipText("Para poder modificar la tabla debe crear un nuevo perfil");
        jScrollPane1.setViewportView(jTable1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton3.setText("Nuevo Perfil");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Permisos del Perfil:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Usuario:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Perfil:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nuevo Usuario:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Repetir Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jButton2)
                                .addGap(149, 149, 149)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //r_con.cierraConexion();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void alta(){
        Usuario u=new Usuario();                
        Perfil p=new Perfil();
        String contraseña,rep_contraseña;contraseña=rep_contraseña="";
        if(camposNecesarios()){        
            u.setUsuario(jTextField3.getText());
            u.setApellido(jTextField2.getText());
            u.setNombre(jTextField1.getText());            
            contraseña=jPasswordField1.getText();
            rep_contraseña=jPasswordField2.getText();                               
            int item=jComboBox1.getSelectedIndex();
            Vector<Vector<String>>vv=perfiles.getTablaPerfiles();                        
            p.setId(Integer.parseInt(vv.elementAt(item).elementAt(0)));
            p.setDescripcion(perfiles.getDescripcion(p.getId()));
            u.setPerfil(p);                                                    
                           
            if(contraseña.equals(rep_contraseña)){ 
                u.setContraseña(jPasswordField2.getText());
                if (usuarios.insertar(u)){                                
                    //Auditoria auditoria=new Auditoria(r_con);
                    //auditoria.insertarUsuario(usuarioLogueado,u,"alta");
                }
                limpiarForm();                        
            }
            else
            {
                JOptionPane.showMessageDialog(null,"La contraseña debe coincidir");
            }
        } 
    }
    
    public void baja(){
        try{
            if(camposNecesarios()){
                if(usuarios.existe(jTextField3.getText())){
                    Usuario u=usuarios.getUsuario(jTextField3.getText());
                    usuarios.eliminar(jTextField3.getText());
                    //Auditoria auditoria=new Auditoria(r_con);
                    u.setExiste(false);
                    //auditoria.insertarUsuario(usuarioLogueado,u,"baja");
                    limpiarForm();
                }        
            }
        }catch(Exception e){}
    }
    
    public void modificar(){
        //Auditoria auditoria=new Auditoria(r_con);
        Usuarios usuarios=new Usuarios(r_con);
        Usuario u=new Usuario();
        Perfil p=new Perfil();
        u.setNombre(jTextField1.getText());
        u.setApellido(jTextField2.getText());
        u.setUsuario(jTextField3.getText());
        u.setContraseña(jPasswordField1.getText());

        int item=jComboBox1.getSelectedIndex();
        Vector<Vector<String>>vv=perfiles.getTablaPerfiles();                        
        p.setId(Integer.parseInt(vv.elementAt(item).elementAt(0)));
        p.setDescripcion(perfiles.getDescripcion(p.getId()));
        u.setPerfil(p);                                                    
        
        u.setExiste(true);
        usuarios.modificar(u);
                
        //auditoria.insertarUsuario(usuarioLogueado,u,"modificar");
        limpiarForm();
    }
    
    /**
     * Cuando presiona aceptar le indico lo que debe hacer mediante estos
     * metodos
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(modo.equals("Alta")){
            alta();
        }
        if(modo.equals("Baja")){
            baja();
        }
        if(modo.equals("Modificar")){
            modificar();
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        // TODO add your handling code here:        
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png")));
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
        Vector<Vector<String>>v = perfiles.getTablaPerfiles();
        int item=jComboBox1.getSelectedIndex();
        id_perfil=0;
        int i=0;
        for(Vector<String>a:v){
            if(i++==item){
                id_perfil=Integer.parseInt(a.elementAt(0));
            }
        }
        //cargarTabla(id_perfil);
        jButton1.requestFocus();
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        Vector<Vector<String>>v = perfiles.getTablaPerfiles();
        int item=jComboBox1.getSelectedIndex();
        id_perfil=0;
        int i=0;
        for(Vector<String>a:v){
            if(i++==item){
                id_perfil=Integer.parseInt(a.elementAt(0));
            }
        }
        cargarTabla(id_perfil);
        jButton1.requestFocus();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here: 
    r_con.Connection();
    if(jButton3.getText().equals("Nuevo Perfil")){
        jTable1.setEnabled(true);   
        jButton3.setText("Crear Perfil");
        jTextField4.setEnabled(true);
    }        
    else{
             
            String nuevoPerfil=jTextField4.getText();
            nuevoPerfil=nuevoPerfil.toUpperCase();
            int nuevoPerfilId=-1;
            Vector<Integer>claveFila=new Vector();
            Vector<Integer>claveColumna=new Vector();        
            String aux="";
            int clave=-1;

            String consulta="select count(prf_id_perfil) from perfil";
            ResultSet rs=r_con.Consultar(consulta);
            try {
                while(rs.next()){
                    nuevoPerfilId=rs.getInt(1)+1;
                }                
                for(int i=0;i<modelo.getRowCount();i++){
                    aux=(String)modelo.getValueAt(i,0);            
                    consulta="select mod_id_modulo from modulo where mod_descripcion='"+aux+"'";
                    rs=r_con.Consultar(consulta);
                    clave=-1;            
                    while(rs.next()){
                        clave=rs.getInt(1);
                    }            
                    claveFila.add(clave);
                }

                for(int i=1;i<=modelo.getColumnCount();i++){
                    
                    aux=modelo.getColumnName(i);            
                    consulta="select tar_id_tarea from tarea where tar_descripcion='"+aux+"'";
                    rs=r_con.Consultar(consulta);
                    clave=-1;        
                    while(rs.next()){
                        clave=rs.getInt(1);
                    }        
                    claveColumna.add(clave);
                }
                if(!nuevoPerfil.equals("")){
                    Perfil p=new Perfil();p.setId(nuevoPerfilId);p.setDescripcion(nuevoPerfil);
                    perfiles.insertar(p);
                    //Auditoria auditoria=new Auditoria(r_con);
                    //auditoria.insertarPerfiles(usuarioLogueado,p,"Alta");
                    for(int i=0;i<modelo.getRowCount();i++){
                        for(int j=1;j<modelo.getColumnCount();j++){
                            
                            if((boolean)modelo.getValueAt(i,j)==true){ 
                                System.out.println("i: "+i+" j: "+j);
                                Permiso per=new Permiso(nuevoPerfilId,claveFila.elementAt(i),claveColumna.elementAt(j-1));
                                Permisos prs=new Permisos(r_con);prs.insertar(per);
                                //consulta="insert into permiso values("+nuevoPerfilId+","+claveFila.elementAt(i)+","+claveColumna.elementAt(j-1)+")";
                                //r_con.InsertarSinCartel(consulta);
                            }
                            else{System.out.println(" FALSO i: "+i+" j: "+j);}
                        }            
                    }
                }
                else
                {JOptionPane.showMessageDialog(null,"Debe ingresar un nombre al nuevo perfil");}            
            rs.close();
            } 
            catch (SQLException ex) {
                    Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }        
        r_con.cierraConexion();
        cargarComboBox();
        jComboBox1.setSelectedIndex(jComboBox1.getItemCount()-1);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:                
        String contraseña,rep_contraseña;
        contraseña=rep_contraseña="";
        char[]pas=jPasswordField1.getPassword();
        char[]pas2=jPasswordField2.getPassword();
        for(char c2:pas2)
            rep_contraseña+=c2;
        for(char c:pas)
            contraseña+=c;
        if(contraseña.equals(rep_contraseña))
            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png")));
        else{
            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png")));
            
        }
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            if(modo.equals("Baja")){
                if(jTextField3.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de un usuario");
                else                
                    completarCampos(jTextField3.getText());                             
            }
            if(modo.equals("Modificar")){
                if(jTextField3.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de un usuario");
                else
                {                
                    completarCampos(jTextField3.getText());                                                
                    habilitarCampos(true);
                    jButton3.setEnabled(false);
                    jTextField4.setEnabled(false);
                    jTable1.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        // TODO add your handling code here:
        jPasswordField2.setText("");
    }//GEN-LAST:event_jPasswordField2FocusGained

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        // TODO add your handling code here:
        jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1FocusGained
    /**
     * Obtengo el nombre de las columnas
     * @return 
     */
    private String[] getColumnas(){
        Tareas t=new Tareas(r_con);
        Vector<Vector<String>>tareas = t.getTablaTareas();
        String []columnas=new String[tareas.size()+1];
        columnas[0]="Modulo";
        int i=1;
        for(Vector<String>vv:tareas)
            columnas[i++]=vv.elementAt(1);
        return columnas;
    }
    
    /**
     * Obtengo el tipo de cada columna
     * @return 
     */
    private Class[] getTipoColumnas(){
        Tareas t=new Tareas(r_con);
        Vector<Vector<String>>tareas = t.getTablaTareas();
        final Class[] datos = new Class[tareas.size()+1];        
        datos[0]=java.lang.String.class;
        for(int i=1;i<tareas.size();i++)            
            datos[i]=java.lang.Boolean.class;
        return datos;
    }
    
    
    private Vector<Vector<Object>> getContenidoTabla(int perfil){
        //r_con.Connection();
        Tareas t=new Tareas(r_con);
        Permisos p=new Permisos(r_con);
        Vector<Vector<String>> v = p.getContenidoTablaPermisos(perfil);
        Vector<Vector<String>>tareas = t.getDescripcionTareas();
        
        Vector<Vector<Object>>matriz = new Vector();        
        Vector<Object>fila;
        int id_modulo,id_tarea;id_modulo=-1;id_tarea=-1;
        r_con.Connection();
        ResultSet rs;        
        try{
            for(Vector<String>modulos:v){
                fila=new Vector();
                fila.add(modulos.elementAt(0));// guardo en la primera posicion el nombre del MODULO                
                rs=r_con.Consultar("select mod_id_modulo from modulo where mod_descripcion='"+modulos.elementAt(0)+"'");
                    while(rs.next())
                        id_modulo=rs.getInt(1);                    
                for(Vector<String>tarea:tareas){                    
                    rs=r_con.Consultar("select tar_id_tarea from tarea where tar_descripcion='"+tarea.elementAt(0)+"'");
                    while(rs.next())     
                        id_tarea=rs.getInt(1);                                        
                    rs=r_con.Consultar("select per_id_perfil,mod_descripcion,tar_descripcion "
                                       +"from permiso,modulo,tarea "
                                       +"where mod_id_modulo=per_id_modulo and tar_id_tarea=per_id_tarea and "
                                       +"per_id_modulo="+id_modulo+" and per_id_tarea="+id_tarea +" and per_id_perfil="+perfil);
                    if(rs.next())
                        fila.add(true);
                    else
                        fila.add(false);                    
                }
                rs.close();
                matriz.add(fila);
            } 
        
        r_con.cierraConexion();
        }catch(Exception e){r_con.cierraConexion();}
        return matriz;
    }
    
    public void cargarTabla(int perfil){                               
        System.out.println("tabla");
        String[] columnas = getColumnas();
        Class[] tipoDatosColumnas=getTipoColumnas();
        
        Vector<Vector<Object>> contenidoTabla = new Vector();
        contenidoTabla = getContenidoTabla(perfil);
        
        modelo = new DefaultTableModel();
        
        for(int i=0;i<modelo.getRowCount();i++)
            modelo.removeRow(i);
        
        modelo.setColumnIdentifiers(columnas); 
        
        for(int i=0;i<contenidoTabla.size();i++){            
            modelo.addRow(contenidoTabla.elementAt(i));
        }        
        
        if(modelo.getRowCount()!=contenidoTabla.size()){            
            int r=campoRepetido();     
            while(r!=-1){                            
                modelo.removeRow(r);            
                r=campoRepetido();
            }
        }
        
        jTable1.setModel(modelo);
        
        for(int i=1;i<columnas.length;i++){            
            //jTable1.getColumnModel().getColumn(i).setCellEditor(new Clase_CellEditor());
            //jTable1.getColumnModel().getColumn(i).setCellRenderer(new Clase_CellRender());
        }
        
    }              
    
    /**
     * Identifica en el modelo algun modulo que se repita
     * (no se porque se da la repeticio) y me retorna la posicion
     * dentro del modelo para su posterior eliminacion
     * @return pos del modulo repetido
     */
    private int campoRepetido(){ 
        int pos=-1;
        for(int i=0;i<modelo.getRowCount();i++){            
            for(int j=0;j<modelo.getRowCount();j++){                
                if(i!=j){
                    if(modelo.getValueAt(i, 0).equals(modelo.getValueAt(j,0))){                        
                        return i;
                    }
                }
            }
        }
        return pos;
    }    
    
    private boolean camposNecesarios () {
       boolean rta;
       if ((jTextField1.getText().equals("")))
       {
            JOptionPane.showMessageDialog(null, "Complete el campo nombre!","Atención",JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            rta = false;
       }
       else{
            if ((jTextField2.getText().equals("")))
            {
                jTextField2.requestFocus();
                JOptionPane.showMessageDialog(null, "Complete el campo apellido!","Atención",JOptionPane.WARNING_MESSAGE);
                rta = false;
            }
            else{
                if ((jTextField3.getText().equals("")))
                {
                    jTextField3.requestFocus();
                    JOptionPane.showMessageDialog(null, "Complete el campo usuario!","Atención",JOptionPane.WARNING_MESSAGE);
                    rta = false;
                }
                else{
                    if (((jPasswordField1.getText().equals("")))||((jPasswordField2.getText().equals(""))))
                    {
                        jTextField3.requestFocus();
                        JOptionPane.showMessageDialog(null, "Complete el campo contraseña!","Atención",JOptionPane.WARNING_MESSAGE);
                        rta = false;
                     }
                    else{
                        rta = true;
                    }
                }
            }
       }      
       return rta;             
    }

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

public void setTitleLabel (String t){
        this.jLabel1.setText(t);
}

public void limpiarForm(){
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField4.setEnabled(false);
    jPasswordField1.setText("***************");
    jPasswordField2.setText("***************");
    jLabel9.setIcon(null);
    jLabel10.setIcon(null);
    jTextField1.requestFocus();
    jTable1.removeAll();
    jComboBox1.setSelectedIndex(0);
    jButton3.setText("Nuevo Perfil");
    cargarTabla(-1);    
}

  private void habilitarCampos(boolean valor){
      jTextField1.setEnabled(valor);
      jTextField2.setEnabled(valor);
      jTextField4.setEnabled(valor);
      jButton3.setEnabled(valor);
      jPasswordField1.setEnabled(valor);
      jPasswordField2.setEnabled(valor);
      jTable1.setEnabled(valor);
      jComboBox1.setEnabled(valor);
  }

}
 
