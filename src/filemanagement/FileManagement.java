package filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManagement {

	final String filepath = "4001.csv";

	public void readingFile() throws IOException {
		String[] field;
		String[] conditionField;
		String[] takingMinutes;
		int value;
		
		BufferedReader buffReader = new BufferedReader(new FileReader(filepath));
		String firstLine = buffReader.readLine();
		PrintWriter writer = new PrintWriter("4001managed.csv","UTF-8");
		writer.println(firstLine);
		
			while (true) {
				String currentLine = buffReader.readLine();
				if (currentLine == null)
					break;
				field = currentLine.split(",");
				
				conditionField = field[0].split(" ");
				
				takingMinutes =  conditionField[1].split(":");
				
				value = new Integer(takingMinutes[1]);
				
				if(value % 3 == 0){
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

