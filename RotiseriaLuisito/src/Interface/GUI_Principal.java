
package Interface;
import Objetos.Usuario;
import Auxiliares.Conexion;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;

/**
 *
 * @author Manolo
 */
public class GUI_Principal extends javax.swing.JFrame {

 
    private Conexion r_con;
    private int perfil;
    private Usuario usuario; 
    
    /**
     * Creates new form GUI_Principal
     */
    
    public GUI_Principal(Usuario u, Conexion con) {           
        initComponents();        
        setDefaultCloseOperation(0);
        r_con = con;
        usuario=u;
        perfil=usuario.getIdPerfil().getId();
   
        //Frame tome el tamaño de la pantalla al 95% y comienze maximizado
        float escalar = 0.91F;
        int ancho = (int)(Toolkit.getDefaultToolkit().getScreenSize(). width);
        int alto = (int)(Toolkit.getDefaultToolkit().getScreenSize(). height*escalar);
   
        this.setSize(ancho,alto);        
        setLocationRelativeTo (null);                
        habilitarMenu(true);
        
        habilitarFunciones(perfil);
        infoEstado();     
    }
    
    private void infoEstado(){
        String name = this.getTitle();
        //name+=" : "+r_con.getUsuario();
        name+=" : Administrador";
        this.setTitle(name);
    }
    
    private void habilitarMenu(boolean valor){
        Component[] components = jMenuBar1.getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(valor);
            JMenu jaux=(JMenu)components[i];  
            for(int ff=0;ff<jaux.getItemCount();ff++){
                jaux.getItem(ff).setEnabled(valor);                
                
             /*   if(jaux.getItem(ff) instanceof JMenu){
                    JMenu jaux2=(JMenu)jaux.getItem(ff);                
                    for(int fff=0;fff<jaux2.getItemCount();fff++)
                        jaux2.getItem(fff).setEnabled(valor);                
                }*/
            }
        }    
    }
    
    // EJ---> 
    // Vector<Vector<Integer>>v(Vectro<modulo Tarea,...,...)    
    // Vector=(modulo,tarea,tarea,tarea)
    public void habilitarFunciones(int perfil){                           
        String consulta="select per_id_perfil,per_id_modulo,per_id_tarea from permiso where per_id_perfil="+perfil;
        r_con.abrirConexion();
        ResultSet rs=r_con.Consultar(consulta);
        Vector<Vector<Integer>>modulosTarea=new Vector();
        boolean existe=false;
        int i=0;int pos=-1;
        try {
            while(rs.next()){                                                
                int aux=rs.getInt(2);//obtengo el modulo
                for(Vector<Integer>v1:modulosTarea){
                    if(v1.get(0)==aux){
                        existe=true;                        
                        pos=i;
                    }
                    i++;
                }
                if(!existe){
                    Vector<Integer>v=new Vector();
                    v.add(aux);v.add(rs.getInt(3));
                    modulosTarea.add(v);
                }
                else{
                    modulosTarea.get(pos).add(rs.getInt(3));
                }
                existe=false;
                i=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        habilitarMenuPerfil(modulosTarea);
        jMenu7.setEnabled(true);
        r_con.cerrarConexion();
    }    
   
    /**
     * Para que funcione este metodo es necesario que el nombre de cada jMenu
     * se corresponda con el mod_id_modulo en la base de datos
     * @param moduloTarea 
     */
    private void habilitarMenuPerfil(Vector<Vector<Integer>>moduloTarea){        
        habilitarMenu(false);
        for(Component cMenu:jMenuBar1.getComponents()){
            for(Vector<Integer>modulo:moduloTarea){ 
                if(cMenu.getName().equals("M"+modulo.get(0))){                    
                    cMenu.setEnabled(true);
                }                                    
            }
            JMenu maux=(JMenu)cMenu;
            for(int i=0;i<maux.getItemCount();i++){
                for(Vector<Integer>modulo:moduloTarea){                                
                    if(maux.getItem(i).getName().equals("M"+modulo.get(0))){                    
                        maux.getItem(i).setEnabled(true);
                    }
                    for(int z=1;z<modulo.size();z++){                        
                        if(maux.getItem(i).getName().equals("T"+modulo.get(0)+modulo.get(z)))
                            maux.getItem(i).setEnabled(true);
                    }
                }
                // menu interno que tiene menu                                                    
            }            
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Contable");
        setIconImage(Toolkit.getDefaultToolkit().getImage("_icono.png"));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jMenu7.setMnemonic('0');
        jMenu7.setText("Cerrar Sesión");
        jMenu7.setName("M7"); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
       GUI_Inicio_Sesion se = new GUI_Inicio_Sesion(r_con);
       this.dispose();
       se.setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked
    
    
    public void abrirSesion (){
        jMenu7.setText("Iniciar Sesión");
        jMenu7.setEnabled(true);
    }   
    
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
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {               
                System.out.println("COMENZO EL PROGRAMA");
                GUI_Conexion gui = new GUI_Conexion();
                
                if (gui.validarConexion()){                      
                        Conexion r_con = gui.getConexion();
                        gui.dispose();
                        gui=null;
                        GUI_Inicio_Sesion IS = new GUI_Inicio_Sesion(r_con);
                        IS.setVisible(true);
                }
                else{
                    gui.setVisible(true);
                    gui.generarConexion ();                        
                }             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
/**
    if(maux.getItem(i) instanceof JMenu){
                    System.out.println("PAJERO");
                    JMenu menuInterno=(JMenu)maux.getItem(i);
                    System.out.println(menuInterno.getComponentCount());
                    for(int contMI=0;contMI<menuInterno.getComponentCount();contMI++){
                        for(Vector<Integer>vInterno:moduloTarea)
                            for(int z=1;z<vInterno.size();z++){           
                                System.out.println(menuInterno.getItem(contMI).getName()+" --- "+"T"+vInterno.get(0)+vInterno.get(z));
                                if(menuInterno.getItem(contMI).getName().equals("T"+vInterno.get(0)+vInterno.get(z)))
                                    menuInterno.getItem(contMI).setEnabled(true);
                            }
                    }
                }
    
    */
