package com.leetcode.easy.design;

public class _1603_Design_Parking_System {
    //https://leetcode.com/problems/design-parking-system/

    class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (big > 0) {
                    big--;
                    return true;
                }
                return false;
            } else if (carType == 2) {
                if (medium > 0) {
                    medium--;
                    return true;
                }
                return false;
            } else if (carType == 3) {
                if (small > 0) {
                    small--;
                    return true;
                }
                return false;
            }
            return false;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
}
