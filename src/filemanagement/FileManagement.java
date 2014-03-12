package filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManagement {

	public static void readingFile() throws IOException {
		Scanner filePath = new Scanner(System.in);
		System.out.print("Please enter the File Path: ");
		String filepath = filePath.nextLine();
	
		String[] fileName =  filepath.split("\\.");
		
		Scanner inputParser = new Scanner(System.in);
		System.out.print("Enter the Minute Divisor: ");
		int timeDivizor = inputParser.nextInt();
		
		BufferedReader buffReader = new BufferedReader(new FileReader(filepath));
		String firstLine = buffReader.readLine();
		PrintWriter writer = new PrintWriter(fileName[0] + "managedBy" + timeDivizor + ".csv", "UTF-8");
		writer.println(firstLine);
		
			while (true) {
				String currentLine = buffReader.readLine();
				if (currentLine == null)
					break;
				String[] splitedLine = currentLine.split(",");
				
				String[] timeField = splitedLine[0].split(" ");
				
				String[] splitedTime = timeField[1].split(":");
				
				int minutesValue = new Integer(splitedTime[1]);
				
				if(minutesValue % timeDivizor == 0){
					writer.println(currentLine);
				}
			}
			
		filePath.close(); 
		inputParser.close();//Close Scanners
		buffReader.close(); //Close reader
		writer.close(); //Close writer
	}
	
	public static void main(String[] args) {
		try {//the static method
			readingFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
	}
}

