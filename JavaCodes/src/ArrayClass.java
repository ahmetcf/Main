import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javafx.scene.control.TableColumnSortTypeWrapper.isAscending;

/**
 * Created by Ahmet on 20/05/16.
 */
public class ArrayClass {
        public static void main (String[]args)
        {
            int[]list = {1,2,3,4,6,56,21,2,3};
            findAndPrintPairs(list,7);
            //bubblesort(list);
            List<Integer> arrayList = new ArrayList<Integer>();
            arrayList= bubblesort(list);

            for (int val:arrayList
            ) {
                System.out.println(val);
            }

        }

        public static void findAndPrintPairs(int[] list,int target)
        {
            assert  list != null : "Failed precondition";

            for (int i =0; i < list.length ; i++) {
                for (int j = i+1; j < list.length ; j++) {
                        if(list[i] + list[j] == target )
                        {
                            System.out.println("The Element in indices "+ i + " " +
                                    "and element in "+ j + " is added up to " + target);
                        }
                }
            }
        }

        public static List<Integer> bubblesort(int[]list)
        {
            assert  list != null : "Failed precondition";
            boolean changed = true;
            int temp;

            for (int i = 0; i < list.length && changed;  i++) {
                changed =false;
                for (int j = 0; j < list.length-i-1 ; j++) {
                    assert (j>0) && (j+1<list.length) : "loop counter j" + j +"is out of bound";
                        if(list[j] > list[j+1])
                        {
                            changed =true;
                            temp =list[j+1];
                            list[j+1] = list[j];
                            list[j] = temp;
                        }
                    
                }
            }
        }
}


