import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class biodata
{
    String ownname;
    String Gender;
    biodata father;
    biodata mother;
    Set<biodata> sisters =new LinkedHashSet<biodata>();
    Set<biodata> brothers =new LinkedHashSet<biodata>();
    Set<String> sons =new LinkedHashSet<String>();
    Set<String> daughter =new LinkedHashSet<String>();

    void checkChildrens(String Father)
    {
        biodata temp;
        //Checking for daughter in Map
        for (String key : map.keySet())
        {
            temp=map.get(key);
            if(temp.father!=null)
                if(temp.father.ownname==Father)
                {
                    //System.out.println("Fttttter : "+temp.father.ownname);
                    //System.out.println("This name : "+this.ownname);
                    if(temp.Gender=="Female")
                    {
                        temp.father.daughter.add(temp.ownname);
                        temp.mother.daughter.add(temp.ownname);
                    }
                    else
                    {
                        temp.father.sons.add(temp.ownname);
                        temp.mother.sons.add(temp.ownname);
                    }
                }
        }
    }

    void checkSiblings(String Father)
    {
        biodata temp;
        //Checking for Sister in Map
        for (String key : map.keySet())
        {
            temp=map.get(key);
            if(temp.father!=null)
                if(temp.father.ownname==Father && this.ownname!=temp.ownname)
                {
                    //System.out.println("Fttttter : "+temp.father.ownname);
                    //System.out.println("This name : "+this.ownname);
                    if(temp.Gender=="Female")
                    {
                        this.sisters.add(temp);
                    }
                    else
                    {

                        this.brothers.add(temp);
                    }
                }
        }
    }

    void checkFather(String Father)
    {
        //Update Father object
        if(map.containsKey(Father)==true)
        {
            this.father=map.get(Father);
        }else
        {   //If not father found , Create father and insert
            biodata temp=new biodata(Father,"Male");
            this.father=map.get(Father);
        }
    }

    void checkMother(String Mother)
    {
        //Update Mother object
        if(map.containsKey(Mother)==true)
        {
            this.mother=map.get(Mother);
        }else
        {   //If not Mother found , Create Mother and insert
            biodata temp=new biodata(Mother,"Female");
            this.mother=map.get(Mother);
        }
    }

    //Self Creating Half biodata-Constructor
    biodata(String OwnName, String Gender){
        this.ownname=OwnName;
        this.Gender=Gender;
        //add half biodata to the MAP
        map.put(OwnName,this);
    }

    //Creating biodata from USER Input
    biodata(String OwnName , String Gender , String Father , String Mother){
        this.ownname=OwnName;
        this.Gender=Gender;
        checkFather(Father);
        checkMother(Mother);
        //add complete biodata to the MAP
        map.put(OwnName,this);

    }

    static HashMap<String,biodata> map =new HashMap<String,biodata>();

}