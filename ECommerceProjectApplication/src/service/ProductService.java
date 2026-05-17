package service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entity.ProductEntity;

public class ProductService {

	private List<ProductEntity> products = Arrays.asList(new ProductEntity(1, "Laptop", 40000.0, 4),
			new ProductEntity(2, "Mouse", 1000.0, 10), new ProductEntity(3, "KeyBoard", 2000.0, 3),
			new ProductEntity(4, "Screen", 4, 1), new ProductEntity(5, "Charger", 1500.0, 5)).stream().distinct()
			.collect(Collectors.toList());

	public List<ProductEntity> getAllProducts() {

		return products;
	}

	public ProductEntity getProductById(int id) {
		return products.stream().filter(n -> n.getId() == id).findFirst().orElse(null);

	}

	public List<ProductEntity> searchProducts(String keyword) {
		return products.stream().filter(n -> n.getName().toLowerCase().contains(keyword.toLowerCase().trim()))
//	                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());

	}

	public List<ProductEntity> sortProductsByPrice(boolean ascending) {
		Comparator<ProductEntity> comparator = Comparator.comparing(ProductEntity::getPrice);
		if (!ascending) {
			comparator = comparator.reversed();
		}
		return products.stream().sorted(comparator).collect(Collectors.toList());
	}

	public static void printProducts(List<ProductEntity> productEntities) {
		if (productEntities.isEmpty()) {
			System.out.println("No products found.");
		} else {
			System.out.println();
			for (ProductEntity productEntitys : productEntities) {
				System.out.println(
						productEntitys.getId() + " " + productEntitys.getName() + " " + productEntitys.getPrice());
			}
			System.out.println();
		}
	}
}
