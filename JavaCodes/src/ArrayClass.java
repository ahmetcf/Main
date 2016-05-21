import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;


public class ArrayClass {
        public static void main (String[]args)
        {
            int[]list = {1,2,3,4,6,56,21,2,3,-1,-2};
            findAndPrintPairs(list,7);
            //bubblesort(list);
            List<Integer> arrayList = new ArrayList<Integer>();
            arrayList= bubblesort(list);
            showList(arrayList);

            list = new int[]{-1,2,45,-8,9,19,32,3333,56};
            bubblesort(list);
            List<Integer> arrayList2 = bubblesort(list);
            showList(arrayList2);

            /*I want list in deascending order
            In order to do that I need sort list again with reverse order
            */

           int[]returnArrayFromAssecdingOrder = deAscending(list);

            for(int val : returnArrayFromAssecdingOrder)
            {
                System.out.println("This is ascending value " + val);
            }

            /*
            * Find min and max value in the list
            *
            * */

            findMinandMax(list);

            //my code"

            int myNewSize = list.length + 10;

           int[]myFinalArray = resiseMyArray(list,myNewSize);

            System.out.println("New Resized array "+ myFinalArray.length);

            for (int val:myFinalArray
                 ) {
                if(val!=0)
                System.out.println(val);

            }

        }

    public static int[] resiseMyArray(int[] list,int size)
    {
        assert list!= null && list.length >0 : "Precondition failed. Check your code again";
        int[] newResizedArray = new int[size];
        int limit = Math.min(list.length,size);

        for (int i = 0; i <limit ; i++) {
            newResizedArray[i] = list[i];
        }

        assert newResizedArray.length >0 && newResizedArray != null : "Post conditoon failed check your code and indexing";

        return  newResizedArray;
    }

    /*
     *pre: list != null, newSize >= 0
     *post: returns an array of size newSize. Elements from 0 to newSize - 1
     *	will be copied into the new array
     */
    public static int[] goodResize(int[] list, int newSize)
    {	assert list != null && newSize >= 0 : "failed precondition";

        int[] result = new int[newSize];
        int limit = Math.min(list.length, newSize);
        //returns the smaller of two values

        for(int i = 0; i < limit; i++)
        {	result[i] = list[i];
        }

        return result;
    }


    public  static void findMinandMax(int[]list)
        {
            assert  list.length >0 && list != null : "failed precondition";

            int maxValue,minValue;
            maxValue = list[0];
            minValue = list[0];

            for (int i = 0; i < list.length; i++) {
                if(list[i]>maxValue)
                    maxValue = list[i];
                if(list[i]<minValue)
                    minValue = list[i];
            }

            System.out.println("Maximum value of list is "+ maxValue);
            System.out.println("Minumum value of list is "+ minValue);
            System.out.println("Total number of elements in this list is" + list.length);
        }

        public static void showList(List<Integer> myList)
        {
            for (Integer i: myList
                 ) {
                System.out.println(i);
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

        public static boolean isAscending(int[]list)
        {
            boolean ascending = true;
            int index =1 ;
            while(ascending && index < list.length)
            {
                ascending =(list[index-1]<= list[index]);
                index++;
            }
            return  ascending;
        }

        public static int[] deAscending(int[]list)
        {
            assert list.length >0 : "List is empty";

            int swap;
            int initialListSize = list.length;
            int finalListSize =0;

            for (int i = 0; i < list.length; i++) {
                for (int j =i ; j < list.length; j++) {
                    if(list[j]>list[i])
                    {
                        swap = list[j];
                        list[j] = list[i];
                        list[i]= swap;
                    }
                }
            }

            finalListSize = list.length;

            if(initialListSize != finalListSize)
            {
                System.out.println("index is missing in array, error occured");
            }

            return  list;
        }


        public static List<Integer> bubblesort(int[]list)
        {
            assert  list != null : "Failed precondition";

            boolean changed = true;
            int temp;

            List<Integer> myList = new ArrayList<Integer>();

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

            for (int i = 0; i < list.length ; i++) {
                myList.add(list[i]);
            }

            assert  isAscending(list);
            return myList;
        }
}


