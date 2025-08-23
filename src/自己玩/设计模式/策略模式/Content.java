package 自己玩.设计模式.策略模式;

import java.util.HashMap;
import java.util.Map;

public class Content {

    private static Map<String, Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("addStrategy", new AddStrategy());
        strategyMap.put("subStrategy", new SubStrategy());
    }

    public int invokeSum(String name,int a, int b){
        return strategyMap.get(name).print(a, b);
    }

}
