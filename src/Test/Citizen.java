package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Citizen {

    public String cardld;
    public String name;
    public String sex;

    public void display(){
        System.out.println(this.cardld);
        System.out.println(this.name);
        System.out.println(this.sex);
    }

    public Citizen(String cardld, String name, String sex) {
        this.cardld = cardld;
        this.name = name;
        this.sex = sex;
    }

    public String getCardld() {
        return cardld;
    }

    public void setCardld(String cardld) {
        this.cardld = cardld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "cardld='" + cardld + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Citizen citizen1 = new Citizen("1", "name1", "18");
        Citizen citizen2 = new Citizen("2", "name1", "18");
        Citizen citizen3 = new Citizen("3", "name3", "18");
        Citizen citizen4 = new Citizen("4", "name4", "18");
        Citizen citizen5 = new Citizen("5", "name5", "18");
        Citizen citizen6 = new Citizen("6", "name6", "18");
        List<Citizen> citizenList = new ArrayList<Citizen>();
        citizenList.add(citizen1);
        citizenList.add(citizen2);
        citizenList.add(citizen3);
        citizenList.add(citizen4);
        citizenList.add(citizen5);
        citizenList.add(citizen6);
        Map<String, List<Citizen>> map = citizenList.stream()
                .collect(Collectors.groupingBy(Citizen::getName));
        for (String key : map.keySet()) {
            System.out.println("key值为:"+key+"----->value值为:"+map.get(key));
        }
    }

}
