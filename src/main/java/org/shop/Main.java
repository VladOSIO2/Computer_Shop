package org.shop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.shop.computer.Product;
import org.shop.util.db.DBMock;

public class Main {

  public static void main(String[] args) {
    List<Product> computerList = new ArrayList<>(DBMock.getAllComputers());
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to our shop! Here we have the next computers:\n");
    printProducts(computerList);

    System.out.println("Would you like to buy any of them?");
    System.out.println("Enter the position number you'd like to buy, or 0 to exit");

    int chosen = Integer.MIN_VALUE;

    do {
      try {
        chosen = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("You need to enter an integer.");
      }
      if (chosen < 0 || chosen > computerList.size())
        System.out.println("Invalid position number! Enter the valid one, or 0 to exit.");
      else
        break;
    } while (true);

    if (chosen == 0) {
      System.out.println("Ok. Have a good day!");
    } else {
      System.out.println("Good for you! Buying computer #" + chosen +
          ", named: " + computerList.get(chosen - 1).getName());
      computerList.remove(chosen - 1);
    }
    System.out.println("\nComputers left in stock:\n");
    printProducts(computerList);
  }

  private static void printProducts(List<Product> productList) {
    for (int i = 0; i < productList.size(); i++) {
      Product product = productList.get(i);
      System.out.println("Position #" + (i + 1) + ", named: " + product.getName());
      for (Map.Entry<String, String> property : product.getProperties().entrySet()) {
        System.out.println("\t" + property.getKey() + " : " + property.getValue());
      }
      System.out.println("Total price of this product: " + product.getPrice() + "\n");
    }
  }
}