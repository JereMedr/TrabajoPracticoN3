package PRESENTACION;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CeldaBandaGrafica {
	JPanel celda;
	
	public CeldaBandaGrafica(int horaEntrada, int horaSalida, String banda, Double dinero){
		String horario = horaEntrada + " a " + horaSalida + " hs.";
		
		celda = new JPanel();
		celda.setBackground(Color.BLACK);
		
		
		JLabel lblHorario = new JLabel(horario);
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setBackground(Color.WHITE);
		
		JLabel lblBanda = new JLabel(banda);
		lblBanda.setForeground(Color.WHITE);
		
		JLabel lblDinero = new JLabel("$ "+dinero);
		lblDinero.setForeground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(celda);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addComponent(lblHorario, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBanda, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(lblDinero, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblHorario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblBanda, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblDinero, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		celda.setLayout(gl_panel);
	}
	JPanel getCelda(int y){
		celda.setBounds(0, 0, 414, 30);
		return celda;
	}
}
