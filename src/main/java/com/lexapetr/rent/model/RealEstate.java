package com.lexapetr.rent.model;

public class RealEstate {
        private int realestateid;

        private String address;

        private int price;

        private RenterModel renter;

        public RealEstate(){
            setAddress("");
            setPrice(0);
        }

        public RealEstate(final String address,final Integer price){
            setAddress(address);
            setPrice(price);
        }

        public int getRealEstateId() {
            return realestateid;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public RenterModel getRenter() {
            return renter;
        }

        public void setRenter(RenterModel renter) {
            this.renter = renter;
        }
}
