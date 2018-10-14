package com.ibmCodingChallenge;

public class ParagraphParser {

	public static void main(String[] args){
		
		// String para = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive computing|'IBM Cognitive Computing' is a revolution?";
        String para = "\"Computer Science Department\"|Computer-Science-Department|the \"computer science department\"";
        String[] p = para.split("\\|");
        String[] conv = new String[p.length];
        int k = 0;
        for(String s : p){

            p[k] = s.trim();
            conv[k] = convertPara(s);
            k++;
        }

        for(int i=0; i < p.length; i++){
            for(int j = 0; j < i; j++){
                if (i == j)
                    continue;;
                if(conv[i].equalsIgnoreCase(conv[j])){
                    if (p[i].length() <= p[j].length()){
                        p[j] = "";
                    }else{
                        p[i] = "";
                    }
                }else if(conv[i].contains(conv[j])){
                    p[j] = "";
                }else if(conv[j].contains(conv[i])){
                    p[i] = "";
                }
            }
        }

        String temp = "";

        for (int i = 0 ; i < p.length; i++){

            if (p[i].length() > 0){
                temp = temp + p[i];
                temp = temp + "|";
            }
        }

        if (temp.charAt(temp.length()-1) == '|'){
            temp = temp.substring(0, temp.length()-1);
        }
        System.out.println(temp);
    }

    private static String convertPara(String s) {
        s = s.toLowerCase();
        s = s.replaceAll(" +", " ");
        s = s.replaceAll("[^A-Za-z0-9 ]","");
        s = s.trim();
        return s;
    }
}
