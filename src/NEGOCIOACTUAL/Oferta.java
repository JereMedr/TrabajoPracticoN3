package NEGOCIOACTUAL;

public class Oferta {

	  private int horaEntrada;
	  private int horaSalida;
	  private double dinero;
	  private String nombre;
	  
		  
		public Oferta(String nombre, double dinero, int horaEntrada , int horaSalida) {
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
			this.dinero = dinero;
			this.nombre = nombre;
		}
		


		public int getHoraEntrada() {
			return horaEntrada;
		}

		public int getHoraSalida() {
			return horaSalida;
		}

		public double getDinero() {
			return dinero;
		}

		public String getNombre() {
			return nombre;
		}

		@Override
		public String toString() {
			return "Oferta [horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", dinero=" + dinero
					+ ", nombre=" + nombre + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Oferta other = (Oferta) obj;
			if (Double.doubleToLongBits(dinero) != Double.doubleToLongBits(other.dinero))
				return false;
			if (horaEntrada != other.horaEntrada)
				return false;
			if (horaSalida != other.horaSalida)
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}
		  
	  
}
