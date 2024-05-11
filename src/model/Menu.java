package model;

import java.util.Scanner;

public class Menu implements Imenu {
	public static void main(String[] args) {

    try{
		// Hardcodeo de las armas
		Weapon[] weapons = new Weapon[] {
				new Weapon ("Espada", 150, 25),
				new Weapon ("Hacha", 90, 15),
				new Weapon ("Barreta", 70, 2),
				new Weapon ("Palo", 50, 5),
				new Weapon ("Mazo", 100, 10),
		    };
		// Solicitamos datos al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del personaje: ");
        String characterName = scanner.nextLine();
        System.out.print("Ingrese la salud máxima del personaje: ");
        int characterMaxHp = scanner.nextInt();
        int characterCurHp = characterMaxHp;

        // Creamos el personaje y le asignamos un arma
        GameCharacter character = new GameCharacter(characterName, characterMaxHp, characterCurHp);
        System.out.println("Elija un arma:");
        for (int i = 0; i < weapons.length; i++) {
            System.out.printf("%d. %s (Daño: %d-%d)\n", i + 1, weapons[i].name, weapons[i].minDmg, weapons[i].maxDmg);
        }
        int weaponChoice;
        do {
        System.out.print("Elija un arma (1-5): ");
        weaponChoice = scanner.nextInt();
        if (weaponChoice < 1 || weaponChoice > weapons.length) {
        System.out.println("Error: Opción inválida. Elija un arma entre 1 y " + weapons.length);
         }
        } while (weaponChoice < 1 || weaponChoice > weapons.length);
        character.setWeapon(weapons[weaponChoice - 1]);
        
        // Mostramos información del personaje
        System.out.println("\nPersonaje:");
        System.out.printf("Nombre: %s\n", character.name);
        System.out.printf("Salud máxima: %d\n", character.maxHp);
        System.out.printf("Salud actual: %d\n", character.curHp);
        if (character.myWeapon != null) {
        	  System.out.printf("Arma: %s (Daño: %d-%d)\n", character.myWeapon.name, character.myWeapon.minDmg, character.myWeapon.maxDmg);
        	} else {
        	  System.out.println("No hay arma equipada");
        	}
		}
    catch (Exception e) {
      System.out.println("Error:" + e);
    }
}
}
