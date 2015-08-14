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

MANUAL 

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
