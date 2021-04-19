package com.example.mkghostrunner;

import java.util.Date;

public class DayData {
    Date day;
    String userKey, key;
    //List<RunData> runDataList;
    //List<FoodData> foodDataList;

    public DayData(){

    }
    public DayData(Date day, String userKey, String key){
        this.day = day;
        this.userKey = userKey;
        this.key = key;
        /*this.runDataList = new List<RunData>() {
            private int listSize = 0;
            private int maxSize = 10;
            private RunData[] datArr = new RunData[maxSize];

            @Override
            public int size() {
                return listSize;
            }

            @Override
            public boolean isEmpty() {
                return (listSize == 0);
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<RunData> iterator() {
                return new Iterator<RunData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return position != listSize;
                    }

                    @Override
                    public RunData next() {
                        position++;
                        return datArr[position];
                    }
                };
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return Arrays.copyOfRange(datArr, 0, listSize);
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            private void resize(){
                RunData[] tempArr = new RunData[maxSize * 2];
                System.arraycopy(datArr, 0, tempArr, 0, maxSize);
                maxSize = maxSize * 2;
                datArr = tempArr;
            }

            @Override
            public boolean add(RunData runData) {
                listSize++;
                if (listSize > maxSize){
                    resize();
                }
                datArr[listSize] = runData;
                return true;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends RunData> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends RunData> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {
                listSize = 0;
            }

            @Override
            public RunData get(int index) {
                return datArr[index];
            }

            @Override
            public RunData set(int index, RunData element) {
                RunData temp = datArr[index];
                datArr[index] = element;
                return temp;
            }

            @Override
            public void add(int index, RunData element) {
                datArr[index] = element;
            }

            @Override
            public RunData remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<RunData> listIterator() {
                return new ListIterator<RunData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public RunData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public RunData previous() {
                        position--;
                        return datArr[position];
                    }

                    @Override
                    public int nextIndex() {
                        return position++;
                    }

                    @Override
                    public int previousIndex() {
                        return position--;
                    }

                    @Override
                    public void remove() {

                    }

                    @Override
                    public void set(RunData runData) {

                    }

                    @Override
                    public void add(RunData runData) {

                    }
                };
            }

            @NonNull
            @Override
            public ListIterator<RunData> listIterator(int index) {
                return new ListIterator<RunData>() {
                    int position = index;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public RunData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public RunData previous() {
                        position--;
                        return datArr[position];
                    }

                    @Override
                    public int nextIndex() {
                        return position++;
                    }

                    @Override
                    public int previousIndex() {
                        return position--;
                    }

                    @Override
                    public void remove() {

                    }

                    @Override
                    public void set(RunData runData) {

                    }

                    @Override
                    public void add(RunData runData) {

                    }
                };
            }

            @NonNull
            @Override
            public List<RunData> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        this.foodDataList = new List<FoodData>() {
            private int listSize = 0;
            private int maxSize = 10;
            private FoodData[] datArr = new FoodData[maxSize];

            @Override
            public int size() {
                return listSize;
            }

            @Override
            public boolean isEmpty() {
                return (listSize == 0);
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<FoodData> iterator() {
                return new Iterator<FoodData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return position != listSize;
                    }

                    @Override
                    public FoodData next() {
                        position++;
                        return datArr[position];
                    }
                };
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return Arrays.copyOfRange(datArr, 0, listSize);
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            private void resize(){
                FoodData[] tempArr = new FoodData[maxSize * 2];
                System.arraycopy(datArr, 0, tempArr, 0, maxSize);
                maxSize = maxSize * 2;
                datArr = tempArr;
            }

            @Override
            public boolean add(FoodData foodData) {
                listSize++;
                if (listSize > maxSize){
                    resize();
                }
                datArr[listSize] = foodData;
                return true;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends FoodData> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends FoodData> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {
                listSize = 0;
            }

            @Override
            public FoodData get(int index) {
                return datArr[index];
            }

            @Override
            public FoodData set(int index, FoodData element) {
                FoodData temp = datArr[index];
                datArr[index] = element;
                return temp;
            }

            @Override
            public void add(int index, FoodData element) {
                datArr[index] = element;
            }

            @Override
            public FoodData remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<FoodData> listIterator() {
                return new ListIterator<FoodData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public FoodData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public FoodData previous() {
                        position--;
                        return datArr[position];
                    }

                    @Override
                    public int nextIndex() {
                        return position++;
                    }

                    @Override
                    public int previousIndex() {
                        return position--;
                    }

                    @Override
                    public void remove() {

                    }

                    @Override
                    public void set(FoodData foodData) {

                    }

                    @Override
                    public void add(FoodData foodData) {

                    }
                };
            }

            @NonNull
            @Override
            public ListIterator<FoodData> listIterator(int index) {
                return new ListIterator<FoodData>() {
                    int position = index;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public FoodData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public FoodData previous() {
                        position--;
                        return datArr[position];
                    }

                    @Override
                    public int nextIndex() {
                        return position++;
                    }

                    @Override
                    public int previousIndex() {
                        return position--;
                    }

                    @Override
                    public void remove() {

                    }

                    @Override
                    public void set(FoodData foodData) {

                    }

                    @Override
                    public void add(FoodData foodData) {

                    }
                };
            }

            @NonNull
            @Override
            public List<FoodData> subList(int fromIndex, int toIndex) {
                return null;
            }
        };*/
    }

    public Date getDay() {
        return this.day;
    }
    public String getUserKey() {
        return this.userKey;
    }
    public String getKey(){
        return this.key;
    }
    /*public List<RunData> getDayDataList(){
        return this.runDataList;
    }
    public List<FoodData> getFoodDataList(){
        return this.foodDataList;
    }*/


    public void setDay(Date day){
        this.day = day;
    }
    public void setUserKey(String userKey){
        this.userKey = userKey;
    }
    public void setKey(String key){
        this.key = key;
    }
    /*public void addRun(RunData run){
        this.runDataList.add(run);
    }
    public void addFood(FoodData food){
        this.foodDataList.add(food);
    }*/

}
