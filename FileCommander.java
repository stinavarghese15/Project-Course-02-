import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;


public class FileCommander {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//display application name and developer name
			
			System.out.println("WELCOME TO FILE COMMANDER-  a file handling application");
			System.out.println("By Developer: STINA VARGHESE");
			getMenu();
	}
		public static void getMenu() {
			System.out.println("\nPress enter to display menu");
			try{
				System.in.read();
			}
			catch(Exception e){}
			
			//menu on the screen
			System.out.println("MAIN MENU\n"
					+ "\n1.Display Files in the Directory"
					+ "\n2.File Handling Menu"
					+ "\n3.Close the Application");
			//accept user input
			
			System.out.println("\nENTER YOUR CHOICE");
			Scanner sc=new Scanner(System.in);
			int mainMenuUserChoice=sc.nextInt();
			switch(mainMenuUserChoice){
			case 1:
				firstChoice();
				getMenu();
				break;
			case 2:
				secondChoice();
				break;
			case 3:
				try {
					closeChoice();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default :
				System.out.println("\nInvalid Choice");
			
			}
	}
		//to run the case 1 to display list of files in the directory
		public static void firstChoice() {
			System.out.println("\nEnter the directory name to get the list of files");
			Scanner sc=new Scanner(System.in);
			String dirPath=sc.nextLine();
			File fileDir = new File(dirPath);
			
			//to check the directory is empty or not
			if(fileDir.length()>0) {
				
				System.out.println("the directory  is not empty,the files are :\n");
				
					String[] fileList = fileDir.list();
					Arrays.sort(fileList);
				    for(String name:fileList){
				            System.out.println(name);
					}
			}	
			else {
				System.out.println("\nthe directory "+fileDir.getPath()+" is  empty");
			}
		}
		
		//to run for case 2 with 4 other sub menu items
		public static void secondChoice() {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("\nSUB MENU\n"
					+ "\n1.Add a file"
					+ "\n2.Delete a file"
					+ "\n3.Search a file"
					+ "\n4.Go back to main Menu");
			System.out.println("\nENTER YOUR CHOICE");
			int subMenuChoice=sc.nextInt();
			//sub menu options 
			switch(subMenuChoice) {
			case 1:
				addFile();
				secondChoice();
				break;
			case 2:
				deleteFile();
				secondChoice();
				break;
			case 3:
				searchFile();
				secondChoice();
				break;
			case 4:
				System.out.println("\nExiting sub menu");
				getMenu();
				break;
			default :
				System.out.println("\nInvalid Choice");
			
			}
		}
		
		//sub menu case 1 to add a file
		public static void addFile() {
			Scanner sc=new Scanner(System.in);
			System.out.println("\nEnter the path with file name to be created ");
			String dirPath=sc.nextLine();
			File newFile = new File(dirPath);
			try {
				if(newFile.createNewFile()) {
					System.out.println("\nFile is created at "+newFile.getCanonicalPath());
				}
				else {
					System.out.println("\nFile already exists");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//sub menu case 2 to delete a file
		public static void deleteFile() {
			Scanner sc=new Scanner(System.in);
			System.out.println("\nEnter the file to delete");
			String dirPath=sc.nextLine();
			
			
			try {
				File newFile = new File(dirPath);
				String[] listFile=newFile.list();
				if(newFile.delete()) {
					System.out.println("\nFile "+newFile.getName()+" has been deleted");
					
				}
				else {
					System.out.println("File not found");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//sub menu case 3 to search for a file
		public static void searchFile() {
			int flag=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("\nEnter the directory to search");
			String dirPath=sc.nextLine();
				File newFile = new File(dirPath);
				String[] listFile=newFile.list();
				
				//to check the directory is empty or not
				if(listFile.length<=0) {
					System.out.println("\nThe directory is empty");
				}
				else {
					
					System.out.println("\nEnter the file name to be searched");
					String fileSearch=sc.next();
					for(int i=0;i<listFile.length;i++) {
						String fname=listFile[i];
						if(fname.equalsIgnoreCase(fileSearch)) {
							System.out.println(fname+" has found in the directory "+dirPath);
							flag=1;// set flag as one
						}
					}
				}
				if(flag==0) {
					System.out.println("File not found");
				}
			
			
		}
		
		//main menu case 4 to close the running program
		public static void closeChoice() throws InterruptedException {
			System.out.println("\nThank you");
			try {
				Thread t=new Thread();
				t.start();
				Thread.sleep(1000);
				System.out.println("\nClosing File Commander Application");
				System.exit(1);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}	
       


	
