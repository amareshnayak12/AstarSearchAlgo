

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputFileReader {
	static int lineCount;
	
	
	/**
	 * @return the lineCount
	 */
	public int getLineCount() {
		return lineCount;
	}

	/**
	 * @param lineCount the lineCount to set
	 */
	public void setLineCount(int lineCount) {
		InputFileReader.lineCount = lineCount;
	}

	public List<String> readLargeMapFile(String filename){		
		BufferedReader br=null;
		FileReader fr=null;
		List<String> records = new ArrayList<String>();
		try
		  {
			fr=new FileReader(filename);
		    br = new BufferedReader(fr);
		    String line;
		    
		    while ((line = br.readLine()) != null)
		    {
		    	lineCount++;
		      records.add(line);
		    }
		    
		    setLineCount(lineCount);
		    
		    br.close();
		    return records;
		  }catch (Exception e){
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    return null;
		  }
		}
	
	public Map <String,Coordinates> getStartAndGoalLocation(List<String> records, char target,String key){		
		Map <String,Coordinates> multiplePoints=new HashMap<String,Coordinates>();		
		String temp="";
		char str=0;
		for(int i=0;i<records.size();i++){			
			    temp=records.get(i);
			    for(int j=0;j<temp.length();j++){
			    	str=temp.charAt(j);
			    	if(str== target){			    		        
			    		 multiplePoints.put(key, new Coordinates(i, j));
			    	}
			    }			 
		}		
		return multiplePoints;
	}
	
	public void convertGridValue(List<String> records, Utility util){	
		System.out.println("inside convertGridValue ");
		String temp="";
		char str=0;		
		for(int i=0;i<records.size();i++){	
			    temp=records.get(i);
			    System.out.println(temp);
			    
			    
			    for(int j=0;j<temp.length();j++){
			    	str=temp.charAt(j);
			    	if(str== '@' ||str=='X'||str=='.'){				    		 
			    		 util.grid[i][j]=1;
			    	}else if(str=='*'){			    		
			    		util.grid[i][j]=2;
			    	}else if(str=='^'){
			    		util.grid[i][j]=3;
			    	}else if(str=='~'){
			    		util.grid[i][j]=0;
			    	}else{
			    		util.grid[i][j]=-1;
			    	}
			    		
			    }			 
		}		
		
	}
 }


