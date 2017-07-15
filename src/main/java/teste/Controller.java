package teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		//String filePath = args[0];
		Command commads = readFile("/Users/andrepatricio/Documents/ambiente_prog/workspace/teste-java/involves.csv");
		waitCommands(commads);
	}

	private static Command readFile(String filePath) throws IOException {
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

	private static void waitCommands(Command commands) {
		while(true){
			String userInput = getUserInput();
			if(userInput.equals("count *")){
				System.out.println("Count: " + commands.count()); 
			} else if (userInput.startsWith("count distinct")){
				try {
					System.out.println(commands.count("uf"));
				} catch (PropertyNotFoundException e) {
					System.out.println("A propriedade procurada nao existe no arquivo");
				}
			} else if (userInput.startsWith("filter")){
				try {
					System.out.println(commands.find("uf", "RO"));
				} catch (PropertyNotFoundException e) {
					System.out.println("A propriedade procurada nao existe no arquivo");
				}
			} else {
				System.out.println("Comando nao encontrado");
			}
		}
	}

	private static String getUserInput() {
		System.out.printf("\nInformar o comando: \n");
		return scanner.nextLine();
	}
	
	private static String[] getParam(String userInput){
		Matcher m = Pattern.compile("filter ([\\w]*)").matcher(userInput);
		if(m.matches()){
		    System.out.println("Name entered: " + m.group(1));
		}
		return null;
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
