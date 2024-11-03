import java.util.*;

class LibrarySystem{
	private static Deque<Book> books = new ArrayDeque<>();
	private static Deque<User> users = new ArrayDeque<>();
	private static Map<Integer, Integer> borrowedBooks = new HashMap<>();
	private static Map<Integer, List<Integer>> usersBorrow = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);

	public  static void addBook() {
		System.out.println("Enter the book info: id, name, and quantity:");
		int id = scanner.nextInt();
		scanner.nextLine();  // Consume newline
		String name = scanner.nextLine();
		int quantity = scanner.nextInt();
		books.addFirst(new Book(id, name, quantity));
	}

	public static void searchBookByPrefix() {
		System.out.println("Enter the prefix:");
		String prefix = scanner.next();
		boolean found = false;
		for (Book book : books) {
			if (book.name.startsWith(prefix)) {
				System.out.println(book.name);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No book with such prefix.");
		}
	}

	public static void printBooksById() {
		List<Book> sortedBooks = new ArrayList<>(books);
		sortedBooks.sort(Comparator.comparingInt(b -> b.id));
		for (Book book : sortedBooks) {
			System.out.println("name: " + book.name + " | id: " + book.id +
					" | quantity: " + (book.quantity - borrowedBooks.getOrDefault(book.id, 0)) +
					" | number of borrowed books: " + borrowedBooks.getOrDefault(book.id, 0));
		}
	}

	public static void printBooksByName() {
		List<Book> sortedBooks = new ArrayList<>(books);
		sortedBooks.sort(Comparator.comparing(b -> b.name));
		for (Book book : sortedBooks) {
			System.out.println("name: " + book.name + " | id: " + book.id +
					" | quantity: " + (book.quantity - borrowedBooks.getOrDefault(book.id, 0)) +
					" | number of borrowed books: " + borrowedBooks.getOrDefault(book.id, 0));
		}
	}

	public static void addUser() {
		System.out.println("Enter the user name and id:");
		scanner.nextLine();  // Consume newline
		String name = scanner.nextLine();
		int id = scanner.nextInt();
		users.addFirst(new User(id, name));
	}

	public static void userBorrowBook() {
		System.out.println("Enter the user id and book id:");
		int userId = scanner.nextInt();
		int bookId = scanner.nextInt();
		borrowedBooks.put(bookId, borrowedBooks.getOrDefault(bookId, 0) + 1);
		usersBorrow.putIfAbsent(userId, new ArrayList<>());
		usersBorrow.get(userId).add(bookId);
	}

	public static void userReturnBook() {
		System.out.println("Enter the user id and book id:");
		int userId = scanner.nextInt();
		int bookId = scanner.nextInt();
		borrowedBooks.put(bookId, borrowedBooks.getOrDefault(bookId, 0) - 1);
		if (usersBorrow.containsKey(userId)) {
			usersBorrow.get(userId).remove(Integer.valueOf(bookId));
		}
	}

	public static void printUsers() {
		for (User user : users) {
			boolean hasBorrowed = false;
			System.out.print("name: " + user.name + " | id: " + user.id + " | borrowed books: ");
			if (usersBorrow.containsKey(user.id)) {
				for (int bookId : usersBorrow.get(user.id)) {
					System.out.print(bookId + " ");
					hasBorrowed = true;
				}
			}
			if (!hasBorrowed) {
				System.out.println("the user hasn't borrowed any books yet.");
			} else {
				System.out.println();
			}
		}
	}

	public static void printWhoBorrowedBooksByName() {
		for (User user : users) {
			if (usersBorrow.containsKey(user.id) && !usersBorrow.get(user.id).isEmpty()) {
				System.out.print("name: " + user.name + " books: ");
				for (int bookId : usersBorrow.get(user.id)) {
					System.out.print(bookId + " ");
				}
				System.out.println();
			}
		}
	}

	public static void librarySystem() {
		System.out.println("Library menu:");
		System.out.println("1) add book");
		System.out.println("2) search book by prefix");
		System.out.println("3) print who borrowed books by name");
		System.out.println("4) print books sorted by id");
		System.out.println("5) print books sorted by name");
		System.out.println("6) add user");
		System.out.println("7) user borrow book");
		System.out.println("8) user return book");
		System.out.println("9) print users");
		System.out.println("10) Exit");

		int op = 0;
		while (op != 10) {
			System.out.println("Enter your menu choice [1-10]:");
			try{
			op = scanner.nextInt();
			}
			catch(Exception e){
				System.out.println(e.getCause());
				break;
			}



			switch (op) {
				case 1 :
					addBook();
					break;
				case 2 :
					searchBookByPrefix();
					break;
				case 3 :
					printWhoBorrowedBooksByName();
					break;
				case 4 :
					printBooksById();
					break;
				case 5 :
					printBooksByName();
					break;
				case 6 :
					addUser();
					break;
				case 7 :
					userBorrowBook();
					break;
				case 8 :
					userReturnBook();
					break;
				case 9 :
					printUsers();
					break;
				case 10 :
					System.out.println("Exiting the system.");
					break;
				default :
					System.out.println("Error: invalid option.");
			}
		}
	}

}





