package services;

public class Analysis {
	private String[] queries;

	public Analysis(String[] queries) {
		this.queries = queries;
	}

	public String getQuery(int index) {
		return this.queries[index];
	}
}
