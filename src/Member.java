public class Member {
	private int id;
	private String name;
	private int borrowedCount;
	
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	
	private double sessionFees;

	public static double TotalRevenue = 0;
	public static int TotalViewBorrowed = 0;
	public static int TotalBorrows = 0;
	public static int TotalReturns = 0;

	// Constructor
	public Member(int id, String name, int borrowedCount) {
		this.id = id;
		this.name = name;
		this.borrowedCount = borrowedCount;
	}
	
	private boolean canBorrow() {
		return false;
	}
	
	private boolean canReturn() {
		return false;
	}
	
	public void viewBorrowedCount() {
		
	}
	
	// A method that tries to borrow one book
	public boolean borrowOne() {
		if (!canBorrow()) {
			return false;
		}
		
		this.borrowedCount += 1;

		this.numBorrows += 1;
		this.sessionFees += 0.5f;

		TotalRevenue += 0.5f;
		TotalBorrows += 1;
		
		return true;
	}
	
	// A method that tries to return one book
	public boolean returnOne() {
		if (!canReturn()) {
			return false;
		}
		
		this.borrowedCount -= 1;
		this.numReturns += 1;
		
		TotalReturns += 1;
		
		return true;
	}
	
	public void displayStatistics() {
		
	}
	
	public void reset() {
		
	}
}
