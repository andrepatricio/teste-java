package teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Controller {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		//String filePath = args[0];
		readFile("/home/andrepatricio/Desktop/involves.csv");
		waitCommands();
	}

	private static void readFile(String filePath) throws IOException {
		BufferedReader bufferedReader = getBufferedReader(filePath);		
		FileData fileData = new FileData(bufferedReader.readLine());
		String line = bufferedReader.readLine();
		while(line != null){
			String[] lineElements = line.split(",");
			City city = new City(lineElements);
			fileData.getCities().add(city);				
			line = bufferedReader.readLine();
		}
		System.out.println(fileData.toString());
		System.out.println("Ocorreu algum problema ao ler o arquivo");
		bufferedReader.close();
	}

	private static void waitCommands() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		while(true){
			String userInput = getUserInput();
			String[] commandList = getCommand(userInput);
			for(int i = 1; i< commandList.length; i++){
				System.out.println(commandList[i]);
			}
			
			Method method = Command.class.getDeclaredMethod(commandList[0]);
			System.out.println(method.invoke(new Command()));
		}
	}

	private static String[] getCommand(String userInput) {
		return userInput.split("\\s+");
	}

	private static String getUserInput() {
		System.out.printf("\nInforme um comando: \n");
		return scanner.nextLine();
	}

	private static BufferedReader getBufferedReader(String caminhoDoArquivo) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(caminhoDoArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: "+ caminhoDoArquivo);
		}
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		return bufferedReader;
	}
}
