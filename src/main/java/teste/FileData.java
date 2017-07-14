package teste;

import java.util.HashSet;
import java.util.Set;

public class FileData {
	
	private String header;
	private Set<City> cities;
	public FileData(String header) {
		this.header = header;
		this.cities = new HashSet<City>();
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
