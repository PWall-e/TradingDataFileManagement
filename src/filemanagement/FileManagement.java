package filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileManagement {

	//final String filepath;

	public void readingFile() throws IOException {
		String[] field;
		String[] conditionField;
		String[] takingMinutes;
		String[] name;
		int value;
		
		Scanner filePath = new Scanner(System.in);
		System.out.print("Please enter the File Path: ");
		String filepath = filePath.nextLine();
		
		System.out.println(filepath);
		name =  filepath.split("\\.");
		System.out.println(name[1]);
		
		Scanner inputParser = new Scanner(System.in);
		System.out.print("Enter the Time Divisor: ");
		int timeDivizor = inputParser.nextInt();
		
		BufferedReader buffReader = new BufferedReader(new FileReader(filepath));
		String firstLine = buffReader.readLine();
		PrintWriter writer = new PrintWriter(name[0] + "managedBy" + timeDivizor + ".csv", "UTF-8");
		writer.println(firstLine);
		
			while (true) {
				String currentLine = buffReader.readLine();
				if (currentLine == null)
					break;
				field = currentLine.split(",");
				
				conditionField = field[0].split(" ");
				
				takingMinutes =  conditionField[1].split(":");
				
				value = new Integer(takingMinutes[1]);
				
				if(value % timeDivizor == 0){
					writer.println(currentLine);
				}
			}
			
		buffReader.close();
		writer.close();
	}
	
	public static void main(String[] args) {
		FileManagement a = new FileManagement();
		try {
			a.readingFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
	}
}

