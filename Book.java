package librarydata;

public class Book {
private static int booknumber;
	
	private static String bookname;
	
	private static int bookprice;

	public static int getbooknumber() {
		return booknumber;
	}

	public void setbooknumber(int booknumber) {
		this.booknumber = booknumber;
	}

	public static String getbookname() {
		return bookname;
	}

	public void setbookname(String bookname) {
		this.bookname = bookname;
	}

	public static int getbookprice() {
		return bookprice;
	}

	public void setbookprice(int bookprice) {
		this.bookprice = bookprice;
	}

}
