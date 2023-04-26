# Arknoid

# Overview
In this project we create the Arkanoid game base on GUI interface of the Bar-Ilan university. <br>
This is assignment in the oop-course of Bar-Ilan University. <br>

# User Guide
The goal is to eliminate all the blocks on the screen. <br>
Every time ball hit block, the block disappeared. <br>
The control in the balls achieved by moving the paddle in the bootom of the screen by the keyboards left and right arrows. <br>
To pause the game use `p`. To continue, use `SPACE`. <br>

# levels
There are 4 levels in this game: <br>
Level 1: <br>
![level 1](https://user-images.githubusercontent.com/118112616/234551408-bedddbee-17f1-4cc3-a57f-1506036016d6.png) <br>

Level 2: <br>
![level 2](https://user-images.githubusercontent.com/118112616/234555794-deef6da6-d7f1-4097-9a88-89f4ddc71a8a.png)
 <br>
Level 3: <br>
![level 3](https://user-images.githubusercontent.com/118112616/234554271-5051f978-98e0-4b45-a128-327cdb23f624.png) <br>
Level 4: <br>
![image](https://user-images.githubusercontent.com/118112616/234214911-c4a8d024-b9e5-4ff1-9aa9-4660781fc009.png) {: width="100%"} <br>

# run <br>
First, clone the repo. Than use the following commands inside the project folder: <br>
To run this game from level 1 to 4 use the command `ant run`. <br>
To run in any other levels order use the command `ant run -Dargs="levels order"`. <br> For example, to start the game in level 2 and after win it move to level 4 write `ant run -Dargs="2 4"`. <br>
To clean all the compilation files use `ant clean`. <br>
To compile the game without run it use `ant compile`. <br>

# Requirements
- Java
- Ant
