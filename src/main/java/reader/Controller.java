package reader;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reader.exception.CommandOutOfPatternException;
import reader.exception.PropertyNotFoundException;

public class Controller {
	
	private static final String FILTER_REGEX = "filter (['-.\\p{L}\\w\\s]*)";
	private static final String COUNT_DISTINCT_REGEX = "count distinct ([\\w]*)";
	private static final String FILTER = "filter";
	private static final String COUNT_DISTINCT = "count distinct";
	private static final String COUNT = "count *";
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String filePath = args[0];
		try {
			Command commads = Reader.readCSV(filePath);
			waitCommands(commads);
		} catch (IOException e) {
			System.out.println("Problema ao ler o arquivo");
		}
	}

	private static void waitCommands(Command commands) {
		while(true){
			String userInput = getUserInput();
			if(userInput.equals(COUNT)){
				System.out.println("Total de registros: " + commands.count()); 
			} else if (userInput.startsWith(COUNT_DISTINCT)){
				countDistinct(commands, userInput);
			} else if (userInput.startsWith(FILTER)){
				filter(commands, userInput);
			} else {
				System.out.println("Comando nao encontrado");
			}
		}
	}

	private static void filter(Command commands, String userInput) {
		try {
			String params = getParams(userInput, FILTER_REGEX);
			String property = params.substring(0, params.indexOf(" "));
			String value = params.substring(params.indexOf(" "), params.length()).trim();
			System.out.println(commands.filter(property, value));
		} catch (PropertyNotFoundException e) {
			System.out.println("A propriedade procurada nao existe no arquivo");
		} catch (CommandOutOfPatternException | StringIndexOutOfBoundsException e) {
			System.out.println("O comando esta fora do padrao");
		}
	}

	private static void countDistinct(Command commands, String userInput) {
		try {
			System.out.println("Total de valores distintos: " + commands.count(getParams(userInput, COUNT_DISTINCT_REGEX)));
		} catch (PropertyNotFoundException e) {
			System.out.println("A propriedade procurada nao existe no arquivo");
		} catch (CommandOutOfPatternException e) {
			System.out.println("O comando esta fora do padrao");
		}
	}

	private static String getUserInput() {
		System.out.printf("\nInformar o comando: \n");
		return scanner.nextLine();
	}
	
	private static String getParams(String userInput, String regex) throws CommandOutOfPatternException{  
		Matcher matcher = Pattern.compile(regex).matcher(userInput);
		if(matcher.matches())
		{
		    return matcher.group(1);
		}
		throw new CommandOutOfPatternException();
	}
}
