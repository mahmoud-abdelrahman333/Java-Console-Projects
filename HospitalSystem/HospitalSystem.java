import java.util.*;

public class HospitalSystem {
	// Each specialization has a deque of patients
	static List<Deque<Map.Entry<String, String>>> v = new ArrayList<>(21);

	// List of medical specializations
	static List<String> medicalSpecializations = Arrays.asList(
			"Cardiology",
			"Neurology",
			"Orthopedics",
			"Pediatrics",
			"Dermatology",
			"Ophthalmology",
			"Radiology",
			"Oncology",
			"Gastroenterology",
			"Endocrinology",
			"Psychiatry",
			"Urology",
			"Pulmonology",
			"Rheumatology",
			"Obstetrics and Gynecology (OB-GYN)"
	);


	static Patient p;
public HospitalSystem(){
	// Initialize the deque list with 21 empty deques
	for (int i = 0; i <= 20; i++) {
		v.add(new ArrayDeque<>());
	}

}
	// Function to handle option 1 (Add new patient)
	public static void option1() {
		// Display the list of specializations
		for (int i = 0; i < medicalSpecializations.size(); i++) {
			System.out.println((i + 1) + " : " + medicalSpecializations.get(i));
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter specialization Number:");
		p = new Patient(scanner.nextInt(), "", 0);
		scanner.nextLine(); // consume newline
		System.out.println("Enter name:");
		p.name = scanner.nextLine();
		System.out.println("Enter status (0 for regular, 1 for urgent):");
		p.status = scanner.nextInt();

		if (p.spec > 20 || p.spec < 1) {
			System.out.println("Error: the specialization number is not valid");
		} else if (v.get(p.spec).size() == 5) {
			System.out.println("The list is full");
		} else {
			// Determine the patient's status and add accordingly
			if (p.status == 0) {
				v.get(p.spec).addLast(new AbstractMap.SimpleEntry<>(p.name, "regular"));
			} else {
				v.get(p.spec).addFirst(new AbstractMap.SimpleEntry<>(p.name, "urgent"));
			}
		}
	}

	// Function to handle option 2 (Print all patients)
	public static void option2() {
        boolean flag=true;
		for (int i = 1; i < v.size(); i++) {
			if (v.get(i).isEmpty()){
				continue;
			} else {
				flag=false;
				System.out.println("There are " + v.get(i).size() + " patients in specialization " + medicalSpecializations.get(i - 1) + ":");
				System.out.println("--------------------");
				for (Map.Entry<String, String> entry : v.get(i)) {
					System.out.println("Name : " + entry.getKey());
					System.out.println("Status : " + entry.getValue());
					System.out.println("--------------------");
				}
			}
		}
		if(flag){
			System.out.println("There are no patients at all specializations.");
		}
	}

	// Function to handle option 3 (Get the next patient)
	public static void option3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the specialization:");
		p = new Patient(scanner.nextInt(), "", 0);

		if (v.get(p.spec).isEmpty()) {
			System.out.println("No patients at the moment, have a rest, Doctor.");
		} else {
			System.out.println(v.get(p.spec).peekFirst().getKey() + " please go to the " + medicalSpecializations.get(p.spec - 1) + " Doctor.");
			v.get(p.spec).pollFirst();
		}
	}

	// Main function to handle the hospital system options
	public static void hospitalSystem() {
		// Initialize the deque list with 21 empty deques
		for (int i = 0; i <= 20; i++) {
			v.add(new ArrayDeque<>());
		}

		int option = 0;
		System.out.println("                                         Hospital System");
		System.out.println("                                         ---------------");

		Scanner scanner = new Scanner(System.in);

		while (option != 4) {
			System.out.println("Enter your choice:");
			System.out.println("1) Add new patient");
			System.out.println("2) Print all patients");
			System.out.println("3) Get the next patient");
			System.out.println("4) Exit");

			option = scanner.nextInt();

			if (option == 1) {
				option1();
			} else if (option == 2) {
				option2();
			} else if (option == 3) {
				option3();
			} else if (option != 4) {
				System.out.println("Invalid option.");
			} else {
				break;
			}

			System.out.println("*************************");
		}
		System.out.println("The end of the day.");
	}


}
