package diaryfarm.farm.v2;

import diaryfarm.domain.Cow;

public class Farm {
    final MyLinkedLIst<Cow> allFarmCows;

    final String name;

    public Farm(MyLinkedLIst<Cow> allFarmCows, String name) {
        this.allFarmCows = allFarmCows;
        this.name = name;
    }

    public Cow GiveBirth(Long parentCowId, Long childCowId, String childNickName){
        Cow calf = new Cow(childCowId,  childNickName, parentCowId);
        allFarmCows.insert(calf);
        return calf;
    }
    public void PrintFarmData(){
        //todo
    }
    public void EndLifeSpan(Long cowId){
        Cow c =  cowMap.remove(cowId);
        if(c != null){
            allFarmCows.remove(c);
        }
    }
}
