package Sokoban.Step_One;

import java.io.*;
import java.util.ArrayList;


public class InputMapData {
	private String fileName;
	char[][] arr;
	public InputMapData(String fileName) {
		this.fileName = fileName;
		this.arr = null;
	}
	
	public void getListData() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(this.fileName));
		ArrayList<String> list = new ArrayList<>();String str;
		while(true) {
			str = br.readLine();		
			if(str == null)
				break;
			list.add(str);
		}
		br.close();
		this.arr =new char[list.size()][];
		for(int i=0; i < list.size(); i++)
			arr[i] = list.get(i).toCharArray();
	}
	
	public char[][] getNumberMap() throws IOException{
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = isNumber(arr[i][j]);
			}
		}
		
		return arr;
	}
	static char isNumber(char mdc) {
		switch(mdc) {
			case '#':
				return '0';
			case 'O' :
				return '1';
			case 'o' :
				return '2';
			case 'P' :
				return '3';
			case '=' :
				return '4';
			default :
				return mdc;
		}
	}
	static char isChar(char mdc) {
		switch(mdc) {
			case '0':
				return '#';
			case '1' :
				return 'O';
			case '2' :
				return 'o';
			case '3' :
				return 'P';
			case '4' :
				return '=';
			default :
				return mdc;
		}
	}
}