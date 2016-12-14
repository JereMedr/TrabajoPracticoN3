package DATO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import NEGOCIOACTUAL.Oferta;

public class Datos {

	private File archivo;
	private FileWriter writeFile;
	private BufferedWriter writer;
	private FileReader readFile;
	private BufferedReader reader;

	public Datos() {
		archivo = new File("Datos.txt");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				writeFile = new FileWriter(archivo);
				writer = new BufferedWriter(writeFile);
				for (int i = 0; i < 24; i++) {
					writer.write("null");
					writer.newLine();
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarDatos(Oferta[] dia) throws IOException {
		FileWriter writeFile = new FileWriter(archivo);
		BufferedWriter writer = new BufferedWriter(writeFile);

		for (Oferta oferta : dia) {
			if (oferta != null) {
				String formato = oferta.getHoraEntrada() + ":" + oferta.getHoraSalida() + ":" + oferta.getNombre() + ":"
						+ oferta.getDinero();
				writer.write(formato);
				writer.newLine();
			} else {
				writer.write("null");
				writer.newLine();
			}
		}
		writer.close();
	}

	public Oferta[] leerDatos() throws IOException {
		Oferta[] dia = new Oferta[24];
		readFile = new FileReader(archivo);
		reader = new BufferedReader(readFile);

		for (int i = 0; i < 24; i++) {
			Oferta ofertaNueva = agarrarOferta(reader.readLine());
			if (ofertaNueva != null) {
				dia[i] = new Oferta(ofertaNueva.getNombre(), ofertaNueva.getDinero(), ofertaNueva.getHoraEntrada(),
						ofertaNueva.getHoraSalida());
			}

		}
		reader.close();

		return dia;
	}

	private Oferta agarrarOferta(String linea) {
		String Banda = "";
		String Dinero = "";
		String HE = "";
		String HS = "";

		if (linea.equals("null")) {
			return null;
		}

		int cont = 0;
		for (int i = 0; i < linea.length(); i++) {
			if (linea.charAt(i) != ':') {
				if (cont == 0) {
					HE += "" + linea.charAt(i);
				} else if (cont == 1) {
					HS += "" + linea.charAt(i);
				} else if (cont == 2) {
					Banda += "" + linea.charAt(i);
				} else if (cont == 3) {
					Dinero += "" + linea.charAt(i);
				}
			} else {
				cont++;
			}
		}
		return new Oferta(Banda, new Double(Dinero), new Integer(HE), new Integer(HS));
	}
}
