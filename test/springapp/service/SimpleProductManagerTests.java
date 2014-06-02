package springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import springapp.domain.Product;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import springapp.service.SimpleProductManager;

public class SimpleProductManagerTests {
	private SimpleProductManager productManager;
	private List<Product> products;
	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static Double TABLE_PRICE = new Double(150.10);
	private static String TABLE_DESCRIPTION = "Table";

	private static int POSITIVE_PRICE_INCREASE = 10;

	@Before
	public void initialProducts() throws Exception {
		productManager = new SimpleProductManager();
		products = new ArrayList<Product>();

		Product product = new Product();
		product.setDescription(CHAIR_DESCRIPTION);
		product.setPrice(CHAIR_PRICE);

		products.add(product);

		product = new Product();
		product.setDescription(TABLE_DESCRIPTION);
		product.setPrice(TABLE_PRICE);

		products.add(product);

		productManager.setProducts(products);

	}

	@Test
	public void testGetProductsWithNoProducts() {
		productManager = new SimpleProductManager();

		List<Product> products = productManager.getProducts();
		assertNull(products);

	}

	@Test
	public void testGetProducts() {
		List<Product> products = productManager.getProducts();
		assertNotNull(products);

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}
	
	@Test
	public void testIncreasePriceWithNullListProducts(){
		try{
			productManager = new SimpleProductManager();
			productManager.increasePrice(this.POSITIVE_PRICE_INCREASE);
		}catch (NullPointerException e){
			fail("products list is empty");
		}
	}
	@Test
	public void testIncreasePriceWithEmptyListOfProducts(){
		try{
			productManager = new SimpleProductManager();
			products = new ArrayList<Product>();
			productManager.setProducts(products);
			productManager.increasePrice(this.POSITIVE_PRICE_INCREASE);
			
		} catch (Exception e){
			fail("Product list is empty");
		}
	}
	@Test
	public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Product> products = productManager.getProducts();      
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice(),0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getPrice(),0);       
    }
}
