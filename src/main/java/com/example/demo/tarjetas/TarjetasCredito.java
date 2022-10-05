package com.example.demo.tarjetas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TarjetasCredito {
	 
	private MarcaTarjetas marcaTarjeta;
	private String nroTarjeta;
	private Persona titular;
	private String vencimiento;
	private int  consumo;

	

	public TarjetasCredito(MarcaTarjetas marcaTarjeta, String nroTarjeta, Persona titular, String vencimiento, int consumo) {
		
		this.marcaTarjeta = marcaTarjeta;
		this.nroTarjeta = nroTarjeta;
		this.titular = titular;
		this.vencimiento = vencimiento;
		this.consumo = consumo;
	}
	
	
	public void TasaOperacion() {
		
		if (marcaTarjeta == MarcaTarjetas.VISA) {
			
			try {
				String dateParts[] = vencimiento.split("-");
				String year = dateParts[0];
				String month = dateParts[1];
				String ySub = year.substring(2, 4);
				
				float y = Integer.parseInt(ySub);
				float m = Integer.parseInt(month);
				float result = y / m;
				
				System.out.println("La tasa para VISA es de: " + result);
				
			} catch (Exception e) {
				
				System.out.println("La tasa no es correcta");
			}

		}
		
		if (marcaTarjeta == MarcaTarjetas.NARA) {

			try {
				
				float tasa = 0.5f;
				String dateParts[] = vencimiento.split("-");
				String day = dateParts[2];
				
				float d = Integer.parseInt(day);
				float result = d * tasa;
				
				System.out.println("La tasa para NARA es de: " + result);
				
			} catch (Exception e) {
				System.out.println("La tasa no es correcta");
			}
		}
	
		
		if (marcaTarjeta == MarcaTarjetas.AMEX) {

			try {
				
				float tasa = 0.1f;
				String dateParts[] = vencimiento.split("-");
				String month = dateParts[1];
				
				float m = Integer.parseInt(month);
				float result = m * tasa;
				
				System.out.println("La tasa para AMEX es de: " + result);
				
			} catch (Exception e) {
				System.out.println("La tasa no es correcta");
			}
			
		}
	
	}
	
	
	public static void CompararTarjetas(TarjetasCredito tc, TarjetasCredito tc2) {
		
		if (tc.nroTarjeta == tc2.nroTarjeta) {
			System.out.println("Las tarjetas son iguales");

		}else {
			System.out.println("Las tarjetas no son iguales");

		}

	}
	
	public void ValidarFechaTarjeta(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate result = LocalDate.parse(vencimiento, formatter);
		LocalDate ld =  LocalDate.now();
	   

		if (result.isAfter(ld)) {
			
			System.out.println("La Tarjeta es valida");
		} else {
		
			System.out.println("La Tarjeta no es valida");
		}
		
	}

			
	public void ValidarConsumo() {

		if (consumo < 1000) {
			System.out.println("La operaciones valida");
		}else {
			System.out.println("La operaciones no valida");
		}
		
	}


	public void InfoTarjeta() {
		System.out.println("TarjetasCredito [marcaTarjeta=" + marcaTarjeta + ", nroTarjeta=" + nroTarjeta + ", titular=" + titular + ", vencimiento=" + vencimiento + " ,consumo= " + consumo + "]"); 
	}


	public MarcaTarjetas getMarcaTarjeta() {
		return marcaTarjeta;
	}


	public void setMarcaTarjeta(MarcaTarjetas marcaTarjeta) {
		this.marcaTarjeta = marcaTarjeta;
	}


	public String getNroTarjeta() {
		return nroTarjeta;
	}


	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}


	public Persona getTitular() {
		return titular;
	}


	public void setTitular(Persona titular) {
		this.titular = titular;
	}


	public String getVencimiento() {
		return vencimiento;
	}


	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}


	public int getConsumo() {
		return consumo;
	}


	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	
	
	

}
