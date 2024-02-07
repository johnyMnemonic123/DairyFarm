package diaryfarm.farm.v2;

import diaryfarm.domain.Cow;

public class Farm {
    final MyLinkedList<Cow> allFarmCows;

    final String name;
    private static Long COW_ID_SEQUENCE = 1L;
    public Farm(MyLinkedList<Cow> allFarmCows, String name) {
        this.allFarmCows = allFarmCows;
        this.name = name;
    }

    public static void main(String[] args) {
        Cow firstCow = new Cow(COW_ID_SEQUENCE++, "MotherOfAllCows", null);
        MyLinkedList<Cow> cows = new MyLinkedList<>();
        cows.insert(firstCow);

        Farm farm2 = new Farm(cows, "MyFarmv2");

        Cow Nancy =  farm2.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "Nancy");
        Cow secondCalf =  farm2.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "Moana");
        System.out.println("First 2 calfs:");
        farm2.allFarmCows.printList();


        farm2.EndLifeSpan(Nancy.getCowId());

        System.out.println("No Nancy:");
        farm2.allFarmCows.printList();

        Cow thirdGeneration =  farm2.GiveBirth(secondCalf.getCowId(), COW_ID_SEQUENCE++, "Joy");
        System.out.println("Joy is here:");
        farm2.allFarmCows.printList();

    }

    public Cow GiveBirth(Long parentCowId, Long childCowId, String childNickName){
        Cow calf = new Cow(childCowId,  childNickName, parentCowId);
        allFarmCows.insert(calf);
        return calf;
    }
    public void PrintFarmData(){
        //todo
        allFarmCows.printList();
    }
    public void EndLifeSpan(Long cowId){
        allFarmCows.deleteByPredicate(cow -> cow.getCowId().equals(cowId));
    }
}
