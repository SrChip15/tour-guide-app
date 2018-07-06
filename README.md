Tour Guide App Project
=======================

An Android application that presents all the popular attractions of the city of Fort Collins, categorized as Activities, Restaurants, Breweries, Bars/Nightlife. Splash screen presents all the categories vertically and the attractions horizontally, i.e., user could access all the information using swipe gestures from the splash screen itself. 

User could click on “Show All” in the splash screen to see all the attractions from the category in a vertical list. User could also click on an attraction to view a brief description about the attraction. Further, an user can also view the location of the attraction on [Google Maps](https://www.google.com/maps), simply by clicking on the "Show in Map" button.

Specs
------

* Developed a Nested RecyclerView with Section Headers to build splash screen UI
* Used CardView to present attractions as Cards
* Used ViewPager to facilitate swipe navigation to subsequent attraction while in details screen
* Used ConstrainLayout to build the base UI for splash screen and details screen (landscape)
* Written in Java 8 with Lambdas

Tools
------

* Gradle v4.4
* Android Plugin v3.1.3
* Support Library v27.1.1
* Android API v27
* Android Build Tools v27

Screenshots
------------

<img src="https://raw.githubusercontent.com/SrChip15/tour-guide-app/master/splash_screen.png"
width="250"/>
<img src="https://github.com/SrChip15/tour-guide-app/blob/master/list_view_tourfc.png"
width="250"/>
<img src="https://raw.githubusercontent.com/SrChip15/tour-guide-app/master/detail_view.png"
width="250"/>

Demo
----

<img src="https://github.com/SrChip15/tour-guide-app/blob/master/updated_demo_06172018.gif" width="250"/>

License
--------
```
Copyright 2018 Srinath Chintapalli

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
