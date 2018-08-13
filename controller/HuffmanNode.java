/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Lenovo
 */
    class HuffmanNode
    {
        public String symbol;   
        public int frequency;        
        public String code;           
        public HuffmanNode parentNode;
        public HuffmanNode leftTree;  
        public HuffmanNode rightTree;  
        public boolean isLeaf;           


        public HuffmanNode(String value)   
        {
            symbol = value;     
            frequency = 1;

            rightTree =null; 
            leftTree = null;
            parentNode = null;       
            code = "";        
            isLeaf = true;    
        }


        public HuffmanNode(HuffmanNode node1, HuffmanNode node2)
        {
           
            code = "";
            isLeaf = false;
            parentNode = null;
            // JIS KI FREQUENCY ZIADA HIA WOH RIGHT P LAGEGA HMAESHA
                 if (node1.frequency >= node2.frequency)
            {
                rightTree = node1;
                leftTree = node2;
                rightTree.parentNode = leftTree.parentNode = this;
                symbol = node1.symbol + node2.symbol;
                frequency = node1.frequency + node2.frequency;
            }
            else if (node1.frequency < node2.frequency)
            {
                rightTree = node2;
                leftTree = node1;
                leftTree.parentNode = rightTree.parentNode = this;     
                symbol = node2.symbol + node1.symbol;
                frequency = node2.frequency + node1.frequency;
            }
        }




        public void frequencyIncrease()          
        {
            frequency++;
        }
 
    }

