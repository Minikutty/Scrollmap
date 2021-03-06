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

Scrollmap is an android application which acts as a multifunctional navigation instrument, showing the current location 
on a chart and the feet above sea level. This app mainly provides the map scrolling functionality of a GPS.

The application supports 2D (overhead) as well as 3D (projection of 2D image to add
perspective) modes. The 2D mode also supports “North-up” and “Heading-up” modes. 

As a target for simulations, a 5.4” FWVGA screen resolution (480 x 854 pixels) is used.

A raster image (png format) of the chart area is used by the application. Only this image
is used and hence scaling has to be done by zooming in and out. To facilitate this, it 
tiles the given image into smaller pieces such that the pieces are small enough to be
handled by Android.

For the purpose of simulations, random numbers are generated for the elevation data, i.e.
the elevation at different points in the chart would just be generated randomly, whereas in
reality, the elevation information would be provided to the Android device by some external
devices through Bluetooth or serial port.

#### User Documents
User docs can be found at [User Manual](https://github.com/Minikutty/Scrollmap/blob/master/User%20Manual.pdf)

#### License Information

This work is available under the "MIT License". Please see the file [COPYING] (https://github.com/Minikutty/Scrollmap/blob/master/COPYING) in this distribution 
for license terms.

#### Build Details

###### Prerequisites for build
* Android SDK
* Eclipse IDE (prefer Eclipse 3.7.2 (Indigo) or greater)
* ADT plugin
* Requires Android 2.0.1 and up.
* The provided Android application works only on a 480x854 WVGA854 resolution Android AVD.
 
###### Installation instructions
* Download and install the most recent apk file: [Scrollmap](https://github.com/Minikutty/Scrollmap/blob/master/bin/ScrollMap.apk?raw=true)
 
* Online installation help for installing apk file on your android phone is available at: [Installation Instructions] (http://vbraille.cs.washington.edu/doc/how_to_install_apks.pdf) 

* For setting up an environment ready to develop Android applications is available at: [SET UP](http://www.instructables.com/id/How-To-Setup-Eclipse-for-Android-App-Development/?ALLSTEPS)

#### Source Code:

https://github.com/Minikutty/Scrollmap

#### References:

* https://developer.android.com
* http://www.phonesdevelopers.com/1784347/
* https://www.youtube.com/watch?v=7-n6p6RxSS8
* https://www.youtube.com/watch?v=sVx46awjtFQ  
* http://vbraille.cs.washington.edu/doc/how_to_install_apks.pdf
* http://www.instructables.com/id/How-To-Setup-Eclipse-for-Android-App-Development/?ALLSTEPS
