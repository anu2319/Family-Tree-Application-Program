import java.util.ArrayList;
import java.util.HashMap;

class moraponnu
{

    public static void main(String[] args)
    {
        biodata Relations[]=new biodata[5],temp;
        Relations[0]=new biodata("John","Male","Brad","Lisa");
        Relations[1]=new biodata("Emma","Female","Brad","Lisa");
        Relations[2]=new biodata("Alex","Male","John","Jenny");
        Relations[3] =new biodata("Emily","Female","Steve","Emma");
        Relations[4]=new biodata("Rachel","Female","Steve","Emma");
        //Checking sibiling after getting all inputs
        for(int i=0;i<5;i++)
            Relations[i].checkSiblings(Relations[i].father.ownname);
        //Checking childrens after getting all inputs
        for(int i=0;i<5;i++)
            Relations[i].checkChildrens(Relations[i].father.ownname);

        //Printing Family Tree/Relation
        for (String key : biodata.map.keySet()) {
            System.out.println("\n******\nkey "+key);
            temp=biodata.map.get(key);
            System.out.println("Gender : "+temp.Gender);
            if(temp.father!=null)
                System.out.println("Father : "+temp.father.ownname);
            if(temp.mother!=null)
                System.out.println("Mother : "+temp.mother.ownname);
            if(temp.brothers!=null) {
                for(biodata s : temp.brothers)
                    System.out.println("Brother : " +s.ownname);
            }
            if(temp.sisters!=null){
                for(biodata s : temp.sisters)
                    System.out.println("Sisters : " + s.ownname);
            }
        }
        //Family tree ends here


        System.out.println("MoraPonu of Alex : ");
        temp=biodata.map.get("Alex");

        if(temp!=null) {
            //checking father sisters
            if (temp.father != null) {
                if (temp.father.sisters != null)
                    for (biodata s : temp.father.sisters) {
                        if (s != null) {
                            if(temp.Gender=="Male") {
                                System.out.println("Result ponnu1 : " + s.daughter);
                            }else {
                                System.out.println("Result payan1 : " + s.sons);
                            }
                        }
                    }
            }
            //checking mother brother
            if (temp.mother != null) {
                if (temp.mother.brothers != null)
                    for (biodata s : temp.mother.brothers) {
                        if (s != null) {
                            if(s.Gender=="Male") {
                                System.out.println("Result ponnu2 : " + s.daughter);
                            }
                            else {
                                System.out.println("Result payan2 : " + s.sons);
                            }
                        }
                    }
            }
        }else{
            System.out.println("Name not found in the Record");
        }
    }
}