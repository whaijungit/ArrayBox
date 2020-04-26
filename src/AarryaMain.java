public class AarryaMain {

    public static void main(String[] args) {
       ArrayBox<Integer> box = new ArrayBox<Integer>();
       for (int i = 1; i <= 6;i++){
           box.add(i*10);
       }
        System.out.println("有效元素个数:" + box.size());
//        System.out.println("真实数组长度:" + box.elementData.length);
        for (int i = 0 ;i < box.size();i++){
            int value = box.get(i);
            System.out.print(value+" ");//10 20 30 40 50 60
        }
        System.out.println();
        //删除2好索引位置的元素
        int removeValue = box.remove(2);
        System.out.println(removeValue);//30
        System.out.println(box.size());
        for (int i = 0 ;i < box.size();i++){
            int value = box.get(i);
            System.out.print(value+" ");//10 20 40 50 60
        }
    }

}
