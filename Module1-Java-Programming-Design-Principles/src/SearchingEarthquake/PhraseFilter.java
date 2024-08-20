package SearchingEarthquake;

public class PhraseFilter implements Filter{

	private String typeRequest;
	private String phraseSearch;
	
	public PhraseFilter(String tr, String ps) {
		
		typeRequest = tr;
		phraseSearch = ps;
		
	}
	
	@Override
	public boolean satisfies(QuakeEntry entry) {

		String info = entry.getInfo();
		
		switch(typeRequest) 
		{
		case "start": if(info.startsWith(phraseSearch))
					  return true;
		case "end":   if(info.endsWith(phraseSearch))
			          return true;
		case "any":   if(info.indexOf(phraseSearch) != -1)
			          return true;
		}
	
		return false;
		
	}

}
