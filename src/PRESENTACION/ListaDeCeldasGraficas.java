package PRESENTACION;

import java.util.ArrayList;

import javax.swing.JPanel;

import NEGOCIOACTUAL.Oferta;

public class ListaDeCeldasGraficas {

	JPanel lista;
	int cantBandas;
	
	public ListaDeCeldasGraficas(){
		lista = new JPanel();
	}
	
	JPanel getLista(Oferta [] dia){
		
		lista = new JPanel();
		
		
		EncabezadoGrafico encabezado = new EncabezadoGrafico();
		lista.add(encabezado.getEncabezado());
		
		
		
		ArrayList<Oferta> bandas = new ArrayList<Oferta>();
		for (Oferta oferta : dia) {
			if (oferta != null && bandas.contains(oferta) == false) {
				CeldaBandaGrafica banda = new CeldaBandaGrafica(oferta.getHoraEntrada(), oferta.getHoraSalida(), oferta.getNombre(),oferta.getDinero());
				bandas.add(oferta);
				lista.add(banda.getCelda(30*(bandas.size()+1)));
			}
			
			
		}
		cantBandas = bandas.size();
		lista.setBounds(188,100,414,((cantBandas+1)*35)+5);
		return lista;
	}
	
}
