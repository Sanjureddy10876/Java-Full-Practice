package productmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import entity.ProductEntity;
import execptions.EmptyCartExeception;
import execptions.OutOfStockException;
import service.CartService;
import service.CheckOutService;
import service.ProductService;

public class ListofProducts {

	public static void main(String[] args) {
		ProductService productService = new ProductService();
		CartService cartService = new CartService();
		CheckOutService checkoutService = new CheckOutService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to ECommerce");

		while (true) {
			System.out.println(
					"\n1. View Products\n2. Search/Sort Products\n3. Add to Cart\n4. Remove from Cart\n5. Update Quantity\n6. View Cart\n7. Checkout\n8. Exit");
//            System.out.println("View Products. Search Sort Products. Add to Cart. Remove from Cart. Update Quantity. View Cart. Checkout. Exit");
			System.out.print("Select an option ");

			try {
				int selectedOption = sc.nextInt();

				switch (selectedOption) {
				case 1:
					productService.printProducts(productService.getAllProducts());
					break;
				case 2:
					System.out.println("a. Search by Name | b. Sort Low-High | c. Sort High-Low");
					String subChoice = sc.next();
					if (subChoice.equalsIgnoreCase("a")) {
						System.out.print("Enter search keyword ");
						productService.printProducts(productService.searchProducts(sc.next().trim()));
					} else if (subChoice.equalsIgnoreCase("b")) {
						productService.printProducts(productService.sortProductsByPrice(true));
					} else if (subChoice.equalsIgnoreCase("c")) {
						productService.printProducts(productService.sortProductsByPrice(false));
					}
					break;
				case 3:
					System.out.print("Enter Product ID to add ");
					int addId = sc.nextInt();
					System.out.print("Enter Quantity ");
					int addQty = sc.nextInt();
					ProductEntity productToAdd = productService.getProductById(addId);
					cartService.addProductToCart(productToAdd, addQty);
					break;
				case 4:
					System.out.print("Enter Product ID to remove ");
					int removeId = sc.nextInt();
					ProductEntity productToRemove = productService.getProductById(removeId);
					cartService.removeProductFromCart(productToRemove);
					break;
				case 5:
					System.out.print("Enter Product ID to update ");
					int updateId = sc.nextInt();
					System.out.print("Enter new Quantity ");
					int newQty = sc.nextInt();
					ProductEntity productToUpdate = productService.getProductById(updateId);
					cartService.updateQuality(productToUpdate, newQty);
					break;
				case 6:
					cartService.viewCart();
					break;
				case 7:
					checkoutService.processCheckout(cartService);
					break;
				case 8:
					System.out.println("Exiting... Have a great day");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option. Please try again");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter valid text/numbers");
				sc.nextLine();
			} catch (EmptyCartExeception | OutOfStockException e) {
				System.out.println("Error " + e.getMessage());
			} catch (Exception e) {
				System.out.println("An unexpected error occurred " + e.getMessage());
			}
		}
	}

}
