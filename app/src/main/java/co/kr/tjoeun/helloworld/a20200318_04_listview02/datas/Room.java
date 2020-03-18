package co.kr.tjoeun.helloworld.a20200318_04_listview02.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String description;

    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;
    }

    public String getFloorToString() {

        //        주소 / 층수 결합해서

        String floorStr = "";
//        층>0 층 ==0 그외 (층<0)
        if (this.floor > 0) {
            floorStr = String.format("%d층", this.floor);
        } else if (this.floor == 0) {
//            0=> 반지하
            floorStr = "반지하";
        } else {
            floorStr = String.format("지하 %d층", this.floor * -1);
        }

    return floorStr;
    }

    public String getFormattedPrice (){
//        상황에따라 표기방법에따라 나눠 리턴해줌
        if(this.price > 10000){
            int uk = this.price / 10000;
            int thousand = this.price % 10000;
            return String.format("%d억 %,d만원",uk,thousand);
        }else{
            return String.format("%,d만원", this.price);
        }


    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
