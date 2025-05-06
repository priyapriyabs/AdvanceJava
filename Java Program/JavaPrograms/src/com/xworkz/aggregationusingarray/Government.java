package com.xworkz.aggregationusingarray;

import java.util.Arrays;

public class Government {
	
	String name;
String state;
int population;

ChiefMinister[] chiefMinister;
Minister[] minister;
MLA[]  mla;
Schems[] schems;

public Government(String name,String state,int population,ChiefMinister[] chiefMinister,Minister[] minister,MLA[] mla,Schems[] schems) {
	this.name=name;
	this.state=state;
	this.population=population;
	this.chiefMinister=chiefMinister;
	this.minister=minister;
this.mla=mla;
this.schems=schems;
}

public void govDetails() {
	System.out.println("gov name:"+name);
	System.out.println("gov capital:"+state);
	System.out.println("gov populatio:"+population);
	
	System.out.println("==============");
	for(int i=0;i<chiefMinister.length;i++) {
		chiefMinister[i].cmDetails();
	}
//	System.out.println("CM name:"+cname);
//	System.out.println("CM adhar:"+adhar);
//	System.out.println("CM email:"+email);
//	System.out.println("==============");
//	System.out.println("minister age:"+age);
//	System.out.println("minister name:"+mname);
//	System.out.println("minister place:"+place);
//	System.out.println("==============");
//	System.out.println("MLA thaluk:"+thaluk);
//	System.out.println("MLA voterid:"+voterId);
//	System.out.println("MLA salary:"+salary);
//	System.out.println("==============");
//	System.out.println("Schem name:"+schemName);
//	System.out.println("Schem validity:"+validity);
//	System.out.println("Schem schemId:"+schemId);
}

@Override
public String toString() {
	return "Government [name=" + name + ", state=" + state + ", population=" + population + ", chiefMinister="
			+ Arrays.toString(chiefMinister) + ", minister=" + Arrays.toString(minister) + ", mla="
			+ Arrays.toString(mla) + ", schems=" + Arrays.toString(schems) + "]";
}


}
