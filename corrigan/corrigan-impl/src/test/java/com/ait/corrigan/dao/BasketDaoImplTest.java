package com.ait.corrigan.dao;

public class BasketDaoImplTest {
//	public static final String sqlBeforeTest = ""
//			+ "INSERT INTO `categories` (`cateID`,`cate_name`) VALUES (99993963,'_TestCategory');INSERT INTO `items` (`itemID`, `name`, `stock_q`, `unit_of_measure`, `description`, `category`) VALUES ('99990001', '_ItemForBasketDaoImplTest', '10', '', 'Desciption text for BasketDaoImplTest', '99993963');INSERT INTO `items` (`itemID`, `name`, `stock_q`, `unit_of_measure`, `description`, `category`) VALUES ('99990002', '_Item2ForBasketDaoImplTest', '23', '', 'Desciption text2 for BasketDaoImplTest', '99993963');";
//	public static final String sqlAfterTest = "DELETE FROM `corrigan`.`items` WHERE `itemID`='99990001';"
//			+ "DELETE FROM `corrigan`.`items` WHERE `itemID`='99990002';"
//			+ "DELETE FROM `categories` WHERE `cateID`='99993963';";
//	private Connection con;
//	public BasketDaoImplTest() {
//		// get db connection
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/corrigan?allowMultiQueries=true","root","qwer1234");
//		}catch (ClassNotFoundException e) {
//			Logger.getLogger(BasketDaoImplTest.class.getName()).log(Level.SEVERE, "Fail to load db driver.", e);
//		} catch (SQLException e) {
//			Logger.getLogger(BasketDaoImplTest.class.getName()).log(Level.SEVERE, "SQL execution fail.", e);
//		}
//	}
//	@Mock
//	private ItemDao mockItemDao;
//	@Before
//	public void setUpMockObjects() {
//		MockitoAnnotations.initMocks(this);
//		when(mockItemDao.getItem(99990001)).thenReturn(new Item(99990001, "_ItemForBasketDaoImplTest", 1, "",
//				"Desciption text for BasketDaoImplTest", new Category(99993963, "_TestCategory")));
//		when(mockItemDao.getItem(99990002)).thenReturn(new Item(99990002, "_Item2ForBasketDaoImplTest", 1, "",
//				"Desciption text2 for BasketDaoImplTest", new Category(99993963, "_TestCategory")));
//	}
//	@Before
//	public void setUpMockData(){
//		Statement stmt;
//		try {
//			stmt = con.createStatement();
//			stmt.executeUpdate(sqlBeforeTest);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	@After
//	public void cleanUpMockData(){
//		Statement stmt;
//		try {
//			stmt=con.createStatement();
//			stmt.executeUpdate(sqlAfterTest);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void CreateDao() {
//		BasketDaoImpl basketDao = new BasketDaoImpl();
//		Assert.assertTrue("BasketDaoImpl instantiation failed.", basketDao != null);
//	}
//
//	@Test
//	public void addBasketTest() {
//
//		BasketDaoImpl basketDao = new BasketDaoImpl();
//
//		Customer testCustomer = new Customer();
//		testCustomer.setCustomerId(99991234);
//
//		@SuppressWarnings("serial")
//		Map<Item, Integer> testItems = new HashMap<Item, Integer>(){
//		{
//			put(mockItemDao.getItem(99990001), 2);
//			put(mockItemDao.getItem(99990002), 4);
//		}};
//
//
//		Basket basket = new Basket(testCustomer, testItems);
//		Basket basketReturn = basketDao.getBasket(basketDao.addBasket(basket));
//		Assert.assertTrue(basket.equals(basketReturn));
//
//	}
//
//	@Test
//	public void updateBasketTest() {
//		//TODO
//	}
//
//	@Test
//	public void deleteBasketTest() {
//		//TODO
//	}
//
//	@Test
//	public void getBasketTest() {
//		//TODO
//	}
//
//	@Test
//	public void addItemTest() {
//		//TODO
//	}
//
//	@Test
//	public void updateItemTest() {
//		//TODO
//	}
//
//	@Test
//	public void deleteItemTest() {
//		//TODO
//	}

}
