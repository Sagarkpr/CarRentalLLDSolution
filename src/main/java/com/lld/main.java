package com.lld;

import com.lld.providers.CarRentalService;

/**
 *                                          REQUIREMENTS
 * Vehicle Rental application
 * Using OO principles to design a cab rental application
 *
 * Users should be able to create an account for them to book vehicles of the below types.
 *
 * HATCHBACK
 * SUV
 * SEDAN
 * THREEWHEELER
 * TRUCK
 * VAN
 * MOTORCYCLE
 * BICYCLE
 *
 * Admin should be able to add vehicle to inventory. ---> done
 * Users should be able to book an available vehicle. ---> done
 * Users should be able to scan qrCode of the vehicle and book (walkin booking). Not Required
 * Users can pick booked vehicle from the available from the designated places. invalid
 * Users should be able to cancel the booking.---> completed
 * Users should be able to return the vehicle post usage.---> completed
 * Users get invoice for payment post returning the vehicle. ----> completed
 * Users Should get remainder notification a day before their booking. invalid
 * Users should be able to choose and add devices and services to the vehicles while they book. ---> out of scope
 *
 * System should be provide APIs to search for vechicles booked by users by user id and for a particular interval.
 */
public class main {
    public static void main(String[] args) {
        CarRentalService carRentalService = new CarRentalService();
    }
}
