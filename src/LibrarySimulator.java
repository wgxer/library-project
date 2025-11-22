import java.util.Scanner;

public class LibrarySimulator {
	public static void main(String[] args) {
		// Account Names & IDs
		final Member member1 = new Member(1, "User A", 0);
		final Member member2 = new Member(2, "User B", 0);
		final Member member3 = new Member(3, "User C", 0);
		
		boolean running = true;
		Scanner input = new Scanner(System.in);

		// Selected Account Variables
		boolean adminAccount = false;
		Member selectedMember = new Member(-1, "Placeholder", 0);

		System.out.println("Welcome to Library !");

		// Main Loop
		while (running) {
			if (selectedMember == member1 || selectedMember == member2 || selectedMember == member3) { // User Operations Menu
				// Display possible operations for user account
				System.out.println();
				System.out.println("- User: " + selectedMember.getName() + " (ID: " + selectedMember.getId() + ")");
				System.out.println("» Enter the number of one of the following operations:");
				System.out.println(" 1- Borrow Book");
				System.out.println(" 2- Return Book");
				System.out.println(" 3- View Borrowed Books Count");
				System.out.println(" 4- View Session Summary");
				System.out.println(" 5- Exit to Main Menu");

				// Read operation from user
				int operation = input.nextInt();

				// Apply operation
				switch (operation) {
				case 1: // Borrow Book
					if (selectedMember.borrowOne()) {
						System.out.println("✔ A book has been borrowed successfully");
					} else {
						System.out.println("✘ You can't borrow more than 5 books");
					}

					break;
				case 2: // Return Book
					if (selectedMember.returnOne()) {
						System.out.println("✔ A book has been returned successfully");
					} else {
						System.out.println("✘ You don't have books to return");
					}

					break;
				case 3: // View Borrowed Books Count
					selectedMember.viewBorrowedCount();
					break;
				case 4: // Session Summary
					selectedMember.displayStatistics();
					break;
				case 5: // Return to Main Menu
					selectedMember = new Member(-1, "Placeholder", 0);
					break;
				default:
					System.out.println("✘ Invalid operation: " + operation);
					break;
				}
			} else if (adminAccount) { // Admin Operations Menu
				// Display admin account operations
				System.out.println();
				System.out.println("» Enter the number of one of the following operations:");
				System.out.println(" 1- View Total Revenue");
				System.out.println(" 2- View Most Frequent Operation");
				System.out.println(" 3- Exit to Main Menu");

				// Read operation from user
				int operation = input.nextInt();

				// Apply operation
				switch (operation) {
				case 1: // View total revenue
					System.out.printf("- Total Revenue: %.2f credit fee\n", Member.TotalRevenue);
					break;
				case 2: // View most frequent operation
					if (Member.TotalBorrows == Member.TotalReturns) {
						System.out.println("- Borrow Operations: " + Member.TotalBorrows + " operations");
						System.out.println("- Return Operations: " + Member.TotalReturns + " operations");
					} else if (Member.TotalBorrows > Member.TotalReturns) {
						System.out.println("- Borrow Operations (most frequent): " + Member.TotalBorrows + " operations");
					} else {
						System.out.println("- Return Operations (most frequent): " + Member.TotalReturns + " operations");
					}

					break;
				case 3: // Exit to main menu
					adminAccount = false;
					break;
				default:
					System.out.println("✘ Invalid operation: " + operation);
					break;
				}
			} else { // Main Menu
				// Display main menu
				System.out.println();
				System.out.println("» Enter the number of one of the following options to login or exit:");

				System.out.printf(" 1- %s (ID: %d)\n", member1.getName(), member1.getId());
				System.out.printf(" 2- %s (ID: %d)\n", member2.getName(), member2.getId());
				System.out.printf(" 3- %s (ID: %d)\n", member3.getName(), member3.getId());

				System.out.println(" 4- Admin Account");
				System.out.println(" 5- Exit");

				// Read option from user
				int option = input.nextInt();

				// Do action based on option
				switch (option) {
				// Login as User
				case 1:
					selectedMember = member1;
					selectedMember.reset();
					break;
				case 2:
					selectedMember = member2;
					selectedMember.reset();
					break;
				case 3:
					selectedMember = member3;
					selectedMember.reset();
					break;
				case 4: // Login as Admin
					adminAccount = true;
					break;
				case 5: // Exit from Program
					running = false;
					break;
				default:
					System.out.println("✘ Invalid option: " + option);
					break;
				}
			}
		}
	}
}