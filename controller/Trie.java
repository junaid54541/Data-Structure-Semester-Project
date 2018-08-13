/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Ramish
 */
class Trie {
    private TrieNode root;
 
    public Trie(String File_name) throws IOException {
        System.out.println("constructor of TRIE");
        root = new TrieNode(' '); 
    File names =new File(File_name);
    FileReader fr=new FileReader(names);
    BufferedReader br=new BufferedReader(fr);
    String line ;
            while((line=br.readLine())!=null){
                System.out.println(""+line);   
               insert(line);
              
    }
    }
 
   final public void insert(String word) {
        if (search(word) == true) 
        return;
        TrieNode current = root; 
        TrieNode pre ;
        for (char ch : word.toCharArray()) {
        	pre = current;
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
                child.parent = pre;
            } else {
                 current.children.add(new TrieNode(ch));
                 current = current.getChild(ch);
                 current.parent = pre;
            }
        }
        current.isEnd = true;
    }
//    public List<String> com(String input) throws FileNotFoundException, IOException{
//        
//    File names =new File("C:\\Users\\Ramish\\Documents\\NetBeansProjects\\autocomplete\\src\\names.txt");
//        
//    System.out.println("input======== "+input);
//    System.out.println("====READ FROM FILE=====");
//   // Trie t=new Trie();        
//    FileReader fr=new FileReader(names);
//            BufferedReader br=new BufferedReader(fr);
//            
//            String line ;
//            while((line=br.readLine())!=null){
//                System.out.println(""+line);   
//               insert(line);
//              
//            }
//            // BufferedWriter bw=new BufferedWriter(fw);
//            List<String> list= autocomplete(input);
//            System.out.println("after auto complete");
//            for (int i = 0; i < list.size(); i++) {
// 	    System.out.println(list.get(i));
//           }
//            return list;
//



    
    public boolean search(String word) {
        TrieNode current = root;      
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else {
                current = current.getChild(ch);    
            }
        }      
        if (current.isEnd == true) {       
            return true;
        }
        return false;
    }
    
    public List<String> autocomplete(String prefix) {     
       TrieNode lastNode = root;
       for (int i = 0; i< prefix.length(); i++) {
	       lastNode = lastNode.getChild(prefix.charAt(i));	     
	       if (lastNode == null) 
	    	   return new ArrayList<String>();      
       }
       
       return lastNode.getWords();
    }
}


