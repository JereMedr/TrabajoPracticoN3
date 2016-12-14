package PRESENTACION;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EncabezadoGrafico {
	JPanel  encabezado;
	
	public EncabezadoGrafico() {
		encabezado = new JPanel();
		encabezado.setBackground(Color.BLACK);
		encabezado.setBounds(0, 0, 414, 30);

		JLabel lblNewLabel = new JLabel("Horario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);

		JLabel lblBanda = new JLabel("Banda");
		lblBanda.setForeground(Color.WHITE);

		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(encabezado);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(4)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblBanda, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
						.addComponent(lblDinero, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBanda, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDinero, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
		encabezado.setLayout(gl_panel);
	}
	
	JPanel getEncabezado(){
		return encabezado;
	}
}
