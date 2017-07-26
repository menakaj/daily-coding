package hackerrank.ssq;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SSQTest {

    private static class Query extends Sale {

        private int endDate;


        public int getEndDate() {
            return endDate;
        }

        public void setEndDate(int endDate) {
            this.endDate = endDate;
        }

        public String toString() {
            return getDay() + " " + " " + endDate + " " + getPid() + " " + getCid() + " " + getRegion() + " " + getState();
        }
    }

    private static class Sale{
        private int day;
        private int pid;
        private int cid;
        private int state;
        private int region;

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getRegion() {
            return region;
        }

        public void setRegion(int region) {
            this.region = region;
        }

        public String toString() {
            return day + " " + pid + " " + cid + " " + region + " " + state;
        }
    }

    private static Sale createSale(String line) {
        Sale sale = new Sale();
        String[] tokens = line.split(" ");
        // S 1 1.3 2.5 => {"S", "1", "1.[3]", "2.[5]"}
        // Indices          0    1     2      3

        sale.setDay(convertToInt(tokens[1]));

        String[] pidcid = checkDot(tokens[2]);
        String[] sidrid = checkDot(tokens[3]);

        sale.setPid(convertToInt(pidcid[0]));
        sale.setState(convertToInt(sidrid[0]));


        if (pidcid.length >= 2) {
            sale.setCid(convertToInt(pidcid[1]));
        }

        if (sidrid.length >= 2) {
            sale.setRegion(convertToInt(sidrid[1]));
        }

        return sale;
    }

    private static Query createQuery(String line) {
        Query query = new Query();
        String[] tokens = line.split(" ");
        // S 1 1.3 2.5 => {"Q", "1.[1]", "1.[3]", "2.[5]"}
        // Indices          0    1     2      3


        String[] sded = checkDot(tokens[1]);
        String[] pidcid = checkDot(tokens[2]);
        String[] sidrid = checkDot(tokens[3]);

        query.setDay(convertToInt(sded[0]));
        query.setPid(convertToInt(pidcid[0]));
        query.setState(convertToInt(sidrid[0]));


        if (pidcid.length >= 2) {
            query.setCid(convertToInt(pidcid[1]));
        }

        if (sidrid.length >= 2) {
            query.setRegion(convertToInt(sidrid[1]));
        }

        if (sded.length >=2) {
            query.setEndDate(convertToInt(sded[1]));
        }

        return query;
    }

    private static String[] checkDot(String s) {
        if (s.contains(".")) {
            return s.split(Pattern.quote("."));
        } else {
            return new String[]{s};
        }
    }

    private static Integer convertToInt(String s) {
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i<times; i++) {
            String line = scanner.nextLine();

            if (line.contains("S")) {
                System.out.println("Sale: " + createSale(line));
            } else {
                System.out.println("Query: " + createQuery(line));
            }

        }

    }


}


