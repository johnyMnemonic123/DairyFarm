package diaryfarm.farm.v2;

import diaryfarm.domain.Cow;

public class Farm {
    final MyLinkedList<Cow> aliveCows;
    final Tree<Cow> farmTree;
    final String name;
    private static Long COW_ID_SEQUENCE = 1L;
    public Farm(Cow firstCow, String name) {
        this.farmTree = new Tree<>(new TreeNode<>(firstCow));
        MyLinkedList<Cow> cows = new MyLinkedList<>();
        cows.insert(firstCow);
        this.aliveCows = cows;
        this.name = name;
    }

    public static void main(String[] args) {
        Cow firstCow = new Cow(COW_ID_SEQUENCE++, "MotherOfAllCows", null);
        Farm farm2 = new Farm(firstCow, "MyFarmv2");

        Cow Nancy =  farm2.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "Nancy");
        Cow Moana =  farm2.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "Moana");
        farm2.PrintFarmData("First 2 calfs:");

        farm2.EndLifeSpan(Nancy.getCowId());

        Cow thirdGeneration1 =  farm2.GiveBirth(Moana.getCowId(), COW_ID_SEQUENCE++, "Joy");
        Cow thirdGeneration2 =  farm2.GiveBirth(Moana.getCowId(), COW_ID_SEQUENCE++, "Bliss");
        farm2.PrintFarmData("Bye Nancy");


        farm2.EndLifeSpan(Moana.getCowId());
        farm2.PrintFarmData("Bye Moana");

        Cow lola =  farm2.GiveBirth(firstCow.getCowId(), COW_ID_SEQUENCE++, "lola");
        farm2.PrintFarmData("Hi Lola");

        Cow _4G =  farm2.GiveBirth(thirdGeneration1.getCowId(), COW_ID_SEQUENCE++, "Joy V2");
        farm2.PrintFarmData("4G");

        // will throw IllegalArgumentException - Moana is not alive
        //Cow parent404 =  farm2.GiveBirth(Moana.getCowId(), COW_ID_SEQUENCE++, "Joy V2");
    }

    public Cow GiveBirth(Long parentCowId, Long childCowId, String childNickName){
        Cow calf = new Cow(childCowId,  childNickName, parentCowId);
        aliveCows.insert(calf);

        var parentCow = farmTree.findTreeNode(farmTree.getRoot(), c -> c.getCowId().equals(parentCowId));
        if(parentCow != null && parentCow.getData().isAlive()) {
            var newCowNode = new TreeNode<>(calf);
            newCowNode.setParent(parentCow);
            parentCow.addChild(newCowNode);
        }
        else{
            throw new IllegalArgumentException("No such parent:" + parentCowId);
        }
        return calf;
    }
    public void PrintFarmData(String msg){
        System.out.println(msg);
        System.out.println(farmTree.print());
    }
    public void EndLifeSpan(Long cowId){
        aliveCows.deleteByPredicate(cow -> cow.getCowId().equals(cowId));

        TreeNode<Cow> cow = farmTree.findTreeNode(farmTree.getRoot(), c -> c.getCowId().equals(cowId));
        cow.getData().setAlive(false);
    }
}
