class Book {
	int id;
	String name;
	int quantity;
	int borrowed;

	Book(int id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.borrowed = 0;
	}
}