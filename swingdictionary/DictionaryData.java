package swingdictionary;

public class DictionaryData {

	public String[][] loadData() {
		
		String[][] data = new String[4][3];
		data[0][0]="dictionary";
		data[0][1]="1.\n" + 
				"명사  (일반적인) 사전\n" + 
				"2.\n" + 
				"명사  (특정 분야의) 사전\n" + 
				"3.\n" + 
				"명사  (컴퓨터의) 사전[딕셔너리]\n" + 
				"";
		data[0][2]="예문\n" +  
				"Can you suggest a good dictionary? \n" + 
				"좋은 사전 하나 추천해 주시겠어요?" +
				"";
		
		
		data[1][0]="apple";
		data[1][1]="명사 : 사과";
		data[1][2]="예문\n" +  
				"He ate the apple, stalk and all.\n" +  
				"그는 그 사과를 속심까지 다 먹었다.\n" +
				"";
		
		return data;
	}
}
