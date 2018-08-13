/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
 class Tree
    {
        
       public String str;
      public Tree(String str)
       {
           this.str = str;
       }
      Map<String , String> dictionary = new HashMap<String , String>();
        public List<HuffmanNode> makeNodesAndSetFrequencies()
        {
            List nodeList = new ArrayList();  // Node List.

                for (int i = 0; i < str.length(); i++)
                {
                    String read=String.valueOf(str.charAt(i));
                   // String read = Convert.ToChar(str[i]).ToString();
                    if (contains(nodeList,read))
                        returnNode(nodeList,read).frequencyIncrease(); 
                    else
                        nodeList.add(new HuffmanNode(read)); 
                }
                Sort(nodeList); 
                return nodeList;
            
        }

        public boolean contains(List nodeList, String symbol)
        {

            for (int i = 0; i <nodeList.size(); i++)
            {
                HuffmanNode node=(HuffmanNode)nodeList.get(i);
                if (node.symbol == symbol)
                {
                    return true;
                }
            }
            return false;
        }
        public HuffmanNode returnNode(List nodeList, String symbol)
        {
            HuffmanNode node=null;
            for (int i = 0; i < nodeList.size(); i++)
            {
                HuffmanNode n=(HuffmanNode)nodeList.get(i);
                if (n.symbol == symbol)
                {
                    node =(HuffmanNode) nodeList.get(i);
                    break;
                }
            }
            return node;
 
        }


       
        public void createTreeFromList(List nodeList)
        {
            while (nodeList.size() > 1)  
            {
                HuffmanNode node1 = (HuffmanNode)nodeList.get(0);
                nodeList.remove(0);
                HuffmanNode node2 = (HuffmanNode)nodeList.get(0);    
                nodeList.remove(0);               
                nodeList.add(new HuffmanNode(node1, node2));    
                Sort(nodeList); 
            }
        }


      
        public void setCodeToTheTree(String code, HuffmanNode Nodes)
        {
            if (Nodes == null)
                return;
            if (Nodes.leftTree == null && Nodes.rightTree == null)
            {
                Nodes.code = code;
                return;
            }

            setCodeToTheTree(code + "0", Nodes.leftTree);
            setCodeToTheTree(code + "1", Nodes.rightTree);
        }

        
        public void addCodesInDict(HuffmanNode nodeList)
        {
            if (nodeList == null)
                return;
            if (nodeList.leftTree == null && nodeList.rightTree == null)
            {
                //dictionary.add(nodeList.symbol, nodeList.code);
                dictionary.put(nodeList.symbol, nodeList.code);
                return;
            }
            addCodesInDict(nodeList.leftTree);
            addCodesInDict(nodeList.rightTree);
        }
        public String encodedString()
        {
            String encoded = "";
            for (int i = 0; i < str.length(); i++)
            {
                String j =String.valueOf( str.charAt(i));
                encoded += dictionary.get(j);
            }
            return encoded;
        }
        public Map<String, String> returnDictionary()
        {
            return dictionary;
        }

        public void Sort(List<HuffmanNode> nodeList)
        {
            for (int i = 1; i <= nodeList.size() - 1; i++)
            {
                for (int j = 0; j < nodeList.size() - 1; j++)
                {
                    if (nodeList.get(j+1).frequency < nodeList.get(j).frequency)
                    {
                        HuffmanNode temp = nodeList.get(j);
                        nodeList.set(j, (HuffmanNode)nodeList.get(j+1));
                        nodeList.set(j + 1 , temp);
                    }
                }
            }
        }


    }
