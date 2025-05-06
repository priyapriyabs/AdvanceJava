package com.xworkz.javaproject;

import com.xworkz.aggregationusingarray.ChiefMinister;
import com.xworkz.aggregationusingarray.Government;
import com.xworkz.aggregationusingarray.MLA;
import com.xworkz.aggregationusingarray.Minister;
import com.xworkz.aggregationusingarray.Schems;

public class TestGovernmentDetails {

	public static void main(String[] args) {
		
	ChiefMinister	cm=new ChiefMinister("Sidharamaya", 75846201, "cm@gmail.com");
	
	ChiefMinister[] chiefMinisters= {cm};
	
	
Minister	minister=new Minister(50, "Ashwath narayan","Bangalore");
Minister	minister2=new Minister(40, "CC Patil","Managlore");
Minister	minister3=new Minister(60, "R Shankar","Kolara");
Minister	minister4=new Minister(55, "B C Patil","Mysore");

Minister[] ministers= {minister,minister2,minister3,minister4};
		
  MLA mla=new MLA("Honnali", "v5844d25554", 2571000);
  MLA mla2=new MLA("tharikere", "R2597821G225", 700000);
  MLA mla3=new MLA("Bhadravathi", "T2557H3392", 300000);
  MLA mla4=new MLA("Vijayapura", "v487522J236958", 400000);
  
  MLA[] mlas= {mla,mla2,mla3,mla4};
  
  
 Schems Schem=new Schems("Gruha Jyothi Schem", "2 years", 123);
 Schems Schem2=new Schems("Yuva Nidhi Schem", "5 years", 222);
 Schems Schem3=new Schems("Gruha Laxmi Schem", "3 years", 333);
 Schems Schem4=new Schems("Shakthi yojane Schem", "10 years", 444);
 
 Schems[]  schems= {Schem,Schem2,Schem3,Schem4};
 
 
	Government	gov=new Government("BJP", "Karnataka", 8000000, chiefMinisters, ministers, mlas, schems);
//gov.govDetails();

System.out.println(gov.toString());

	}

}
