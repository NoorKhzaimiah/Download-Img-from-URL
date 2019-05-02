 
package javaapplication10;

import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class JavaApplication10 {

   
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
    URL url = new URL("https://www.aaup.edu");
    URLConnection conn = url.openConnection();
    BufferedReader buf = new BufferedReader(new InputStreamReader (conn.getInputStream()));
    String line;
    String n;
    String str[];
    BufferedImage img;
    URL rUrl;
    while((line=buf.readLine() )!=null) {
    	if (line.contains("img")) {
    	str=line.split(" ");	
    	for(int i=0;i<str.length;i++)
    	{
    		if(str[i].contains("src=\"")) {
    			int d =str[i].indexOf("sites/")-1;
    			
                        String l = str[i].subSequence(d, str[i].lastIndexOf("\"")).toString();
            	rUrl=new URL(url+l);
                
            	n=str[i].subSequence(str[i].lastIndexOf("/")+1, str[i].length()-1).toString();
            	System.out.println(rUrl);
            	img = ImageIO.read(rUrl);
            	ImageIO.write(img, "jpg", new File("d://"+n));
    		}
    		
    	}
    	
    	
    	}
    	
    }
    
    }
    
}
