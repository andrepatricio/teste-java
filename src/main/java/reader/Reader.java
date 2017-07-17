package reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

	public static Command readCSV(String filePath) throws IOException{
		BufferedReader bufferedReader = getBufferedReader(filePath);		
		FileData fileData = new FileData(bufferedReader.readLine());
		String line = bufferedReader.readLine();
		while(line != null){
			fileData.getCities().add(line.split(","));
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return new Command(fileData);
	}
	
	private static BufferedReader getBufferedReader(String caminhoDoArquivo) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(caminhoDoArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado: "+ caminhoDoArquivo);
		}
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		return bufferedReader;
	}
	
}
