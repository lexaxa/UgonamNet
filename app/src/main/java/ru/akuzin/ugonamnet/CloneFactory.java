package ru.akuzin.ugonamnet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by akuzin on 02.06.2017.
 */

class CloneFactory {

    private static CloneFactory cloneFactory;
    private static List<Ugon> ugonList;

    public class Ugon {
        private Date date;
        private String title;
        private String number;
        private String address;
        private String color;
        private String award;
        private String description;
        private List<String> imgs;

        public Ugon(){

        }

        public Ugon(Date date, String title, String number, String address, String color, String award, String description) {
            this.date = date;
            this.title = title;
            this.number = number;
            this.address = address;
            this.color = color;
            this.award = award;
            this.description = description;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getAward() {
            return award;
        }

        public void setAward(String award) {
            this.award = award;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }

    private CloneFactory(){
        ugonList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {

            ugonList.add(new Ugon(new Date(), "title", "number", "address",
                    "color", "award", "desc"));
        }
    }

    public static List<Ugon> getCloneList(){
        if(cloneFactory == null){
            cloneFactory = new CloneFactory();
        }
        return ugonList;
    }
}
