package arithstudy;

/**
 * @author YuSiJia
 * @date 2020/2/21
 * @desc
 */
public class Test0224 {
    public static void slectSort(int[] arrSort){
        for(int i=0;i<arrSort.length; i++){
            for (int j = i+1;j<arrSort.length;j++){
                if (arrSort[j]<arrSort[i]){
                    int temp = arrSort[i];
                    arrSort[i] = arrSort[j];
                    arrSort[j] = temp;
                }
            }
        }
        System.out.print(arrSort);
    }

    public static void bubbleSort(int[] arrSort){
        for(int i=0; i <arrSort.length-1; i++){
            for (int j=0; j<arrSort.length-1-i; j++){
                if (arrSort[j] > arrSort[j+1]){
                    int temp = arrSort[j+1];
                    arrSort[j+1] = arrSort[j];
                    arrSort[j] = temp;
                }
            }
        }
        System.out.println(arrSort);
    }


    public static void insertSort(int[] arrSort){
        int preIndex;
        int current;
        for (int i = 1; i<arrSort.length; i++){
            preIndex = i-1;
            current = arrSort[i];
            while (current < arrSort[preIndex] && preIndex >= 0){
                arrSort[preIndex+1] = arrSort[preIndex];
                preIndex--;
            }
            arrSort[preIndex+1] = current;
        }
        System.out.println(arrSort);
    }


    public static void shellSort(int[] arrSort){
        for (int gap = arrSort.length/2; gap>0; gap /=2 ){
            for (int i = gap; i<arrSort.length; i++){
                int j = i;
                int temp = arrSort[j];
                if(arrSort[j]<arrSort[j-gap]){
                    while(j-gap>=0 && temp<arrSort[j-gap]) {
                        arrSort[j] = arrSort[j - gap];
                        j -= gap;
                    }
                    arrSort[j] = temp;
                }
            }
        }
    }

    class Merge{
        private int[] aux;

        public void sort(int[] arrSort){
            aux = new int[arrSort.length];
            sort(arrSort,0, arrSort.length-1);
            System.out.println(arrSort);
        }

        public void sort(int[] arrSort, int start, int end){
            if (end <= start) return;
            int mid = (end - start)/2;
            sort(arrSort,0 ,mid);
            sort(arrSort,mid+1, end);
            merge(arrSort,start,mid,end);
        }

        public void merge(int[] arrSort, int start,int mid, int end){
            int i = start, j = mid+1;
            for (int k = start; k <= end; k++)
                aux[k] = arrSort[k];

            for (int k = start; k <= end; k++) {
                if (i > mid)
                    arrSort[k] = aux[j++];
                else if (j > end)
                    arrSort[k] = aux[i++];
                else if ((aux[j]<aux[i]))
                    arrSort[k] = aux[j++];
                else arrSort[k] = aux[i++];
            }
        }
    }

    class Quickly{
        public void sort(int[] arrSort){
            quicklySort(arrSort,0,arrSort.length-1);
            System.out.println(arrSort);
        }

        public void quicklySort(int[] arrSort, int start, int end){
            if (start>=end) return;
            int midIndex = partion(arrSort, start, end);
            quicklySort(arrSort,0,midIndex-1);
            quicklySort(arrSort,midIndex+1,end);
        }

        public int partion(int[] arrSort, int start, int end){
            int i = start;
            int base = arrSort[start];
            for (int j = start+1; j<=end; j++){
                if (arrSort[j] > base){
                    i++;
                    int temp = arrSort[i];
                    arrSort[i] = arrSort[j];
                    arrSort[j] = temp;
                }
            }
            return i;
        }
    }



    public static void main(String[] args) {
        int[] arrSort = {1,2,4,45,23,21,43,65,23,4453,53224,7675,87,343};
        Test0224 test0224 = new Test0224();
        Quickly quickly = test0224.new Quickly();
        quickly.sort(arrSort);
    }
}
