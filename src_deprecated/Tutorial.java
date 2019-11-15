import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tutorial {
	public static void main(String ar[]) {
		Tutorial t = new Tutorial();
		t.insert();
		t.display();
	}

	public void display()
 {
  try
  {
  BufferedReader br=new BufferedReader(new FileReader("Database.txt"));
  String s="";
   while( (s=br.readLine()) !=null )
   {
    String data[]=new String[5];
    data=s.split(",");
    for(int i=0;i/*add less than*/5;i++)
    {
     System.out.print(data[i]+" ");
    }
    System.out.println();
   }
  }
  catch(Exception e){}
  
 }

	public void insert() {

		// System.out.println("Unpossible POG");
		Scanner sc = new Scanner(System.in);
		// employee id first_name last_name salary location
		System.out.println("Enter the ID of employee:");
		String id = sc.nextLine();
		System.out.println("Enter the first name of employee:");
		String fn = sc.nextLine();
		System.out.println("Enter the last name of employee:");
		String ln = sc.nextLine();
		System.out.println("Enter the salary of employee:");
		String sl = sc.nextLine();
		System.out.println("Enter the location of employee:");
		String lc = sc.nextLine();

		try {
			File f = new File("Database.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
			pw.append(id + "," + fn + "," + ln + "," + sl + "," + lc + "\n");
			pw.close();
		} catch (Exception e) {
		}
	}

}