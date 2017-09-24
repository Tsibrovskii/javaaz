package ru.tsibrovskii;

/**
 * Created by Aleksei on 20.09.2017.
 */
public class HH {

    public static void main(String[] args) {
        HH hh = new HH();
        hh.firstTask();
    }

    public void firstTask() {
        int count = 0;
        for(Long i = 1L; i < 12074; i++) {
            String str = i.toString();
            StringBuffer s = new StringBuffer(str);
            s.reverse();
            Long first = Long.valueOf(str);
            Long second = Long.valueOf(s.toString());
            for(int j = 0; j < 50; j++) {
                first = first + second;
                str = first.toString();
                s = new StringBuffer(str);
                s.reverse();
                second = Long.valueOf(s.toString());
                if(s.toString().equals(str)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
