package teste;

public class City {
	private String ibgeId;
	private String uf;
	private String name;
	private String capital;
	private String lon;
	private String lat;
	private String noAccents;
	private String alternativeNames;
	private String microregion;
	private String mesoregion;
	public City(String... lineElements) {
		this.ibgeId = lineElements[0];
		this.uf = lineElements[1];
		this.name = lineElements[2];
		this.capital = lineElements[3];
		this.lon = lineElements[4];
		this.lat = lineElements[5];
		this.noAccents = lineElements[6];
		this.alternativeNames = lineElements[7];
		this.microregion = lineElements[8];
		this.mesoregion = lineElements[9];
	}
	public String getIbgeId() {
		return ibgeId;
	}
	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getNoAccents() {
		return noAccents;
	}
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	public String getAlternativeNames() {
		return alternativeNames;
	}
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
}
