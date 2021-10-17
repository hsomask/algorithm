/**
 * @author:hsoluo
 * @date 2021/8/11 9:44
 */
public  class Sort {


    /**
     * 1.冒泡排序是原地排序算法：（冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为 O(1)，是一个原地排序算法。）
     * 2.在冒泡排序中，只有交换才可以改变两个元素的前后顺序。为了保证冒泡排序算法的稳定性，当有相邻的两个元素大小相等的时候，我们不做交换，相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
     * 3.最好情况下，要排序的数据已经是有序的了，我们只需要进行一次冒泡操作，就可以结束了，所以最好情况时间复杂度是 O(n)。而最坏的情况是，要排序的数据刚好是倒序排列的，我们需要进行 n 次冒泡操作，所以最坏情况时间复杂度为 O(n2)。
     */

    public void bubbleSort(int[] sort) {
        if (sort.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //数据交换标志

        for (int i = 0; i < sort.length; i++) {
            boolean flag = false;
            for (int j = 1; j < sort.length; j++) {
                if (sort[i] > sort[j]) {
                    int temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;// 没有数据交换，提前退出

        }
    }


    /**
     * 插入排序
     */

    public static void insertionSort(int[] a) {

        int length = a.length;
        if (length < 0)
            return;

        for (int i = 1; i < length; ++i) {
            int tempValue = a[i];//未排序区域的第一位数
            int j = i - 1; //假定为已排好序的区域

            for (; j >= 0; --j) {
                if (a[j] > tempValue) {
                    a[j+1] = a[j]; //数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = tempValue;//数据交换
        }


    }

    public static void main(String[] args) {
        int[] a = {5, 9, 8, 6};
        insertionSort(a);
        System.out.println(a);

    }
}
