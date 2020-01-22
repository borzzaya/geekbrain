/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;

2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 */


import java.util.Arrays;

public class lesson2 {

    public void lesson2Run() {

        System.out.println("========= Упражнение 1 ==================");
        ex1();

        System.out.println("========= Упражнение 2 ==================");
        ex2();

        System.out.println("========= Упражнение 3 ==================");
        ex3();

        System.out.println("========= Упражнение 4 ==================");
        ex4();

        System.out.println("========= Упражнение 5 ==================");
        ex5();

        System.out.println("========= Упражнение 6 ==================");
        int[] arr1 = {5, 6, 9, 3, 6, 0, 2, 4, 1};
        int[] arr2 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean ex6Res = ex6(arr1);
        System.out.println(ex6Res);
        ex6Res = ex6(arr2);
        System.out.println(ex6Res);

        System.out.println("========= Упражнение 7 ==================");
        ex7(arr1, -4);
        ex7(arr1, 3);
    }



    public void ex1() {
        byte[] arr = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length;i++){
            //System.out.println(arr[i]);
            if (arr[i]==0){
                arr[i]=1;
            }else {
                arr[i]=0;
            }

            //System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    public void ex2(){
        int[] arr = new int[8];
        for (int i=0;i<arr.length;i++){
            arr[i]=i*3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void ex3(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++){
            if (arr[i]<6){
                arr[i]=arr[i]*2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void ex4(){
        byte l = 7;
        int[][] arr = new int[l][l];
        for (int i=0; i<l; i++){
            arr[i][i]=1;
            arr[i][l-1-i]=1;
        }
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    public void ex5(){
        int[] arr = {12, 7, 26, -17, 23, 5, -28, 10, 4};
        int min = 0;
        int max = 0;
        for (int i=0; i<arr.length; i++){
            if (i==0){
                min=arr[i];
                max=arr[i];
                continue;
            }

            if (min>arr[i]){
                min=arr[i];
            }
            if (max < arr[i]) {
                max=arr[i];

            }
        }
        System.out.println("min = "+min);
        System.out.println("max = "+max);
    }
    public boolean ex6(int[] arr){
        int sumLeft=0;
        int sumRight=0;
        for (int i=1; i<arr.length; i++){
           sumLeft = ex6Sum(arr,0, i);
           sumRight = ex6Sum(arr, i, arr.length);
            System.out.println("sumLeft = "+sumLeft);
            System.out.println("sumRight = "+sumRight);
            if (sumLeft==sumRight){
                return true;
            }
        }
        return false;
    }

    private int ex6Sum(int[] arr, int startIndex, int endIndex){
        int sum = 0;
        for (int i=startIndex; i<endIndex; i++){
            sum= sum+ arr[i];
        }
        return sum;
    }

    public void ex7(int[] arr, int n){
        for (int i=0; i< Math.abs(n); i++) {
            //System.out.println(i);
            if (n>0){
                int tmp1 = arr[arr.length-1];
                for (int j=arr.length-2;j>=0; j--){
                    arr[j+1] = arr[j];
                }
                arr[0] = tmp1;
            } else {
                int tmp1 = arr[0];
                for (int j=0;j<arr.length-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=tmp1;

            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
