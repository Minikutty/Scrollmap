## Project Details

#### Author:

Minikutty Joseph

#### Project Name:

ScrollMap

#### Contact Information:

minikuttychiramel@gmail.com

#### Issue Tracker:

Please report issues at the following link:
https://github.com/Minikutty/Scrollmap/issues

#### Description:

Scrollmap is an android application which acts as a multifunction navigation instrument, showing the current location 
on a chart and the feet above sea level. This app mainly provides the map scrolling functionality of a GPS.

The application supports 2D (overhead) as well as 3D (projection of 2D image to add
perspective) modes. The 2D mode also supports “North-up” and “Heading-up” modes. 

As a target for simulations, a 5.4” FWVGA screen resolution (480 x 854 pixels) is used.

A raster image (png format) of the chart area is used by the application. Only this image
is used and hence scaling has to be done by zooming in and out. To facilitate this, it 
tiles the given image into smaller pieces such that the pieces are small enough to be
handled by Android.

For the purpose of simulations, random numbers are generated for the depth data, i.e.
the depth at different points in the chart would just be generated randomly, whereas in
reality, the depth information would be provided to the Android device by some external
devices through Bluetooth or serial port.

#### How to use

This app assumes that the longitudes and latitudes can be obtained from the GPS feature aleady present in the Android device. So the start location, end location and the path from source to destination is hardcoded in this source code.
And hence, when you start the app, you can see the marker (green circle) is moving from the source to the destination. Actually the marker is stable at a point and the map is scrolling from source to destination. The speed of movement is also hardcoded in the source file.

Once the app starts and the marker appears to start moving, you can tap on the touchscreen or mouse click on emulator, to select the three different modes of operation. By default, the app shows mode 1, which provides a 2D View and the top of the image always pointing north. Once we tap the touchscreen or mouse click on emulator, the app shows mode 2, which is also a
2D view but top of the image is always pointing to the direction of motion. Another tap on the touch screen or mouse click on emulator, the app shows mode 3, which is a 3D View and the image shows the driver’s perspective or driver’s view.

This app provides the map scrolling functionality of a GPS. It has to be integrated with GPS to make a full fledged GPS app.


#### License Information

This work is available under the "MIT License". Please see the file [COPYING] (https://github.com/Minikutty/Scrollmap/blob/master/COPYING) in this distribution 
for license terms.

#### Build Details

###### Prerequisites for build
* Requires Android 2.0.1 and up.
* The provided Android application works only on a 480x854 WVGA854 resolution Android AVD.
 
###### Installation instructions
* Download and install the most recent apk file: [Scrollmap](https://github.com/Minikutty/Scrollmap/blob/master/bin/ScrollMap.apk?raw=true)
 
Installation guide is available at: http://www.talkandroid.com/guides/beginner/install-apk-files-on-android/


###### Build instructions

#### Source Code:

https://github.com/Minikutty/Scrollmap

#### References:

* https://developer.android.com
* http://www.phonesdevelopers.com/1784347/
* https://www.youtube.com/watch?v=7-n6p6RxSS8
* https://www.youtube.com/watch?v=sVx46awjtFQ  
