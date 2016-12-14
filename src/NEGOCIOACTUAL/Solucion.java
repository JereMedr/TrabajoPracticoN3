package NEGOCIOACTUAL;

import java.util.ArrayList;


public class Solucion {

	private Oferta dia[];
	private ArrayList<Oferta> ofertas;

	public Solucion() {
		dia = new Oferta[24];
	}

	public Oferta[] getDia() {
		return dia;
	}

	public void setDia(Oferta[] arr) {
		dia = arr;
	}

	public boolean aceptarOferta(Oferta nueva) {
		if (nueva.getDinero() == 0) {
			return false;
		}
		if (nueva.getHoraEntrada() >= 24 || nueva.getHoraSalida() >= 24) {
			return false;
		}
		if (nueva.getHoraEntrada() == nueva.getHoraSalida()) {
			return false;
		}
		if (nueva.getHoraEntrada() > nueva.getHoraSalida()) {
			return false;
		}

		solverGoloso(nueva);
		return true;
	}

	void solverGoloso(Oferta nueva) {

		if (horasDisponibles(nueva)) {

			ofertaAceptada(nueva);
		} else {

			if (mejorOpcion(nueva)) {
				liberarHoras();
				ofertaAceptada(nueva);
			} 
		}

	}

	boolean mejorOpcion(Oferta nueva) {
		ofertas = new ArrayList<Oferta>();
		boolean ret = true;
		double dinero = 0;
		for (int i = nueva.getHoraEntrada(); i < nueva.getHoraSalida(); i++) {
			if (dia[i] != null && !ofertas.contains(dia[i])) {
				ofertas.add(dia[i]);
				dinero += dia[i].getDinero();
			}
			if (dinero >= nueva.getDinero()) {
				return false;
			}
		}
		return ret;

	}

	void ofertaAceptada(Oferta nueva) {
		for (int i = nueva.getHoraEntrada(); i < nueva.getHoraSalida(); i++) {
			dia[i] = nueva;
		}
	}

	boolean horasDisponibles(Oferta nueva) {
		boolean ret = true;

		for (int i = nueva.getHoraEntrada(); i < nueva.getHoraSalida(); i++) {
			if (dia[i] != null) {
				ret = false;
			}
		}
		return ret;
	}

	boolean noSonNull(Oferta oferta1, Oferta oferta2) {
		if (oferta1 != null && oferta2 != null) {
			return true;
		}
		return false;
	}

	void liberarHoras() {
		for (int i = 0; i < dia.length; i++) {

			for (int j = 0; j < ofertas.size(); j++) {

				if (noSonNull(dia[i], ofertas.get(j)) == true) {

					if (dia[i].equals(ofertas.get(j))) {

						dia[i] = null;
					}
				}
			}
		}
	}
	// FIN DE LA
	// CLASE--------------------------------------------------------------------------------------------->>
}