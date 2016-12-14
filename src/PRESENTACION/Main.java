package PRESENTACION;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DATO.Datos;
import NEGOCIOACTUAL.Oferta;
import NEGOCIOACTUAL.Solucion;
//import asd.Datos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main extends JFrame {
 
    private static final long serialVersionUID = 1L;
 
    private JPanel contentPane;
    private JTextField TFnombre;
    private JTextField TFdinero;
    private JTextField TFentrada;
    private JTextField TFsalida;
    private Panel menu;
    private Panel panelHorarios;
    private ListaDeCeldasGraficas tabla;
	private JPanel tablaHorarios;
    private Solucion solucion;
    private Datos datos;
    private boolean musica;
    private AudioClip musicaFondo;
    private JButton BttnVolver;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
 
                    Main frame = new Main();
 
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    public Main() throws IOException {
        setVisible(true);
        setSize(800, 600);
        setResizable(false);
        setTitle("Trabajo Practico   - UNGS");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
 
        datos = new Datos();
        solucion = new Solucion();
        solucion.setDia(datos.leerDatos());
        tabla = new ListaDeCeldasGraficas();
    	tablaHorarios = tabla.getLista(solucion.getDia());
 
        panelMenu();
        panelHorarios();
 
        opcNombre();
        opcDinero();
        opcEntradaSalida();
 
        musicaFondo();
        musica = true;
       
        labels();
        buttons();
        bttnMusica(menu);
        bttnMusica(panelHorarios);
        
       
        
       
       
    }
 
    private void panelMenu() {
        contentPane.setLayout(new CardLayout(0, 0));
        menu = new Panel("/PRESENTACION/fondo.jpg");
        menu.setForeground(new Color(238, 232, 170));
 
        contentPane.add(menu);
        menu.setLayout(null);
    }
 
    private void panelHorarios() {
        panelHorarios = new Panel("/PRESENTACION/fondo.jpg");
        panelHorarios.setForeground(new Color(238, 232, 170));
        contentPane.add(panelHorarios);
        panelHorarios.setLayout(null);
 
    }
 
    private void opcEntradaSalida() {
        JLabel lblHorarioDeEntrada = new JLabel("horario de entrada/ horario de salida");
        lblHorarioDeEntrada.setBackground(Color.BLACK);
        lblHorarioDeEntrada.setForeground(Color.WHITE);
        lblHorarioDeEntrada.setFont(new Font("Magneto", Font.PLAIN, 22));
        lblHorarioDeEntrada.setBounds(177, 270, 571, 39);
        menu.add(lblHorarioDeEntrada);
 
        TFentrada = new JTextField();
        TFentrada.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isDigit(c)) {
                    getToolkit().beep();
                    ke.consume();
                }
            }
        });
        TFentrada.setFont(new Font("Magneto", Font.PLAIN, 22));
        TFentrada.setForeground(Color.WHITE);
        TFentrada.setBackground(Color.BLACK);
        TFentrada.setBounds(305, 320, 54, 39);
        menu.add(TFentrada);
        TFentrada.setColumns(10);
 
        TFsalida = new JTextField();
        TFsalida.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isDigit(c)) {
                    getToolkit().beep();
                    ke.consume();
                }
            }
        });
        TFsalida.setFont(new Font("Magneto", Font.PLAIN, 22));
        TFsalida.setForeground(Color.WHITE);
        TFsalida.setBackground(Color.BLACK);
        TFsalida.setBounds(423, 320, 54, 39);
        menu.add(TFsalida);
        TFsalida.setColumns(10);
    }
 
    private void opcDinero() {
        JLabel lblDinero = new JLabel("Dinero");
        lblDinero.setFont(new Font("Magneto", Font.PLAIN, 22));
        lblDinero.setForeground(Color.WHITE);
        lblDinero.setBounds(354, 135, 111, 39);
        menu.add(lblDinero);
        TFdinero = new JTextField();
        TFdinero.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isDigit(c)) {
                    getToolkit().beep();
                    ke.consume();
                   
                }
            }
        });
 
        TFdinero.setFont(new Font("Magneto", Font.PLAIN, 22));
        TFdinero.setBackground(Color.BLACK);
        TFdinero.setForeground(Color.WHITE);
        TFdinero.setBounds(324, 185, 157, 38);
        menu.add(TFdinero);
        TFdinero.setColumns(10);
    }
 
    private void opcNombre() {
        JLabel lblNombre = new JLabel("Nombre ");
        lblNombre.setFont(new Font("Magneto", Font.PLAIN, 22));
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(338, 47, 201, 44);
        menu.add(lblNombre);
 
        TFnombre = new JTextField();
        TFnombre.setFont(new Font("Magneto", Font.PLAIN, 15));
        TFnombre.setForeground(Color.WHITE);
        TFnombre.setBackground(Color.BLACK);
        TFnombre.setBounds(186, 85, 420, 39);
        menu.add(TFnombre);
        TFnombre.setColumns(10);
    }
 
    private void buttons() {
        JButton btnReservar = new JButton("Reservar");
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               
                String Rnombre = "";
                Double Rdinero = (double)0;
                int RhoraEntrada=0;
                int RhoraSalida=0;
 
                if (TFnombre.getText().equals("") || TFdinero.getText().equals("") || TFentrada.getText().equals("") || TFsalida.getText().equals("")       ) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                }else{
                     Rnombre = TFnombre.getText();
                     Rdinero = (double) Integer.parseUnsignedInt(TFdinero.getText());
                     RhoraEntrada = (int) Integer.parseUnsignedInt(TFentrada.getText());
                     RhoraSalida = (int) Integer.parseUnsignedInt(TFsalida.getText());
                     
                     Oferta ofertaNueva = new Oferta(Rnombre, Rdinero, RhoraEntrada, RhoraSalida);
                     boolean estado = solucion.aceptarOferta(ofertaNueva);
                     if(estado == true){
                    	 JOptionPane.showMessageDialog(null, "Su oferta fue aceptada. Verifique su estado en 'Consultar horarios', en caso de no figurar mejore su oferta.");
                     }
                     else{
                    	 JOptionPane.showMessageDialog(null,"Hubo un error en su oferta. Verifique los datos ingresados.\nNombre: "+ofertaNueva.getNombre()+"   Dinero: $ "+ofertaNueva.getDinero()+"\nHora ingreso: "+ofertaNueva.getHoraEntrada()+"   Hora egreso: "+ofertaNueva.getHoraSalida(),"ERROR",JOptionPane.ERROR_MESSAGE);
                     }
                     
                }
                try {
                    datos.guardarDatos(solucion.getDia());
                    tablaHorarios = tabla.getLista(solucion.getDia());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
 
        btnReservar.setFont(new Font("Magneto", Font.PLAIN, 15));
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setBackground(Color.BLACK);
        btnReservar.setBounds(338, 401, 145, 39);
        menu.add(btnReservar);
 
        JButton btnVerHorariosDe = new JButton("Consultar horarios");
        btnVerHorariosDe.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mousePressed(MouseEvent e) {
            	
                panelHorarios.add(BttnVolver);
                panelHorarios.add(tablaHorarios);
                contentPane.setVisible(false);
                panelHorarios.setVisible(true);
                panelHorarios.configMusica(musica);
                
                
               
                setContentPane(panelHorarios);
            }
        });
        btnVerHorariosDe.setFont(new Font("Magneto", Font.PLAIN, 15));
        btnVerHorariosDe.setBackground(Color.BLACK);
        btnVerHorariosDe.setForeground(Color.WHITE);
        btnVerHorariosDe.setBounds(225, 471, 400, 44);
        menu.add(btnVerHorariosDe);
 
        BttnVolver = new JButton("");
        BttnVolver.addMouseListener(new MouseAdapter() {
           
 
            @Override
            public void mousePressed(MouseEvent e) {
            	
            	panelHorarios.remove(tablaHorarios);
                contentPane.setVisible(true);
                panelHorarios.setVisible(false);
                menu.configMusica(musica);
               
                setContentPane(contentPane);
            }
        });
        BttnVolver.setIcon(new ImageIcon("imagenes\\volver.png"));
        BttnVolver.setBounds(25, 25, 49, 48);
        panelHorarios.add(BttnVolver);
       
 
    }
 
    private void bttnMusica(Panel panel) {
 
        panel.musica = new JButton("");
        panel.musica.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                 musica =! musica;
                if (musica == true) {
                    panel.musica.setIcon(new ImageIcon("imagenes\\musica.png"));
                    musicaFondo.loop();
                } else {
                    panel.musica.setIcon(new ImageIcon("imagenes\\musicaOff.png"));
                    musicaFondo.stop();
                }
            }
        });
       
        panel.musica.setIcon(new ImageIcon("imagenes\\musica.png"));
       
 
        panel.musica.setBounds(720, 25, 50, 49);
        panel.add(panel.musica);
       
       
    }
 
    private void musicaFondo() {
        try {
            musicaFondo = Applet.newAudioClip(new URL("file:sonidos/fondo.wav"));
            musicaFondo.loop();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
 
    private void labels() {
        JLabel lblHagaSuReserva = new JLabel("Haga su Reserva");
        lblHagaSuReserva.setBackground(Color.BLACK);
        lblHagaSuReserva.setFont(new Font("Magneto", Font.PLAIN, 24));
        lblHagaSuReserva.setForeground(Color.WHITE);
        lblHagaSuReserva.setBounds(269, 0, 253, 64);
        menu.add(lblHagaSuReserva);
 
        JLabel lblAutores = new JLabel("Jeremias Medrano - Jorge Rearte Carvalho");
        lblAutores.setForeground(Color.WHITE);
        lblAutores.setFont(new Font("Magneto", Font.PLAIN, 12));
        lblAutores.setBounds(473, 537, 301, 14);
        menu.add(lblAutores);
        JLabel HSHS = new JLabel("hs           hs");
        HSHS.setFont(new Font("Magneto", Font.PLAIN, 22));
        HSHS.setForeground(Color.WHITE);
        HSHS.setBounds(366, 320, 212, 38);
        menu.add(HSHS);
       
        JLabel $ = new JLabel("$");
        $.setForeground(Color.WHITE);
        $.setFont(new Font("Magneto", Font.PLAIN, 22));
        $.setBounds(491, 184, 44, 38);
        menu.add($);
       
       
    }
}