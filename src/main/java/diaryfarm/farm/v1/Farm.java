package diaryfarm.farm.v1;

import diaryfarm.domain.Cow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Farm {
    final List<Cow> allFarmCows;
    final Map<Long, Cow> cowMap;
    final String name;

    private static Long COW_ID_SEQUENCE = 1L;

    public Farm(List<Cow> allFarmCows,  String name) {
        this.allFarmCows = allFarmCows;
        this.name = name;
        this.cowMap = allFarmCows.stream().collect(Collectors.toMap(Cow::getCowId, Function.identity()));
    }

    public static void main(String[] args) {
        Cow firstCow = new Cow(COW_ID_SEQUENCE++, "First", null);
        List<Cow> cows = new ArrayList<>();
        cows.add(firstCow);

        Farm farm1 = new Farm(cows, "MyFarmv1");

        Cow firstCalf =  farm1.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "Baby1");
        farm1.EndLifeSpan(firstCalf.getCowId());
        System.out.println("Farm size: " + farm1.allFarmCows.size());
    }

    //fixme this method makes more sense in Cow class from OOP POV
    public Cow GiveBirth(Long parentCowId, Long childCowId, String childNickName){
        Cow calf = new Cow(childCowId,  childNickName, parentCowId);
        allFarmCows.add(calf);
        cowMap.put(childCowId, calf);
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
