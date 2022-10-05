package com.example.demo.tarjetas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTarjetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTarjetasApplication.class, args);
		
		Persona p = new Persona("Daniel", "Maldonado" );
		Persona p2 = new Persona ("Alan", "Aguiar");
		Persona p3 = new Persona ("Micaela", "Baez");
		
		TarjetasCredito tc1 = new TarjetasCredito(MarcaTarjetas.VISA, "123456", p, "2021-10-10", 900);
		TarjetasCredito tc2 = new TarjetasCredito(MarcaTarjetas.NARA, "654321", p2, "2023-11-07", 1000);
		TarjetasCredito tc3 = new TarjetasCredito(MarcaTarjetas.AMEX, "456729",  p3, "2024-12-23", 700);
		 
		tc1.InfoTarjeta();
		tc2.InfoTarjeta();
		tc3.InfoTarjeta();
		
		tc1.ValidarConsumo();
		tc2.ValidarConsumo();
		tc3.ValidarConsumo();
		
		tc1.ValidarFechaTarjeta();
		tc2.ValidarFechaTarjeta();
		tc3.ValidarFechaTarjeta();
		
		TarjetasCredito.CompararTarjetas(tc2, tc3);
		TarjetasCredito.CompararTarjetas(tc1, tc2);
		
		tc1.TasaOperacion();
		tc2.TasaOperacion();
		tc3.TasaOperacion();
	}

}
