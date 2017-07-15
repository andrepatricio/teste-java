package teste;

import java.util.ArrayList;
import java.util.List;


public class Command {
	
	private FileData fileData;
	
	public Command(FileData fileData) {
		this.fileData = fileData;
	}
	public int count(){
		return fileData.getCities().size();
	}
	public int count(String property) throws PropertyNotFoundException{
		int indexSearch = getIndexByProperty(property);
		List<String> listDistinctValues = new ArrayList<String>();
		for(String[] city : fileData.getCities()){
			if(!listDistinctValues.contains(city[indexSearch])){
				listDistinctValues.add(city[indexSearch]);
			}
		}
		return listDistinctValues.size();
	}
	public String find(String property, String value) throws PropertyNotFoundException{
		String result = formmatCSV(fileData.getHeader()) + "\n";
		int indexSearch = getIndexByProperty(property);
		for(String[] city : fileData.getCities()){
			if(city[indexSearch].equals(value)){
				result += formmatCSV(city);
			}
		}
		return result;
	}
	
	private int getIndexByProperty(String property) throws PropertyNotFoundException {
		for(int i = 0; i<fileData.getHeader().length; i++){
			if(fileData.getHeader()[i].equals(property)){
				return i;
			}
		}
		throw new PropertyNotFoundException();
	}
	
	private String formmatCSV(String[] lineElements){
		String result = "";
		for(int i = 0; i < lineElements.length; i++){
			String element = i == lineElements.length - 1 ?  lineElements[i] : lineElements[i]+",";
			result += element;
		}
		return result+ "\n";
	}

}
