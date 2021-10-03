
package AO1;

import java.util.*;

public class MyAppli {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyShop shop = new MyShop();
		System.out.println("Bienvenue dans le systeme de gestion de stocks");
		while (true) {
			try {
				System.out.println("veuillez choisir l'opération que vous voulez effectuer\n" + "1 : Créer un stock\n"
						+ "2 : ajouter des produits dans le stock\n"
						+ "3 : afficher les caracteristiques d'un produit du stock\n"
						+ "4 : ajouter/retirer une quantité d'un produit donné au stock\n" + "5 : quitter\n ");
				String value = sc.nextLine();
				if (value.length() == 1 && Character.isDigit(value.charAt(0))) {
					switch (Integer.parseInt(value)) {
						case 1:
							System.out.println("veuillez saisir le nom du stock  que vous voulez créer");
							String nameStock = sc.nextLine();
							if (nameStock.isEmpty()) {
								System.out.println("veuillez saisir au moins un charactere");
								break;
							}
							System.out.println("veuillez saisir l'adresse du stock que vous voulez créer");
							String location = sc.nextLine();
							if (location.isEmpty()) {
								System.out.println("veuillez saisir au moins un charactere");
								break;
							}
							if (!shop.createStock(nameStock, location)) {
								System.out.println("ce stock existe déja");
							}
							break;
						case 2:
							if (shop.shopEmpty()) {
								System.out.println("il n'existe aucun stocks");
								break;
							}
							System.out.println("veuillez saisir le nom du stock auquel vous voulez ajouter un produit");
							String nameS = sc.nextLine();
							if (nameS.isEmpty()) {
								System.out.println("veuillez saisir au moins un charactere");
								break;
							}
							System.out.println("veuillez saisir le nom du produit que vous voulez ajouter");
							String nameProduct = sc.nextLine();
							System.out.println("veuillez saisir la quantité de produit que vous voulez ajouter");
							int quantity = Integer.parseInt(sc.nextLine());
							System.out.println("quel est le type de ce produit\n 1 sanitaire \n 2 alimentaire");
							int typeOfProduct = Integer.parseInt(sc.nextLine());
							if (typeOfProduct == 1) {
								if (!shop.addProduct(nameS, new HealthProduct(nameProduct, quantity))) {
									System.out.println("ce produit existe déja");
									break;
								}
							} else {
								System.out.println(
										"veuillez saisir la date de pr�remption du produit sous le format DD/MM/YYYY");
								String dateIn = sc.nextLine();
								String[] date = dateIn.split("/");
								int day = Integer.parseInt(date[0]);
								int month = Integer.parseInt(date[1]);
								int year = Integer.parseInt(date[2]);
								if (!shop.addProduct(nameS, new DietaryProduct(nameProduct, quantity,
										new GregorianCalendar(day, month, year)))) {
									System.out.println("ce produit existe déja");
									break;
								}
							}
							break;
						case 3:
							if (shop.shopEmpty()) {
								System.out.println("il n'existe aucun stocks");
								break;
							}
							System.out.println(
									"veuillez saisir le nom  du stock auquel vous voulez voir les caracteristiques d'un produit");
							String nameStockCase3 = sc.nextLine();
							if (shop.noProductInStock(nameStockCase3)) {
								System.out.println("ce stock ne contient aucun produit");
								break;
							}
							System.out.println(
									"veuillez selectionnez le produit adont vous voulez voir les caracteristiques");
							String productCase3 = sc.nextLine();
							shop.printProduct(nameStockCase3, productCase3);
							break;
						case 4:
							if (shop.shopEmpty()) {
								System.out.println("il n'existe aucun stocks");
								break;
							}
							System.out.println(
									"veuillez selectionnez le stock auquel vous voulez modifier la quantité d'un produit");
							String nameStockCase4 = sc.nextLine();
							if (shop.noProductInStock(nameStockCase4)) {
								System.out.println("ce stock ne contient aucun produit");
								break;
							}
							System.out.println(
									"veuillez selectionnez le produit dont vous voulez ajouter ou retirer une quantité");
							String productCase4 = sc.nextLine();
							System.out.println(
									"veuillez saisir le quantité de produit que vous voulez ajouter ou retirer");
							int q = Integer.parseInt(sc.nextLine());
							shop.modifyProduct(nameStockCase4, productCase4, q);
							break;
						case 5:
							System.exit(0);
						default:
							System.out.println("veuillez saisir une entrée valide");
							break;
					}

				} else {
					System.out.println("veuillez saisir une entrée valide");
				}
			} catch (NoSuchElementException e) {
				System.out.println("aucun élément de ce nom n'existe");
			} catch (NumberFormatException e) {
				System.out.println("veuillez saisir des valeurs num�rique");
			}

		}

	}
}
