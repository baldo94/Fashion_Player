package reproductor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JList;

import java.awt.Rectangle;

public class visual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPlay;
	private int estado; // 0 play , 1 pausa
	private Reproductor cancionActual;

	Reproductor r = null;
	private JMenu mnCargar;
	private JMenuBar menuBar;
	private JMenuItem mntmCanciones;
	private JList list;
	private JTextArea playlist;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visual frame = new visual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public visual() {
		super("Fashion Player");
		setBackground(Color.BLUE);
		setResizable(false);

		r = new Reproductor();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnCargar = new JMenu("Cargar");
		mntmCanciones = new JMenuItem("canciones");
		mntmCanciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();

				int respuesta = fc.showOpenDialog(mnCargar);
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					File archivoElegido = fc.getSelectedFile();

					try {
						
						cancionActual = new Reproductor(archivoElegido.getPath());
						
						
						cancionActual.setRuta(archivoElegido.getPath());
						cancionActual.setRuta(archivoElegido.getPath());
						playlist.append(archivoElegido.getName() + "\n");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					;

				}
			}
		});
		mnCargar.add(mntmCanciones);
		menuBar.add(mnCargar);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPlay = new JButton("");
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setIcon(new ImageIcon("C:\\Users\\oswaldo\\Desktop\\MP3\\play2.png"));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (estado == 1) {
					
						r.Continuar();
						estado = 0;
					} else
						r.AbrirFichero("C:/Users/oswaldo/Desktop/MP3/hola.mp3");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPlay.setBounds(20, 73, 70, 64);
		contentPane.add(btnPlay);

		JButton btnPause = new JButton("");
		btnPause.setBounds(new Rectangle(12, 13, 44, 44));
		btnPause.setBackground(new Color(0, 0, 0));
		btnPause.setIcon(new ImageIcon("C:\\Users\\oswaldo\\Desktop\\MP3\\pause2.png"));
		btnPause.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					r.Pausa();
					estado = 1; // pausa

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPause.setBounds(20, 167, 62, 51);
		contentPane.add(btnPause);

		JButton btnStop = new JButton("");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop.setBackground(Color.BLACK);
		btnStop.setIcon(new ImageIcon("C:\\Users\\oswaldo\\Desktop\\MP3\\parar2.png"));
		btnStop.setBounds(20, 11, 62, 51);
		contentPane.add(btnStop);
		
		
		list = new JList();
		list.setBounds(246, 11, 156, 207);
		contentPane.add(list);
	}
}