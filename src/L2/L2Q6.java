package L2;

public class L2Q6 {
    public static void main(String[] args) {
        Integer[][] int2DArr = {{4,1},{5,2},{6,3}};
        String[][] strings={{"RED","BLUE"},{"YELLOW","HALO"}};
        minMaxTwoDArray minmax=new minMaxTwoDArray();
        System.out.println("Min ="+minmax.min(int2DArr));
        System.out.println("Max ="+minmax.max(int2DArr));
        System.out.println("Min ="+minmax.min(strings));
        System.out.println("Max ="+minmax.max(strings));
    }
}

class minMaxTwoDArray{
    public <T extends  Comparable<T>> T min(T[][] arr){
        T min=arr[0][0];
        for (T[] list:arr){
            for(T list1:list){
                min=(list1.compareTo(min)<0)?list1:min;
            }
        }
        return min;
    }

    public <T extends  Comparable<T>> T max(T[][] arr){
        T max=arr[0][0];
        for (T[] list:arr){
            for(T list1:list){
                max=(list1.compareTo(max)>0)?list1:max;
            }
        }
        return max;
    }
}
