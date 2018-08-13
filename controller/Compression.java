/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package controller;

import java.util.List;

/**
 *
 * @author Lenovo
 */
class Compression
    {
      
        public String getCompressedString(String str)
        {
            Tree tree = new Tree(str);
            List nodeList = tree.makeNodesAndSetFrequencies();
            tree.createTreeFromList(nodeList);
            tree.setCodeToTheTree("", (HuffmanNode)nodeList.get(0));
            tree.addCodesInDict((HuffmanNode)nodeList.get(0));
            String newPassword = tree.encodedString();
            String compresd = "";
            int noOfZeroAdded = 0;

            String s = newPassword;

            while (s.length() > 0)
            {
               


                if (s.length() < 8 && s.length() != 0)
                {
                    int l = s.length();
                    noOfZeroAdded = 8 - l;
                    for (int j = 0; j < noOfZeroAdded; j++)
                    {
                        s += "0";
                    }



                }
                 String sub = s.substring(0,8);
                s = s.substring(8);
                int number = Integer.parseInt(sub, 2);
                compresd += String.valueOf((char)number);
            }
            return compresd;
        }
    }

