/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2017  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */

import java.util.List;
import java.util.Scanner;

import interfaces.Calculation;
import interfaces.EEAImplementation;
import loader.PluginLoader;

public class Cryptocalc {

	private static List<Calculation> calculationPlugins;
	public static Scanner scanner = new Scanner(System.in);
	public static List<EEAImplementation> eeaPlugins;
	
	public static void main(String[] args) throws InterruptedException {
		calculationPlugins = PluginLoader.load(Calculation.class);
		eeaPlugins = PluginLoader.load(EEAImplementation.class);
		System.out.println(eeaPlugins.size());
		printMenu();
	}

	private static void printMenu() {
		
		System.out.println("Enter one of the following numbers to start a calculation: ");
		
		for (Calculation c : calculationPlugins) {
			System.out.println("\t" + calculationPlugins.indexOf(c) + "\t" + c.getName());
		}
		
		System.out.println("\n\t99\tquit");

		int selection = scanner.nextInt();
		
		execute(selection);
	}
	
	private static void execute(int selection) {
		
		if(selection == 99) {
			System.exit(0);
		}
		calculationPlugins.get(selection).execute();
		returnToMenu();
	}
	
	private static void returnToMenu() {

		System.out.println("\n\npress enter to return to menu");
		scanner.nextLine();
		scanner.nextLine();
		System.out.print("\n\n\n");
		printMenu();
	}

}
