package com.example.mkghostrunner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserData {
    String username, password, key;
    //List<DayData> dayDataList;

    public UserData(){

    }
    public UserData(String username, String password, String key){
        this.username = username;
        this.password = password;
        this.key = key;
        /*this.dayDataList = new List<DayData>() {
            private int listSize = 0;
            private int maxSize = 10;
            private DayData[] datArr = new DayData[maxSize];

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
            public Iterator<DayData> iterator() {
                return new Iterator<DayData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return position != listSize;
                    }

                    @Override
                    public DayData next() {
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
                DayData[] tempArr = new DayData[maxSize * 2];
                System.arraycopy(datArr, 0, tempArr, 0, maxSize);
                maxSize = maxSize * 2;
                datArr = tempArr;
            }

            @Override
            public boolean add(DayData dayData) {
                listSize++;
                if (listSize > maxSize){
                    resize();
                }
                datArr[listSize] = dayData;
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
            public boolean addAll(@NonNull Collection<? extends DayData> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends DayData> c) {
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
            public DayData get(int index) {
                return datArr[index];
            }

            @Override
            public DayData set(int index, DayData element) {
                DayData temp = datArr[index];
                datArr[index] = element;
                return temp;
            }

            @Override
            public void add(int index, DayData element) {
                datArr[index] = element;
            }

            @Override
            public DayData remove(int index) {
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
            public ListIterator<DayData> listIterator() {
                return new ListIterator<DayData>() {
                    int position = 0;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public DayData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public DayData previous() {
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
                    public void set(DayData dayData) {

                    }

                    @Override
                    public void add(DayData dayData) {

                    }
                };
            }

            @NonNull
            @Override
            public ListIterator<DayData> listIterator(int index) {
                return new ListIterator<DayData>() {
                    int position = index;
                    @Override
                    public boolean hasNext() {
                        return (position != listSize);
                    }

                    @Override
                    public DayData next() {
                        position++;
                        return datArr[position];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return (position != 0);
                    }

                    @Override
                    public DayData previous() {
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
                    public void set(DayData dayData) {

                    }

                    @Override
                    public void add(DayData dayData) {

                    }
                };
            }

            @NonNull
            @Override
            public List<DayData> subList(int fromIndex, int toIndex) {
                return null;
            }
        };*/
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getKey(){
        return this.key;
    }
    /*public List<DayData> getDayDataList() {
        return this.dayDataList;
    }*/

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setKey(String key){
        this.key = key;
    }
    /*public void addDayData(DayData dayData) {
        this.dayDataList.add(dayData);
    }*/
}
