package 自己玩.dede;

public class StudentTest2 {
    public static void main(String[] args) {
        //1.创建一个数组用来存储学生对象
        Student[] arr = new Student[3];
        //2.创建学生对象并添加到数组当中
        Student s1 = new Student("1","张三",10);
        Student s2 = new Student("2","李四",11);
        Student s3 = new Student("3","王五",12);
        //3.把学生对象添加到数组当中
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        /*要求3：通过id删除学生信息
        * 如果存在，则删除，如果不存在，则提示删除失败*/

        //要找到id再数组中对应的索引
        int index = getIndex(arr,2);
        if (index >= 0){
            //如果存在，则删除
            arr[index] = null;  
            printArr(arr);
        }else {
            //如果不存在，则提示删除失败
            System.out.println("当前id不存在，删除失败！");
        }
    }

    //定义一个方法打印数组
    public static void printArr(Student[] arr){
        for (int i = 0; i < arr.length; i++) {
            Student student = arr[i];
            if (student != null){
                System.out.println(student.getId()+","+student.getName()+","+student.getAge());
            }
        }
    }

    //1.我要干嘛？  找到id在数组中的索引
    //2.我需要什么？   数组  id
    //3.调用处是否需要继续使用方法的结果？ 要
    public static int getIndex(Student[] arr,int id){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            Student student = arr[i];
            //对对象进行非空判断
            if (student != null){
                if (student.getId() == id){
                    return i;
                }
            }
        }
        //如果循环结束后，没找到
        return -1;
    }
}
