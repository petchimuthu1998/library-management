package librarydata;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class Crud {
	Dbconnection get = new Dbconnection();

	Scanner scan = new Scanner(System.in);
	PreparedStatement ps;
	Book b = new Book();

	public static void main(String[] args)throws Exception {
		library();

	}
	public void insertbook() {
		try {
			Connection connect = get.connectDb();
			Object book;
			ps = connect.prepareStatement("insert into addbook(booknumber,bookname,bookprice) values("
					+ b.getbooknumber() + ",'" + b.getbookname() + "'," + b.getbookprice() + ")");

			System.out.println("" + b.getbooknumber());

			int i = ps.executeUpdate();

			if (i != 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("not Inserted");
			}

			int a1, b1 = 0;
			System.out.println("Process Continue Press 1 Or Main page Press 0");
			a1 = scan.nextInt();
			if (a1 != b1) {
				library();
			} else {
				System.exit(0);

			}

		} catch (Exception e) {
			System.out.println("Try Again");
			e.printStackTrace();
		}

	}

	public void updatebook() {
		try {
			Connection connect = get.connectDb();
			ps = connect.prepareStatement("update addbook set '" + b.getbookname() + "','" + b.getbookprice()
					+ "' where '" + b.getbooknumber() + "' ");

			System.out.println("" + b.getbooknumber());

			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("updated");
			} else {
				System.out.println("No data Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletebook() {
		try {
			Connection connect = get.connectDb();
			ps = connect.prepareStatement("delete from addbook where '" + b.getbooknumber() + "'");
			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("deleted");
			} else {
				System.out.println("not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispAll() {
		try {
			Connection connect = get.connectDb();

			Statement st = connect.createStatement();
			ResultSet res = st.executeQuery("select * from addbook");
			while (res.next()) {
				System.out.print(res.getString(1) + "\n");
				System.out.print(res.getString(2) + "\n");
				System.out.print(res.getString(3) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dispAnbook() {
		try {
			Connection connect = get.connectDb();
			ps = connect.prepareStatement("select * from addbook where '" + b.getbooknumber() + "'");

			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.print(res.getString(1) + "\n");
				System.out.print(res.getString(2) + "\n");
				System.out.print(res.getString(3) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void library() {
		Book b = new Book();
		Scanner a = new Scanner(System.in);

		Crud obj = new Crud();
		int ch = 0;

		System.out.println("Library management \n" + "1. Add Book \n " + "2. Edit Book \n " + "3. Deletok \n "
				+ "4. Display all Book \n" + "5.Display a Book\n" + "6. Exit ");

		try {

			int choice = a.nextInt();
			switch (choice) {
			case 1:
				try {
					Scanner scan = new Scanner(System.in);

					System.out.println("Enter Book number");
					b.setbooknumber(a.nextInt());
					System.out.println("Enter Book Name");
					b.setbookname(a.next());
					System.out.println("Enter Book price");
					b.setbookprice(a.nextInt());

					System.out.println("Serialized data is saved in sd.txt file");
					obj.insertbook();

				} catch (InputMismatchException e) {

					System.out.println("Try again!!!!\n");
					library();
				}

			case 2: {
				try {
					System.out.println("Enter Book number");
					b.setbooknumber(a.nextInt());
					System.out.println("Enter Book name");
					b.setbookname(a.next());
					System.out.println("Enter Book Price");
					b.setbookprice(a.nextInt());
					obj.updatebook();
					break;
				} catch (InputMismatchException e) {

				}

				System.out.println("Try again!!!\n");
				library();

			}

			case 3: {
				try {
					System.out.println("Enter Book number to delete record");
					b.setbooknumber(a.nextInt());
					obj.deletebook();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Try again!!!\n");
					library();
				}
			}

			case 4: {
				obj.dispAll();

				break;
			}

			case 5: {
				try {
					System.out.println("Enter Book number to display record");
					b.setbooknumber(a.nextInt());
					obj.dispAnbook();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Try again!!!\n");
					library();
				}
			}

			case 6: {

				System.out.println("Thank You");
				System.exit(0);
			}
			default:

				System.out.println("Try again");
				library();
				break;
			}
		} catch (Exception e) {
			System.out.println("Try Again!!!!\n");
			library();
		}

	}
}
