package teste;

import java.util.HashSet;
import java.util.Set;

public class FileData {
	
	private String[] header;
	private Set<String[]> cities;
	public FileData(String header) {
		this.header = header.split(",");
		this.cities = new HashSet<String[]>();
	}
	public String[] getHeader() {
		return header;
	}
	public void setHeader(String[] header) {
		this.header = header;
	}
	public Set<String[]> getCities() {
		return cities;
	}
	public void setCities(Set<String[]> cities) {
		this.cities = cities;
	}

}
