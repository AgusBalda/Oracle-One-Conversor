package Programa;

import javax.swing.*;

public class Conversor {
	public static void main(String[] args) {
		String[] options = { "Conversor de Moneda", "Salir" };

		while (true) {
			int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Aplicación de Conversión",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (choice == 0) {

				// Lista de monedas y sus tasas de conversión (ejemplo)
				String[] currencies = { "Dólares", "Euros", "Libras Esterlinas", "Yen Japones", "wones coreanos" };
				double[] rates = { 0.0029, 0.0026, 0.0022, 0.42, 3.83 }; // Tasa de conversión según moneda
				boolean validInput = false;

				while (!validInput) {
					// Solicitar al usuario ingresar el monto
					String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad de Pesos Argentinos:");
					
					try {
						if (Double.parseDouble(input) < 0) {
							while (Double.parseDouble(input) < 0)
								input = JOptionPane.showInputDialog(null, "Ingrese un numero mayor o igual a 0");
						}
						validInput = true;
						double pesos = Double.parseDouble(input);

						// Solicitar al usuario seleccionar una moneda
						int currencyChoice = JOptionPane.showOptionDialog(null,
								"Seleccione la moneda a la que desea convertir:", "Seleccionar Moneda",
								JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, currencies, currencies[0]);

						double dollars = pesos * rates[currencyChoice];

						JOptionPane.showMessageDialog(null,
								pesos + " Pesos Argentinos equivalen a " + dollars + " " + currencies[currencyChoice],
								"Resultado de la Conversión", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ingresa un valor numérico válido", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (choice == 1) {
				// Salir del programa
				JOptionPane.showMessageDialog(null, "Saliendo del programa...");
				System.exit(0);
			}
		}
	}
}
