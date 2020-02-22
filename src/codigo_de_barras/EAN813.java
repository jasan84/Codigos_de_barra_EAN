package codigo_de_barras;

import javax.swing.JOptionPane;

public class EAN813 {
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "VERIFICA CÓDIGOS DE BARRA\nVERIFICA SI ES UN CÓDIGO EAN-8 O EAN-13\nVERIFICA PAIS DE PERTENENCIA");
		
		String ingresa_codigo = JOptionPane.showInputDialog("INGRESA EL CÓDIGO EAN");		
		int[] codigo_ean = new int[ingresa_codigo.length()];
		String pais ="";
		
		
		
		for (int i=0; i<codigo_ean.length; i++) {
			codigo_ean[i] = Integer.parseInt(ingresa_codigo.substring(i,i+1));
		}
		
		//int[] codigo_ean = {6,5,8,3,9,5,2,2}; // INGRESO DE CODIGO MANUAL
		
		
 // CONDICIONAL QUE INDICA SI ES EAN-8
		
		
		if(codigo_ean.length <= 8 && codigo_ean.length > 0) {
		
			int suma_total=0;
			
// ENCONTRAR POSICIONES IMPARES, APLICAR FORMULA Y SUMAR AL TOTAL
			for(int i=codigo_ean.length-2; i>-1; i--) {
				
				if((i+1)%2!=0 ){	
					suma_total = suma_total+(codigo_ean[i]*3);
				}
				
// ENCONTRAR POSICIONES PARES Y SUMAR AL TOTAL
				if((i+1)%2==0) {
					suma_total = suma_total+codigo_ean[i];
				}
				
			}
			if(suma_total !=0) {
				
// DEFINIR SI LA SUMA TOTAL ES MULTIPLO DE 10
				if ((suma_total + codigo_ean[codigo_ean.length-1])%10==0) {
					System.out.println("si");
				}else {
					System.out.println("no");
				}
			}
			
 // CONDICIONAL QUE INDICA SI ES EAN-13
			
			
		} else if(codigo_ean.length > 8 && codigo_ean.length<=13) {
		
			int suma_total=0;
			
// ENCONTRAR POSICIONES IMPARES, APLICAR FORMULA Y SUMAR AL TOTAL
			for(int i=codigo_ean.length-2; i>-1; i--) {
				
				if((i+1)%2==0 ){	
					suma_total = suma_total+(codigo_ean[i]*3);
				}
				
// ENCONTRAR POSICIONES PARES Y SUMAR AL TOTAL
				if((i+1)%2!=0) {
					suma_total = suma_total+codigo_ean[i];
				}
				
			}
			
			if(suma_total != 0) {
				
// DEFINIR PAIS
				
				if(ingresa_codigo.substring(0,1).equals("0")) {
					pais = "EEUU";
				}else if(ingresa_codigo.substring(0,3).equals("380")) {
					pais = "Bulgaria";
				}else if(ingresa_codigo.substring(0,2).equals("50")) {
					pais = "Inglaterra";
				}else if(ingresa_codigo.substring(0,3).equals("539")) {
					pais = "Irlanda";
				}else if(ingresa_codigo.substring(0,3).equals("560")) {
					pais = "Portugal";
				}else if(ingresa_codigo.substring(0,2).equals("70")) {
					pais = "Noruega";
				}else if(ingresa_codigo.substring(0,3).equals("759")) {
					pais = "Venezuela";
				}else if(ingresa_codigo.substring(0,3).equals("850")) {
					pais = "Cuba";
				}else if(ingresa_codigo.substring(0,3).equals("890")) {
					pais = "India";
				}else {
					pais ="Desconocido";
				}
				
// DEFINIR SI LA SUMA TOTAL ES MULTIPLO DE 10
				if ((suma_total + codigo_ean[codigo_ean.length-1])%10==0) {
					System.out.println("SI " + pais);
				}else {
					System.out.println("NO");
				}
			}
		}
	}
}